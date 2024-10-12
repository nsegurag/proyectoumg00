package com.factura.demo.entity;

import com.cliente.demo.entity.Cliente;
import com.producto.demo.entity.Producto;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "factura")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Transient
    private Cliente cliente;  // Usamos Transient si no quieres persistir este campo en la base de datos

    @Transient
    private Producto producto;  // Lo mismo aquí para Producto

    @Column(name = "cliente_id")
    private int clienteId;

    @Column(name = "producto_id")
    private int productoId;

    @Column(name = "descripcion_cliente")
    private String descripcionCliente;

    @Column(name = "descripcion_producto")
    private String descripcionProducto;

    @Column(name = "total")
    private Double total;

    // Setters para Cliente y Producto
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        this.clienteId = cliente.getId();  // Opcional, si quieres almacenar el ID
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
        this.productoId = producto.getId();  // Opcional, si quieres almacenar el ID
    }
}
