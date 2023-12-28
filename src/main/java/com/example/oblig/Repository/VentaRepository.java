package com.example.oblig.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.oblig.Entity.ClientEntity;
import com.example.oblig.Entity.ProductEntity;
import com.example.oblig.Entity.VentaEntity;
import java.util.List;
import java.sql.Date;

public interface VentaRepository extends JpaRepository<VentaEntity, Integer> {

}
