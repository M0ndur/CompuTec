
package com.compuTec.domain;

import java.io.Serializable;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name="producto")

public class Producto implements Serializable {
    
    private static final long serialVersionUI = 1L; 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long idProducto; 
    private Long idCategoria;
     private String descripcion;
     private String detalle;
    private boolean novedad;
    private double precio;
    private int cant_disponible;

    public Producto() {
    }

    public Producto(Long idCategoria, String descripcion, String detalle, boolean novedad, double precio, int cant_disponible) {
        this.idCategoria = idCategoria;
        this.descripcion = descripcion;
        this.detalle = detalle;
        this.novedad = novedad;
        this.precio = precio;
        this.cant_disponible = cant_disponible;
    }
   
    
}
