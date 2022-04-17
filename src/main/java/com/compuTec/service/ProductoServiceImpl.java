
package com.compuTec.service;

import com.compuTec.dao.ProductoDao;
import com.compuTec.domain.Producto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl implements ProductoService{

@Autowired
    
    private ProductoDao productoDao;

    @Override
    public List<Producto> getProductos(boolean activos) {
        var lista = (List<Producto>)productoDao.findAll();
        
        if (activos) {
            lista.removeIf(e -> !e.isNovedad());
        }
        return(List<Producto>)productoDao.findAll();  
    }

    @Override
    public void save(Producto producto) {
        productoDao.save(producto);
    }

    @Override
    public void delete(Producto producto) {
        productoDao.delete(producto);
    }

    @Override
    public Producto getProducto(Producto producto) {
        return productoDao.findById(producto.getIdProducto()).orElse(null);
    }
    
}
