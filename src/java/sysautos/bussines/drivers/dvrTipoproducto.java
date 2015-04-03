/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.drivers;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import sysautos.bussines.entities.Tipoproducto;
import sysautos.integration.Conexion;
import sysautos.integration.Parameter;

/**
 *
 * @author hp
 */
public class dvrTipoproducto {

    //Insertar un nuevo registro a la tabla
    public static int tipoproductoRegister(Tipoproducto objeto) throws Exception {
        int codigo = 0;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getNombre(), Types.VARCHAR));
        parametros.add(new Parameter(2, objeto.getDesc(), Types.VARCHAR));
        parametros.add(new Parameter(3, objeto.getStockmin(), Types.INTEGER));
        String llamadaPA = "SELECT autos.\"tipoproductoRegister_pa\"(?,?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            codigo = con.getInt("tipoproductoRegister_pa");
        }
        con.cerrarConexion();
        return codigo;
    }

    //Editar un nuevo registro de la tabla
    public static boolean tipoproductoUpdate(Tipoproducto objeto) throws Exception {
        boolean respuesta = false;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getId(), Types.INTEGER));
        parametros.add(new Parameter(2, objeto.getNombre(), Types.VARCHAR));
        parametros.add(new Parameter(3, objeto.getDesc(), Types.VARCHAR));
        parametros.add(new Parameter(4, objeto.getStockmin(), Types.INTEGER));
        String llamadaPA = "SELECT autos.\"tipoproductoUpdate_pa\"(?,?,?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            respuesta = true;
        }
        con.cerrarConexion();
        return respuesta;
    }

    //Eliminar un registro de la tabla
    public static boolean tipoproductoDelete(Tipoproducto objeto) throws Exception {
        boolean respuesta = false;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getId(), Types.INTEGER));
        String llamadaPA = "SELECT autos.\"tipoproductoDelete_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            respuesta = true;
        }
        con.cerrarConexion();
        return respuesta;
    }

    //Listar todos los registros de la tabla
    public static List<Tipoproducto> getTipoproductoList() throws Exception {
        List<Tipoproducto> lista = new ArrayList<>();
        String llamadaPA = "SELECT * from autos.\"tipoproductoSelectAll_pa\"()";
        Conexion con = new Conexion(llamadaPA);
        while (con.siguiente()) {
            int id = con.getInt("outid");
            String name = con.getString("outnombre");
            String desc = con.getString("outdesc");
            int stockmin = con.getInt("outstockmin");
            lista.add(new Tipoproducto(id, name, desc, stockmin));
        }
        con.cerrarConexion();
        return lista;
    }

    //Listar los registros de la tabla dado el ID 
    public static Tipoproducto getTipoproductoById(int val) throws Exception {
        Tipoproducto var = null;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, val, Types.INTEGER));
        String llamadaPA = "SELECT * from autos.\"tipoproductoByID_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        if (con.siguiente()) {
            int id = con.getInt("outid");
            String name = con.getString("outnombre");
            String desc = con.getString("outdesc");
            int stockmin = con.getInt("outstockmin");
            var = new Tipoproducto(id, name, desc, stockmin);
        }
        con.cerrarConexion();
        return var;
    }

    //Listar los registros de la tabla dado el nombre 
    public static List<Tipoproducto> getTipoproductoListByName(String text) throws Exception {
        List<Tipoproducto> lista = new ArrayList<>();
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, text, Types.VARCHAR));
        String llamadaPA = "SELECT * from autos.\"tipoproductoByName_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            int id = con.getInt("outid");
            String name = con.getString("outnombre");
            String desc = con.getString("outdesc");
            int stockmin = con.getInt("outstockmin");
            lista.add(new Tipoproducto(id, name, desc, stockmin));
        }
        con.cerrarConexion();
        return lista;
    }
}