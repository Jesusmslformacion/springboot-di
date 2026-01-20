package com.jesus.springboot.di.app.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
//import org.springframework.web.context.annotation.RequestScope;

import com.jesus.springboot.di.app.springboot_di.models.Product;

//@RequestScope // Un nuevo repositorio por cada solicitud HTTP
@Primary // Marca esta implementacion como la principal cuando hay multiples beans del mismo tipo
@Repository("productList") // Atributos
public class ProductRepositoryImpl implements ProductRepository { // Atributos

    private List <Product> data; // Simulando una base de datos

    public ProductRepositoryImpl() { // Constructor
        this.data = Arrays.asList( // Datos de ejemplo
            new Product(1L,"Memoria corsair 32", 300L),
            new Product(2L,"Disco solido samsung", 250L),
            new Product(3L,"Monitor LG 24'", 400L),
            new Product(4L,"Motherboard Asus", 150L));
    }

    @Override 
    public List<Product> findAll() { // Metodos
        return data;
    }

    @Override 
    public Product findById(Long id) { // Buscar por ID
        return data.stream() 
            .filter(p -> p.getId().equals(id))
            .findFirst()
            .orElse(null);
    }
    
}
