package com.example.oblig.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.oblig.Entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    public List<ProductEntity> findByNombre(String nombre);

    List<ProductEntity> findBycantStockLessThan(int cantidad);
}
