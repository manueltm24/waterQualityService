package com.waterQualityService.Clases;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by MT on 6/24/2017.
 */
@Entity
public class Muestra {

    @Id
    @GeneratedValue
    private long id;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Parametro> listaParametros;

    @OneToOne(mappedBy = "muestra")
    private Direccion direccion;

    @OneToOne(mappedBy = "muestra")
    private Contenedor contenedor;


    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Parametro> getListaParametros() {
        return listaParametros;
    }

    public void setListaParametros(Set<Parametro> listaParametros) {
        this.listaParametros = listaParametros;
    }

    public Muestra(){}

    public Muestra(Set<Parametro> listaParametros,Direccion direccion) {
        this.listaParametros = listaParametros;
        this.id=id;
        this.direccion=direccion;
    }
}
