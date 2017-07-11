package com.waterQualityService;



import com.waterQualityService.clases.Muestra;
import com.waterQualityService.clases.Parametro;
import com.waterQualityService.services.MuestraService;
import freemarker.template.Configuration;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.*;

import static spark.Spark.*;
import static spark.debug.DebugScreen.enableDebugScreen;

/**
 * Created by MT on 7/3/2017.
 */
public class Main {
    public static void main(String[] args) {
        initSpark();// ** Inicia las funcionalidades Spark **

    }
    private static void initSpark(){
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
        configuration.setClassForTemplateLoading(Main.class, "/templates/");
        FreeMarkerEngine freeMarkerEngine= new FreeMarkerEngine(configuration);

        staticFiles.location("/public");

        //Linea para agregar la pantalla de debug. En productivo se debe quitar.
        enableDebugScreen();

        //Indicando el puerto de Spark,
        port(getPuertoHeroku());


        get("/", (request, response) -> {
            return "Water Quality Service, Manuel Tolentino & John BienAimee";
        });

        /**
         * Obteniendo los parametros...
         * http://localhost:4567/parametros?param1=valor1&param2=valor2&paramN=valorN
         */
        get("/parametros", (request, response) -> {
            procesarParametros(request, response); //encapsular las petición y las respuetas.

            return "Nuevos paramatros procesados:";
        });

        post("/parametros", (request, response) -> {
            return procesarParametros(request, response);
        });


        get("/inicio", (request,response)-> {
            Map<String, Object> attributes = new HashMap<>();

            float valorPH=0, valorTemp=0;

            valorPH=obtenerValorParametro("PH").getValor();
            valorTemp=obtenerValorParametro("TEMPERATURA").getValor();

            attributes.put("valorPH", valorPH);
            attributes.put("valorTemp", valorTemp);
            return new ModelAndView(attributes, "/index.ftl");
        }, freeMarkerEngine );

    }
/*
    private static void restServiceMuestra(){
        //Clase que representa el servicio.
        MuestraService muestraService = MuestraService.getInstancia();

        //Manejo de Excepciones.
        exception(IllegalArgumentException.class, (exception, request, response) -> {
            //manejarError(Main.BAD_REQUEST,exception, request, response);
        });

        exception(JsonSyntaxException.class, (exception, request, response) -> {
           // manejarError(Main.BAD_REQUEST,exception, request, response);
        });

        exception(Exception.class, (exception, request, response) -> {
           // manejarError(Main.ERROR_INTERNO,exception, request, response);
        });

        //rutas servicios RESTFUL
        path("/rest",() -> {
            //filtros especificos:
            afterAfter("/*", (request, response) -> { //indicando que todas las llamadas retorna un json.
                response.header("Content-Type", ACCEPT_TYPE);
            });
            //rutas del api
            path("/muestras", () -> {

                //listar todos los estudiantes.
                get("/", (request, response) -> {
                    return muestraService.findAll();
                }, JsonUtilidades.json());

                //retorna un estudiante
                get("/:id", (request, response) -> { //OJO ID NO ES MUY BUENO PARA ESTO
                    return muestraService.find(Integer.parseInt(request.params("id")));
                }, JsonUtilidades.json());


            });
        });
    }

    private static void manejarError(int codigo,Exception exception, Request request, Response response ){
        response.status(codigo);
        response.body(JsonUtilidades.toJson(new ErrorRespuesta(100, exception.getMessage())));
        exception.printStackTrace();
    }

*/
    static int getPuertoHeroku() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 80; //En caso de no pasar la información, toma el puerto 4567
    }

    private static Object procesarParametros(Request request, Response response){

        Set listaParametros = new HashSet();
        System.out.println("Recibiendo mensaje por el metodo: "+request.requestMethod());
        Set<String> parametros = request.queryParams();
        String salida="";
        float valor=0;
        for(String param : parametros){
            salida+=String.format("Parametro[%s] = %s <br/>", param, request.queryParams(param));
            //System.out.println(request.queryParams(param));
            valor=Float.parseFloat(request.queryParams(param));
            System.out.println(param + ": "+ valor);
            if(param.equals("param1")){
                listaParametros.add(new Parametro("PH",valor));
            }
            if(param.equals("param2")){
                listaParametros.add(new Parametro("TEMPERATURA",valor));
            }
        }
        MuestraService.getInstancia().crear(new Muestra(listaParametros,null));
        return salida;
    }

    private static Parametro obtenerValorParametro(String nombreParametro){
        Parametro parametro1 = new Parametro();
        Set<Parametro> allParametros = MuestraService.getInstancia().findAll().get(MuestraService.getInstancia().findAll().size()-1).getListaParametros();
        List<Parametro> parametroList = new ArrayList<>();

        for(Parametro parametro : allParametros) {
            parametroList.add(parametro);
        }
        for(int i=0;i<parametroList.size();i++){
            if(parametro1==null && parametroList.get(i).getNombreParametro().equals(nombreParametro)){
                parametro1=parametroList.get(i);
            }
            else{
                for(int j=0; j<parametroList.size();j++){
                    if(parametro1.getId()<parametroList.get(i).getId() && parametroList.get(i).getNombreParametro().equals(nombreParametro)){
                        parametro1=parametroList.get(i);
                    }
                }
            }
        }


        return parametro1;


    }
}
