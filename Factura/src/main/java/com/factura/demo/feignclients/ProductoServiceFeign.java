package com.factura.demo.feignclients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.producto.demo.entity.Producto;

@FeignClient(name = "producto-service", url = "http://localhost:8082")
public interface ProductoServiceFeign {
    @GetMapping("/productos/{id}")
    Producto obtenerProductoPorId(@PathVariable("id") Long id);
}
