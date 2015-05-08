/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.drivers;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import sysautos.bussines.entities.ClienteCredito;
import sysautos.integration.Conexion;
import sysautos.integration.Parameter;


/**
 *
 * @author DISMAGIC0985043396
 */
public class dvrClienteCredito { 
    
    
    public static int ClienteCreditoRegister(ClienteCredito objeto, int resul ) throws Exception {
       
        int codigo = 0;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getIdcli(), Types.INTEGER));
        parametros.add(new Parameter(2, resul, Types.INTEGER));
        parametros.add(new Parameter(3, objeto.getIdtipo(), Types.INTEGER));
        
        String llamadaPA = "SELECT * from autos.cliente_creditoregister_pa(?,?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            codigo = con.getInt("cliente_creditoregister_pa");
        }
        con.cerrarConexion();
        return codigo;
    }
    public static List<ClienteCredito> getAplicarList() throws Exception {
        List<ClienteCredito> lista = new ArrayList<>();
        String llamadaPA ="SELECT * from autos.\"clientecreditoSelectAll_pa\"()";
        Conexion con = new Conexion(llamadaPA);
     

        while (con.siguiente()) {
            int cliente=  con.getInt("outcltid");
            int credito  = con.getInt("outcrtid");
            int tipo= con.getInt("outtpdid");
            lista.add(new ClienteCredito(cliente,credito,tipo));
         
        }
        con.cerrarConexion();
        return lista;
    }

    public static ClienteCredito getClientecreditoById(int cltid, int crtid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    
    }
    
       
//     public static List<ClienteCredito> getCreditoGarantesListByTipo(int codigo) throws Exception {
//        List<ClienteCredito> lista = new ArrayList<>();
//        List<Parameter> parametros = new ArrayList<>();
//        parametros.add(new Parameter(1, codigo, Types.INTEGER));
//        String llamadaPA = "SELECT * from autos.\"creditogaranteByID_pa\"(?)";
//        Conexion con = new Conexion(llamadaPA, parametros);
//        while (con.siguiente()) {
//            String nombre = con.getString("outnombre");
//            String apellido= con.getString("outapellido");
//            String tipodeudor=con.getString("outtipo");
//            lista.add(new ClienteCredito(nombre,apellido,tipodeudor));
//        }
//        con.cerrarConexion();
//        return lista;
//    }
    
    
}
