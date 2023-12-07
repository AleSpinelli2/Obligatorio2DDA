package com.example.oblig.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.oblig.Entity.VendedorEntity;
import java.util.List;
import java.util.Optional;


@Repository
public interface VendedorRepository extends JpaRepository<VendedorEntity, Integer> {
    public List <VendedorEntity>findByNombre(String nombre);
    public Optional<VendedorEntity> findByNombreAndPassword(String name, String password);
}
