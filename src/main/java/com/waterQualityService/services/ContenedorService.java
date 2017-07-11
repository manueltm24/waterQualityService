package com.waterQualityService.services;

import com.waterQualityService.clases.Contenedor;
import com.waterQualityService.GestionDb;

/**
 * Created by john on 10/07/17.
 */
public class ContenedorService extends GestionDb<Contenedor> {
    private static ContenedorService instancia;

    private ContenedorService() {
        super(Contenedor.class);
    }

    public static ContenedorService getInstancia(){
        if(instancia==null){
            instancia = new ContenedorService();
        }
        return instancia;
    }

}
