package com.apih2.models;

public class Book {
    private int id;
    private String titulo;
    private String autor;

    public Book() {
        this.id = 0;
        this.titulo = "Sin titulo";
        this.autor = "anonimo";

    }

    public Book(int id, String titulo, String autor){
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
    }

    public int getId(){
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo != null && !titulo.trim().isEmpty()) {
            this.titulo = titulo;
        } else {
            throw new IllegalArgumentException("El título no puede estar vacío");
        }
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        if (autor != null && !autor.trim().isEmpty()) {
            this.autor = autor;
        } else {
            throw new IllegalArgumentException("El autor no puede estar vacío");
        }
    }
    
}
