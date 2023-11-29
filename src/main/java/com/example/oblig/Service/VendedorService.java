package com.example.oblig.Service;

import java.util.Optional;

import com.example.oblig.Entity.VendedorEntity;
import com.example.oblig.Utils.AppException;

public interface VendedorService {

    public VendedorEntity save(VendedorEntity vendedorEntity) throws AppException;

    public String delete(int nroVendedor) throws AppException;

    public VendedorEntity update(VendedorEntity vendedorEntity) throws AppException;

    public Optional<VendedorEntity> getByCod(int nroVendedor) throws AppException;
}
