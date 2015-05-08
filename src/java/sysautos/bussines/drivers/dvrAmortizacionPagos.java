/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.drivers;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import sysautos.bussines.entities.AmortizacionPagos;
import sysautos.integration.Conexion;
import sysautos.integration.Parameter;


/**
 *
 * @author DISMAGIC0985043396
 */
public class dvrAmortizacionPagos {
    
    
    
    public static int userAmtPagosRegister(AmortizacionPagos objeto) throws Exception {
        int codigo = 0;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getAmrid(), Types.INTEGER));
        parametros.add(new Parameter(2, objeto.getPagosid(), Types.INTEGER));
       
        String llamadaPA = "SELECT autos.\"amortizacionpagosRegister_pa\"(?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            codigo = con.getInt("amortizacionpagosRegister_pa");
        }
        con.cerrarConexion();
        return codigo;
    }

    
    
    
     public static List<AmortizacionPagos> getAmortizacionPagosList() throws Exception {
        List<AmortizacionPagos> lista = new ArrayList<>();
        String llamadaPA = "SELECT * from autos.\"amortpagosSelectAll_pa\"()";
        Conexion con = new Conexion(llamadaPA);
        while (con.siguiente()) {
            int amortizacion = con.getInt("crtid");
            int pago = con.getInt("amzid");
            int credito= con.getInt("pgsid");
            int factura= con.getInt("id_fac");
           
            lista.add(new AmortizacionPagos(credito,amortizacion,pago,factura));
        }
        con.cerrarConexion();
        return lista;
    }
    
    
    
    
    
    
    
}
