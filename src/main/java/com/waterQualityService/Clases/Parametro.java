package com.waterQualityService.Clases;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by MT on 6/24/2017.
 */
@Entity
public class Parametro {
    @Id
    @GeneratedValue
    private long id;
    private String nombreParametro;
    private float valor;

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreParametro() {
        return nombreParametro;
    }

    public void setNombreParametro(String nombreParametro) {
        this.nombreParametro = nombreParametro;
    }

    public Parametro(){

    }

    public Parametro(String nombreParametro, float valor) {
        this.nombreParametro = nombreParametro;
        this.valor = valor;
    }
}
