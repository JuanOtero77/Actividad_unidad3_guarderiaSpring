/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.unicartagena.guarderia.servicio;

import co.edu.unicartagena.guarderia.modelo.Usuario;
import java.util.List;

/**
 *
 * @author PC
 */
public interface IUsuarioServicio {
    public List<Usuario> listarUsuarios();
    public void guardar (Usuario user);
    public void eliminar (Usuario user);
    public Usuario buscar (Usuario user);
}
