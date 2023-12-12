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
import com.example.oblig.Entity.VipEntity;
import com.example.oblig.Repository.ClienteRepository;
import com.example.oblig.Repository.ProductRepository;
import com.example.oblig.Repository.VendedorRepository;
import com.example.oblig.Repository.VentaRepository;
import com.example.oblig.Utils.AppException;

@Service
public class VentaServiceImpl implements VentaService {
    @Autowired
    public VentaRepository ventaRepository;

    @Autowired
    public ClienteRepository clienteRepository;
    @Autowired
    public VendedorRepository vendedorRepository;
    @Autowired
    public ProductRepository productRepository;

    @Override
    public VentaEntity agregarVenta(VentaEntity ventaEntity, int idCliente, int nroVendedor) throws AppException {
        if (!ventaRepository.existsById(ventaEntity.getNroVenta())) {
            if (esClienteVipConDescuento(ventaEntity, idCliente)) {
                aplicarDescuentoVentaVip(ventaEntity);
                System.out.println("es vip" + ventaEntity.toString());
            }
            ventaEntity.setCliente(clienteRepository.findById(idCliente).get());
            ventaEntity.setVendedor(vendedorRepository.findById(nroVendedor).get());

            System.out.println("cantidad Stock" + ventaEntity.getListaProductos());
            VentaEntity ventaEntity2 = ventaRepository.save(ventaEntity);
            controlStock(ventaEntity2);
            return ventaEntity2;
        }
        throw new AppException("Esta venta ya existe capo");
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
    public int getCantidadCompras(int idCliente) {
        // Set<VentaEntity> cantidadCompras = new HashSet<>();
        int cantidadCompras = 0;
        for (VentaEntity unaVenta : ventaRepository.findAll()) {
            if (unaVenta.getCliente().getIdCli() == idCliente) {
                cantidadCompras++;
                System.out.println(cantidadCompras);
            }
        }
        return cantidadCompras;
    }

    public Set<VentaEntity> findByFchCompra(Date fchCompra) {
        Set<VentaEntity> ventasPorFecha = new HashSet<>();
        for (VentaEntity unaVenta : ventaRepository.findAll()) {
            if (unaVenta.getFchCompra() == fchCompra) {
                ventasPorFecha.add(unaVenta);
            }
        }
        return ventasPorFecha;
    }

    @Override
    public int getCantidadCompras(int idCliente) {
        // Set<VentaEntity> cantidadCompras = new HashSet<>();
        int cantidadCompras = 0;
        for (VentaEntity unaVenta : ventaRepository.findAll()) {
            if (unaVenta.getCliente().getIdCli() == idCliente) {
                cantidadCompras++;
                System.out.println(cantidadCompras);
            }
        }
        return cantidadCompras;
    }

    private boolean esClienteVipConDescuento(VentaEntity ventaEntity, int idCliente) {
        int cantidadCompras = getCantidadCompras(idCliente);
        return clienteRepository.buscarVip(idCliente) != null
                && cantidadCompras % 3 == 0;
    }

    private void aplicarDescuentoVentaVip(VentaEntity ventaEntity) {
        double totalConDescuento = ventaEntity.getTotalVenta() * 0.7;
        ventaEntity.setTotalVenta((int) totalConDescuento);
    }

    private void controlStock(VentaEntity ventaEntity) {
        for (ProductEntity producto : ventaEntity.getListaProductos()) {
            producto.setCantStock(producto.getCantStock() - 1);
            productRepository.save(producto);
        }
    }
}
