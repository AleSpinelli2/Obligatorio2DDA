package com.example.oblig.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.oblig.Entity.VendedorEntity;
import com.example.oblig.Repository.VendedorRepository;
import com.example.oblig.Utils.AppException;



@Service
public class VendedorServiceImpl implements VendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;

    public VendedorEntity save(VendedorEntity vendedorEntity) throws AppException{
        if(!(vendedorRepository.findByNombre(vendedorEntity.getNombre()).size()>0)){
            return vendedorRepository.save(vendedorEntity);
        }
        throw new AppException("El nombre ya existe.");
    }
    public String delete(int nroVendedor) throws AppException{
        if(vendedorRepository.existsById(nroVendedor)){
            vendedorRepository.deleteById(nroVendedor);
            return "Se eliminó con éxito";
        }
        throw new AppException("El vendedor a eliminar no existe");
    }



    public VendedorEntity update(VendedorEntity vendedorEntity) throws AppException{
        if(vendedorRepository.existsById(vendedorEntity.getNroVendedor())){
            return vendedorRepository.save(vendedorEntity);
        }
        throw new AppException("El vendedor a modificar no existe");
    }

    public Optional<VendedorEntity> getByCod(int nroVendedor) throws AppException{
        if(vendedorRepository.existsById(nroVendedor))
            return vendedorRepository.findById(nroVendedor);
        throw new AppException("El numero no corresponde a un vendedor");
    }

}
