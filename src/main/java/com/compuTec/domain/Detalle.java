package com.compuTec.domain;

import javax.persistence.*;
import lombok.Data;
import java.io.Serializable;

@Data
@Entity
@Table(name="detalle")
public class Detalle implements Serializable{
    
    
    private static final long serialVersionUI = 1L; 
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long idClienteDetalle; 
    
    private String correo;
    private String telefono;
    private String direccion;
    private String NombreTarjeta;
    private int idCliente;
    public Detalle() {
    }

    public Detalle(String correo, String telefono, String direccion, String NombreTarjeta, int idCliente) {
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.NombreTarjeta = NombreTarjeta;
        this.idCliente = idCliente;
    }

   
}
