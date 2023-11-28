package com.example.oblig.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.oblig.Entity.VendedorEntity;
import java.util.List;


@Repository
public interface VendedorRepository extends JpaRepository<VendedorEntity, Integer> {
    public List <VendedorEntity>findByNombre(String nombre);
}
