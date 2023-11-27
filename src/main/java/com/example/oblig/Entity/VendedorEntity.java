package com.example.oblig.Entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class VendedorEntity {
    @Id
    private int nroVendedor;

    @Column
    private String nombre;

    @JsonIgnore
    @OneToMany(mappedBy = "vendedor")
    private Set<VendedorEntity> vendedor;

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

    public Set<VendedorEntity> getVendedor() {
        return vendedor;
    }

    public void setVendedor(Set<VendedorEntity> vendedor) {
        this.vendedor = vendedor;
    }

    public VendedorEntity(int nroVendedor, String nombre, Set<VendedorEntity> vendedor) {
        this.nroVendedor = nroVendedor;
        this.nombre = nombre;
        this.vendedor = vendedor;
    }

    public VendedorEntity() {
    }

}
