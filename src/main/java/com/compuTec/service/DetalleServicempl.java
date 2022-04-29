
package com.compuTec.service;


import com.compuTec.dao.DetalleDao;
import com.compuTec.domain.Detalle;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //
public class DetalleServicempl implements DetalleService {
    
    @Autowired
    private DetalleDao detalleDao;
    
    

    @Override
    public List<Detalle> getDetalles() {
        return(List<Detalle>)detalleDao.findAll();  
    }

    @Override
    public void save(Detalle detalle) {
        detalleDao.save(detalle);
    }

    @Override
    public void delete(Detalle detalle) {
        detalleDao.delete(detalle);
    }

    @Override
    public Detalle getDetalle(Detalle detalle) {
        return detalleDao.findById(detalle.getIdClienteDetalle()).orElse(null);
    }
    
}
