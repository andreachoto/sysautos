/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.drivers;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import sysautos.bussines.entities.Role;
import sysautos.integration.Conexion;
import sysautos.integration.Parameter;

/**
 *
 * @author hp
 */
public class dvrRole {
    
    //Insertar un nuevo registro a la tabla
    public static int roleRegister(Role objeto) throws Exception {
        int codigo = 0;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getName(), Types.VARCHAR));
        parametros.add(new Parameter(2, objeto.getDesc(), Types.VARCHAR));
        parametros.add(new Parameter(3, objeto.isActive(), Types.BOOLEAN));
        String llamadaPA = "SELECT autos.\"roleRegister_pa\"(?,?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            codigo = con.getInt("roleRegister_pa");
        }
        con.cerrarConexion();
        return codigo;
    }
    
    //Editar un nuevo registro de la tabla
    public static boolean roleUpdate(Role objeto) throws Exception {
        boolean respuesta = false;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getRolid(), Types.INTEGER));
        parametros.add(new Parameter(2, objeto.getName(), Types.VARCHAR));
        parametros.add(new Parameter(3, objeto.getDesc(), Types.VARCHAR));
        parametros.add(new Parameter(4, objeto.isActive(), Types.BOOLEAN));
        String llamadaPA = "SELECT autos.\"roleUpdate_pa\"(?,?,?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            respuesta = true;
        }
        con.cerrarConexion();
        return respuesta;
    }
    
    //Eliminar un registro de la tabla
    public static boolean roleDelete(Role objeto) throws Exception {
        boolean respuesta = false;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getRolid(), Types.INTEGER));
        String llamadaPA = "SELECT autos.\"roleDelete_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            respuesta = true;
        }
        con.cerrarConexion();
        return respuesta;
    }
    
    //Listar todos los registros de la tabla
    public static List<Role> getRoleList() throws Exception {
        List<Role> lista = new ArrayList<>();
        String llamadaPA = "SELECT * from autos.\"roleSelectAll_pa\"()";
        Conexion con = new Conexion(llamadaPA);
        while (con.siguiente()) {
            int id = con.getInt("out_id");
            String name = con.getString("out_name");
            String desc = con.getString("out_desc");
            boolean active = con.getBoolean("out_active");
            lista.add(new Role(id,name, desc, active));
        }
        con.cerrarConexion();
        return lista;
    }
    
    //Listar los registros de la tabla dado el ID 
    public static Role getRoleById(int val) throws Exception {
        Role var = null;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, val, Types.INTEGER));
        String llamadaPA = "SELECT * from autos.\"roleByID_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        if (con.siguiente()) {
            int id = con.getInt("outid");
            String name = con.getString("outname");
            String desc = con.getString("outdesc");
            boolean active = con.getBoolean("outisactive");
            var = new Role(id,name, desc, active);
        }
        con.cerrarConexion();
        return var;
    }
    
    //Listar los registros de la tabla dado el nombre 
    public static List<Role> getRoleListByName(String text) throws Exception {
        List<Role> lista = new ArrayList<>();
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, text, Types.VARCHAR));
        String llamadaPA = "SELECT * from autos.\"roleByName_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            int id = con.getInt("outid");
            String name = con.getString("outname");
            String desc = con.getString("outdesc");
            boolean active = con.getBoolean("outisactive");
            lista.add(new Role(id,name, desc, active));
        }
        con.cerrarConexion();
        return lista;
    }
}