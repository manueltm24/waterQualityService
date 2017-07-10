package com.waterQualityService.Clases;

import javax.persistence.*;

/**
 * Created by john on 04/07/17.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Entidad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    @Column
    private String nombre;


}
