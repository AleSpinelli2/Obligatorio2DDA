package com.example.oblig.Service;

import java.util.List;
import java.util.Optional;

import com.example.oblig.Entity.ProductEntity;
import com.example.oblig.Utils.AppException;

public interface ProductService {

    public ProductEntity save(ProductEntity productEntity) throws AppException;

    public String delete(int codProd) throws AppException;

    public ProductEntity update(ProductEntity productEntity) throws AppException;

    public Optional<ProductEntity> getByCod(int codProd) throws AppException;

    public List<ProductEntity> listarProductosStockMenor(int cantStock) throws AppException;

    public List<ProductEntity> getAllProducts() throws AppException;
}
