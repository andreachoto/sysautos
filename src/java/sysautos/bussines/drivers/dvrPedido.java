/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.drivers;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import sysautos.bussines.entities.Pedido;
import sysautos.integration.Conexion;
import sysautos.integration.Parameter;

/**
 *
 * @author hp
 */
public class dvrPedido {
    
    //Insertar un nuevo registro a la tabla
    public static int pedidoRegister(Pedido objeto) throws Exception {
        int codigo = 0;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getPvdid(), Types.INTEGER));
        parametros.add(new Parameter(2, objeto.getUsrid(), Types.VARCHAR));
        parametros.add(new Parameter(3, objeto.getFecha(), Types.TIMESTAMP));
        parametros.add(new Parameter(4, objeto.getEstado(), Types.VARCHAR));
        String llamadaPA = "SELECT autos.\"pedidoRegister_pa\"(?,?,?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            codigo = con.getInt("pedidoRegister_pa");
        }
        con.cerrarConexion();
        return codigo;
    }

    //Editar un nuevo registro de la tabla
    public static boolean pedidoUpdate(Pedido objeto) throws Exception {
        boolean respuesta = false;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getId(), Types.INTEGER));
        parametros.add(new Parameter(2, objeto.getPvdid(), Types.INTEGER));
        parametros.add(new Parameter(3, objeto.getUsrid(), Types.VARCHAR));
        parametros.add(new Parameter(4, objeto.getFecha(), Types.TIMESTAMP));
        parametros.add(new Parameter(5, objeto.getEstado(), Types.VARCHAR));
        String llamadaPA = "SELECT autos.\"pedidoUpdate_pa\"(?,?,?,?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            respuesta = true;
        }
        con.cerrarConexion();
        return respuesta;
    }

    //Eliminar un registro de la tabla
    public static boolean pedidoDelete(Pedido objeto) throws Exception {
        boolean respuesta = false;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getId(), Types.INTEGER));
        String llamadaPA = "SELECT autos.\"pedidoDelete_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            respuesta = true;
        }
        con.cerrarConexion();
        return respuesta;
    }
    
    //OUT outid integer, OUT  integer, OUT  integer, OUT  timestamp, 
    //OUT  character

    //Listar todos los registros de la tabla
    public static List<Pedido> getPedidoList() throws Exception {
        List<Pedido> lista = new ArrayList<>();
        String llamadaPA = "SELECT * from autos.\"pedidoSelectAll_pa\"()";
        Conexion con = new Conexion(llamadaPA);
        while (con.siguiente()) {
            int id = con.getInt("outid");
            int pvdid = con.getInt("outpvdid");
            int usrid = con.getInt("outusrid");
            Timestamp fecha = con.getTimestamp("outfecha");
            String estado = con.getString("outestado");
            lista.add(new Pedido(id, pvdid, usrid, fecha, estado));
        }
        con.cerrarConexion();
        return lista;
    }

    //Listar los registros de la tabla dado el ID 
    public static Pedido getPedidoById(int val) throws Exception {
        Pedido var = null;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, val, Types.INTEGER));
        String llamadaPA = "SELECT * from autos.\"pedidoByID_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        if (con.siguiente()) {
            int id = con.getInt("outid");
            int pvdid = con.getInt("outpvdid");
            int usrid = con.getInt("outusrid");
            Timestamp fecha = con.getTimestamp("outfecha");
            String estado = con.getString("outestado");
            var = new Pedido(id, pvdid, usrid, fecha, estado);
        }
        con.cerrarConexion();
        return var;
    }

    //Listar los registros de la tabla dado el nombre 
    public static List<Pedido> getPedidoListByName(String text) throws Exception {
        List<Pedido> lista = new ArrayList<>();
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, text, Types.VARCHAR));
        String llamadaPA = "SELECT * from autos.\"pedidoByName_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            int id = con.getInt("outid");
            int pvdid = con.getInt("outpvdid");
            int usrid = con.getInt("outusrid");
            Timestamp fecha = con.getTimestamp("outfecha");
            String estado = con.getString("outestado");
            lista.add(new Pedido(id, pvdid, usrid, fecha, estado));
        }
        con.cerrarConexion();
        return lista;
    }
}