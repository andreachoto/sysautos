/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.drivers;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import sysautos.bussines.entities.TipoIdentidad;
import sysautos.integration.Conexion;
import sysautos.integration.Parameter;


/**
 *
 * @author Carolyn
 */
public class dvrTipoIdentidad {
       //Insertar un nuevo registro a la tabla
    public static int tipoIdentidadRegister(TipoIdentidad objeto) throws Exception {
        int codigo = 0;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getNombre(), Types.VARCHAR));
        parametros.add(new Parameter(2, objeto.getDescripcion(), Types.VARCHAR));
        String llamadaPA = "SELECT autos.\"tipoIdentidadRegister_pa\"(?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            codigo = con.getInt("tipoIdentidadRegister_pa");
        }
        con.cerrarConexion();
        return codigo;
    }
    //Editar un nuevo registro de la tabla
    public static boolean tipoIdentidadUpdate(TipoIdentidad objeto) throws Exception {
        boolean respuesta = false;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getId(), Types.INTEGER));
        parametros.add(new Parameter(2, objeto.getNombre(), Types.VARCHAR));
        parametros.add(new Parameter(3, objeto.getDescripcion(), Types.VARCHAR));
        String llamadaPA = "SELECT autos.\"tipoIdentidadUpdate_pa\"(?,?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            respuesta = true;
        }
        con.cerrarConexion();
        return respuesta;
    }
    //Eliminar un registro de la tabla
    public static boolean tipoIdentidadDelete(TipoIdentidad objeto) throws Exception {
        boolean respuesta = false;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getId(), Types.INTEGER));
        String llamadaPA = "SELECT autos.\"tipoIdentidadDelete_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            respuesta = true;
        }
        con.cerrarConexion();
        return respuesta;
    }
    //Listar todos los registros de la tabla
    public static List<TipoIdentidad> gettipoIdentidadList() throws Exception {
        List<TipoIdentidad> lista = new ArrayList<>();
        String llamadaPA = "SELECT * from autos.\"tipoIdentidadSelectAll_pa\"()";
        Conexion con = new Conexion(llamadaPA);
        while (con.siguiente()) {
            int id = con.getInt("outid");
            String  nombre = con.getString("outnombre");
            String descripcion=con.getString("outdescripcion");
            lista.add(new TipoIdentidad(id, nombre,descripcion));
        }
        con.cerrarConexion();
        return lista;
    }
    
//    //Listar los registros de la tabla dado el nombre 
//    public static List<TipoIdentidad> gettipoIdentidadListByName(String text) throws Exception {
//        List<TipoIdentidad> lista = new ArrayList<>();
//        List<Parameter> parametros = new ArrayList<>();
//        parametros.add(new Parameter(1, text, Types.VARCHAR));
//        String llamadaPA = "SELECT * from autos.\"tipoIdentidadByName_pa\"(?)";
//        Conexion con = new Conexion(llamadaPA, parametros);
//        while (con.siguiente()) {
//           int ustid = con.getInt("out_ustid");
//            int rolid = con.getInt("out_rolid");
//            lista.add(new TipoIdentidad(ustid, rolid));
//        }
//        con.cerrarConexion();
//        return lista;
//    }
    
    //Listar los registros de la tabla dado el nombre 
    public static TipoIdentidad gettipoIdentidadById(int id1) throws Exception {
        TipoIdentidad var = null;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, id1, Types.INTEGER));
        String llamadaPA = "SELECT * from autos.\"tipoIdentidadByID_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        if (con.siguiente()) {
            int id = con.getInt("outid");
            String  nombre = con.getString("outnombre");
            String descripcion=con.getString("outdescripcion");
            var = new TipoIdentidad(id, nombre,descripcion);
        }
        con.cerrarConexion();
        return var;
    }



   public static List<TipoIdentidad> getTipoIdentidadListByName(String text) throws Exception {
        List<TipoIdentidad> lista = new ArrayList<>();
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, text, Types.VARCHAR));
        String llamadaPA = "SELECT * from autos.\"tipoIdentidadByName_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            int id = con.getInt("outid");
            String  nombre = con.getString("outnombre");
            String descripcion=con.getString("outdescripcion");
            lista.add(new TipoIdentidad(id, nombre,descripcion));
        }
        con.cerrarConexion();
        return lista;
    }
   
//      public static TipoIdentidad getTipoIdentidadtById(int text) throws Exception {
//       
//        List<Parameter> parametros = new ArrayList<>();
//        parametros.add(new Parameter(1, text, Types.VARCHAR));
//        String llamadaPA = "SELECT * from autos.\"tipoIdentidadByName_pa\"(?)";
//        Conexion con = new Conexion(llamadaPA, parametros);
//        while (con.siguiente()) {
//            int id = con.getInt("outid");
//            String  nombre = con.getString("outnombre");
//            String descripcion=con.getString("outdescripcion");
//            lista.add(new TipoIdentidad(id, nombre,descripcion));
//        }
//        con.cerrarConexion();
//        return lista;
//    }
    
    
}
