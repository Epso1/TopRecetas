package com.example.toprecetas.models;

import java.util.List;

public class Receta {


    private String nombre;
    private List<String> ingredientes;
    private String preparacion;
    private int foto;
    private Categoria categoria;


    public Receta(String nombre, List<String> ingredientes, String preparacion, int foto, Categoria categoria) {
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.preparacion = preparacion;
        this.foto = foto;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public List<String> getIngredientes() {
        return ingredientes;
    }

    public String getPreparacion() {
        return preparacion;
    }

    public int getFoto() {
        return foto;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}
