package com.example.oblig.Entity;

import java.sql.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class VipEntity extends ClientEntity {
    @Column
    public Date fchIngreso;

    public Date getFchIngreso() {
        return fchIngreso;
    }

    public void setFchIngreso(Date fchIngreso) {
        this.fchIngreso = fchIngreso;
    }

    public VipEntity(int idCli, String nombre, String direccion, int telefono, Set<VentaEntity> ventaProductos,
            Date fchIngreso) {
        super(idCli, nombre, direccion, telefono, ventaProductos);
        this.fchIngreso = fchIngreso;
    }

    public VipEntity() {
    }

}
