package com.waterQualityService.services;

import com.waterQualityService.clases.Sensor;
import com.waterQualityService.GestionDb;

/**
 * Created by john on 10/07/17.
 */
public class SensorService extends GestionDb<Sensor> {
    private static SensorService instancia;

    private SensorService() {
        super(Sensor.class);
    }

    public static SensorService getInstancia(){
        if(instancia==null){
            instancia = new SensorService();
        }
        return instancia;
    }

}
