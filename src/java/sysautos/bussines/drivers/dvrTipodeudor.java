/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.drivers;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import sysautos.bussines.entities.Tipodeudor;
import sysautos.integration.Conexion;
import sysautos.integration.Parameter;


/**
 *
 * @author DISMAGIC0985043396
 */
public class dvrTipodeudor {

       //Insertar un nuevo registro a la tabla
    public static int tipodeudorRegister(Tipodeudor objeto) throws Exception {
        int codigo = 0;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getNombre(), Types.VARCHAR));
        parametros.add(new Parameter(2, objeto.getDescrip(), Types.VARCHAR));
        String llamadaPA = "SELECT autos.\"tipodeudorRegister_pa\"(?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            codigo = con.getInt("tipodeudorRegister_pa");
        }
        con.cerrarConexion();
        return codigo;
    }

    //Editar un nuevo registro de la tabla

    public static boolean tipodeudorUpdate(Tipodeudor objeto) throws Exception {
        boolean respuesta = false;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getId(), Types.INTEGER));
        parametros.add(new Parameter(2, objeto.getNombre(), Types.VARCHAR));
        parametros.add(new Parameter(3, objeto.getDescrip(), Types.VARCHAR));

        String llamadaPA = "SELECT autos.\"tipodeudorUpdate_pa\"(?,?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            respuesta = true;
        }
        con.cerrarConexion();
        return respuesta;
    }

    //Eliminar un registro de la tabla

    public static boolean tipodeudorDelete(Tipodeudor objeto) throws Exception {
        boolean respuesta = false;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getId(), Types.INTEGER));
        String llamadaPA = "SELECT autos.\"tipodeudorDelete_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            respuesta = true;
        }
        con.cerrarConexion();
        return respuesta;
    }

    //Listar todos los registros de la tabla

    public static ArrayList<Tipodeudor> getTipodeudorList() throws Exception {
        ArrayList<Tipodeudor> lista = new ArrayList<>();
        String llamadaPA = "SELECT * from autos.\"tipodeudorSelectAll_pa\"()";
        Conexion con = new Conexion(llamadaPA);
        while (con.siguiente()) {
            int id = con.getInt("outtpdid");
            String name = con.getString("outtpdnombre");
            String desc = con.getString("outtpddescrip");
            lista.add(new Tipodeudor(id, name, desc));
        }
        con.cerrarConexion();
        return lista;
    }
    
     public static ArrayList<Tipodeudor> getTipoGarantesList() throws Exception {
        ArrayList<Tipodeudor> lista = new ArrayList<>();
        String llamadaPA = "SELECT * from autos.\"tipogaranteSelectAll_pa\"()";
        Conexion con = new Conexion(llamadaPA);
        while (con.siguiente()) {
            int id = con.getInt("outtpdid");
            String name = con.getString("outtpdnombre");
            String desc = con.getString("outtpddescrip");
            lista.add(new Tipodeudor(id, name, desc));
        }
        con.cerrarConexion();
        return lista;
    }
    
    
    
    
    

    //OUT outtpdid integer, OUT outtpdnombre character varying, OUT outtpddescrip character varying
    
    //Listar los registros de la tabla dado el nombre 

    public static List<Tipodeudor> getTipodeudorListByName(String text) throws Exception {
        List<Tipodeudor> lista = new ArrayList<>();
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, text, Types.VARCHAR));
        String llamadaPA = "SELECT * from upkeep.\"tipodeudorByName_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            int id = con.getInt("outtpdid");
            String name = con.getString("outtpdnombre");
            String desc = con.getString("outtpddescrip");
            lista.add(new Tipodeudor(id, name, desc));
        }
        con.cerrarConexion();
        return lista;
    }
//IN inid integer, OUT outtpdid integer, OUT outtpdnombre character varying, OUT outtpddescrip character varying
    //Listar los registros de la tabla dado el nombre 
    public static Tipodeudor getTipodeudorById(int val) throws Exception {
        Tipodeudor var = null;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, val, Types.INTEGER));
        String llamadaPA = "SELECT * from autos.\"tipodeudorByID_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        if (con.siguiente()) {
            int id = con.getInt("outtpdid");
            String nombre = con.getString("outtpdnombre");
            String descripcion = con.getString("outtpddescrip");

            var = new Tipodeudor(id, nombre, descripcion);
        }
        con.cerrarConexion();
        return var;
    }

    
   
    
}
