package com.cn_product.vet_product.model;

public class Producto {
    private int id;
    private String nombre;
    private int valor;


    // Constructor
    public Producto(int id, String nombre, int valor) {
        this.id = id;
        this.nombre = nombre;
        this.valor = valor;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getValor(){
        return valor;
    }
    public void setValor(int valor){
        this.valor = valor;
    }
}
