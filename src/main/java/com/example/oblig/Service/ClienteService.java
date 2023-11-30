package com.example.oblig.Service;

import java.util.List;
import java.util.Optional;
import com.example.oblig.Entity.ClientEntity;
import com.example.oblig.Entity.RegularEntity;
import com.example.oblig.Entity.VipEntity;
import com.example.oblig.Utils.AppException;

public interface ClienteService {
    public ClientEntity save(ClientEntity clienteEntity) throws AppException;

    public String delete(int ci) throws AppException;

    public ClientEntity update(ClientEntity ClienteEntity) throws AppException;

    public Optional<ClientEntity> getById(int ci) throws AppException;

    public List<ClientEntity> getAllClient() throws AppException;

    public List<VipEntity> getByVip() throws AppException;

    public List<RegularEntity> getByRegular() throws AppException;

}
