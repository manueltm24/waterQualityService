package com.waterQualityService.clases;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by john on 10/07/17.
 */
@Entity
public class Normativa {
    @Id
    @GeneratedValue
    private long Id;
    private String nombreNormativa;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Parametro> listaParametros;
    private Date fechaCreacion;

    //GETTERS & SETTERS

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getNombreNormativa() {
        return nombreNormativa;
    }

    public void setNombreNormativa(String nombreNormativa) {
        this.nombreNormativa = nombreNormativa;
    }

    public Set<Parametro> getListaParametros() {
        return listaParametros;
    }

    public void setListaParametros(Set<Parametro> listaParametros) {
        this.listaParametros = listaParametros;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    //CONSTRUCTORES

    public Normativa() {
    }

    public Normativa(String nombreNormativa, Set<Parametro> listaParametros, Date fechaCreacion) {
        this.nombreNormativa = nombreNormativa;
        this.listaParametros = listaParametros;
        this.fechaCreacion = fechaCreacion;
    }
}
