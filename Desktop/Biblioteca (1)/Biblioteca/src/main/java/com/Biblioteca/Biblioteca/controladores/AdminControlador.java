
package com.Biblioteca.Biblioteca.controladores;

import com.Biblioteca.Biblioteca.entidades.Usuario;
import com.Biblioteca.Biblioteca.servicios.UsuarioServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminControlador {  
    
    
    @Autowired
    UsuarioServicio usuarioservicio;
    
    
    @GetMapping("/dashboard")
    public String panelAdministrativo(){
        return"panel.html"; 
    } 
    
    @GetMapping("/usuarios") 
    public String listar(ModelMap modelo){ 
        
        List<Usuario> usuarios = usuarioservicio.listaUsuarios(); 
        
        modelo.addAttribute("usuarios", usuarios); 
        
        return "usuario_list";
        
    } 
    
     @GetMapping("/modificarRol/{id}")
    public String cambiarRol(@PathVariable String id){
        
        usuarioservicio.cambiarRol(id);
        
       return "redirect:/admin/usuarios";
    }
    
}
