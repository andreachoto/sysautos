/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.drivers;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sysautos.bussines.entities.ClienteCredito;
import sysautos.bussines.entities.Credit;
import sysautos.bussines.entities.Requisitos;
import sysautos.integration.Conexion;
import sysautos.integration.Parameter;

/**
 *
 * @author DISMAGIC0985043396
 */
public class dvrCredit {

    public static int userCreditoRegister(Credit objeto) throws Exception {
        int codigo = 0;

        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getFecha(), Types.TIMESTAMP));
        parametros.add(new Parameter(2, objeto.getVencimiento(), Types.TIMESTAMP));
        parametros.add(new Parameter(3, objeto.getFormapago(), Types.VARCHAR));
        parametros.add(new Parameter(4, objeto.getMonto(), Types.DECIMAL));
        parametros.add(new Parameter(5, objeto.getInteres(), Types.DECIMAL));
        parametros.add(new Parameter(6, objeto.getPlazo(), Types.INTEGER));
        parametros.add(new Parameter(7, objeto.getIduser(), Types.INTEGER));
        parametros.add(new Parameter(8, objeto.getEstado(), Types.VARCHAR));
        
        String llamadaPA = "SELECT * from autos.creditosregister_pa(?,?,?,?,?,?,?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            codigo = con.getInt("creditosregister_pa");
        }
        return codigo;
    }

    //Listar todos los registros de la tabla
    public static ArrayList<Credit> getuserCreditoList() throws Exception {
        ArrayList<Credit> lista = new ArrayList<>();
        // OUT  character varying, OUT  numeric, OUT  numeric, OUT  integer, OUT  integer)
        String llamadaPA = "SELECT * from autos.\"creditosclientesByID_pa\"()";
        Conexion con = new Conexion(llamadaPA);
        while (con.siguiente()) {
            int id = con.getInt("outcrtid");
            Timestamp fecha = con.getTimestamp("outcrtfecha");
            Timestamp venci = con.getTimestamp("outcrtvencimiento");
            String formap = con.getString("outcrtformapago");
            BigDecimal monto = con.getBigDecimal("outcrtmonto");
            BigDecimal interes = con.getBigDecimal("outcrtinteres");
            int plazo = con.getInt("outcrtplazo");
            int userid = con.getInt("outuserid");
            String estado=con.getString("outcrtestado");
            String cliente=con.getString("outcliente");
            
            lista.add(new Credit(id, fecha, venci, formap, monto, interes, plazo, userid,estado,cliente));
        }

        return lista;
    }
    //Listar los registros de la tabla dado el nombre 

    
    
    public static ArrayList<Credit> getCreditoClienteById(String val) throws Exception {
        ArrayList<Credit> lista = new ArrayList<>();
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, val, Types.VARCHAR));
        String llamadaPA = "SELECT * from autos.\"creditosclientesEstByID_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while(con.siguiente()) {
            int id = con.getInt("outcrtid");
            Timestamp fecha = con.getTimestamp("outcrtfecha");
            Timestamp venci = con.getTimestamp("outcrtvencimiento");
            String formap = con.getString("outcrtformapago");
            BigDecimal monto = con.getBigDecimal("outcrtmonto");
            BigDecimal interes = con.getBigDecimal("outcrtinteres");
            int plazo = con.getInt("outcrtplazo");
            int userid = con.getInt("outuserid");
            String estado=con.getString("outcrtestado");
            String cliente=con.getString("outcliente");
            lista.add( new Credit(id, fecha, venci, formap, monto, interes, plazo, userid,estado,cliente));
        }
      
        return lista;
    }
    
    
    public static Credit getCreditoById(int val) throws Exception {
        Credit var = null;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, val, Types.INTEGER));
        String llamadaPA = "SELECT * from autos.\"creditoclienteByID_pa\"(?)";

 
        Conexion con = new Conexion(llamadaPA, parametros);
        if (con.siguiente()) {
            int id = con.getInt("outcrtid");
            Timestamp fecha = con.getTimestamp("outcrtfecha");
            Timestamp venci = con.getTimestamp("outcrtvencimiento");
            String formap = con.getString("outcrtformapago");
            BigDecimal monto = con.getBigDecimal("outcrtmonto");
            BigDecimal interes = con.getBigDecimal("outcrtinteres");
            int plazo = con.getInt("outcrtplazo");
            int userid = con.getInt("outuserid");
            String estado=con.getString("outcrtestado");
            String cliente=con.getString("outcliente");
            var = new Credit(id, fecha, venci, formap, monto, interes, plazo, userid,estado,cliente);
        }
        con.cerrarConexion();
        return var;
    }
    
    
    
    
    
    
    

}
