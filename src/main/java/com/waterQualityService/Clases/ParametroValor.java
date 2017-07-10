package com.waterQualityService.Clases;

import javax.persistence.*;
import java.util.List;

/**
 * Created by john on 04/07/17.
 */

//Considerar cambiar el nombre de esa clase como Parametro en vez de ParametroValor
@Entity
public class ParametroValor {
    @Id
    @GeneratedValue
    private long Id;
    private long nivelMaximo;
    private long nivelMinimo;
    private String unidadMedida;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Sensor> sensors;

    public ParametroValor(long nivelMaximo, long nivelMinimo, String unidadMedida, List<Sensor> sensors) {
        this.nivelMaximo = nivelMaximo;
        this.nivelMinimo = nivelMinimo;
        this.unidadMedida = unidadMedida;
        this.sensors = sensors;
    }

    public ParametroValor() {
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public long getNivelMaximo() {
        return nivelMaximo;
    }

    public void setNivelMaximo(long nivelMaximo) {
        this.nivelMaximo = nivelMaximo;
    }

    public long getNivelMinimo() {
        return nivelMinimo;
    }

    public void setNivelMinimo(long nivelMinimo) {
        this.nivelMinimo = nivelMinimo;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public List<Sensor> getSensors() {
        return sensors;
    }

    public void setSensors(List<Sensor> sensors) {
        this.sensors = sensors;
    }
}
