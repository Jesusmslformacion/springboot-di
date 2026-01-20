package com.jesus.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jesus.springboot.di.app.springboot_di.models.Product;
import com.jesus.springboot.di.app.springboot_di.repositories.ProductRepository;


@Service // Atributos
public class ProductServiceImpl  implements ProductService{ // Atributos

    
    private ProductRepository repository; // Simulando inyeccion de dependencias

    public ProductServiceImpl(ProductRepository repository) { // Constructor
        this.repository = repository;
    }

    @Override 
    public List<Product> findAll() { // Metodos
        return repository.findAll().stream().map(p -> { // Aplicando un 25% de impuesto a cada producto
            Double priceTax = p.getPrice() * 1.25d;
            //Product newProd = new Product(p.getId(),p.getName(),priceImp.longValue());
            Product newProd = (Product)p.clone();
            newProd.setPrice(priceTax.longValue());
            return newProd; // Retornando el producto clonado
        }).collect(Collectors.toList()); // Retornando la lista con los precios actualizados
    }

    @Override
    public Product findById(Long id) { // Buscar por ID

        return repository.findById(id); 
    }


    
}
