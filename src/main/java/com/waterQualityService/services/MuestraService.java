package com.waterQualityService.services;


import com.waterQualityService.clases.Muestra;
import com.waterQualityService.GestionDb;

/**
 * Created by MT on 6/24/2017.
 */
public class MuestraService extends GestionDb<Muestra> {
    private static MuestraService instancia;

    private MuestraService() {
        super(Muestra.class);
    }

    public static MuestraService getInstancia(){
        if(instancia==null){
            instancia = new MuestraService();
        }
        return instancia;
    }
}
