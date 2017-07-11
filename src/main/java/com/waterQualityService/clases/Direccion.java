package com.waterQualityService.clases;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by john on 04/07/17.
 */
@Entity
public class Direccion {
    @Id
    private long Id;
    private Long latitud;
    private Long longitud;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Usuario> usuarios;   ///????????????????
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Parametro> listaParametros;  ///?????????????????
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Muestra muestra;
}
