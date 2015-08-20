/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.drivers;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import sysautos.bussines.entities.Venta;
import sysautos.integration.Conexion;
import sysautos.integration.Parameter;

/**
 *
 * @author hp
 */
public class dvrVenta {

    //Insertar un nuevo registro a la tabla
    public static int ventaRegister(Venta objeto) throws Exception {
        int codigo = 0;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getClitid(), Types.INTEGER));
        parametros.add(new Parameter(2, objeto.getMpgid(), Types.INTEGER));
        parametros.add(new Parameter(3, objeto.getUsrid(), Types.INTEGER));
        parametros.add(new Parameter(4, objeto.getFecha(), Types.TIMESTAMP));
        parametros.add(new Parameter(5, objeto.getNumfac(), Types.VARCHAR));
        parametros.add(new Parameter(6, objeto.getFechafac(), Types.TIMESTAMP));
        parametros.add(new Parameter(7, objeto.getSubtotal(), Types.DECIMAL));
        parametros.add(new Parameter(8, objeto.getIva(), Types.DECIMAL));
        parametros.add(new Parameter(9, objeto.getImpuestos(), Types.DECIMAL));
        parametros.add(new Parameter(10, objeto.getDescuento(), Types.DECIMAL));
        parametros.add(new Parameter(11, objeto.getTotal(), Types.DECIMAL));
        parametros.add(new Parameter(12, objeto.getEstado(), Types.VARCHAR));
        parametros.add(new Parameter(13, objeto.getCancelado(), Types.BOOLEAN));
        String llamadaPA = "SELECT autos.\"ventaRegister_pa\"(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            codigo = con.getInt("ventaRegister_pa");
        }
        con.cerrarConexion();
        return codigo;
    }

    //Editar un nuevo registro de la tabla
    public static boolean ventaUpdate(Venta objeto) throws Exception {
        boolean respuesta = false;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getId(), Types.INTEGER));
        parametros.add(new Parameter(2, objeto.getClitid(), Types.INTEGER));
        parametros.add(new Parameter(3, objeto.getMpgid(), Types.INTEGER));
        parametros.add(new Parameter(4, objeto.getUsrid(), Types.INTEGER));
        parametros.add(new Parameter(5, objeto.getFecha(), Types.TIMESTAMP));
        parametros.add(new Parameter(6, objeto.getNumfac(), Types.VARCHAR));
        parametros.add(new Parameter(7, objeto.getFechafac(), Types.TIMESTAMP));
        parametros.add(new Parameter(8, objeto.getSubtotal(), Types.DECIMAL));
        parametros.add(new Parameter(9, objeto.getIva(), Types.DECIMAL));
        parametros.add(new Parameter(10, objeto.getImpuestos(), Types.DECIMAL));
        parametros.add(new Parameter(11, objeto.getDescuento(), Types.DECIMAL));
        parametros.add(new Parameter(12, objeto.getTotal(), Types.DECIMAL));
        parametros.add(new Parameter(13, objeto.getEstado(), Types.VARCHAR));
        parametros.add(new Parameter(14, objeto.getCancelado(), Types.BOOLEAN));
        String llamadaPA = "SELECT autos.\"ventaUpdate_pa\"(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            respuesta = true;
        }
        con.cerrarConexion();
        return respuesta;
    }

    //Eliminar un registro de la tabla
    public static boolean ventaDelete(Venta objeto) throws Exception {
        boolean respuesta = false;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getId(), Types.INTEGER));
        String llamadaPA = "SELECT autos.\"ventaDelete_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            respuesta = true;
        }
        con.cerrarConexion();
        return respuesta;
    }

   //Listar todos los registros de la tabla
    public static List<Venta> getVentaList() throws Exception {
        List<Venta> lista = new ArrayList<>();
        String llamadaPA = "SELECT * from autos.\"ventaSelectAll_pa\"()";
        Conexion con = new Conexion(llamadaPA);
        while (con.siguiente()) {
            int id = con.getInt("outid");
            int clitid = con.getInt("outclitid");
            int mpgid = con.getInt("outmpgid");
            int usrid = con.getInt("outusrid");
            Timestamp fecha = con.getTimestamp("outfecha");
            String numfac = con.getString("outnumfac");
            Timestamp fechafac = con.getTimestamp("outfechafac");
            BigDecimal subtotal = con.getBigDecimal("outsubtotal");
            BigDecimal iva = con.getBigDecimal("outiva");
            BigDecimal impuestos = con.getBigDecimal("outimpuestos");
            BigDecimal descuento = con.getBigDecimal("outdescuento");
            BigDecimal total = con.getBigDecimal("outtotal");
            String estado = con.getString("outestado");
            boolean cancelado = con.getBoolean("outcancelado");
            lista.add(new Venta(id, clitid, mpgid, usrid, fecha, numfac, fechafac, subtotal, iva,
                    impuestos, descuento, total, estado, cancelado));
        }
        con.cerrarConexion();
        return lista;
    }

    //Listar los registros de la tabla dado el ID 
    public static Venta getVentaById(int val) throws Exception {
        Venta var = null;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, val, Types.INTEGER));
        String llamadaPA = "SELECT * from autos.\"ventaByID_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        if (con.siguiente()) {
            int id = con.getInt("outid");
            int clitid = con.getInt("outclitid");
            int mpgid = con.getInt("outmpgid");
            int usrid = con.getInt("outusrid");
            Timestamp fecha = con.getTimestamp("outfecha");
            String numfac = con.getString("outnumfac");
            Timestamp fechafac = con.getTimestamp("outfechafac");
            BigDecimal subtotal = con.getBigDecimal("outsubtotal");
            BigDecimal iva = con.getBigDecimal("outiva");
            BigDecimal impuestos = con.getBigDecimal("outimpuestos");
            BigDecimal descuento = con.getBigDecimal("outdescuento");
            BigDecimal total = con.getBigDecimal("outtotal");
            String estado = con.getString("outestado");
            boolean cancelado = con.getBoolean("outcancelado");
            var = new Venta(id, clitid, mpgid, usrid, fecha, numfac, fechafac, subtotal, iva,
                    impuestos, descuento, total, estado, cancelado);
        }
        con.cerrarConexion();
        return var;
    }

    //Listar los registros de la tabla dado el nombre 
    public static List<Venta> getVentaListByName(String text) throws Exception {
        List<Venta> lista = new ArrayList<>();
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, text, Types.VARCHAR));
        String llamadaPA = "SELECT * from autos.\"ventaByName_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            int id = con.getInt("outid");
            int clitid = con.getInt("outclitid");
            int mpgid = con.getInt("outmpgid");
            int usrid = con.getInt("outusrid");
            Timestamp fecha = con.getTimestamp("outfecha");
            String numfac = con.getString("outnumfac");
            Timestamp fechafac = con.getTimestamp("outfechafac");
            BigDecimal subtotal = con.getBigDecimal("outsubtotal");
            BigDecimal iva = con.getBigDecimal("outiva");
            BigDecimal impuestos = con.getBigDecimal("outimpuestos");
            BigDecimal descuento = con.getBigDecimal("outdescuento");
            BigDecimal total = con.getBigDecimal("outtotal");
            String estado = con.getString("outestado");
            boolean cancelado = con.getBoolean("outcancelado");
            lista.add(new Venta(id, clitid, mpgid, usrid, fecha, numfac, fechafac, subtotal, iva,
                    impuestos, descuento, total, estado, cancelado));
        }
        con.cerrarConexion();
        return lista;
    }
    
    public static List<Venta> getVentaListToReport(int op, int agent, Timestamp f1, Timestamp f2) throws Exception {
        List<Venta> lista = new ArrayList<>();
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, op, Types.INTEGER));
        parametros.add(new Parameter(2, agent, Types.INTEGER));
        parametros.add(new Parameter(3, f1, Types.TIMESTAMP));
        parametros.add(new Parameter(4, f2, Types.TIMESTAMP));
        String llamadaPA = "SELECT * from autos.\"ventaByAgenteRange\"(?,?,?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            int id = con.getInt("outid");
            int clitid = con.getInt("outclitid");
            int mpgid = con.getInt("outmpgid");
            int usrid = con.getInt("outusrid");
            Timestamp fecha = con.getTimestamp("outfecha");
            String numfac = con.getString("outnumfac");
            Timestamp fechafac = con.getTimestamp("outfechafac");
            BigDecimal subtotal = con.getBigDecimal("outsubtotal");
            BigDecimal iva = con.getBigDecimal("outiva");
            BigDecimal impuestos = con.getBigDecimal("outimpuestos");
            BigDecimal descuento = con.getBigDecimal("outdescuento");
            BigDecimal total = con.getBigDecimal("outtotal");
            String estado = con.getString("outestado");
            boolean cancelado = con.getBoolean("outcancelado");
            lista.add(new Venta(id, clitid, mpgid, usrid, fecha, numfac, fechafac, subtotal, iva,
                    impuestos, descuento, total, estado, cancelado));
        }
        con.cerrarConexion();
        return lista;
    }
}
