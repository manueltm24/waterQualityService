package com.waterQualityService.Clases;

import org.hibernate.type.EnumType;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;

/**
 * Created by john on 04/07/17.
 */
@Entity
public class Usuario {
    @Id
    private long Id;

    private String nombre;
    private String Apellido;
    private String username;
    private String contrasena;
    private String telefono;

    @Enumerated(javax.persistence.EnumType.STRING)
    private Sex sex;

    @Enumerated(javax.persistence.EnumType.STRING)
    private TipoUsuario tipoUsuario;

    //Pensando poner mejor una tabla para la direccion
}
