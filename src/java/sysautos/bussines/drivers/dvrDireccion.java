/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.drivers;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import sysautos.bussines.entities.Direccion;
import sysautos.integration.Conexion;
import sysautos.integration.Parameter;

/**
 *
 * @author Carolyn
 */
public class dvrDireccion {
  
        //Insertar un nuevo registro a la tabla
    public static boolean direccionRegister(Direccion objeto) throws Exception {
        boolean codigo =false;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getCltid(), Types.INTEGER));
        parametros.add(new Parameter(2, objeto.getTdrid(), Types.INTEGER));
        parametros.add(new Parameter(3, objeto.getCidid(), Types.INTEGER));
        parametros.add(new Parameter(4, objeto.getCalleprincipal(), Types.VARCHAR));
        parametros.add(new Parameter(5, objeto.getCallesecundaria(), Types.VARCHAR));
        parametros.add(new Parameter(6, objeto.getNumcasa(), Types.VARCHAR));
        parametros.add(new Parameter(7, objeto.getParroquia(), Types.VARCHAR));
        parametros.add(new Parameter(8, objeto.getReferencia(), Types.VARCHAR));
        parametros.add(new Parameter(9, objeto.getBarrio(), Types.VARCHAR));
        parametros.add(new Parameter(10, objeto.getSector(), Types.VARCHAR));
        String llamadaPA = "SELECT autos.\"direccionRegister_pa\"(?,?,?,?,?,?,?,?,?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            codigo = con.getBoolean("direccionRegister_pa");
        }
        con.cerrarConexion();
        return codigo;
    }
    
     //Editar un nuevo registro de la tabla
    public static boolean direccionUpdate(Direccion objeto) throws Exception {
        boolean respuesta = false;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getCltid(), Types.INTEGER));
        parametros.add(new Parameter(2, objeto.getTdrid(), Types.INTEGER));
        parametros.add(new Parameter(3, objeto.getCidid(), Types.INTEGER));
        parametros.add(new Parameter(4, objeto.getCalleprincipal(), Types.VARCHAR));
        parametros.add(new Parameter(5, objeto.getCallesecundaria(), Types.VARCHAR));
        parametros.add(new Parameter(6, objeto.getNumcasa(), Types.VARCHAR));
        parametros.add(new Parameter(7, objeto.getParroquia(), Types.VARCHAR));
        parametros.add(new Parameter(8, objeto.getReferencia(), Types.VARCHAR));
        parametros.add(new Parameter(9, objeto.getBarrio(), Types.VARCHAR));
        parametros.add(new Parameter(10, objeto.getSector(), Types.VARCHAR));
        String llamadaPA = "SELECT autos.\"direccionUpdate_pa\"(?,?,?,?,?,?,?,?,?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            respuesta = true;
        }
        con.cerrarConexion();
        return respuesta;
    }
        //Eliminar un registro de la tabla
    public static boolean direccionDelete(Direccion objeto) throws Exception {
        boolean respuesta = false;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getCltid(), Types.INTEGER));
        parametros.add(new Parameter(2, objeto.getTdrid(), Types.INTEGER));
        String llamadaPA = "SELECT autos.\"direccionDelete_pa\"(?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            respuesta = true;
        }
        con.cerrarConexion();
        return respuesta;
    }
       //Listar todos los registros de la tabla
    public static List<Direccion> getDireccionList() throws Exception {
        List<Direccion> lista = new ArrayList<>();
        String llamadaPA = "SELECT * from autos.\"direccionSelectAll_pa\"()";
        Conexion con = new Conexion(llamadaPA);
        while (con.siguiente()) {
            int cltid = con.getInt("outcltid");
            int tdrid=con.getInt("outtdrid");
            int cidid=con.getInt("outcidid");
            String calleprincipal = con.getString("outcalleprincipal");
            String callesecundaria = con.getString("outcallesecundaria");
            String numcasa = con.getString("outnumcasa");
            String parroquia = con.getString("outparroquia");
            String referencia = con.getString("outreferencia");
            String barrio = con.getString("outbarrio");
            String sector = con.getString("outsector");
            lista.add(new Direccion(cltid,tdrid,cidid,calleprincipal,callesecundaria,numcasa,parroquia,referencia,barrio,sector));
        }
        con.cerrarConexion();
        return lista;
    }
       //Listar los registros de la tabla dado el nombre 
    public static List<Direccion> getDireccionListByName(String text) throws Exception {
        List<Direccion> lista = new ArrayList<>();
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, text, Types.VARCHAR));
        String llamadaPA = "SELECT * from autos.\"direccionByName_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            int cltid=con.getInt("outcltid");
            int tdrid = con.getInt("outtdrid");
            int cidid=con.getInt("outcidid");            
            String calleprincipal = con.getString("outcalleprincipal");
            String callesecundaria = con.getString("outcallesecundaria");
            String numcasa = con.getString("outnumcasa");
            String parroquia = con.getString("outparroquia");
            String referencia = con.getString("outreferencia");
            String barrio = con.getString("outbarrio");
            String sector = con.getString("outsector");
            lista.add(new Direccion(cltid,tdrid,cidid,calleprincipal,callesecundaria,numcasa,parroquia,referencia,barrio,sector));
        }
        con.cerrarConexion();
        return lista;
    }
    
     //Listar los registros de la tabla dado el nombre 
    public static Direccion getDireccionById(int incltid, int intdrid) throws Exception {
        Direccion var = null;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, incltid, Types.INTEGER));
        parametros.add(new Parameter(2, intdrid, Types.INTEGER));
        String llamadaPA = "SELECT * from autos.\"direccionByID_pa\"(?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        if (con.siguiente()) {
            int cltid=con.getInt("outcltid");
            int tdrid=con.getInt("outtdrid");            
            int cidid = con.getInt("outcidid");
            String calleprincipal = con.getString("outcalleprincipal");
            String callesecundaria = con.getString("outcallesecundaria");
            String numcasa = con.getString("outnumcasa");
            String parroquia = con.getString("outparroquia");
            String referencia = con.getString("outreferencia");
            String barrio = con.getString("outbarrio");
            String sector = con.getString("outsector");
            var = new Direccion(cltid,tdrid,cidid,calleprincipal,callesecundaria,numcasa,parroquia,referencia,barrio,sector);
        }
        con.cerrarConexion();
        return var;
    }
    
     public static Direccion getDireccionByIdCliente(int incltid) throws Exception {
        Direccion var = null;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, incltid, Types.INTEGER));
        String llamadaPA = "SELECT * from autos.\"direccionByID_paCliente\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        if (con.siguiente()) {
            int cltid=con.getInt("outcltid");
            int tdrid=con.getInt("outtdrid");            
            int cidid = con.getInt("outcidid");
            String calleprincipal = con.getString("outcalleprincipal");
            String callesecundaria = con.getString("outcallesecundaria");
            String numcasa = con.getString("outnumcasa");
            String parroquia = con.getString("outparroquia");
            String referencia = con.getString("outreferencia");
            String barrio = con.getString("outbarrio");
            String sector = con.getString("outsector");
            var = new Direccion(cltid,tdrid,cidid,calleprincipal,callesecundaria,numcasa,parroquia,referencia,barrio,sector);
        }
        con.cerrarConexion();
        return var;
    }

}
