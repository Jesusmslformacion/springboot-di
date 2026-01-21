package com.jesus.springboot.di.app.springboot_di.repositories;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

//import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.jesus.springboot.di.app.springboot_di.models.Product;


import tools.jackson.databind.ObjectMapper;

public class ProductRepositoryJson implements ProductRepository{ //Implementacion de la interfaz ProductRepository

    private List<Product> list; //= Arrays.asList(new Product(1L, "Product from JSON 1", 100.0),
                                      //new Product(2L, "Product from JSON 2", 200.0),
                                      //new Product(3L, "Product from JSON 3", 300.0));


    
    public ProductRepositoryJson(Resource resource) { //Constructor
        //Resource resource = new ClassPathResource("json/product.json"); //Carga el recurso JSON desde la ruta especificada
        ObjectMapper objectMapper = new ObjectMapper(); //Crea una instancia de ObjectMapper para mapear el JSON a objetos Java
        try { //Intenta leer y mapear el archivo JSON
            list = Arrays.asList(objectMapper.readValue(resource.getInputStream(), Product[].class)); //Lee el archivo JSON y lo convierte en una lista de objetos Product
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Product> findAll() { //Implementacion del metodo findAll de la interfaz ProductRepository
        return list;
    }


    @Override
    public Product findById(Long id) { //Implementacion del metodo findById de la interfaz ProductRepository
       return list.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow(); //Busca el producto por ID en la lista y lo devuelve
    }

}
