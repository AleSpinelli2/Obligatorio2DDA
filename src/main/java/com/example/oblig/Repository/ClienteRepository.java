package com.example.oblig.Repository;

import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.oblig.Entity.ClientEntity;

@Repository
public interface ClienteRepository extends JpaRepository<ClientEntity,Integer> {
  // Colocar funciones correcpondiente al cliente   
}