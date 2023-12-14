package com.example.oblig.Service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.oblig.Entity.ClientEntity;
import com.example.oblig.Entity.RegularEntity;
import com.example.oblig.Entity.VipEntity;
import com.example.oblig.Repository.ClienteRepository;
import com.example.oblig.Utils.AppException;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public ClientEntity save(ClientEntity clienteEntity) throws AppException {

        if (clienteRepository.existsById(clienteEntity.getIdCli())) {
            throw new AppException(
                    "Este cliente ya se encuentra en la base de datos y esto no se tendria que mostrar porque el id es autoincremental");
        }

        return clienteRepository.save(clienteEntity);
    }

    @Override
    public String delete(int ci) throws AppException {
        if (clienteRepository.existsById(ci)) {
            clienteRepository.deleteById(ci);
            return "Se ha borrado exitosamente";
        }
        throw new AppException("No se ha podido encontrar a este cliente");
    }

    @Override
    public ClientEntity update(ClientEntity ClienteEntity) throws AppException {
        ClientEntity cliente = clienteRepository.findById(ClienteEntity.getIdCli()).get();
        cliente.setNombre(ClienteEntity.getNombre());
        cliente.setDireccion(ClienteEntity.getDireccion());
        cliente.setTelefono(ClienteEntity.getTelefono()); 
        clienteRepository.save(cliente);
        return cliente;
    }

    @Override
    public Optional<ClientEntity> getById(int ci) throws AppException {
        return clienteRepository.findById(ci);
    }

    @Override
    public List<ClientEntity> getAllClient() throws AppException {
        return clienteRepository.findAll();
    }

    @Override
    public List<VipEntity> getByVip() throws AppException {
        return clienteRepository.findAllVip();
        // .findAll().stream()
        // .filter(cliente -> cliente instanceof VipEntity)
        // .map(cliente -> (VipEntity) cliente)
        // .collect(Collectors.toList());
    }

    @Override
    public List<RegularEntity> getByRegular() throws AppException {
        return clienteRepository.findAllRegular();
        // findAll().stream()
        // .filter(cliente -> cliente instanceof RegularEntity)
        // .map(cliente -> (ClientEntity) cliente)
        // .collect(Collectors.toList());
    }
}
