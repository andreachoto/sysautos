/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.entities;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import sysautos.bussines.entities.Cliente;
import sysautos.integration.Conexion;
import sysautos.integration.Parameter;


/**
 *
 * @author Carolyn
 */
public class dvrCliente {
     //Insertar un nuevo registro a la tabla
    public static int clienteRegister(Cliente objeto) throws Exception {
        int codigo = 0;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getNombre(), Types.VARCHAR));
        parametros.add(new Parameter(2, objeto.getApellido(), Types.VARCHAR));
        parametros.add(new Parameter(3, objeto.getSexo(), Types.VARCHAR));
        parametros.add(new Parameter(4, objeto.getEdad(), Types.INTEGER));
        parametros.add(new Parameter(5, objeto.getFax(), Types.VARCHAR));
        parametros.add(new Parameter(6, objeto.getEmail(), Types.VARCHAR));
        parametros.add(new Parameter(7, objeto.getEstadocivil(), Types.VARCHAR));
        String llamadaPA = "SELECT autos.\"clienteRegister_pa\"(?,?,?,?,?,?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            codigo = con.getInt("clienteRegister_pa");
        }
        con.cerrarConexion();
        return codigo;
    }
    //Editar un nuevo registro de la tabla
    public static boolean clienteUpdate(Cliente objeto) throws Exception {
        boolean respuesta = false;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getId(), Types.INTEGER));
        parametros.add(new Parameter(2, objeto.getNombre(), Types.VARCHAR));
        parametros.add(new Parameter(3, objeto.getApellido(), Types.VARCHAR));
        parametros.add(new Parameter(4, objeto.getSexo(), Types.VARCHAR));
        parametros.add(new Parameter(5, objeto.getEdad(), Types.INTEGER));
        parametros.add(new Parameter(6, objeto.getFax(), Types.VARCHAR));
        parametros.add(new Parameter(7, objeto.getEmail(), Types.VARCHAR));
        parametros.add(new Parameter(8, objeto.getEstadocivil(), Types.VARCHAR));
        String llamadaPA = "SELECT autos.\"clienteUpdate_pa\"(?,?,?,?,?,?,?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            respuesta = true;
        }
        con.cerrarConexion();
        return respuesta;
    }
    //Eliminar un registro de la tabla
    public static boolean clienteDelete(Cliente objeto) throws Exception {
        boolean respuesta = false;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getId(), Types.INTEGER));
        String llamadaPA = "SELECT autos.\"clienteDelete_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            respuesta = true;
        }
        con.cerrarConexion();
        return respuesta;
    }
    //Listar todos los registros de la tabla
    public static List<Cliente> getClienteList() throws Exception {
        List<Cliente> lista = new ArrayList<>();
        String llamadaPA = "SELECT * from autos.\"clienteSelectAll_pa\"()";
        Conexion con = new Conexion(llamadaPA);
        while (con.siguiente()) {
            int id = con.getInt("outid");
            String nombre = con.getString("outnombre");
            String apellido=con.getString("outapellido");
            String sexo=con.getString("outsexo");
            int edad = con.getInt("outedad");
            String fax=con.getString("outfax");
            String email=con.getString("outemail");
            String estadocivil=con.getString("outestadocivil");
            lista.add(new Cliente(id,nombre,apellido,sexo,edad,fax,email,estadocivil));
        }
        con.cerrarConexion();
        return lista;
    }
    //Listar los registros de la tabla dado el nombre 
    public static List<Cliente> getClienteListByName(String text) throws Exception {
        List<Cliente> lista = new ArrayList<>();
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, text, Types.VARCHAR));
        String llamadaPA = "SELECT * from autos.\"clienteByName_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            int id = con.getInt("out_Id");
            String nombre = con.getString("out_nombre");
            String apellido=con.getString("out_apellido");
            String sexo=con.getString("out_sexo");
            int edad = con.getInt("out_edad");
            String fax=con.getString("out_fax");
            String email=con.getString("out_email");
            String estadocivil=con.getString("out_estadocivil");
            lista.add(new Cliente(id,nombre,apellido,sexo,edad,fax,email,estadocivil));
        }
        con.cerrarConexion();
        return lista;
    }
    
//     //Listar los registros de la entidad por id foraneo 
//    public static List<Cliente> getClienteListByMagnitudeId(int val) throws Exception {
//        List<Cliente> lista = new ArrayList<>();
//        List<Parameter> parametros = new ArrayList<>();
//        parametros.add(new Parameter(1, val, Types.INTEGER));
//        String llamadaPA = "SELECT * from autos.\"clienteByMagnitudeID_pa\"(?)";
//        Conexion con = new Conexion(llamadaPA, parametros);
//        while (con.siguiente()) {
//            int id = con.getInt("out_Id");
//            String nombre = con.getString("out_nombre");
//            String desc = con.getString("out_desc");
//            boolean active = con.getBoolean("out_active");
//            lista.add(new Cliente(id,nombre, desc, active));
//        }
//        con.cerrarConexion();
//        return lista;
//    }
    
    //Listar los registros de la tabla dado el nombre 
    public static Cliente getClienteById(int val) throws Exception {
        Cliente var = null;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, val, Types.INTEGER));
        String llamadaPA = "SELECT * from autos.\"clienteByID_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        if (con.siguiente()) {
            int id = con.getInt("outid");
            String nombre = con.getString("outnombre");
            String apellido=con.getString("outapellido");
            String sexo=con.getString("outsexo");
            int edad = con.getInt("outedad");
            String fax=con.getString("outfax");
            String email=con.getString("outemail");
            String estadocivil=con.getString("outestadocivil");
            var = new Cliente(id,nombre,apellido,sexo,edad,fax,email,estadocivil);
        }
        con.cerrarConexion();
        return var;
    }
    
    
}
