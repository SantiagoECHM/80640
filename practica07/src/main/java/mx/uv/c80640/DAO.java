package mx.uv.c80640;

import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

//su objetivo es independizar la logica del negocio
public class DAO{
    public static Conexion c = new  Conexion();

    public static List<Usuario> dameUsuarios(){
        Statement stm = null;
        ResultSet rs = null;
        List<Usuario> resultado = new ArrayList<>();
        Connection cc = null;
        cc = c.getConnection();
        try{
            String sql = "select * from usuarios";
            stm = (Statement)cc.createStatement();
            rs =stm.executeQuery(sql);
            while(rs.next()){
                Usuario u = new Usuario(rs.getString("id"),
                rs.getString("nombre"), rs.getString("password"));
                resultado.add(u);
            }
            rs = null;
        }catch(Exception e){
            System.out.println(e);
        } finally {
            if(rs != null){
                try{
                    rs.close();
                }catch(SQLException e){
                    System.out.println(e);
                }
            }
        }

        return resultado;
    }

    public static String crearUsuario(Usuario u){
        PreparedStatement stm = null;
        Connection cc = null;
        String msj="";

        cc=c.getConnection();
        try{
            String sql = "insert into usuarios (id,nombre,password) values (?,?,?)";
            stm = (PreparedStatement) cc.prepareStatement(sql);
            stm.setString(1, u.getId());
            stm.setString(2, u.getNombre());
            stm.setString(3, u.getPassword());
            if(stm.executeUpdate() > 0)
                msj+="El usuario se agrego";
            else
                msj+="El usuario no se agrego";
        }catch(Exception e){
            System.out.println(e);
        }
        return msj;
    }
}