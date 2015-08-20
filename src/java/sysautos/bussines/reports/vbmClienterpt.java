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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import sysautos.bussines.common.Genericas;
import sysautos.bussines.drivers.dvrUser;
import sysautos.bussines.drivers.dvrVenta;
import sysautos.bussines.entities.User;
import sysautos.bussines.entities.Venta;

/**
 *
 * @author hp
 */
@ManagedBean(name = "dtRptClienteView")
@ViewScoped
public final class vbmClienterpt {

    /**
     * Creates a new instance of vbmVentasrpt
     */

    private List<Venta> ventas;
    private String valor;
    private int parameter;


    public vbmClienterpt() throws Exception {
        this.ventas = new ArrayList<>();
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    
    /*logica del reporte*/
    public void generar() throws Exception {
       

    }

    public void preProcessPDF(Object document) throws IOException, BadElementException, DocumentException {
        final Paragraph paragrap = new Paragraph("Reporte de Cliente");
        final Phrase phrase = new Phrase("\n ");

        PdfPTable dt = null;
        ReporteItex obRepItx = new ReporteItex();
        obRepItx.preProcessPDF(document, paragrap, phrase, dt);
    }
}
