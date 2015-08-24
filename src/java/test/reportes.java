/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sysautos.bussines.entities.Cliente;
import sysautos.bussines.entities.ClienteCredito;
import sysautos.bussines.entities.dvrCliente;

/**
 *
 * @author Carolyn
 */
public class reportes {
     public static void main(String[] args) {
   
         try {
             System.out.println("----------ObtenerTodos");
             List<Cliente> list = new ArrayList<Cliente>();
             list = dvrCliente.getClienteListToReport(2);
             for (Cliente c : list) {
                 System.out.println(c.getNombre());
             }
         } catch (Exception ex) {
             Logger.getLogger(reportes.class.getName()).log(Level.SEVERE, null, ex);
         }
            
    }
    
}
