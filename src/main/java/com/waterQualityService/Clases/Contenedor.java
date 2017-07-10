package com.waterQualityService.Clases;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Created by john on 04/07/17.
 */
@Entity
public class Contenedor {
    @Id
    private long id;

    private String nombre;
    private String descripcion;//Porque tiene una descripcion?

    @OneToOne
    private Muestra muestra;

    public Contenedor(long id, String nombre, String descripcion, Muestra muestra) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.muestra = muestra;
    }

    public Contenedor() {
    }

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Muestra getMuestra() {
        return muestra;
    }

    public void setMuestra(Muestra muestra) {
        this.muestra = muestra;
    }
}
