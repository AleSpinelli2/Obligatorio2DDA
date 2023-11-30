package com.example.oblig.Entity;

import java.sql.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
public class VipEntity extends ClientEntity {
    @Column
    private Date fchIngreso;

    public Date getFchIngreso() {
        return fchIngreso;
    }

    public void setFchIngreso(Date fchIngreso) {
        this.fchIngreso = fchIngreso;
    }

    public VipEntity(int id, String nombre, String direccion, int telefono, Set<VentaEntity> ventaProductos,
            Date fchIngreso) {
        super(id, nombre, direccion, telefono, ventaProductos);
        this.fchIngreso = fchIngreso;
    }

    public VipEntity() {
    }

}
