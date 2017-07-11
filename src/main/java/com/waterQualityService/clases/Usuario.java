package com.waterQualityService.clases;

import javax.persistence.*;

/**
 * Created by john on 04/07/17.
 */
@Entity
public class Usuario {
    @Id
    @GeneratedValue
    private long id;
    private String nombre;
    private String apellido;
    private String username;
    private String contrasena;
    private String telefono;
    @Enumerated(javax.persistence.EnumType.STRING)
    private TipoUsuario tipoUsuario;
    @Enumerated(javax.persistence.EnumType.STRING)
    private TipoSexo sexo;

    //GETTERS & SETTERS

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public TipoSexo getSexo() {
        return sexo;
    }

    public void setSexo(TipoSexo sexo) {
        this.sexo = sexo;
    }

    //CONSTRUCTORES

    public Usuario() {
    }

    public Usuario(long id, String nombre, String apellido, String username, String contrasena, String telefono, TipoUsuario tipoUsuario, TipoSexo sexo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.username = username;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.tipoUsuario = tipoUsuario;
        this.sexo = sexo;
    }

    //Pensando poner mejor una tabla para la direccion
}
