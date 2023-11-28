package com.example.oblig.Service;

import java.util.Optional;
import com.example.oblig.Entity.ClientEntity;
import com.example.oblig.Utils.AppException;


public interface ClienteService {
    public ClientEntity save(ClientEntity ClienteEntity) throws AppException;
    public String delete(int ci) throws AppException;
    public ClientEntity update(ClientEntity ClienteEntity) throws AppException;
    public Optional<ClientEntity> getById(int ci) throws AppException;
}
