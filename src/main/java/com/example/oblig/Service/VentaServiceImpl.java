package com.example.oblig.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            throw new AppException("Esta venta ya existe");
        }
        return ventaRepository.save(ventaEntity);
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
}
