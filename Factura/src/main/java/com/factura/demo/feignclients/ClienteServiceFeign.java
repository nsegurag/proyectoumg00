package com.factura.demo.feignclients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cliente.demo.entity.Cliente;

@FeignClient(name = "cliente-service", url = "http://localhost:8080")
public interface ClienteServiceFeign {
    @GetMapping("/clientes/{id}")
    Cliente obtenerClientePorId(@PathVariable("id") Long id);
}
