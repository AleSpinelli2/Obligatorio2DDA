package com.example.oblig.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.oblig.Entity.ClientEntity;
import com.example.oblig.Entity.RegularEntity;
import com.example.oblig.Entity.VipEntity;

@Repository
public interface ClienteRepository extends JpaRepository<ClientEntity, Integer> {
  // @Query("SELECT c FROM ClientEntity c WHERE TYPE(c) = VipEntity")
  // List<VipEntity> findAllVip();

  // @Query("SELECT c FROM ClientEntity c WHERE TYPE(c) = RegularEnity")
  // List<RegularEntity> findAllRegular();

}