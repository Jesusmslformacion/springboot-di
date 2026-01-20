package com.jesus.springboot.di.app.springboot_di.models;

public class Product implements Cloneable{ // Atributos
    
    private Long id; 
    private String name;
    private Long price;

    public Product() { // Constructor vacio
    }

    public Product(Long id, String name, Long price) { // Constructor con parametros
        this.id = id;
        this.name = name;
        this.price = price;
    }
    

    public Long getId() { // Getters y Setters
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getPrice() {
        return price;
    }
    public void setPrice(Long price) {
        this.price = price;
    }

    @Override 
    public Object clone()  { // Metodo clone
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) { // Manejo de la excepcion
            return new Product(this.getId(), this.getName(), this.getPrice());
        }
    }

    
}
