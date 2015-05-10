/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.drivers;

import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import sysautos.bussines.entities.Cliente;
import sysautos.bussines.entities.Identificacion;
import sysautos.integration.Conexion;
import sysautos.integration.Parameter;


/**
 *
 * @author Carolyn
 */
public class dvrIdentificacion {
     //Insertar un nuevo registro a la tabla
    public static boolean identificacionRegister(Identificacion objeto) throws Exception {
             boolean codigo =false;
        try {
          
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getCltid(), Types.INTEGER));
        parametros.add(new Parameter(2, objeto.getTidid(), Types.INTEGER));
        parametros.add(new Parameter(3, objeto.getNumdescripcion(), Types.VARCHAR));
        parametros.add(new Parameter(4, objeto.getEstado(), Types.VARCHAR));
        String llamadaPA = "SELECT autos.\"identificacionRegister_pa\"(?,?,?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            codigo = con.getBoolean("identificacionRegister_pa");
        }
        con.cerrarConexion();
       
        } catch (SQLException e) {
            
        }
         return codigo;
     
    }
    //Editar un nuevo registro de la tabla
    public static boolean identificacionUpdate(Identificacion objeto) throws Exception {
        boolean respuesta = false;
        List<Parameter> parametros = new ArrayList<>();
       parametros.add(new Parameter(1, objeto.getCltid(), Types.INTEGER));
        parametros.add(new Parameter(2, objeto.getTidid(), Types.INTEGER));
        parametros.add(new Parameter(3, objeto.getNumdescripcion(), Types.VARCHAR));
        parametros.add(new Parameter(4, objeto.getEstado(), Types.VARCHAR));
        String llamadaPA = "SELECT autos.\"identificacionUpdate_pa\"(?,?,?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            respuesta = true;
        }
        con.cerrarConexion();
        return respuesta;
    }
    //Eliminar un registro de la tabla
    public static boolean identificacionDelete(Identificacion objeto) throws Exception {
        boolean respuesta = false;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getCltid(), Types.INTEGER));
         //parametros.add(new Parameter(2, objeto.getTidid(), Types.INTEGER));
        String llamadaPA = "SELECT autos.\"identificacionDeleteById_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            respuesta = true;
        }
        con.cerrarConexion();
        return respuesta;
    }
    //Listar todos los registros de la tabla
    public static List<Identificacion> getidentificacionList() throws Exception {
        List<Identificacion> lista = new ArrayList<>();
        String llamadaPA = "SELECT * from autos.\"identificacionSelectAll_pa\"()";
        Conexion con = new Conexion(llamadaPA);
        while (con.siguiente()) {
            int cltid = con.getInt("outcltid");
            int tidid = con.getInt("outtidid");
            String numdescripcion = con.getString("outnumero");
            String estado=con.getString("outestado");
            lista.add(new Identificacion(cltid, tidid,numdescripcion,estado));
        }
        con.cerrarConexion();
        return lista;
    }
    
//    //Listar los registros de la tabla dado el nombre 
//    public static List<Identificacion> getidentificacionListByName(String text) throws Exception {
//        List<Identificacion> lista = new ArrayList<>();
//        List<Parameter> parametros = new ArrayList<>();
//        parametros.add(new Parameter(1, text, Types.VARCHAR));
//        String llamadaPA = "SELECT * from autos.\"identificacionByName_pa\"(?)";
//        Conexion con = new Conexion(llamadaPA, parametros);
//        while (con.siguiente()) {
//           int ustid = con.getInt("out_ustid");
//            int rolid = con.getInt("out_rolid");
//            lista.add(new Identificacion(ustid, rolid));
//        }
//        con.cerrarConexion();
//        return lista;
//    }
    
    //Listar los registros de la tabla dado el nombre 
    public static Identificacion getidentificacionById(int id1, int id2) throws Exception {
        Identificacion var = null;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, id1, Types.INTEGER));
        parametros.add(new Parameter(2, id2, Types.INTEGER));
        String llamadaPA = "SELECT * from autos.\"identificacionByID_pa\"(?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        if (con.siguiente()) {
            int cltid = con.getInt("outcltid");
            int tidid = con.getInt("outtidid");
            String numdescripcion = con.getString("outidfnumerodescrip");
            String estado=con.getString("outidfestado");
            var = new Identificacion(cltid, tidid,numdescripcion,estado);
        }
        con.cerrarConexion();
        return var;
    }

//    public static List<Identificacion> getidentificacionListByCliente(int inustid) throws Exception {
//       
//        List<Identificacion> lista = new ArrayList<>();
//        List<Parameter> parametros = new ArrayList<>();
//        parametros.add(new Parameter(1,inustid, Types.INTEGER));
//        String llamadaPA = "SELECT * from autos.\"identificacionByCliente_pa\"(?)";
//        Conexion con = new Conexion(llamadaPA, parametros);
//        while (con.siguiente()) {
//            int cltid = con.getInt("out_cltid");
//            int tidid = con.getInt("out_tidid");
//            String numdescripcion = con.getString("out_numdescripcion");
//            String estado=con.getString("out_estado");
//            lista.add(new Identificacion(cltid, tidid,numdescripcion,estado));
//            
//        }
//        con.cerrarConexion();
//        return lista;
//    
//    
//    }

    public  static boolean identificacionDeleteByCliente(Cliente objeto) throws Exception {
       
        boolean respuesta = false;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getId(), Types.INTEGER));
        String llamadaPA = "SELECT autos.\"identificacionDeleteByCliente_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            respuesta = true;
        }
        con.cerrarConexion();
        return respuesta;
    
    }
       public static Identificacion getidentificacionByIdCliente(int id1) throws Exception {
        Identificacion var = null;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, id1, Types.INTEGER));
        String llamadaPA = "SELECT * from autos.\"identificacionByID_paCliente\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        if (con.siguiente()) {
            int cltid = con.getInt("outcltid");
            int tidid = con.getInt("outtidid");
            String numdescripcion = con.getString("outidfnumerodescrip");
            String estado=con.getString("outidfestado");
            var = new Identificacion(cltid, tidid,numdescripcion,estado);
        }
        con.cerrarConexion();
        return var;
    }
       
        public static Identificacion getidentificacionByIdTipoIdent(int id1) throws Exception {
        Identificacion var = null;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, id1, Types.INTEGER));
        String llamadaPA = "SELECT * from autos.\"identificacionByID_paTipoIdent\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        if (con.siguiente()) {
            int cltid = con.getInt("outcltid");
            int tidid = con.getInt("outtidid");
            String numdescripcion = con.getString("outidfnumerodescrip");
            String estado=con.getString("outidfestado");
            var = new Identificacion(cltid, tidid,numdescripcion,estado);
        }
        con.cerrarConexion();
        return var;
    }
    
    
}
