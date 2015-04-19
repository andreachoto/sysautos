/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.drivers;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import sysautos.bussines.entities.Detallepedido;
import sysautos.integration.Conexion;
import sysautos.integration.Parameter;

/**
 *
 * @author hp
 */
public class dvrDetallepedido {
    
    
    //Insertar un nuevo registro a la tabla
    public static int detallepedidoRegister(Detallepedido objeto) throws Exception {
        int codigo = 0;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getPedid(), Types.INTEGER));
        parametros.add(new Parameter(2, objeto.getPdtid(), Types.INTEGER));
        parametros.add(new Parameter(3, objeto.getCantidad(), Types.INTEGER));
        parametros.add(new Parameter(4, objeto.getEstado(), Types.VARCHAR));
        parametros.add(new Parameter(5, objeto.getObser(), Types.VARCHAR));
        String llamadaPA = "SELECT autos.\"detallepedidoRegister_pa\"(?,?,?,?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            codigo = con.getInt("detallepedidoRegister_pa");
        }
        con.cerrarConexion();
        return codigo;
    }

    //Editar un nuevo registro de la tabla
    public static boolean detallepedidoUpdate(Detallepedido objeto) throws Exception {
        boolean respuesta = false;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getId(), Types.INTEGER));
        parametros.add(new Parameter(2, objeto.getPedid(), Types.INTEGER));
        parametros.add(new Parameter(3, objeto.getPdtid(), Types.INTEGER));
        parametros.add(new Parameter(4, objeto.getCantidad(), Types.INTEGER));
        parametros.add(new Parameter(5, objeto.getEstado(), Types.VARCHAR));
        parametros.add(new Parameter(6, objeto.getObser(), Types.VARCHAR));
        String llamadaPA = "SELECT autos.\"detallepedidoUpdate_pa\"(?,?,?,?,?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            respuesta = true;
        }
        con.cerrarConexion();
        return respuesta;
    }

    //Eliminar un registro de la tabla
    public static boolean detallepedidoDelete(Detallepedido objeto) throws Exception {
        boolean respuesta = false;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getId(), Types.INTEGER));
        String llamadaPA = "SELECT autos.\"detallepedidoDelete_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            respuesta = true;
        }
        con.cerrarConexion();
        return respuesta;
    }

    //OUT outid integer, OUT  integer, OUT  integer, OUT  integer, 
    //OUT  character varying, OUT  character varying
    //Listar todos los registros de la tabla
    public static List<Detallepedido> getDetallepedidoList() throws Exception {
        List<Detallepedido> lista = new ArrayList<>();
        String llamadaPA = "SELECT * from autos.\"detallepedidoSelectAll_pa\"()";
        Conexion con = new Conexion(llamadaPA);
        while (con.siguiente()) {
            int id = con.getInt("outid");
            int pedid = con.getInt("outpedid");
            int pdtid = con.getInt("outpdtid");
            int cantidad = con.getInt("outcantidad");
            String estado = con.getString("outestado");
            String obser = con.getString("outobser");
            lista.add(new Detallepedido(id, pedid, pdtid, cantidad, estado, obser));
        }
        con.cerrarConexion();
        return lista;
    }

    //Listar los registros de la tabla dado el ID 
    public static Detallepedido getDetallepedidoById(int val) throws Exception {
        Detallepedido var = null;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, val, Types.INTEGER));
        String llamadaPA = "SELECT * from autos.\"detallepedidoByID_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        if (con.siguiente()) {
            int id = con.getInt("outid");
            int pedid = con.getInt("outpedid");
            int pdtid = con.getInt("outpdtid");
            int cantidad = con.getInt("outcantidad");
            String estado = con.getString("outestado");
            String obser = con.getString("outobser");
            var = new Detallepedido(id, pedid, pdtid, cantidad, estado, obser);
        }
        con.cerrarConexion();
        return var;
    }

    //Listar los registros de la tabla dado el nombre 
    public static List<Detallepedido> getDetallepedidoListByName(String text) throws Exception {
        List<Detallepedido> lista = new ArrayList<>();
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, text, Types.VARCHAR));
        String llamadaPA = "SELECT * from autos.\"detallepedidoByName_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            int id = con.getInt("outid");
            int pedid = con.getInt("outpedid");
            int pdtid = con.getInt("outpdtid");
            int cantidad = con.getInt("outcantidad");
            String estado = con.getString("outestado");
            String obser = con.getString("outobser");
            lista.add(new Detallepedido(id, pedid, pdtid, cantidad, estado, obser));
        }
        con.cerrarConexion();
        return lista;
    }
}