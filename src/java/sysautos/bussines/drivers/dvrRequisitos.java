/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.drivers;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import sysautos.bussines.entities.Requisitos;
import sysautos.integration.Conexion;
import sysautos.integration.Parameter;


/**
 *
 * @author DISMAGIC0985043396
 */
public class dvrRequisitos {
    
       //Insertar un nuevo registro a la tabla
    public static int requisitosRegister(Requisitos objeto) throws Exception {
        int codigo = 0;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getDrqid(), Types.INTEGER));
        parametros.add(new Parameter(2, objeto.getMdpid(), Types.INTEGER));
        parametros.add(new Parameter(3, objeto.getAplid(), Types.INTEGER));
        String llamadaPA = "SELECT autos.\"requisitosRegister_pa\"(?,?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            codigo = con.getInt("requisitosRegister_pa");
        }
        con.cerrarConexion();
        return codigo;
    }

    //Editar un nuevo registro de la tabla
    public static boolean requisitosUpdate(Requisitos objeto) throws Exception {
        boolean respuesta = false;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getRqtid(), Types.INTEGER));
        parametros.add(new Parameter(2, objeto.getDrqid(), Types.INTEGER));
        parametros.add(new Parameter(3, objeto.getMdpid(), Types.INTEGER));
        parametros.add(new Parameter(4, objeto.getAplid(), Types.INTEGER));
        String llamadaPA = "SELECT autos.\"requisitosRegister_pa\"(?,?,?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            respuesta = true;
        }
        con.cerrarConexion();
        return respuesta;
    }

    //Eliminar un registro de la tabla
    public static boolean requisitosDelete(Requisitos objeto) throws Exception {
        boolean respuesta = false;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getRqtid(), Types.INTEGER));
        String llamadaPA = "SELECT autos.\"requisitosDelete_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            respuesta = true;
        }
        con.cerrarConexion();
        return respuesta;
    }

   
    //Listar todos los registros de la tabla
    public static List<Requisitos> getRequisitosList() throws Exception {
        List<Requisitos> lista = new ArrayList<>();
        String llamadaPA = "SELECT * from autos.\"requisitosSelectAll_pa\"()";
        Conexion con = new Conexion(llamadaPA);
        while (con.siguiente()) {
            int id = con.getInt("outid");
            int drqid = con.getInt("outdrqid");
            int mdpid = con.getInt("outmdpid");
            int aplid = con.getInt("outaplid");
            lista.add(new Requisitos(id, drqid, mdpid,aplid));
        }
        con.cerrarConexion();
        return lista;
    }
    
       //Listar los registros de la tabla dado su ID 
    public static Requisitos getRequisitosById(int val) throws Exception {
        Requisitos var = null;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, val, Types.INTEGER));
        String llamadaPA = "SELECT * from autos.\"requisitosByID_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        if (con.siguiente()) {
            int id = con.getInt("outid");
            int drqid = con.getInt("outdrqid");
            int mdpid = con.getInt("outmdpid");
            int aplid = con.getInt("outaplid");
            var = new Requisitos(id, drqid, mdpid,aplid);
        }
        con.cerrarConexion();
        return var;
    }

    //Listar los registros de la tabla dado los fks 
    public static List<Requisitos> getrequisitosByForeingID(int indrqid, int inmdpid, int inaplid) throws Exception {
        List<Requisitos> lista = new ArrayList<>();
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, indrqid, Types.INTEGER));
        parametros.add(new Parameter(2, inmdpid, Types.INTEGER));
        parametros.add(new Parameter(3, inaplid, Types.INTEGER));
        String llamadaPA = "SELECT * from upkeep.\"requisitosByForeingID_pa\"(?,?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            int id = con.getInt("outid");
            int drqid = con.getInt("outdrqid");
            int mdpid = con.getInt("outmdpid");
            int aplid = con.getInt("outaplid");
            lista.add(new Requisitos(id, drqid, mdpid,aplid));
        }
        con.cerrarConexion();
        return lista;
    }    
}