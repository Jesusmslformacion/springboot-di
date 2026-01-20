package com.jesus.springboot.di.app.springboot_di;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration // Marca esta clase como una clase de configuracion de Spring
@PropertySource("classpath:config.properties") // Carga el archivo de propiedades
public class AppConfig {

}
