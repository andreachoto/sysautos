/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.drivers;

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
    public static int proveedorRegister(Producto objeto) throws Exception {
        int codigo = 0;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getNombre(), Types.VARCHAR));
//        parametros.add(new Parameter(2, objeto.getDireccion(), Types.VARCHAR));
//        parametros.add(new Parameter(3, objeto.getTelefono(), Types.VARCHAR));
//        parametros.add(new Parameter(4, objeto.getEmail(), Types.VARCHAR));
//        parametros.add(new Parameter(5, objeto.getMovil(), Types.VARCHAR));
//        parametros.add(new Parameter(6, objeto.getFax(), Types.VARCHAR));
        String llamadaPA = "SELECT autos.\"proveedorRegister_pa\"(?,?,?,?,?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            codigo = con.getInt("proveedorRegister_pa");
        }
        con.cerrarConexion();
        return codigo;
    }

    //Editar un nuevo registro de la tabla
    public static boolean proveedorUpdate(Producto objeto) throws Exception {
        boolean respuesta = false;
        List<Parameter> parametros = new ArrayList<>();
//        parametros.add(new Parameter(1, objeto.getId(), Types.INTEGER));
//        parametros.add(new Parameter(2, objeto.getNombre(), Types.VARCHAR));
//        parametros.add(new Parameter(3, objeto.getDireccion(), Types.VARCHAR));
//        parametros.add(new Parameter(4, objeto.getTelefono(), Types.VARCHAR));
//        parametros.add(new Parameter(5, objeto.getEmail(), Types.VARCHAR));
//        parametros.add(new Parameter(6, objeto.getMovil(), Types.VARCHAR));
//        parametros.add(new Parameter(7, objeto.getFax(), Types.VARCHAR));
        String llamadaPA = "SELECT autos.\"proveedorUpdate_pa\"(?,?,?,?,?,?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            respuesta = true;
        }
        con.cerrarConexion();
        return respuesta;
    }

    //Eliminar un registro de la tabla
    public static boolean proveedorDelete(Producto objeto) throws Exception {
        boolean respuesta = false;
        List<Parameter> parametros = new ArrayList<>();
//        parametros.add(new Parameter(1, objeto.getId(), Types.INTEGER));
        String llamadaPA = "SELECT autos.\"proveedorDelete_pa\"(?)";
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
        String llamadaPA = "SELECT * from autos.\"proveedorSelectAll_pa\"()";
        Conexion con = new Conexion(llamadaPA);
        while (con.siguiente()) {
            int id = con.getInt("outid");
            String name = con.getString("outnombre");
            String dir = con.getString("outdireccion");
            String fono = con.getString("outtelefono");
            String mail = con.getString("outemail");
            String movil = con.getString("outmovil");
            String fax = con.getString("outfax");
//            lista.add(new Producto(id, name, dir, fono, mail, movil, fax));
        }
        con.cerrarConexion();
        return lista;
    }

    //Listar los registros de la tabla dado el ID 
    public static Producto getProductoById(int val) throws Exception {
        Producto var = null;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, val, Types.INTEGER));
        String llamadaPA = "SELECT * from autos.\"proveedorByID_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        if (con.siguiente()) {
            int id = con.getInt("outid");
            String name = con.getString("outnombre");
            String dir = con.getString("outdireccion");
            String fono = con.getString("outtelefono");
            String mail = con.getString("outemail");
            String movil = con.getString("outmovil");
            String fax = con.getString("outfax");
//            var = new Producto(id, name, dir, fono, mail, movil, fax);
        }
        con.cerrarConexion();
        return var;
    }

    //Listar los registros de la tabla dado el nombre 
    public static List<Producto> getProductoListByName(String text) throws Exception {
        List<Producto> lista = new ArrayList<>();
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, text, Types.VARCHAR));
        String llamadaPA = "SELECT * from autos.\"proveedorByName_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            int id = con.getInt("outid");
            String name = con.getString("outnombre");
            String dir = con.getString("outdireccion");
            String fono = con.getString("outtelefono");
            String mail = con.getString("outemail");
            String movil = con.getString("outmovil");
            String fax = con.getString("outfax");
//            lista.add(new Producto(id, name, dir, fono, mail, movil, fax));
        }
        con.cerrarConexion();
        return lista;
    }
    
}
