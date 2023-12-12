
package com.example.oblig.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.oblig.Entity.ProductEntity;
import com.example.oblig.Repository.ProductRepository;
import com.example.oblig.Utils.AppException;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductEntity save(ProductEntity productEntity) throws AppException {
        if (!(productRepository.findByNombre(productEntity.getNombre()).size() > 0)) {
            return productRepository.save(productEntity);
        }
        throw new AppException("Este nombre ya existe bro");
    }

    @Override
    public String delete(int codProd) throws AppException {
        if (productRepository.existsById(codProd)) {
            productRepository.deleteById(codProd);
            return "Producto eliminado con exito!!";
        }
        throw new AppException("El producto no se pudo eliminar o no existe");
    }

    @Override
    public ProductEntity update(ProductEntity productEntity) throws AppException {
        if (productRepository.existsById(productEntity.getCodProd())) {
            return productRepository.save(productEntity);
        }
        throw new AppException("El producto no se modifico o no existe");
    }

    @Override
    public Optional<ProductEntity> getByCod(int codProd) throws AppException {
        if (productRepository.existsById(codProd)) {
            return productRepository.findById(codProd);
        }
        throw new AppException("No se encontro ese producto");
    }

    public List<ProductEntity> listarProductosStockMenor(int cantidad) {
        return productRepository.findBycantStockLessThan(cantidad);
    }

    public List<ProductEntity> getAllProducts() throws AppException {
        return productRepository.findAll();
    }
}
