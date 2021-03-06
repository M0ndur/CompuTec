
package com.compuTec.controller;


import com.compuTec.domain.Cliente;
import com.compuTec.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;
    
    @GetMapping("/cliente/listado")
    public String inicio(Model model){         
        var clientes = clienteService.getClientes(); 
        model.addAttribute("clientes", clientes);
        return "/cliente/listado";
    }
    
    @GetMapping("/cliente/listadodetalle")
    public String inici(Model model){         
        var clientes = clienteService.getClientes(); 
        model.addAttribute("clientes", clientes);
        return "/cliente/listadodetalle";
    }
    
    @GetMapping("/cliente/nuevo")
        public String nuevoCliente(Cliente cliente){
        return "/cliente/modificar";
    }
        
    @GetMapping("/cliente/nueva_cuenta")
        public String nueva_cuenta(Cliente cliente){
        return "/cliente/modificar";
    }

    @PostMapping("/cliente/guardar")

        public String guardarCliente(Cliente cliente){
        clienteService.save(cliente);
        return "redirect:/cliente/listado";
    }
    
    
    @GetMapping("/cliente/modificar/{idCliente}") //id Cliente tendra un valor para cada usaurio
        public String modificarCliente(Cliente cliente, Model model){
        cliente = clienteService.getCliente(cliente); // se encarga el objeto
        model.addAttribute("cliente", cliente); // y se lo paso a modificar CLinete, esto para que aparezca la info precargada
        return "/cliente/modificar";
    }
        
    @GetMapping("/cliente/eliminar/{idCliente}")
        public String eliminarCliente(Cliente cliente){
        clienteService.delete(cliente); 
        return "redirect:/cliente/listado";
    }
}
    

