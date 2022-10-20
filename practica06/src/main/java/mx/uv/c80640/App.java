package mx.uv.c80640;


/**
 * Hello world!
 *
 */
import static spark.Spark.*;
public class App 
{
    public static void main(String[] args) {
        system.out.println("Hello world");
        get("/Alex", (req, res) -> "Hello World");
        get("/Eduardo", (req, res) -> "Hello World");
        get("/Brandon", (req, res) -> "Hello World");
        get("/", (req, res)->"<h1>Bienvenido</h1><img src ='https://www.uv.mx/v2/images/logouv.jpg'>");
        post("/", (req, res)->{
            System.out.println(req.queryParams("email")+""+ req.queryPrams("password"));
            System.out.println(req.body());
            res.status(200);
            JasonObject oRespuesta = new JasonObject();
            oRespuesta.addProperty("msj", "hola");
            oRespuesta.addProperty("email", );
        });
    }
}
