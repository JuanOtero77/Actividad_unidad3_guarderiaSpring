/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicartagena.guarderia.modelo;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "usuarios", catalog = "dbguarderiajsp")
@Data
public class Usuario implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotEmpty
    @Column(name = "id")
    private String id;
    @NotEmpty
    @Basic(optional = false)
    private String clave;
    @NotEmpty
    @Basic(optional = false)
    private String nombre;
    @Basic(optional = false)
    @Email
    private String correo;
    @NotEmpty
    @Basic(optional = false)
    private String rol;
}
