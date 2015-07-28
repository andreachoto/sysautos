/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.drivers;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import sysautos.bussines.entities.Cliente;
import sysautos.bussines.entities.UserProfile;
import sysautos.integration.Conexion;
import sysautos.integration.Parameter;

public class dvrUserProfile {

    //Insertar un nuevo registro a la tabla
    public static boolean userprofileRegister(UserProfile objeto) throws Exception {
        boolean codigo = false;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getUsrid(), Types.INTEGER));
        parametros.add(new Parameter(2, objeto.getIdprofile(), Types.INTEGER));
        String llamadaPA = "SELECT autos.\"userprofileRegister_pa\"(?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            codigo = con.getBoolean("userprofileRegister_pa");
        }
        con.cerrarConexion();
        return codigo;
    }

    //Editar un nuevo registro de la tabla
    public static boolean userprofileUpdate(UserProfile objeto) throws Exception {
        boolean respuesta = false;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getUsrid(), Types.INTEGER));
        parametros.add(new Parameter(2, objeto.getIdprofile(), Types.INTEGER));
        String llamadaPA = "SELECT autos.\"userprofileUpdate_pa\"(?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            respuesta = true;
        }
        con.cerrarConexion();
        return respuesta;
    }

    //Eliminar un registro de la tabla
    public static boolean userprofileDelete(UserProfile objeto) throws Exception {
        boolean respuesta = false;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getUsrid(), Types.INTEGER));
        //parametros.add(new Parameter(2, objeto.getTidid(), Types.INTEGER));
        String llamadaPA = "SELECT autos.\"userprofileDeleteByUserId_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            respuesta = true;
        }
        con.cerrarConexion();
        return respuesta;
    }

    //Listar todos los registros de la tabla
    public static List<UserProfile> getuserprofileList() throws Exception {
        List<UserProfile> lista = new ArrayList<>();
        String llamadaPA = "SELECT * from autos.\"userprofileSelectAll_pa\"()";
        Conexion con = new Conexion(llamadaPA);
        while (con.siguiente()) {
            int usrid = con.getInt("outusrid");
            int pflid = con.getInt("outpflid");
            lista.add(new UserProfile(usrid, pflid));
        }
        con.cerrarConexion();
        return lista;
    }

    //Listar los registros de la tabla dado el nombre 
    public static UserProfile getuserprofileById(int id1, int id2) throws Exception {
        UserProfile var = null;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, id1, Types.INTEGER));
        parametros.add(new Parameter(2, id2, Types.INTEGER));
        String llamadaPA = "SELECT * from autos.\"userprofileByID_pa\"(?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        if (con.siguiente()) {
            int usrid = con.getInt("outusrid");
            int pflid = con.getInt("outpflid");
            var = new UserProfile(usrid, pflid);
        }
        con.cerrarConexion();
        return var;
    }

    public static UserProfile getuserprofileByuserID(int id) throws Exception {
        UserProfile var = null;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, id, Types.INTEGER));
        String llamadaPA = "SELECT * from autos.\"userprofileById_paCliente\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        if (con.siguiente()) {
            int usrid = con.getInt("outusrid");
            int pflid = con.getInt("outpflid");
            var = new UserProfile(usrid, pflid);
        }
        con.cerrarConexion();
        return var;
    }

    public static List<UserProfile> getUserprofilesByUserID(int id) throws Exception {
        List<UserProfile> lista = new ArrayList<>();
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, id, Types.INTEGER));
        String llamadaPA = "SELECT * from autos.\"userprofileByUserId_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            int usrid = con.getInt("outusrid");
            int pflid = con.getInt("outpflid");
            lista.add(new UserProfile(usrid, pflid));
        }
        con.cerrarConexion();
        return lista;
    }

    public static boolean userprofileDeleteByCliente(Cliente objeto) throws Exception {

        boolean respuesta = false;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getId(), Types.INTEGER));
        String llamadaPA = "SELECT autos.\"userprofileDeleteByCliente_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            respuesta = true;
        }
        con.cerrarConexion();
        return respuesta;

    }

    public static List<UserProfile> getuserprofileByIdCliente(int iduser) throws Exception {
        List<UserProfile> lista = new ArrayList<>();
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, iduser, Types.INTEGER));
        String llamadaPA = "SELECT * from autos.\"userprofileById_paCliente\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            int usrid = con.getInt("outusrid");
            int pflid = con.getInt("outpflid");
            lista.add(new UserProfile(usrid, pflid));
        }
        con.cerrarConexion();
        return lista;
    }
}
