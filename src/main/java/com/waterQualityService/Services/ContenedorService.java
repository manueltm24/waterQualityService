package com.waterQualityService.Services;

import com.waterQualityService.Clases.Contenedor;
import com.waterQualityService.Clases.ParametroValor;
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
