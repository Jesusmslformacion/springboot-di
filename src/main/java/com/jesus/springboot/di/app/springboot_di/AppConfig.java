package com.jesus.springboot.di.app.springboot_di;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

import com.jesus.springboot.di.app.springboot_di.repositories.ProductRepository;
import com.jesus.springboot.di.app.springboot_di.repositories.ProductRepositoryJson;

@Configuration // Marca esta clase como una clase de configuracion de Spring
@PropertySource("classpath:config.properties") // Carga el archivo de propiedades
public class AppConfig {

    @Value("classpath:json/product.json") 
    private Resource resource; // Inyecta el recurso JSON desde la ruta especificada

    @Bean("productJson")// Define un bean para ProductRepositoryJson
    ProductRepository productRepositoryJson() { // El nombre del bean sera "productRepositoryJson"
        return new ProductRepositoryJson(resource); // Crea una nueva instancia de ProductRepositoryJson con el recurso inyectado
    }

}
