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
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import sysautos.bussines.drivers.dvrVenta;
import sysautos.bussines.entities.User;
import sysautos.bussines.entities.Venta;

/**
 *
 * @author hp
 */
@ManagedBean(name = "dtReporteView")
@ViewScoped
public class vbmVentasrpt {

    /**
     * Creates a new instance of vbmVentasrpt
     */
    private User agente;
    private List<User> agentes;
    private List<Venta> ventas;

    public vbmVentasrpt() {
        this.ventas = new ArrayList<>();
        this.agentes = new ArrayList<>();
        this.agente = new User();
    }

    public User getAgente() {
        return agente;
    }

    public void setAgente(User agente) {
        this.agente = agente;
    }

    public List<User> getAgentes() {
        return agentes;
    }

    public void setAgentes(List<User> agentes) {
        this.agentes = agentes;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }
    
    public void generar() throws Exception {
        this.ventas = dvrVenta.getVentaList();
    }
    
    public void preProcessPDF(Object document) throws IOException, BadElementException, DocumentException {
        final Paragraph paragrap = new Paragraph("Reporte: Ventas por Agente");
        final Phrase phrase = new Phrase("\n ");
        
        PdfPTable dt = null;
        ReporteItex obRepItx = new ReporteItex();
        obRepItx.preProcessPDF(document, paragrap, phrase, dt);
    }
}
