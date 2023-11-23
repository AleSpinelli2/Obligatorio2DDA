package com.example.oblig.Service;

import java.util.Optional;

import com.example.oblig.Entity.ProductEntity;
import com.example.oblig.Utils.AppExeption;

public interface ProductService {

    public ProductEntity save(ProductEntity productEntity) throws AppExeption;

    public String delete(int codProd) throws AppExeption;

    public ProductEntity update(ProductEntity productEntity) throws AppExeption;

    public Optional<ProductEntity> getByCod(int codProd) throws AppExeption;

}
