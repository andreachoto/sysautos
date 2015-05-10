/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.drivers;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import sysautos.bussines.entities.Pais;
import sysautos.integration.Conexion;
import sysautos.integration.Parameter;


/**
 *
 * @author Carolyn
 */
public class dvrPais {
     //Insertar un nuevo registro a la tabla
    public static int paisRegister(Pais objeto) throws Exception {
        int codigo = 0;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getNombre(), Types.VARCHAR));
         String llamadaPA = "SELECT autos.\"paisRegister_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            codigo = con.getInt("paisRegister_pa");
        }
        con.cerrarConexion();
        return codigo;
    }
    //Editar un nuevo registro de la tabla
    public static boolean paisUpdate(Pais objeto) throws Exception {
        boolean respuesta = false;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getId(), Types.INTEGER));
        parametros.add(new Parameter(2, objeto.getNombre(), Types.VARCHAR));
        String llamadaPA = "SELECT autos.\"paisUpdate_pa\"(?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            respuesta = true;
        }
        con.cerrarConexion();
        return respuesta;
    }
    
    //Eliminar un registro de la tabla
    public static boolean paisDelete(Pais objeto) throws Exception {
        boolean respuesta = false;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getId(), Types.INTEGER));
        String llamadaPA = "SELECT autos.\"paisDelete_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            respuesta = true;
        }
        con.cerrarConexion();
        return respuesta;
    }
    //Listar todos los registros de la tabla
    public static List<Pais> getPaisList() throws Exception {
        List<Pais> lista = new ArrayList<>();
        String llamadaPA = "SELECT * from autos.\"paisSelectAll_pa\"()";
        Conexion con = new Conexion(llamadaPA);
        while (con.siguiente()) {
            int id = con.getInt("outid");
            String nombre = con.getString("outnombre");
            lista.add(new Pais(id,nombre));
        }
        con.cerrarConexion();
        return lista;
    }
    
    //Listar los registros de la tabla dado el nombre 
    public static List<Pais> getPaisListByName(String text) throws Exception {
        List<Pais> lista = new ArrayList<>();
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, text, Types.VARCHAR));
        String llamadaPA = "SELECT * from autos.\"paisByName_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            int id = con.getInt("outid");
            String nombre = con.getString("outnombre");
            lista.add(new Pais(id,nombre));
        }
        con.cerrarConexion();
        return lista;
    }
    
//     //Listar los registros de la entidad por id foraneo 
//    public static List<Pais> getPaisListByMagnitudeId(int val) throws Exception {
//        List<Pais> lista = new ArrayList<>();
//        List<Parameter> parametros = new ArrayList<>();
//        parametros.add(new Parameter(1, val, Types.INTEGER));
//        String llamadaPA = "SELECT * from autos.\"paisByMagnitudeID_pa\"(?)";
//        Conexion con = new Conexion(llamadaPA, parametros);
//        while (con.siguiente()) {
//            int id = con.getInt("out_Id");
//            String nombre = con.getString("out_nombre");
//            String desc = con.getString("out_desc");
//            boolean active = con.getBoolean("out_active");
//            lista.add(new Pais(id,nombre, desc, active));
//        }
//        con.cerrarConexion();
//        return lista;
//    }
    
    //Listar los registros de la tabla dado el nombre 
    public static Pais getPaisById(int val) throws Exception {
        Pais var = null;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, val, Types.INTEGER));
        String llamadaPA = "SELECT * from autos.\"paisByID_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        if (con.siguiente()) {
            int id = con.getInt("outid");
            String nombre = con.getString("outnombre");
            var = new Pais(id,nombre);
        }
        con.cerrarConexion();
        return var;
    }
    

    
}
