package com.example.oblig.Controller;

import java.util.List;
import java.util.Map;

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

import com.example.oblig.Entity.ClientEntity;
import com.example.oblig.Entity.RegularEntity;
import com.example.oblig.Entity.VipEntity;
import com.example.oblig.Service.ClienteService;
import com.example.oblig.Utils.AppException;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/vip")
    public ResponseEntity<?> AddClient(@RequestBody VipEntity vipEntity) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(vipEntity));
        } catch (AppException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno del sistema." + e.getMessage());
        }
    }

    @PostMapping("/regular")
    public ResponseEntity<?> AddClient(@RequestBody RegularEntity regularEntity) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(regularEntity));
        } catch (AppException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno del sistema." + e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> DeleteClient(@PathVariable int id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(clienteService.delete(id));
        } catch (AppException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del sistema");
        }
    }

    @PutMapping
    public ResponseEntity<?> UpdateClient(@RequestBody ClientEntity clientEntity) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.update(clientEntity));
        } catch (AppException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del sistema");
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getCliente(@PathVariable int id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(clienteService.getById(id));
        } catch (AppException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del sistema.");
        }
    }

    @GetMapping
    public ResponseEntity<?> getClientes() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(clienteService.getAllClient());
        } catch (AppException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del sistema.");
        }
    }

    @GetMapping("/vip")
    public ResponseEntity<?> getClientesVip() {
        try {
            List<VipEntity> clientesVip = clienteService.getByVip();
            return ResponseEntity.status(HttpStatus.OK).body(Map.of("data", clientesVip));
        } catch (AppException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del sistema.");
        }
    }

    
 

    @GetMapping("/regular")
    public ResponseEntity<?> getClientesRegular() {
        try {
            List<RegularEntity> clientesRegular = clienteService.getByRegular();
            return ResponseEntity.status(HttpStatus.OK).body(Map.of("data", clientesRegular));
        } catch (AppException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del sistema.");
        }
    }

}