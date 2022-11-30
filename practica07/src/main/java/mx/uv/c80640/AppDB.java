package mx.uv.c80640;
import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;

import com.google.gson.Gson;


public class AppDB 
    
{
    public static Gson gson = new Gson();
    //base de datos en memoria
    public static Map<String, Usuario> usuarios = new HashMap<>();
    public Conexion c = new Conexion();
    public static void main( String[] args )
    {

        port(80);

        before((req, res)-> res.type("application/json"));

        get("/usuarios", (req, res)-> gson.toJson(DAO.dameUsuarios() ));


        post("/usuarios", (req, res)->{
            String usuario_request = req.body();
            // logger.info(usuario_request);
            Usuario u = gson.fromJson(usuario_request, Usuario.class);
            String id = UUID.randomUUID().toString();
            u.setId(id);
            return "usuarioAgregado";
        });
        post("/", (req, res)->{
            String datosFormulario = req.body();
            Usuario u = gson.fromJson(datosFormulario, Usuario.class);
            return DAO.crearUsuario(u);
        })

    }
}
