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
import sysautos.bussines.entities.Producto;
import sysautos.integration.Conexion;
import sysautos.integration.Parameter;

/**
 *
 * @author hp
 */
public class dvrProducto {

    //Insertar un nuevo registro a la tabla
    public static int productoRegister(Producto objeto) throws Exception {
        int codigo = 0;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getTptid(), Types.INTEGER));
        parametros.add(new Parameter(2, objeto.getSerial(), Types.VARCHAR));
        parametros.add(new Parameter(3, objeto.getStock(), Types.INTEGER));
        parametros.add(new Parameter(4, objeto.getValorunit(), Types.DECIMAL));
        parametros.add(new Parameter(5, objeto.getPvp(), Types.DECIMAL));
        parametros.add(new Parameter(6, objeto.getMarca(), Types.VARCHAR));
        parametros.add(new Parameter(7, objeto.getModelo(), Types.VARCHAR));
        parametros.add(new Parameter(8, objeto.getCilindraje(), Types.DECIMAL));
        parametros.add(new Parameter(9, objeto.getNombre(), Types.VARCHAR));

        String llamadaPA = "SELECT autos.\"productoRegister_pa\"(?,?,?,?,?,?,?,?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            codigo = con.getInt("productoRegister_pa");
        }
        con.cerrarConexion();
        return codigo;
    }

    //Editar un nuevo registro de la tabla
    public static boolean productoUpdate(Producto objeto) throws Exception {
        boolean respuesta = false;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getId(), Types.INTEGER));
        parametros.add(new Parameter(2, objeto.getTptid(), Types.INTEGER));
        parametros.add(new Parameter(3, objeto.getSerial(), Types.VARCHAR));
        parametros.add(new Parameter(4, objeto.getStock(), Types.INTEGER));
        parametros.add(new Parameter(5, objeto.getValorunit(), Types.DECIMAL));
        parametros.add(new Parameter(6, objeto.getPvp(), Types.DECIMAL));
        parametros.add(new Parameter(7, objeto.getMarca(), Types.VARCHAR));
        parametros.add(new Parameter(8, objeto.getModelo(), Types.VARCHAR));
        parametros.add(new Parameter(9, objeto.getCilindraje(), Types.DECIMAL));
        parametros.add(new Parameter(10, objeto.getNombre(), Types.VARCHAR));
        String llamadaPA = "SELECT autos.\"productoUpdate_pa\"(?,?,?,?,?,?,?,?,?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            respuesta = true;
        }
        con.cerrarConexion();
        return respuesta;
    }

    //Eliminar un registro de la tabla
    public static boolean productoDelete(Producto objeto) throws Exception {
        boolean respuesta = false;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getId(), Types.INTEGER));
        String llamadaPA = "SELECT autos.\"productoDelete_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            respuesta = true;
        }
        con.cerrarConexion();
        return respuesta;
    }

    //Listar todos los registros de la tabla
    public static List<Producto> getProductoList() throws Exception {
        List<Producto> lista = new ArrayList<>();
        String llamadaPA = "SELECT * from autos.\"productoSelectAll_pa\"()";
        Conexion con = new Conexion(llamadaPA);
        while (con.siguiente()) {
            int id = con.getInt("outid");
            int tptid = con.getInt("outtptid");
            String nombre = con.getString("outnombre");
            String serial = con.getString("outserial");
            int stock = con.getInt("outstock");
            BigDecimal valoruni = con.getBigDecimal("outvaloruni");
            BigDecimal pvp = con.getBigDecimal("outpvp");
            String marca = con.getString("outmarca");
            String modelo = con.getString("outmodelo");
            BigDecimal cilindraje = con.getBigDecimal("outcilindraje");
            lista.add(new Producto(id, tptid, nombre, serial, stock, valoruni, pvp, marca, modelo, cilindraje));
        }
        con.cerrarConexion();
        return lista;
    }

    //Listar los registros de la tabla dado el ID 
    public static Producto getProductoById(int val) throws Exception {
        Producto var = null;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, val, Types.INTEGER));
        String llamadaPA = "SELECT * from autos.\"productoByID_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        if (con.siguiente()) {
            int id = con.getInt("outid");
            int tptid = con.getInt("outtptid");
            String nombre = con.getString("outnombre");
            String serial = con.getString("outserial");
            int stock = con.getInt("outstock");
            BigDecimal valoruni = con.getBigDecimal("outvaloruni");
            BigDecimal pvp = con.getBigDecimal("outpvp");
            String marca = con.getString("outmarca");
            String modelo = con.getString("outmodelo");
            BigDecimal cilindraje = con.getBigDecimal("outcilindraje");
            var = new Producto(id, tptid, nombre, serial, stock, valoruni, pvp, marca, modelo, cilindraje);
        }
        con.cerrarConexion();
        return var;
    }

    //Listar los registros de la tabla dado el nombre 
    public static List<Producto> getProductoListByName(String text) throws Exception {
        List<Producto> lista = new ArrayList<>();
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, text, Types.VARCHAR));
        String llamadaPA = "SELECT * from autos.\"productoByName_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            int id = con.getInt("outid");
            int tptid = con.getInt("outtptid");
            String nombre = con.getString("outnombre");
            String serial = con.getString("outserial");
            int stock = con.getInt("outstock");
            BigDecimal valoruni = con.getBigDecimal("outvaloruni");
            BigDecimal pvp = con.getBigDecimal("outpvp");
            String marca = con.getString("outmarca");
            String modelo = con.getString("outmodelo");
            BigDecimal cilindraje = con.getBigDecimal("outcilindraje");
            lista.add(new Producto(id, tptid, nombre, serial, stock, valoruni, pvp, marca, modelo, cilindraje));
        }
        con.cerrarConexion();
        return lista;
    }
    
    //Listar los registros de la tabla dado el nombre 
    public static List<Producto> getProductoListByTipoID(int value) throws Exception {
        List<Producto> lista = new ArrayList<>();
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, value, Types.INTEGER));
        String llamadaPA = "SELECT * from autos.\"productoByTipo_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            int id = con.getInt("outid");
            int tptid = con.getInt("outtptid");
            String nombre = con.getString("outnombre");
            String serial = con.getString("outserial");
            int stock = con.getInt("outstock");
            BigDecimal valoruni = con.getBigDecimal("outvaloruni");
            BigDecimal pvp = con.getBigDecimal("outpvp");
            String marca = con.getString("outmarca");
            String modelo = con.getString("outmodelo");
            BigDecimal cilindraje = con.getBigDecimal("outcilindraje");
            lista.add(new Producto(id, tptid, nombre, serial, stock, valoruni, pvp, marca, modelo, cilindraje));
        }
        con.cerrarConexion();
        return lista;
    }
}