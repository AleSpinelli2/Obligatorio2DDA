package com.example.oblig.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.oblig.Entity.VentaEntity;
import com.example.oblig.Utils.AppExeption;

@Controller
@RequestMapping("/venta")
public class VentaController {
    @Autowired
    public VentaService ventaService;

    @PostMapping
    public ResponseEntity<?> agregarVenta(@RequestBody VentaEntity ventaEntity) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(VentaEntity.agregarVenta(ventaEntity));
        } catch (AppExeption e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del sistema");
        }
    }

    @PutMapping
    public ResponseEntity<?> modificarVenta(@RequestBody VentaEntity ventaEntity) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(VentaEntity.modificarVenta(ventaEntity));
        } catch (AppExeption e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del sistema");
        }
    }

    @DeleteMapping("{nroVenta}")
    public ResponseEntity<?> eliminarVenta(@PathVariable int nroVenta) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(VentaEntity.eliminarVenta(nroVenta));
        } catch (AppExeption e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del sistema");
        }
    }

    @GetMapping("{nroVenta}")
    public ResponseEntity<?> buscarVenta(@PathVariable int nroVenta) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(VentaEntity.buscarVenta(nroVenta));
        } catch (AppExeption e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del sistema");
        }
    }
}
