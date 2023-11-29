package com.example.oblig.Repository;


import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.oblig.Entity.ClientEntity;
import com.example.oblig.Entity.VentaEntity;

@Repository
public interface ClienteRepository extends JpaRepository<ClientEntity,Integer> {

  public Set <VentaEntity>getProductosByCliente(ClientEntity cliente);
  
}