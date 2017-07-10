package com.waterQualityService.Services;


import com.waterQualityService.Clases.Parametro;
import com.waterQualityService.GestionDb;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * Created by MT on 6/24/2017.
 */
public class ParametrosService extends GestionDb<Parametro> {
    private static ParametrosService instancia;

    private ParametrosService() {
        super(Parametro.class);
    }

    public static ParametrosService getInstancia(){
        if(instancia==null){
            instancia = new ParametrosService();
        }
        return instancia;
    }

    public Parametro findByNombre(String nombre){
        EntityManager em = getEntityManager();
        Query query = em.createQuery("select e from Parametro e where e.nombreParametro like :nombre");
        query.setParameter("nombre", nombre+"%");
        Parametro parametro = (Parametro) query.getSingleResult();
        return parametro;
    }


}
