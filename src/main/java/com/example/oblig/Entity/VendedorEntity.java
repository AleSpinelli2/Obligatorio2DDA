package com.example.oblig.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class VendedorEntity {
    @Id
    private int nroVendedor;

    @Column
    private String nombre;

    public int getNroVendedor() {
        return nroVendedor;
    }

    public void setNroVendedor(int nroVendedor) {
        this.nroVendedor = nroVendedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public VendedorEntity(int nroVendedor, String nombre) {
        this.nroVendedor = nroVendedor;
        this.nombre = nombre;
    }

    public VendedorEntity() {
    }
}
