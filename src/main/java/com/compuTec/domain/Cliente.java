package com.compuTec.domain;

import javax.persistence.*;
import lombok.Data;
import java.io.Serializable;

@Data
@Entity
@Table(name="cliente")
public class Cliente implements Serializable{
    
    
    private static final long serialVersionUI = 1L; 
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long idCliente; 
    
    private String nombre;
    private String apellidos;
    private String contrasena;
    private String correo;
    private String telefono;
    
    public Cliente() {
    }

    public Cliente(String nombre, String apellidos, String contrasena, String correo, String telefono) {
     
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.contrasena = contrasena;
        this.correo = correo;
        this.telefono = telefono;
    }

    

    
}
