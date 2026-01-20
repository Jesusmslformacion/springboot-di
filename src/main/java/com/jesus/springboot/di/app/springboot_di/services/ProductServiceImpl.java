package com.jesus.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jesus.springboot.di.app.springboot_di.models.Product;
import com.jesus.springboot.di.app.springboot_di.repositories.ProductRepository;


@Service // Atributos
public class ProductServiceImpl  implements ProductService{ // Atributos



    @Value  ("${config.price.tax}") // Inyecta el valor del impuesto desde el archivo de propiedades
    private Double tax;

    private ProductRepository repository; // Simulando inyeccion de dependencias

    public ProductServiceImpl(@Qualifier("productList") ProductRepository repository) { // Constructor
        this.repository = repository;
    }

    @Override 
    public List<Product> findAll() { // Metodos
        return repository.findAll().stream().map(p -> { // Aplicando un 25% de impuesto a cada producto
            Double priceTax = p.getPrice() * tax; // Calculando el precio con impuesto
            Product newProd = (Product)p.clone(); // Clonando el objeto para no modificar el original
            newProd.setPrice(priceTax.longValue()); // Actualizando el precio con impuesto
            return newProd; // Retornando el nuevo producto con el precio actualizado
        }).collect(Collectors.toList()); // Retornando la lista con los precios actualizados

    }

    @Override
    public Product findById(Long id) { // Buscar por ID

        return repository.findById(id); 
    }


    
}
