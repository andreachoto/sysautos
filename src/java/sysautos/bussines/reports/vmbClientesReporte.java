/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.reports;

import com.lowagie.text.BadElementException;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPTable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import sysautos.bussines.drivers.dvrCliente;
import sysautos.bussines.drivers.dvrClienteCredito;
import sysautos.bussines.drivers.dvrTipodeudor;
import sysautos.bussines.entities.Cliente;
import sysautos.bussines.entities.ClienteCredito;
import sysautos.bussines.entities.Tipodeudor;

/**
 *
 * @author Carolyn
 */
@ManagedBean(name = "dtRptClientesView")
@ViewScoped
public class vmbClientesReporte {

    /**
     * Creates a new instance of vmbClientesReporte
     */
    private ClienteCredito agente;
    private List<Cliente> lstclientes;
    private List<Tipodeudor> lstTipodecudors;

    public vmbClientesReporte() {
        try {
//            this.lstclientes = new ArrayList<>();
            this.lstclientes = dvrCliente.getClienteList();
            this.lstTipodecudors = dvrTipodeudor.getTipodeudorList();
            this.agente = new ClienteCredito();
        } catch (Exception ex) {
            Logger.getLogger(vmbClientesReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ClienteCredito getAgente() {
        return agente;
    }

    public void setAgente(ClienteCredito agente) {
        this.agente = agente;
    }

    public List<Tipodeudor> getLstTipodecudors() {
        return lstTipodecudors;
    }

    public void setLstTipodecudors(List<Tipodeudor> lstTipodecudors) {
        this.lstTipodecudors = lstTipodecudors;
    }
  
    public List<Cliente> getLstclientes() {
        return lstclientes;
    }

    public void setLstclientes(List<Cliente> lstclientes) {
        this.lstclientes = lstclientes;
    }

    public void preProcessPDF(Object document) throws IOException, BadElementException, DocumentException {
        final Paragraph paragrap = new Paragraph("Reporte: Clientes");
        final Phrase phrase = new Phrase("\n ");

        PdfPTable dt = null;
        ReporteItex obRepItx = new ReporteItex();
        obRepItx.preProcessPDF(document, paragrap, phrase, dt);
    }
    
    
     public void generar() throws Exception {
       
        if (this.agente.getIdtipo() != 0) {
          
                this.lstclientes = dvrCliente.getClienteListToReport(this.agente.getIdtipo());
            
        } 

    }
    

}
