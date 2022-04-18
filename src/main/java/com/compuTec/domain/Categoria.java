
package com.compuTec.domain;

import javax.persistence.*;
import lombok.Data;
import java.io.Serializable;

@Data
@Entity
@Table(name="categoria")
public class Categoria implements Serializable{
    
    //Inicio MySQL
    private static final long serialVersionUI = 1L; 
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long idCategoria; 
    private String descripcion;
   

    public Categoria() {
    }

    public Categoria(String descripcion) {
        this.descripcion = descripcion;
        
    }

    
    
}
