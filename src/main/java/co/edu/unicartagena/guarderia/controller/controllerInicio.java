/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicartagena.guarderia.controller;

import co.edu.unicartagena.guarderia.dao.IUsuarioCrud;
import co.edu.unicartagena.guarderia.modelo.Usuario;
import co.edu.unicartagena.guarderia.servicio.IUsuarioServicio;
import java.util.Arrays;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


/**
 *
 * @author PC
 */
@Controller
@Slf4j
public class controllerInicio {
    
    @Autowired
    //IUsuarioCrud crudUsuario;
    IUsuarioServicio userServicio;
    @GetMapping("/")
    
    public String inicio(Model modelo) {
        List<Usuario> listaUsuarios = (List<Usuario>) userServicio.listarUsuarios();
        modelo.addAttribute("usuarios", listaUsuarios);
        log.info("Ejecutando el controlador Inicio");
        return "index";
    }
    
    @GetMapping("/agregar")
    public String agregar(Usuario usuario) {
        return "modificar";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Usuario usuario, Errors errores) {
        if(errores.hasErrors()){
            return "modificar";
        }
        userServicio.guardar(usuario);
        return "redirect:/";
    }
    
    @GetMapping("/editar/{id}")
    public String editar(Usuario usuario, Model modelo){
        log.info("Invocando el metodo editar");
        usuario = userServicio.buscar(usuario);
        modelo.addAttribute("usuario", usuario);
        return "modificar";
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminar(Usuario usuario){
        userServicio.eliminar(usuario);
        return "redirect:/";
    }
}
