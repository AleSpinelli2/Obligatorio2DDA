// package com.example.oblig.Entity;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Inheritance;
// import jakarta.persistence.InheritanceType;

// @Entity
// public class ClientEntity {
//     @Id
//     // @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private int id;

//     // @Column
//     // private String nombre;

//     // @Column
//     // private String direccion;

//     // @Column
//     // private int telefono;

//     public int getIdCli() {
//         return id;
//     }

//     public void setIdCli(int id) {
//         this.id = id;
//     }

//     // public String getNombre() {
//     //     return nombre;
//     // }

//     // public void setNombre(String nombre) {
//     //     this.nombre = nombre;
//     // }

//     // public String getDireccion() {
//     //     return direccion;
//     // }

//     // public void setDireccion(String direccion) {
//     //     this.direccion = direccion;
//     // }

//     // public int getTelefono() {
//     //     return telefono;
//     // }

//     // public void setTelefono(int telefono) {
//     //     this.telefono = telefono;
//     // }

//     public ClientEntity(int idCli, String nombre, String direccion, int telefono) {
//         this.id = idCli;
//         // this.nombre = nombre;
//         // this.direccion = direccion;
//         // this.telefono = telefono;
//     }

//     public ClientEntity() {
//     }
// }
