package com.example.oblig.Entity;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
public class VentaEntity {
    @Id
    private int nroVenta;

    @ManyToMany
    @JoinTable(name = "venta_producto", joinColumns = @JoinColumn(name = "venta_id"), inverseJoinColumns = @JoinColumn(name = "cod_producto"))
    private Set<ProductEntity> listaProductos = new HashSet<ProductEntity>();

    @Column
    private int totalVenta;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private ClientEntity cliente;

    @Column
    private Date fchCompra;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vendedor_id", referencedColumnName = "nroVendedor")
    private VendedorEntity vendedor;

    public int getNroVenta() {
        return nroVenta;
    }

    public void setNroVenta(int nroVenta) {
        this.nroVenta = nroVenta;
    }

    public Set<ProductEntity> getListaProductos() {
        return listaProductos;
    }

    public void ListaProductos(ProductEntity listaProductos) {
        this.listaProductos.add(listaProductos);
    }

    public int getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(int totalVenta) {
        this.totalVenta = totalVenta;
    }

    public ClientEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClientEntity cliente) {
        this.cliente = cliente;
    }

    public Date getFchCompra() {
        return fchCompra;
    }

    public void setFchCompra(Date fchCompra) {
        this.fchCompra = fchCompra;
    }

    public VendedorEntity getVendedor() {
        return vendedor;
    }

    public void setVendedor(VendedorEntity vendedor) {
        this.vendedor = vendedor;
    }

    public VentaEntity(int nroVenta, Set<ProductEntity> listaProductos, int totalVenta,
            Date fchCompra, ClientEntity cliente, VendedorEntity vendedor) {
        this.nroVenta = nroVenta;
        this.listaProductos = listaProductos;
        this.totalVenta = totalVenta;
        this.fchCompra = fchCompra;
        this.cliente = cliente;
        this.vendedor = vendedor;
    }

    public VentaEntity() {
    }
}