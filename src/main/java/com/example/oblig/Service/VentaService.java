package com.example.oblig.Service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.oblig.Entity.VentaEntity;
import com.example.oblig.Utils.AppException;

@Service
public interface VentaService {
    public VentaEntity agregarVenta(VentaEntity ventaEntity) throws AppException;

    public VentaEntity modificarVenta(VentaEntity ventaEntity) throws AppException;

    public String eliminarVenta(int nroVenta) throws AppException;

    public Optional<VentaEntity> buscarVenta(int nroVenta) throws AppException;

}
