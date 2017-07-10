package com.waterQualityService.Clases;

import javax.persistence.*;
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

}
