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
@ManagedBean(name = "dtReporteView")
@ViewScoped
public final class vbmVentasrpt {

    /**
     * Creates a new instance of vbmVentasrpt
     */
    private User agente;
    private List<User> agentes;
    private List<Venta> ventas;
    private Date date1;
    private Date date2;

    public vbmVentasrpt() throws Exception {
        this.ventas = new ArrayList<>();
        this.agentes = new ArrayList<>();
        this.agente = new User();
        this.loadAgentes();
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

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    /*logica del reporte*/
    public void generar() throws Exception {
        Timestamp f1 = Genericas.convertStringtoTimestamp("1900-01-01");
        Timestamp f2 = Genericas.convertStringtoTimestamp("1900-01-01");
        if (this.date1 != null){
            f1 = Genericas.parsDatetoTimestamp(this.date1);
        }
        if (this.date2 != null){
            f2 = Genericas.parsDatetoTimestamp(this.date2);
        }

        if (this.agente.getId() != 0) {
            if (this.date1 != null && this.date2 != null) {
                this.ventas = dvrVenta.getVentaListToReport(1, this.agente.getId(), f1, f2);
            } else {
                this.ventas = dvrVenta.getVentaListToReport(3, this.agente.getId(), f1, f2);
            }
        } else {
            if (this.date1 != null && this.date2 != null) {
                this.ventas = dvrVenta.getVentaListToReport(2, this.agente.getId(), f1, f2);
            } else {
                this.ventas = dvrVenta.getVentaList();
            }
        }

    }

    public void loadAgentes() throws Exception {
        this.agentes = dvrUser.getUserList();
    }

    public void preProcessPDF(Object document) throws IOException, BadElementException, DocumentException {
        final Paragraph paragrap = new Paragraph("Reporte: Ventas por Agente");
        final Phrase phrase = new Phrase("\n ");

        PdfPTable dt = null;
        ReporteItex obRepItx = new ReporteItex();
        obRepItx.preProcessPDF(document, paragrap, phrase, dt);
    }
}
