/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.classes;

import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import sysautos.bussines.entities.Cliente;

/**
 *
 * @author hp
 */
public class rptCliente implements JRDataSource {

    private int indiceDetalle = -1;
    private final List<Cliente> lstClientes = new ArrayList<>();

    @Override
    public boolean next() throws JRException {
        return ++indiceDetalle < lstClientes.size();
    }

    public void addDetalle(Cliente cliente) {
        this.lstClientes.add(cliente);
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        Object valor = null;
        switch (jrf.getName()) {
            case "nombre":
                valor = lstClientes.get(indiceDetalle).getNombre();
                break;
            case "apellido":
                valor = lstClientes.get(indiceDetalle).getApellido();
                break;
            case "email":
                valor = lstClientes.get(indiceDetalle).getEmail();
                break;
        }
        return valor;
    }
}
