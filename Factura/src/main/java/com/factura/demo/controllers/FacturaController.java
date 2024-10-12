package com.factura.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.factura.demo.dao.IFactura;
import com.factura.demo.entity.Factura;

@RestController
@RequestMapping("/umg")
public class FacturaController {

    @Autowired
    private IFactura facturaDao;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/facturas", produces = "application/json")
    public ResponseEntity<List<Factura>> getAllFacturas() {
        List<Factura> lista = facturaDao.findAll();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/facturas/{id}")
    public ResponseEntity<Factura> getFacturaById(@PathVariable int id) {
        Factura factura = facturaDao.findById(id);
        if (factura == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(factura, HttpStatus.OK);
    }

    @PostMapping(value = "/facturas", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Factura> agregarFactura(@RequestBody Factura factura) {

        String clienteUrl = "http://localhost:8080/umg/clientes/" + factura.getClienteId();
        String descripcionCliente = restTemplate.getForObject(clienteUrl, String.class);
        if (descripcionCliente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        String productoUrl = "http://localhost:8082/umg/productos/" + factura.getProductoId();
        Producto producto = restTemplate.getForObject(productoUrl, Producto.class);
        if (producto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        factura.setDescripcionCliente(descripcionCliente);
        factura.setDescripcionProducto(producto.getDescripcion());

        // Asigna el precio del producto a la factura
        Double precioProducto = producto.getPrecio();
        factura.setTotal(precioProducto); // Asegúrate de que esto no cause errores

        Factura nuevaFactura = facturaDao.agregarRegistro(factura);
        return new ResponseEntity<>(nuevaFactura, HttpStatus.CREATED);
    }

    @DeleteMapping("/facturas/{id}")
    public ResponseEntity<Void> eliminarFactura(@PathVariable int id) {
        Factura factura = facturaDao.findById(id);
        if (factura == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        facturaDao.eliminarRegistro(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
