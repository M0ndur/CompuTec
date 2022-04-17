
package controller;

import com.compuTec.domain.Producto;
import com.compuTec.service.ProductoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ProductoController {
    @Autowired
    private ProductoService productoService;
    
    @GetMapping("/producto/listado")
    public String inicio(Model model){     
        var productos = productoService.getProductos(false); 
        model.addAttribute("productos", productos); 
        return "/producto/listado";
    }
    
    @GetMapping("/producto/nuevo")
        public String nuevoProducto(Producto producto){
        return "/producto/modificar";
    }

    @PostMapping("/producto/guardar")
        public String guardarProducto(Producto producto){
        productoService.save(producto);
        return "redirect:/producto/listado";
    }
        
    @GetMapping("/producto/modificar/{idProducto}") 
        public String modificarProducto(Producto producto, Model model){
        producto = productoService.getProducto(producto); 
        model.addAttribute("producto", producto); 
        return "/producto/modificar";
    }
        
    @GetMapping("/producto/eliminar/{idProducto}")
        public String eliminarProducto(Producto producto){
        productoService.delete(producto); 
        return "redirect:/producto/listado";
    }
}
