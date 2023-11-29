package com.example.oblig.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class ProductEntity {
    @Id
    private int codProd;

    @Column(unique = true)
    private String nombre;

    @Column
    private String descripcion;

    @Column
    private int precio;

    @Column
    private int cantStock;

    @Column
    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getCodProd() {
        return codProd;
    }

    public void setCodProd(int codProd) {
        this.codProd = codProd;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantStock() {
        return cantStock;
    }

    public void setCantStock(int cantStock) {
        this.cantStock = cantStock;
    }

    public ProductEntity(int codProd, String nombre, String descripcion, int precio, int cantStock) {
        this.codProd = codProd;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantStock = cantStock;
    }

    public ProductEntity() {
    }
}
