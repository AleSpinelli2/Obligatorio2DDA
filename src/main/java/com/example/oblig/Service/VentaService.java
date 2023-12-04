package com.example.oblig.Service;


import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.oblig.Entity.ClientEntity;
import com.example.oblig.Entity.VentaEntity;
import com.example.oblig.Utils.AppException;

@Service
public interface VentaService {
    public VentaEntity agregarVenta(VentaEntity ventaEntity, int idCliente, int nroVendedor) throws AppException;

    public VentaEntity modificarVenta(VentaEntity ventaEntity) throws AppException;

    public String eliminarVenta(int nroVenta) throws AppException;

    public Optional<VentaEntity> buscarVenta(int nroVenta) throws AppException;

    public Set<VentaEntity> getProductosByCliente (ClientEntity cliente) throws AppException;

    public Set<VentaEntity> findByFchCompra(Date fchCompra) throws AppException;
}
