package com.waterQualityService.services;

import com.waterQualityService.clases.Direccion;
import com.waterQualityService.GestionDb;

/**
 * Created by john on 10/07/17.
 */

//Hay que tomar en cuenta el usuario que se le va a mandar la notificacion
public class DireccionService extends GestionDb<Direccion> {
    private static DireccionService instancia;

    private DireccionService() {
        super(Direccion.class);
    }

    public static DireccionService getInstancia(){
        if(instancia==null){
            instancia = new DireccionService();
        }
        return instancia;
    }

}
