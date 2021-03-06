/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.drivers;

import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import sysautos.bussines.entities.Cliente;
import sysautos.bussines.entities.RoleProfile;
import sysautos.integration.Conexion;
import sysautos.integration.Parameter;

/**
 *
 * @author Carolyn
 */
public class dvrRoleProfile {

    //Insertar un nuevo registro a la tabla

    public static boolean roleprofileRegister(RoleProfile objeto) throws Exception {
        boolean codigo = false;
        try {

            List<Parameter> parametros = new ArrayList<>();
            parametros.add(new Parameter(1, objeto.getPflid(), Types.INTEGER));
            parametros.add(new Parameter(2, objeto.getRolid(), Types.INTEGER));
            String llamadaPA = "SELECT autos.\"roleprofileRegister_pa\"(?,?)";
            Conexion con = new Conexion(llamadaPA, parametros);
            while (con.siguiente()) {
                codigo = con.getBoolean("roleprofileRegister_pa");
            }
            con.cerrarConexion();

        } catch (SQLException e) {

        }
        return codigo;

    }

    //Editar un nuevo registro de la tabla

    public static boolean roleprofileUpdate(RoleProfile objeto) throws Exception {
        boolean respuesta = false;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getPflid(), Types.INTEGER));
        parametros.add(new Parameter(2, objeto.getRolid(), Types.INTEGER));
        String llamadaPA = "SELECT autos.\"roleprofileUpdate_pa\"(?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            respuesta = true;
        }
        con.cerrarConexion();
        return respuesta;
    }

    //Eliminar un registro de la tabla

    public static boolean roleprofileDelete(RoleProfile objeto) throws Exception {
        boolean respuesta = false;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getPflid(), Types.INTEGER));
        //parametros.add(new Parameter(2, objeto.getTidid(), Types.INTEGER));
        String llamadaPA = "SELECT autos.\"roleprofileDeleteByProfileId_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            respuesta = true;
        }
        con.cerrarConexion();
        return respuesta;
    }

    //Listar todos los registros de la tabla

    public static List<RoleProfile> getroleprofileList() throws Exception {
        List<RoleProfile> lista = new ArrayList<>();
        String llamadaPA = "SELECT * from autos.\"roleprofileSelectAll_pa\"()";
        Conexion con = new Conexion(llamadaPA);
        while (con.siguiente()) {
            int usrid = con.getInt("outusrid");
            int pflid = con.getInt("outpflid");
            lista.add(new RoleProfile(usrid, pflid));
        }
        con.cerrarConexion();
        return lista;
    }

//    //Listar los registros de la tabla dado el nombre 
//    public static List<RoleProfile> getroleprofileListByName(String text) throws Exception {
//        List<RoleProfile> lista = new ArrayList<>();
//        List<Parameter> parametros = new ArrayList<>();
//        parametros.add(new Parameter(1, text, Types.VARCHAR));
//        String llamadaPA = "SELECT * from autos.\"roleprofileByName_pa\"(?)";
//        Conexion con = new Conexion(llamadaPA, parametros);
//        while (con.siguiente()) {
//           int ustid = con.getInt("out_ustid");
//            int rolid = con.getInt("out_rolid");
//            lista.add(new RoleProfile(ustid, rolid));
//        }
//        con.cerrarConexion();
//        return lista;
//    }
    //Listar los registros de la tabla dado el nombre 
    public static RoleProfile getroleprofileById(int id1, int id2) throws Exception {
        RoleProfile var = null;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, id1, Types.INTEGER));
        parametros.add(new Parameter(2, id2, Types.INTEGER));
        String llamadaPA = "SELECT * from autos.\"roleprofileByID_pa\"(?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        if (con.siguiente()) {
            int usrid = con.getInt("outusrid");
            int pflid = con.getInt("outpflid");
            var = new RoleProfile(usrid, pflid);
        }
        con.cerrarConexion();
        return var;
    }

//    public static List<RoleProfile> getroleprofileListByCliente(int inustid) throws Exception {
//       
//        List<RoleProfile> lista = new ArrayList<>();
//        List<Parameter> parametros = new ArrayList<>();
//        parametros.add(new Parameter(1,inustid, Types.INTEGER));
//        String llamadaPA = "SELECT * from autos.\"roleprofileByCliente_pa\"(?)";
//        Conexion con = new Conexion(llamadaPA, parametros);
//        while (con.siguiente()) {
//            int cltid = con.getInt("out_cltid");
//            int tidid = con.getInt("out_tidid");
//            String numdescripcion = con.getString("out_numdescripcion");
//            String estado=con.getString("out_estado");
//            lista.add(new RoleProfile(cltid, tidid,numdescripcion,estado));
//            
//        }
//        con.cerrarConexion();
//        return lista;
//    
//    
//    }
    public static boolean roleprofileDeleteByCliente(Cliente objeto) throws Exception {

        boolean respuesta = false;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getId(), Types.INTEGER));
        String llamadaPA = "SELECT autos.\"roleprofileDeleteByCliente_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            respuesta = true;
        }
        con.cerrarConexion();
        return respuesta;

    }

    public static RoleProfile getroleprofileByIdCliente(int id1) throws Exception {
        RoleProfile var = null;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, id1, Types.INTEGER));
        String llamadaPA = "SELECT * from autos.\"roleprofileByID_paCliente\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        if (con.siguiente()) {
            int usrid = con.getInt("outusrid");
            int pflid = con.getInt("outpflid");
            var = new RoleProfile(usrid, pflid);
        }
        con.cerrarConexion();
        return var;
    }
      public static List<RoleProfile> getroleprofileByIdProfile(int iduser) throws Exception {
        List<RoleProfile> lista = new ArrayList<>();
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, iduser, Types.INTEGER));
        String llamadaPA = "SELECT * from autos.\"roleprofileByProfileId_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            int pflid = con.getInt("outpflid");
            int rolid = con.getInt("outrolid");
            lista.add(new RoleProfile(pflid, rolid));
        }
        con.cerrarConexion();
        return lista;
    }

}
