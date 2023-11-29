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

import com.example.oblig.Entity.VendedorEntity;
import com.example.oblig.Service.VendedorService;
import com.example.oblig.Utils.AppException;

@Controller
@RequestMapping("/vendedor")

public class VendedorController {
    @Autowired
    private VendedorService vendedorService;

    @PostMapping
    public ResponseEntity<?> agregarVendedor(@RequestBody VendedorEntity vendedorEntity) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(vendedorService.save(vendedorEntity));
        } catch (AppException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del sistema.");
        }
    }

    @DeleteMapping("{nroVendedor}")
    public ResponseEntity<?> eliminarVendedor(@PathVariable int nroVendedor) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(vendedorService.delete(nroVendedor));
        } catch (AppException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del sistema.");
        }
    }

    @PutMapping
    public ResponseEntity<?> actuzalizarVendedor(@RequestBody VendedorEntity vendedorEntity) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(vendedorService.update(vendedorEntity));
        } catch (AppException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del sistema.");
        }
    }

    @GetMapping("{nroVendedor}")
    public ResponseEntity<?> traerVendedor(@PathVariable int nroVendedor) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(vendedorService.getByCod(nroVendedor));
        } catch (AppException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del sistema.");
        }
    }

}
