/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.drivers;

import com.oracle.jrockit.jfr.ContentType;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import sysautos.bussines.entities.Pagos;
import sysautos.integration.Conexion;
import sysautos.integration.Parameter;

/**
 *
 * @author hp
 */
public class dvrPagos {
        //Insertar un nuevo registro a la tabla
    public static int pedidoRegister(Pagos objeto) throws Exception {
        int codigo = 0;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getVtaid(), Types.INTEGER));
        parametros.add(new Parameter(2, objeto.getFpgid(), Types.INTEGER));
        parametros.add(new Parameter(3, objeto.getValor(), Types.INTEGER));
        parametros.add(new Parameter(4, objeto.getFecha(), Types.TIMESTAMP));
        parametros.add(new Parameter(5, objeto.getNumdocumento(), Types.INTEGER));
        parametros.add(new Parameter(6, objeto.getConcepto(), Types.VARCHAR));
        parametros.add(new Parameter(7, objeto.getMora(), Types.DECIMAL));
        parametros.add(new Parameter(8, objeto.getUsrid(), Types.INTEGER));
        String llamadaPA = "SELECT autos.\"pedidoRegister_pa\"(?,?,?,?,?,?,?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            codigo = con.getInt("pedidoRegister_pa");
        }
        con.cerrarConexion();
        return codigo;
    }

    //Editar un nuevo registro de la tabla
    public static boolean pedidoUpdate(Pagos objeto) throws Exception {
        boolean respuesta = false;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getId(), Types.INTEGER));
        parametros.add(new Parameter(2, objeto.getVtaid(), Types.INTEGER));
        parametros.add(new Parameter(3, objeto.getFpgid(), Types.INTEGER));
        parametros.add(new Parameter(4, objeto.getValor(), Types.INTEGER));
        parametros.add(new Parameter(5, objeto.getFecha(), Types.TIMESTAMP));
        parametros.add(new Parameter(6, objeto.getNumdocumento(), Types.INTEGER));
        parametros.add(new Parameter(7, objeto.getConcepto(), Types.VARCHAR));
        parametros.add(new Parameter(8, objeto.getMora(), Types.DECIMAL));
        parametros.add(new Parameter(9, objeto.getUsrid(), Types.INTEGER));
        String llamadaPA = "SELECT autos.\"pedidoUpdate_pa\"(?,?,?,?,?,?,?,?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            respuesta = true;
        }
        con.cerrarConexion();
        return respuesta;
    }

    //Eliminar un registro de la tabla
    public static boolean pedidoDelete(Pagos objeto) throws Exception {
        boolean respuesta = false;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getFpgid(), Types.INTEGER));
        String llamadaPA = "SELECT autos.\"pedidoDelete_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            respuesta = true;
        }
        con.cerrarConexion();
        return respuesta;
    }
    //OUT outid integer, OUT  integer, OUT  integer, OUT  numeric, 
    //OUT  timestamp, OUT  integer, OUT  character varying, 
    //OUT  numeric, OUT  integer
    //Listar todos los registros de la tabla
    public static List<Pagos> getPagosList() throws Exception {
        List<Pagos> lista = new ArrayList<>();
        String llamadaPA = "SELECT * from autos.\"pedidoSelectAll_pa\"()";
        Conexion con = new Conexion(llamadaPA);
        while (con.siguiente()) {
            int id = con.getInt("outid");
            int vtaid = con.getInt("outvtaid");
            int fpgid = con.getInt("outfpgid");
            BigDecimal valor = con.getBigDecimal("outvalor");
            Timestamp fecha = con.getTimestamp("outfecha");
            int numdocumento = con.getInt("outnumdocumento");
            String concepto = con.getString("outconcepto");
            BigDecimal mora = con.getBigDecimal("outmora");
            int usrid = con.getInt("outusrid");
            lista.add(new Pagos(id, vtaid, fpgid, valor, fecha, numdocumento, concepto, mora, usrid));
        }
        con.cerrarConexion();
        return lista;
    }

    //Listar los registros de la tabla dado el ID 
    public static Pagos getPagosById(int val) throws Exception {
        Pagos var = null;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, val, Types.INTEGER));
        String llamadaPA = "SELECT * from autos.\"pedidoByID_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        if (con.siguiente()) {
            int id = con.getInt("outid");
            int vtaid = con.getInt("outvtaid");
            int fpgid = con.getInt("outfpgid");
            BigDecimal valor = con.getBigDecimal("outvalor");
            Timestamp fecha = con.getTimestamp("outfecha");
            int numdocumento = con.getInt("outnumdocumento");
            String concepto = con.getString("outconcepto");
            BigDecimal mora = con.getBigDecimal("outmora");
            int usrid = con.getInt("outusrid");
            var = new Pagos(id, vtaid, fpgid, valor, fecha, numdocumento, concepto, mora, usrid);
        }
        con.cerrarConexion();
        return var;
    }

    //Listar los registros de la tabla dado el nombre 
    public static List<Pagos> getPagosListByName(String text) throws Exception {
        List<Pagos> lista = new ArrayList<>();
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, text, Types.VARCHAR));
        String llamadaPA = "SELECT * from autos.\"pedidoByName_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            int id = con.getInt("outid");
            int vtaid = con.getInt("outvtaid");
            int fpgid = con.getInt("outfpgid");
            BigDecimal valor = con.getBigDecimal("outvalor");
            Timestamp fecha = con.getTimestamp("outfecha");
            int numdocumento = con.getInt("outnumdocumento");
            String concepto = con.getString("outconcepto");
            BigDecimal mora = con.getBigDecimal("outmora");
            int usrid = con.getInt("outusrid");
            lista.add(new Pagos(id, vtaid, fpgid, valor, fecha, numdocumento, concepto, mora, usrid));
        }
        con.cerrarConexion();
        return lista;
    }
}
