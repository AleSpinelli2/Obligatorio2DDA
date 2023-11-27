package com.example.oblig.Entity;

import java.util.Set;

import jakarta.persistence.Entity;

@Entity
public class RegularEntity extends ClientEntity {
    public RegularEntity(int idCli, String nombre, String direccion, int telefono, Set<VentaEntity> ventaProductos) {
        super(idCli, nombre, direccion, telefono, ventaProductos);
    }

    public RegularEntity() {

    }
}
