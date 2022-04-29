
package com.compuTec.controller;


import com.compuTec.domain.Detalle;
import com.compuTec.service.DetalleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class DetalleController {
    
    @Autowired
    private DetalleService detalleService;
    
    @GetMapping("/detalle/listado")
    public String inicio(Model model){         
        var detalles = detalleService.getDetalles(); 
        model.addAttribute("detalles", detalles);
        return "/detalle/listado";
    }
    
    @GetMapping("/detalle/nuevo")
        public String nuevoDetalle(Detalle detalle){
        return "/detalle/modificar";
    }

    @PostMapping("/detalle/guardar")

        public String guardarDetalle(Detalle detalle){
        detalleService.save(detalle);
        return "redirect:/detalle/listado";
    }
        
    @GetMapping("/detalle/modificar/{idDetalle}") //id Detalle tendra un valor para cada usaurio
        public String modificarDetalle(Detalle detalle, Model model){
        detalle = detalleService.getDetalle(detalle); // se encarga el objeto
        model.addAttribute("detalle", detalle); // y se lo paso a modificar CLinete, esto para que aparezca la info precargada
        return "/detalle/modificar";
    }
        
    @GetMapping("/detalle/eliminar/{idDetalle}")
        public String eliminarDetalle(Detalle detalle){
        detalleService.delete(detalle); 
        return "redirect:/detalle/listado";
    }
}
    

