package com.example.oblig.Entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
public class RegularEntity extends ClientEntity {
    public RegularEntity(int id, String nombre, String direccion, int telefono) {
        super(id, nombre, direccion, telefono);
    }

    public RegularEntity() {

    }
}
