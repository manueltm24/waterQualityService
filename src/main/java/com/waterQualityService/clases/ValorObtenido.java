package com.waterQualityService.clases;

import javax.persistence.*;

/**
 * Created by MT on 7/10/2017.
 */
@Entity
public class ValorObtenido {

    @Id
    @GeneratedValue
    private long id;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Parametro parametro;
    private float valorObtenido;

    //GETTERS & SETTERS

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Parametro getParametro() {
        return parametro;
    }

    public void setParametro(Parametro parametro) {
        this.parametro = parametro;
    }

    public float getValorObtenido() {
        return valorObtenido;
    }

    public void setValorObtenido(float valorObtenido) {
        this.valorObtenido = valorObtenido;
    }

    //CONSTRUCTORES
    public ValorObtenido() {
    }

    public ValorObtenido(Parametro parametro, float valorObtenido) {
        this.parametro = parametro;
        this.valorObtenido = valorObtenido;
    }
}
