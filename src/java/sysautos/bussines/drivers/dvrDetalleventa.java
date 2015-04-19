/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.drivers;

import java.math.BigDecimal;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import sysautos.bussines.entities.Detalleventa;
import sysautos.integration.Conexion;
import sysautos.integration.Parameter;

/**
 *
 * @author hp
 */
public class dvrDetalleventa {

    //Insertar un nuevo registro a la tabla
    public static int detalleventaRegister(Detalleventa objeto) throws Exception {
        int codigo = 0;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getVtaid(), Types.INTEGER));
        parametros.add(new Parameter(2, objeto.getPdtid(), Types.INTEGER));
        parametros.add(new Parameter(3, objeto.getCantidad(), Types.INTEGER));
        parametros.add(new Parameter(4, objeto.getValoruni(), Types.DECIMAL));
        parametros.add(new Parameter(5, objeto.getSubtotal(), Types.DECIMAL));
        parametros.add(new Parameter(6, objeto.getDescuento(), Types.DECIMAL));
        parametros.add(new Parameter(7, objeto.getValtotal(), Types.DECIMAL));
        String llamadaPA = "SELECT autos.\"detalleventaRegister_pa\"(?,?,?,?,?,?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            codigo = con.getInt("detalleventaRegister_pa");
        }
        con.cerrarConexion();
        return codigo;
    }

    //Editar un nuevo registro de la tabla
    public static boolean detalleventaUpdate(Detalleventa objeto) throws Exception {
        boolean respuesta = false;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getId(), Types.INTEGER));
        parametros.add(new Parameter(2, objeto.getVtaid(), Types.INTEGER));
        parametros.add(new Parameter(3, objeto.getPdtid(), Types.INTEGER));
        parametros.add(new Parameter(4, objeto.getCantidad(), Types.INTEGER));
        parametros.add(new Parameter(5, objeto.getValoruni(), Types.DECIMAL));
        parametros.add(new Parameter(6, objeto.getSubtotal(), Types.DECIMAL));
        parametros.add(new Parameter(7, objeto.getDescuento(), Types.DECIMAL));
        parametros.add(new Parameter(8, objeto.getValtotal(), Types.DECIMAL));
        String llamadaPA = "SELECT autos.\"detalleventaUpdate_pa\"(?,?,?,?,?,?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            respuesta = true;
        }
        con.cerrarConexion();
        return respuesta;
    }

    //Eliminar un registro de la tabla
    public static boolean detalleventaDelete(Detalleventa objeto) throws Exception {
        boolean respuesta = false;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getId(), Types.INTEGER));
        String llamadaPA = "SELECT autos.\"detalleventaDelete_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            respuesta = true;
        }
        con.cerrarConexion();
        return respuesta;
    }

    //Listar todos los registros de la tabla
    public static List<Detalleventa> getDetalleventaList() throws Exception {
        List<Detalleventa> lista = new ArrayList<>();
        String llamadaPA = "SELECT * from autos.\"detalleventaSelectAll_pa\"()";
        Conexion con = new Conexion(llamadaPA);
        while (con.siguiente()) {
            int id = con.getInt("outid");
            int vtaid = con.getInt("outvtaid");
            int pdtid = con.getInt("outpdtid");
            int cantidad = con.getInt("outcantidad");
            BigDecimal valoruni = con.getBigDecimal("outvaloruni");
            BigDecimal subtotal = con.getBigDecimal("outsubtotal");
            BigDecimal descuento = con.getBigDecimal("outdescuento");
            BigDecimal valtotal = con.getBigDecimal("outvaltotal");
            lista.add(new Detalleventa(id, vtaid, pdtid, cantidad, valoruni, subtotal, descuento,valtotal));
        }
        con.cerrarConexion();
        return lista;
    }

    //Listar los registros de la tabla dado el ID 
    public static Detalleventa getDetalleventaById(int val) throws Exception {
        Detalleventa var = null;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, val, Types.INTEGER));
        String llamadaPA = "SELECT * from autos.\"detalleventaByID_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        if (con.siguiente()) {
            int id = con.getInt("outid");
            int vtaid = con.getInt("outvtaid");
            int pdtid = con.getInt("outpdtid");
            int cantidad = con.getInt("outcantidad");
            BigDecimal valoruni = con.getBigDecimal("outvaloruni");
            BigDecimal subtotal = con.getBigDecimal("outsubtotal");
            BigDecimal descuento = con.getBigDecimal("outdescuento");
            BigDecimal valtotal = con.getBigDecimal("outvaltotal");
            var = new Detalleventa(id, vtaid, pdtid, cantidad, valoruni, subtotal, descuento,valtotal);
        }
        con.cerrarConexion();
        return var;
    }

    //Listar los registros de la tabla dado el nombre 
    public static List<Detalleventa> getDetalleventaListByName(String text) throws Exception {
        List<Detalleventa> lista = new ArrayList<>();
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, text, Types.VARCHAR));
        String llamadaPA = "SELECT * from autos.\"detalleventaByName_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            int id = con.getInt("outid");
            int vtaid = con.getInt("outvtaid");
            int pdtid = con.getInt("outpdtid");
            int cantidad = con.getInt("outcantidad");
            BigDecimal valoruni = con.getBigDecimal("outvaloruni");
            BigDecimal subtotal = con.getBigDecimal("outsubtotal");
            BigDecimal descuento = con.getBigDecimal("outdescuento");
            BigDecimal valtotal = con.getBigDecimal("outvaltotal");
            lista.add(new Detalleventa(id, vtaid, pdtid, cantidad, valoruni, subtotal, descuento,valtotal));
        }
        con.cerrarConexion();
        return lista;
    }

}
