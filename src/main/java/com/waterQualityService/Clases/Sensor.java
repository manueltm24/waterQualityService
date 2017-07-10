package com.waterQualityService.Clases;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by john on 04/07/17.
 */

@Entity
public class Sensor extends Entidad {

    @Id
    @GeneratedValue
    private long Id;



}
