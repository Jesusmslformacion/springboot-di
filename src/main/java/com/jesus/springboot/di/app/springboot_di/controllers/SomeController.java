package com.jesus.springboot.di.app.springboot_di.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jesus.springboot.di.app.springboot_di.models.Product;
import com.jesus.springboot.di.app.springboot_di.services.ProductServiceImpl;

@RestController // Atributos
@RequestMapping("/api") // Ruta base
public class SomeController { 

    private ProductServiceImpl service = new ProductServiceImpl(); // Simulando inyeccion de dependencias

    @GetMapping // Listar todos los productos
    public List<Product> list() {
        return service.findAll();
    }

    @GetMapping("/{id}") // Buscar por ID
    public Product show(@PathVariable Long id) {
        return service.findById(id);
    }

}
