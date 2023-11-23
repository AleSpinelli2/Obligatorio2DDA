package com.example.oblig.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class VipEntity extends ClientEntity {
    @Column
    public String fchIngreso;

    public String getFchIngreso() {
        return fchIngreso;
    }

    public void setFchIngreso(String fchIngreso) {
        this.fchIngreso = fchIngreso;
    }

    public VipEntity(int idCli, String nombre, String direccion, int telefono, String fchIngreso) {
        super(idCli, nombre, direccion, telefono);
        this.fchIngreso = fchIngreso;
    }

    public VipEntity() {
    }

}
