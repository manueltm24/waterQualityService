package com.waterQualityService.Services;


import com.waterQualityService.Clases.ParametroValor;
import com.waterQualityService.GestionDb;

/**
 * Created by john on 10/07/17.
 */
public class ParametroValorService extends GestionDb<ParametroValor> {
    private static ParametroValorService instancia;

    private ParametroValorService() {
        super(ParametroValor.class);
    }

    public static ParametroValorService getInstancia(){
        if(instancia==null){
            instancia = new ParametroValorService();
        }
        return instancia;
    }
}
