package mx.uv.c80640;

import static spark.Spark.*;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        get("/hello", (req, res) -> "Hello World12313");
        post("/", (req, res)->{
            System.out.println(req.queryParams("email")+""+
            req.queryParams("password"));
            System.out.println(req.body());    
            JsonParser parser = new JsonParser();
            JsonElement arbol=parser.parse(req.body());
            JsonObject peticionDelCliente = arbol.getAsJsonObject();
            System.out.println(peticionDelCliente.get("email").getAsString());
            System.out.println(peticionDelCliente.get("password"));
            System.out.println(parser);

            res.status(200);
            JsonObject oRespuesta = new JsonObject();
            oRespuesta.addProperty("msj", "hola");
            //oRespuesta.addProperty("msj", req.queryParams("email"));
            oRespuesta.addProperty("email", peticionDelCliente.get("email").getAsString());

            return oRespuesta;
        });
    }
}

//parser: analizador sintáctico gramatica formal
