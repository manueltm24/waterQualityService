package com.waterQualityService.restServices;

import com.waterQualityService.clases.Muestra;
import com.waterQualityService.services.MuestraService;

import java.util.List;

/**
 * Created by john on 04/07/17.
 */

public class ServicioMuestra {
    private static ServicioMuestra instancia;
    public static MuestraService muestraService=MuestraService.getInstancia();
    public static List<Muestra> muestras=muestraService.findAll();

    public static ServicioMuestra getInstancia(){
        if(instancia==null){
            instancia = new ServicioMuestra();
        }
        return instancia;
    }

    public List<Muestra> getMuestras(){
        return muestras;
    }

    public Muestra getMuestra(long id){
        return muestras.stream().filter(mues -> mues.getId()==id).findFirst().orElse(null);
    }

    public Muestra crearMuestra(Muestra muestra){
        Muestra temporal=new Muestra(muestra.getListaParametros(),muestra.getDireccion());
        muestraService.crear(temporal);
        return temporal;
    }

    public Muestra actualizarMuestra(Muestra muestra){
        Muestra temp= getMuestra(muestra.getId());
        if (temp==null){throw new IllegalArgumentException(String.format("Esa muestra no existe."));}
        temp.setId(muestra.getId());
        temp.setListaParametros(muestra.getListaParametros());
        return temp;
    }

    public Muestra eliminarMuestra(long Id){
        Muestra muestra=getMuestra(Id);
        if (muestra==null){throw new IllegalArgumentException(String.format("Esa muestra no existe."));}
        muestraService.eliminar(muestra);
        return muestra;
    }

}
