package com.example.oblig.Controller;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.oblig.Entity.ClientEntity;
import com.example.oblig.Entity.ProductEntity;
import com.example.oblig.Entity.VentaEntity;
import com.example.oblig.Service.VentaService;
import com.example.oblig.Utils.AppException;

@Controller
@RequestMapping("/venta")
public class VentaController {
    @Autowired
    private VentaService ventaService;

    @PostMapping("{idCliente}/{nroVendedor}")
    public ResponseEntity<?> agregarVenta(@RequestBody VentaEntity ventaEntity, @PathVariable int idCliente,
            @PathVariable int nroVendedor) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(ventaService.agregarVenta(ventaEntity, idCliente, nroVendedor));
        } catch (AppException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno del sistema " + e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> modificarVenta(@RequestBody VentaEntity ventaEntity) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ventaService.modificarVenta(ventaEntity));
        } catch (AppException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del sistema");
        }
    }

    @DeleteMapping("{nroVenta}")
    public ResponseEntity<?> eliminarVenta(@PathVariable int nroVenta) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ventaService.eliminarVenta(nroVenta));
        } catch (AppException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del sistema");
        }
    }

    @GetMapping("{nroVenta}")
    public ResponseEntity<?> buscarVenta(@PathVariable int nroVenta) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ventaService.buscarVenta(nroVenta));
        } catch (AppException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del sistema");
        }
    }

    @GetMapping("/fecha/{fchCompra}")
    public ResponseEntity<?> findByFchCompra(@PathVariable Date fchCompra) {
        try {
            Set<VentaEntity> ventas = ventaService.findByFchCompra(fchCompra);
            return ResponseEntity.status(HttpStatus.OK).body(Map.of("data", ventas));
        } catch (AppException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno en el sistema");
        }
    }

    @GetMapping("client/{idCliente}")
    public ResponseEntity<?> getCantidadCompras(@PathVariable int idCliente) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ventaService.getCantidadCompras(idCliente));
        } catch (AppException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno en el sistema");
        }
    }

}

