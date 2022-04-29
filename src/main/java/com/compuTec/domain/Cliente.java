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
    
    
    public Cliente() {
    }

    public Cliente(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    
}
