package com.example.oblig.Service;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.oblig.Controller.VentaController;
import com.example.oblig.Entity.ClientEntity;
import com.example.oblig.Entity.ProductEntity;
import com.example.oblig.Entity.VentaEntity;
import com.example.oblig.Repository.VentaRepository;
import com.example.oblig.Utils.AppException;

@Service
public class VentaServiceImpl implements VentaService {
    @Autowired
    public VentaRepository ventaRepository;

    @Override
    public VentaEntity agregarVenta(VentaEntity ventaEntity) throws AppException {
        if (ventaRepository.findById(ventaEntity.getNroVenta()).isPresent()) {
            return ventaRepository.save(ventaEntity);
        }
        throw new AppException("Esta venta ya existe");
    }

    @Override
    public VentaEntity modificarVenta(VentaEntity ventaEntity) throws AppException {
        if (ventaRepository.existsById(ventaEntity.getNroVenta())) {
            return ventaRepository.save(ventaEntity);
        }
        throw new AppException("El producto no se modifico o no existe");
    }

    @Override
    public String eliminarVenta(int nroVenta) throws AppException {
        if (ventaRepository.existsById(nroVenta)) {
            ventaRepository.deleteById(nroVenta);
            return "Venta eliminada con exito";
        }
        throw new AppException("La venta no se pudo eliminar o no existe");
    }

    @Override
    public Optional<VentaEntity> buscarVenta(int nroVenta) throws AppException {
        if (ventaRepository.existsById(nroVenta)) {
            return ventaRepository.findById(nroVenta);
        }
        throw new AppException("No se encontro esta venta");
    }

    @Override
    public Set<VentaEntity> getProductosByCliente(ClientEntity cliente) {
       
        return cliente.getVenta_productos();
    }

    public Set<VentaEntity> findByFchCompra(Date fchCompra){
        
        Set<VentaEntity> ventasPorFecha = new HashSet<>(); 
        
        for(VentaEntity unaVenta: ventaRepository.findAll()){
            if(unaVenta.getFchCompra() == fchCompra)
            {
                ventasPorFecha.add(unaVenta);
            }
        }

        return ventasPorFecha;
    }
}
