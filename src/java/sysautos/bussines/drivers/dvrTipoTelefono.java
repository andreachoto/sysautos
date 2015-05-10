/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.drivers;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import sysautos.bussines.entities.TipoTelefono;
import sysautos.integration.Conexion;
import sysautos.integration.Parameter;


/**
 *
 * @author Carolyn
 */
public class dvrTipoTelefono {
     //Insertar un nuevo registro a la tabla
    public static int tipoTelefonoRegister(TipoTelefono objeto) throws Exception {
        int codigo = 0;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getNombre(), Types.VARCHAR));
        parametros.add(new Parameter(2, objeto.getDescripcion(), Types.VARCHAR));
        String llamadaPA = "SELECT autos.\"tipoTelefonoRegister_pa\"(?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            codigo = con.getInt("tipoTelefonoRegister_pa");
        }
        con.cerrarConexion();
        return codigo;
    }
    //Editar un nuevo registro de la tabla
    public static boolean tipoTelefonoUpdate(TipoTelefono objeto) throws Exception {
        boolean respuesta = false;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getId(), Types.INTEGER));
        parametros.add(new Parameter(2, objeto.getNombre(), Types.VARCHAR));
        parametros.add(new Parameter(3, objeto.getDescripcion(), Types.VARCHAR));
        String llamadaPA = "SELECT autos.\"tipoTelefonoUpdate_pa\"(?,?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            respuesta = true;
        }
        con.cerrarConexion();
        return respuesta;
    }
    //Eliminar un registro de la tabla
    public static boolean tipoTelefonoDelete(TipoTelefono objeto) throws Exception {
        boolean respuesta = false;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getId(), Types.INTEGER));
        String llamadaPA = "SELECT autos.\"tipoTelefonoDelete_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            respuesta = true;
        }
        con.cerrarConexion();
        return respuesta;
    }
    //Listar todos los registros de la tabla
    public static List<TipoTelefono> getTipoTelefonoList() throws Exception {
        List<TipoTelefono> lista = new ArrayList<>();
        String llamadaPA = "SELECT * from autos.\"tipoTelefonoSelectAll_pa\"()";
        Conexion con = new Conexion(llamadaPA);
        while (con.siguiente()) {
            int id = con.getInt("outid");
            String nombre = con.getString("outnombre");
            String descripcion=con.getString("outdescripcion");
            lista.add(new TipoTelefono(id,nombre,descripcion));
        }
        con.cerrarConexion();
        return lista;
    }
    //Listar los registros de la tabla dado el nombre 
    public static List<TipoTelefono> getTipoTelefonoListByName(String text) throws Exception {
        List<TipoTelefono> lista = new ArrayList<>();
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, text, Types.VARCHAR));
        String llamadaPA = "SELECT * from autos.\"tipoTelefonoByName_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            int id = con.getInt("outid");
            String nombre = con.getString("outnombre");
            String descripcion=con.getString("outdescripcion");
            lista.add(new TipoTelefono(id,nombre,descripcion));
        }
        con.cerrarConexion();
        return lista;
    }
    
//     //Listar los registros de la entidad por id foraneo 
//    public static List<TipoTelefono> getTipoTelefonoListByMagnitudeId(int val) throws Exception {
//        List<TipoTelefono> lista = new ArrayList<>();
//        List<Parameter> parametros = new ArrayList<>();
//        parametros.add(new Parameter(1, val, Types.INTEGER));
//        String llamadaPA = "SELECT * from autos.\"tipoTelefonoByMagnitudeID_pa\"(?)";
//        Conexion con = new Conexion(llamadaPA, parametros);
//        while (con.siguiente()) {
//            int id = con.getInt("out_Id");
//            String nombre = con.getString("out_nombre");
//            String desc = con.getString("out_desc");
//            boolean active = con.getBoolean("out_active");
//            lista.add(new TipoTelefono(id,nombre, desc, active));
//        }
//        con.cerrarConexion();
//        return lista;
//    }
    
    //Listar los registros de la tabla dado el nombre 
    public static TipoTelefono getTipoTelefonoById(int val) throws Exception {
        TipoTelefono var = null;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, val, Types.INTEGER));
        String llamadaPA = "SELECT * from autos.\"tipoTelefonoByID_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        if (con.siguiente()) {
            int id = con.getInt("outid");
            String nombre = con.getString("outnombre");
            String descripcion=con.getString("outdescripcion");
            var = new TipoTelefono(id,nombre,descripcion);
        }
        con.cerrarConexion();
        return var;
    }
    
    
}
