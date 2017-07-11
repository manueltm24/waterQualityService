package com.waterQualityService.clases;


import javax.persistence.*;
import java.util.List;

/**
 * Created by MT on 6/24/2017.
 */
@Entity
public class Muestra {

    @Id
    @GeneratedValue
    private long id;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Normativa normativa;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Contenedor contenedor;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ValorObtenido> valoresObtenidos;

    //GETTERS & SETTERS

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Normativa getNormativa() {
        return normativa;
    }

    public void setNormativa(Normativa normativa) {
        this.normativa = normativa;
    }

    public Contenedor getContenedor() {
        return contenedor;
    }

    public void setContenedor(Contenedor contenedor) {
        this.contenedor = contenedor;
    }

    public List<ValorObtenido> getValoresObtenidos() {
        return valoresObtenidos;
    }

    public void setValoresObtenidos(List<ValorObtenido> valoresObtenidos) {
        this.valoresObtenidos = valoresObtenidos;
    }

    //CONTRUCTORES

    public Muestra() {
    }

    public Muestra(Normativa normativa, Contenedor contenedor, List<ValorObtenido> valoresObtenidos) {
        this.normativa = normativa;
        this.contenedor = contenedor;
        this.valoresObtenidos = valoresObtenidos;
    }
}
