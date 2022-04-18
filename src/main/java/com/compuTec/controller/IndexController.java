/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.compuTec.controller;

import com.compuTec.service.ProductoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j

public class IndexController {
    
    @Autowired
     private ProductoService productoService;
    
    @GetMapping("/")

    public String inicio(Model model){ 
        var productos = productoService.getProductos(true); 
        model.addAttribute("productos", productos); 
        return "index";
    }
    
}
