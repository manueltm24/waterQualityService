package com.waterQualityService.clases;


import javax.persistence.*;

/**
 * Created by MT on 6/24/2017.
 */
@Entity
public class Parametro {
    @Id
    @GeneratedValue
    private long id;
    private String nombreParametro;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Sensor sensor;
    private float nivelMaximo;
    private float nivelMinimo;
    private String unidadMedida;

    //GETTERS & SETTERS


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

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public float getNivelMaximo() {
        return nivelMaximo;
    }

    public void setNivelMaximo(float nivelMaximo) {
        this.nivelMaximo = nivelMaximo;
    }

    public float getNivelMinimo() {
        return nivelMinimo;
    }

    public void setNivelMinimo(float nivelMinimo) {
        this.nivelMinimo = nivelMinimo;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    //CONSTRUCTORES


    public Parametro() {
    }

    public Parametro(String nombreParametro, Sensor sensor, float nivelMaximo, float nivelMinimo, String unidadMedida) {
        this.nombreParametro = nombreParametro;
        this.sensor = sensor;
        this.nivelMaximo = nivelMaximo;
        this.nivelMinimo = nivelMinimo;
        this.unidadMedida = unidadMedida;
    }
}
