package mx.uv.c80640;
import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;

import javax.sound.sampled.Port;
import com.google.gson.Gson;
import com.google.gson.JsonParser;

/**
 * Hello world!
 *
 */
public class App 
{
    public static Gson gson =new Gson();
    //base de datos en memoria
    public static Map<String, Usuario> usuarios =new HashMap<>();
    public static void main( String[] args )
    {
    //Inicialización de datos
    Usuario u1 = new Usuario("1", "pablo", "1234");
    Usuario u2 = new Usuario("2", "Ana", "12345");
    usuarios.put(u1.getId(), u2);
    usuarios.put(u2.getId(), u1);
        System.out.println( "Hello World!" );
        port(80);
        before((req, res)->res.type("application/json"));
        //get("/usuario", (req, res)->gson.toJson(u1));
        get("/usuarios", (req, res)->gson.toJson(usuarios));
        
        post("/usuarios", (req, res)->{
            String datosFormulario = req.body();
            Usuario u = gson.fromJson(datosFormulario, Usuario.class);//convertirlo a usuario
            usuarios.put(u.getId(),u);
            return "Usuario Agregado";
        });//curl -X POST -d '{id:"3",nombre:"jose",pass:"123"}' http://localhost/usuarios
    }
    /*public static void main (String[] args){
        port(80);
        before((req, res)->res.type("application/json"));
        get("/usuarios", (req, res)->gson.toJson(DAO.dameUsuarios));
        post("usuarios", (req, res)->{
            String usuario_request=req.body();
        });
    }*/
}
