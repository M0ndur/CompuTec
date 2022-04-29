
package com.compuTec.service;

import com.compuTec.domain.Detalle;
import java.util.List;


public interface DetalleService {
    public List<Detalle> getDetalles();
    public void save(Detalle detalle); 
    public void delete(Detalle detalle);
    public Detalle getDetalle(Detalle detalle);
    
}
