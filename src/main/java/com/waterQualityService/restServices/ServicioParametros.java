package com.waterQualityService.restServices;

import com.waterQualityService.Clases.Muestra;
import com.waterQualityService.Clases.Parametro;
import com.waterQualityService.Services.MuestraService;
import com.waterQualityService.Services.ParametrosService;

import java.util.List;

/**
 * Created by john on 04/07/17.
 */
public class ServicioParametros {
    private static ServicioParametros instancia;
    public static ParametrosService parametrosService=ParametrosService.getInstancia();
    public static List<Parametro> parametros=parametrosService.findAll();

    public static ServicioParametros getInstancia(){
        if(instancia==null){
            instancia = new ServicioParametros();
        }
        return instancia;
    }

    private List<Parametro> getParametros(){return parametros;}

    private Parametro getParametro(long Id){
        return parametros.stream().filter(param -> param.getId()==Id).findFirst().orElse(null);
    }

    private Parametro crearParametro(Parametro parametro){
        long proximoParametro=(parametros.get(parametros.size()-1).getId())+1;
        Parametro temporal=new Parametro(parametro.getNombreParametro(),parametro.getValor());
        parametrosService.crear(temporal);
        return temporal;
    }

    //revisar
    public Parametro actualizarParametro(Parametro parametro){
        Parametro temp= getParametro(parametro.getId());
        if (temp==null){throw new IllegalArgumentException(String.format("Ese parametro no existe."));}
        temp.setId(parametro.getId());
        return temp;
    }

    public Parametro eliminarParametro(long Id){
        Parametro parametro=getParametro(Id);
        if (parametro==null){throw new IllegalArgumentException(String.format("Ese parametro no existe."));}
        parametrosService.eliminar(parametro);
        return parametro;
    }

}
