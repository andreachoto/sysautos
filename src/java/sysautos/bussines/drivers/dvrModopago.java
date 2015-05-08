/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.drivers;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import sun.java2d.cmm.Profile;
import sysautos.bussines.entities.Modopago;
import sysautos.integration.Conexion;
import sysautos.integration.Parameter;

/**
 *
 * @author DISMAGIC0985043396
 */
public class dvrModopago {

    //Insertar un nuevo registro a la tabla
    public static int userModopRegister(Modopago objeto) throws Exception {
        int codigo = 0;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getNombre(), Types.VARCHAR));
        parametros.add(new Parameter(2, objeto.getDescrip(), Types.VARCHAR));
        String llamadaPA = "SELECT autos.\"modopagoRegister_pa\"(?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            codigo = con.getInt("modopagoRegister_pa");
        }
        con.cerrarConexion();
        return codigo;
    }

    //Editar un nuevo registro de la tabla

    public static boolean ModopUpdate(Modopago objeto) throws Exception {
        boolean respuesta = false;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getId(), Types.INTEGER));
        parametros.add(new Parameter(2, objeto.getNombre(), Types.VARCHAR));
        parametros.add(new Parameter(3, objeto.getDescrip(), Types.VARCHAR));

        String llamadaPA = "SELECT autos.\"modopagoUpdate_pa\"(?,?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            respuesta = true;
        }
        con.cerrarConexion();
        return respuesta;
    }

    public static List<Modopago> getModopagoList() throws Exception {
        List<Modopago> lista = new ArrayList<>();
        String llamadaPA = "SELECT * from autos.\"modopagoSelectAll_pa\"()";
        Conexion con = new Conexion(llamadaPA);
        while (con.siguiente()) {
            int id = con.getInt("outid");
            String name = con.getString("outnombre");
            String desc = con.getString("outdescrip");
            lista.add(new Modopago(id, name, desc));
        }
        con.cerrarConexion();
        return lista;
    }

    public static Modopago getModoById(int val) throws Exception {
        Modopago var = null;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, val, Types.INTEGER));
        String llamadaPA = "SELECT * from autos.\"modopagoByID_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        if (con.siguiente()) {
            int id = con.getInt("outid");
            String nombre = con.getString("outnombre");
            String descripcion = con.getString("outdescrip");

            var = new Modopago(id, nombre, descripcion);
        }
        con.cerrarConexion();
        return var;
    }

    //Eliminar un registro de la tabla
    public static boolean modoDelete(Modopago objeto) throws Exception {
        boolean respuesta = false;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getId(), Types.INTEGER));
        String llamadaPA = "SELECT autos.\"modopagoDelete_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            respuesta = true;
        }
        con.cerrarConexion();
        return respuesta;
    }

}
