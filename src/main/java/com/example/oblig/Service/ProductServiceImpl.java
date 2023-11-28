
package com.example.oblig.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.oblig.Entity.ProductEntity;
import com.example.oblig.Repository.ProductRepository;
import com.example.oblig.Utils.AppExeption;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

   
    @Override
    public ProductEntity save(ProductEntity productEntity) throws AppExeption {
        if (!(productRepository.findByNombre(productEntity.getNombre()).size() > 0)) {
            return productRepository.save(productEntity);
        }
        throw new AppExeption("Este nombre ya existe bro");
    }

    @Override
    public String delete(int codProd) throws AppExeption {
        if (productRepository.existsById(codProd)) {
            productRepository.deleteById(codProd);
            return "Producto eliminado con exito!!";
        }
        throw new AppExeption("El producto no se pudo eliminar o no existe");
    }

    
    @Override
    public ProductEntity update(ProductEntity productEntity) throws AppExeption {
        if (productRepository.existsById(productEntity.getCodProd())) {
            return productRepository.save(productEntity);
        }
        throw new AppExeption("El producto no se modifico o no existe");
    }

    
    @Override
    public Optional<ProductEntity> getByCod(int codProd) throws AppExeption {
        if (productRepository.existsById(codProd)) {
            return productRepository.findById(codProd);
        }
        throw new AppExeption("No se encontro ese producto");
    }
}
