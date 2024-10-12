package com.factura.demo.controllers;

import com.cliente.demo.entity.Cliente;
import com.factura.demo.entity.Factura;
import com.factura.demo.feignclients.ClienteServiceFeign;
import com.factura.demo.feignclients.ProductoServiceFeign;
import com.producto.demo.entity.Producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/umg")
public class FacturaController {

    @Autowired
    private ClienteServiceFeign clienteServiceFeign;

    @Autowired
    private ProductoServiceFeign productoServiceFeign;

    @GetMapping("/factura/{clienteId}/{productoId}")
    public Factura obtenerFactura(@PathVariable("clienteId") Long clienteId, @PathVariable("productoId") Long productoId) {
        // Llama a los microservicios de cliente y producto
        Cliente cliente = clienteServiceFeign.obtenerClientePorId(clienteId);
        Producto producto = productoServiceFeign.obtenerProductoPorId(productoId);

        // Crea la factura y asigna cliente y producto
        Factura factura = new Factura();
        factura.setCliente(cliente);
        factura.setProducto(producto);
        factura.setDescripcionCliente(cliente.getNombre()); // Ejemplo de usar el nombre del cliente
        factura.setDescripcionProducto(producto.getNombre()); // Ejemplo de usar el nombre del producto
        factura.setTotal(producto.getPrecio()); // Calcula el total usando el precio del producto

        return factura;
    }
}
