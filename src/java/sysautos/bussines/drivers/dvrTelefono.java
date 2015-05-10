/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.drivers;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import sysautos.bussines.entities.Telefono;
import sysautos.integration.Conexion;
import sysautos.integration.Parameter;


/**
 *
 * @author Carolyn
 */
public class dvrTelefono {
     //Insertar un nuevo registro a la tabla
    public static int telefonoRegister(Telefono objeto) throws Exception {
        int codigo = 0;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getCltid(), Types.INTEGER));
        parametros.add(new Parameter(2, objeto.getTtfid(), Types.INTEGER));
        parametros.add(new Parameter(3, objeto.getNumero(), Types.VARCHAR));
        parametros.add(new Parameter(4, objeto.getOperadora(), Types.VARCHAR));
        parametros.add(new Parameter(5, objeto.getEstado(), Types.VARCHAR));
        String llamadaPA = "SELECT autos.\"telefonoRegister_pa\"(?,?,?,?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            codigo = con.getInt("telefonoRegister_pa");
        }
        con.cerrarConexion();
        return codigo;
    }
    //Editar un nuevo registro de la tabla
    public static boolean telefonoUpdate(Telefono objeto) throws Exception {
        boolean respuesta = false;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getId(), Types.INTEGER));
        parametros.add(new Parameter(2, objeto.getCltid(), Types.INTEGER));
        parametros.add(new Parameter(3, objeto.getTtfid(), Types.INTEGER));
        parametros.add(new Parameter(4, objeto.getNumero(), Types.VARCHAR));
        parametros.add(new Parameter(5, objeto.getOperadora(), Types.VARCHAR));
        parametros.add(new Parameter(6, objeto.getEstado(), Types.VARCHAR));
        String llamadaPA = "SELECT autos.\"telefonoUpdate_pa\"(?,?,?,?,?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            respuesta = true;
        }
        con.cerrarConexion();
        return respuesta;
    }
    //Eliminar un registro de la tabla
    public static boolean telefonoDelete(Telefono objeto) throws Exception {
        boolean respuesta = false;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getId(), Types.INTEGER));
        String llamadaPA = "SELECT autos.\"telefonoDelete_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            respuesta = true;
        }
        con.cerrarConexion();
        return respuesta;
    }
    //Listar todos los registros de la tabla
    public static List<Telefono> getTelefonoList() throws Exception {
        List<Telefono> lista = new ArrayList<>();
        String llamadaPA = "SELECT * from autos.\"telefonoSelectAll_pa\"()";
        Conexion con = new Conexion(llamadaPA);
        while (con.siguiente()) {
            int id = con.getInt("outid");
            int cltid = con.getInt("outcltid");
            int ttfid = con.getInt("outttfid");
            String numero = con.getString("outnumero");
            String operadora = con.getString("outoperadora");
            String estado = con.getString("outestado");
            lista.add(new Telefono(id,cltid, ttfid, numero,operadora,estado));
        }
        con.cerrarConexion();
        return lista;
    }
    //Listar los registros de la tabla dado el nombre 
    public static List<Telefono> getTelefonoListByName(String text) throws Exception {
        List<Telefono> lista = new ArrayList<>();
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, text, Types.VARCHAR));
        String llamadaPA = "SELECT * from autos.\"telefonoByName_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
              int id = con.getInt("outid");
            int cltid = con.getInt("outcltid");
            int ttfid = con.getInt("outttfid");
            String numero = con.getString("outnumero");
            String operadora = con.getString("outoperadora");
            String estado = con.getString("outestado");
            lista.add(new Telefono(id,cltid, ttfid, numero,operadora,estado));
           
        }
        con.cerrarConexion();
        return lista;
    }
    
//     //Listar los registros de la entidad por id foraneo 
//    public static List<Telefono> getTelefonoListByMagnitudeId(int val) throws Exception {
//        List<Telefono> lista = new ArrayList<>();
//        List<Parameter> parametros = new ArrayList<>();
//        parametros.add(new Parameter(1, val, Types.INTEGER));
//        String llamadaPA = "SELECT * from autos.\"telefonoByMagnitudeID_pa\"(?)";
//        Conexion con = new Conexion(llamadaPA, parametros);
//        while (con.siguiente()) {
//            int id = con.getInt("out_Id");
//            String name = con.getString("out_name");
//            String desc = con.getString("out_desc");
//            boolean active = con.getBoolean("out_active");
//            lista.add(new Telefono(id,name, desc, active));
//        }
//        con.cerrarConexion();
//        return lista;
//    }
    
    //Listar los registros de la tabla dado el nombre 
    public static Telefono getTelefonoById(int val) throws Exception {
        Telefono var = null;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, val, Types.INTEGER));
        String llamadaPA = "SELECT * from autos.\"telefonoByID_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        if (con.siguiente()) {
              int id = con.getInt("outid");
            int cltid = con.getInt("outcltid");
            int ttfid = con.getInt("outttfid");
            String numero = con.getString("outnumero");
            String operadora = con.getString("outoperadora");
            String estado = con.getString("outestado");
            var = new Telefono(id,cltid, ttfid, numero,operadora,estado);
        }
        con.cerrarConexion();
        return var;
    }
    
     public static Telefono getTelefonoByIdCliente(int val) throws Exception {
        Telefono var = null;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, val, Types.INTEGER));
        String llamadaPA = "SELECT * from autos.\"telefonoByID_paCliente\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        if (con.siguiente()) {
              int id = con.getInt("outid");
            int cltid = con.getInt("outcltid");
            int ttfid = con.getInt("outttfid");
            String numero = con.getString("outnumero");
            String operadora = con.getString("outoperadora");
            String estado = con.getString("outestado");
            var = new Telefono(id,cltid, ttfid, numero,operadora,estado);
        }
        con.cerrarConexion();
        return var;
    }
    
    
}
