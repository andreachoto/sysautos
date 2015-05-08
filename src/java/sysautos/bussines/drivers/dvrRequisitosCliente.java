/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.drivers;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import sysautos.bussines.entities.ClienteCredito;
import sysautos.bussines.entities.Requisitos;
import sysautos.bussines.entities.RequisitosCliente;
import sysautos.integration.Conexion;
import sysautos.integration.Parameter;

/**
 *
 * @author DISMAGIC0985043396
 */
public class dvrRequisitosCliente {

    public static int userReqClienteRegister(int modo, int cliente, int credito, boolean verificacion) throws Exception {
        int codigo = 0;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, modo, Types.INTEGER));
        parametros.add(new Parameter(2, cliente, Types.INTEGER));
        parametros.add(new Parameter(3, credito, Types.INTEGER));
        parametros.add(new Parameter(4, verificacion, Types.BOOLEAN));

        String llamadaPA = "SELECT autos.\"reclientesRegister_pa\"(?,?,?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            codigo = con.getInt("reclientesRegister_pa");
        }
        con.cerrarConexion();
        return codigo;
    }
//    
//     public static int ReqClienteRegister1(RequisitosClienteCliente objeto) throws Exception {
//        int codigo = 0;
//        List<Parameter> parametros = new ArrayList<>();
//        parametros.add(new Parameter(1, objeto.getRequisitosCliente().getRqtid(), Types.INTEGER));
//        parametros.add(new Parameter(2, objeto.getCltid(), Types.INTEGER));
//        parametros.add(new Parameter(3, objeto.isVerificacion(), Types.BOOLEAN));
//        parametros.add(new Parameter(4, objeto.getClicred(), Types.INTEGER));
//
//        String llamadaPA = "SELECT autos.\"rqpagosRegister_pa\"(?,?,?,?)";
//        Conexion con = new Conexion(llamadaPA, parametros);
//        while (con.siguiente()) {
//            codigo = con.getInt("rqpagosRegister_pa");
//        }
//        con.cerrarConexion();
//        return codigo;
//    }

///All_pa"(OUT outrqtid integer, OUT outcltid integer, OUT outcrtid integer, OUT outrqcverificacion boolean
    public static List<RequisitosCliente> getRequisitosClienteList() throws Exception {
        List<RequisitosCliente> lista = new ArrayList<>();
        String llamadaPA = "SELECT * from autos.\"requisitosclienteSelectAll_pa\"()";
        Conexion con = new Conexion(llamadaPA);
        while (con.siguiente()) {
            int requ = con.getInt("outrqtid");
            int cliente = con.getInt("outcltid");
            int credito = con.getInt("outcrtid");
            boolean verificacion = con.getBoolean("outrqcverificacion");
            lista.add(new RequisitosCliente(requ, cliente, credito, verificacion));
        }
        con.cerrarConexion();
        return lista;
    }

    //Listar los registros de la tabla dado su ID 
//    public static RequisitosCliente getRequisitosClienteById(int val) throws Exception {
//        RequisitosCliente var = null;
//        List<Parameter> parametros = new ArrayList<>();
//        parametros.add(new Parameter(1, val, Types.INTEGER));
//        String llamadaPA = "SELECT * from upkeep.\"userTypeByID_pa\"(?)";
//        Conexion con = new Conexion(llamadaPA, parametros);
//        if (con.siguiente()) {
//            int id = con.getInt("outid");
//            int drqid = con.getInt("outdrqid");
//            int mdpid = con.getInt("outmdpid");
//            int aplid = con.getInt("outaplid");
//            var = new RequisitosCliente(id, drqid, mdpid, aplid);
//        }
//        con.cerrarConexion();
//        return var;
//    }
//     public static List<RequisitosCliente> getRequisitosClienteListByTipo(int tipo) throws Exception {
//        List<RequisitosCliente> lista = new ArrayList<>();
//        List<Parameter> parametros = new ArrayList<>();
//        parametros.add(new Parameter(1, tipo, Types.INTEGER));
//        String llamadaPA = "SELECT * from autos.\"retipdeinByID_pa\"(?)";
//        Conexion con = new Conexion(llamadaPA, parametros);
//        while (con.siguiente()) {
//            int id = con.getInt("outid");
//            int tip = con.getInt("outapli");
//            int re = con.getInt("outrequi");
//            int mod = con.getInt("outmodo");
//            lista.add(new RequisitosCliente(id, tip, re, mod));
//        }
//        con.cerrarConexion();
//        return lista;
//    }
    public static List<Requisitos> getRequisitosListByTipo(int tipo) throws Exception {
        List<Requisitos> lista = new ArrayList<>();
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, tipo, Types.INTEGER));
        String llamadaPA = "SELECT * from autos.\"clientecreditoByID_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            int id = con.getInt("outid");

            lista.add(new Requisitos(id));
        }
        con.cerrarConexion();
        return lista;
    }

    public static List<ClienteCredito> getClientesListByCrdito(int codigo) throws Exception {
        List<ClienteCredito> lista = new ArrayList<>();
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, codigo, Types.INTEGER));
        String llamadaPA = "SELECT * from autos.\"clientecreditoByID_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            int id = con.getInt("outclid");
            int cre= con.getInt("outcrtid");
            int tipo= con.getInt("outtip");

            lista.add(new ClienteCredito(id,cre,tipo));
        }
      
  
        con.cerrarConexion();
        return lista;
    }

}
