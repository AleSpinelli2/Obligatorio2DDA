package com.example.oblig.Entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class VendedorEntity {
    @Id
    private int nroVendedor;

    @Column
    private String nombre;

    @JsonIgnore
    @OneToMany(mappedBy = "vendedor")
    private Set<VentaEntity> ventas = new HashSet<>();;

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

    public Set<VentaEntity> getVendedor() {
        return ventas;
    }

    public void setVendedor(Set<VentaEntity> ventas) {
        this.ventas = ventas;
    }

    public VendedorEntity(int nroVendedor, String nombre, Set<VentaEntity> ventas) {
        this.nroVendedor = nroVendedor;
        this.nombre = nombre;
        this.ventas = ventas;
    }

    public VendedorEntity() {
    }

}
