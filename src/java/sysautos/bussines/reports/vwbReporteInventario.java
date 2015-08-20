/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.reports;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPTable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import sysautos.bussines.drivers.dvrProducto;
import sysautos.bussines.drivers.dvrTipoproducto;
import sysautos.bussines.entities.Producto;
import sysautos.bussines.entities.Tipoproducto;
import sysautos.bussines.session.MbsMessages;

/**
 *
 * @author Maria
 */
@ManagedBean(name = "dtReporteproductoView")
@ViewScoped
public class vwbReporteInventario {

    private List<Tipoproducto> tipoproductos;
    private int tipoproductosel;
    private List<Producto> listaportipoproducto;

    public vwbReporteInventario() {
        loadtipoproductos();
    }

    public void loadtipoproductos() {
        try {
            this.tipoproductos = dvrTipoproducto.getTipoproductoList();
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public final void cargartablaportipoproducto() {
        try {
            listaportipoproducto = dvrProducto.getProductoListByTipoID(tipoproductosel);
        } catch (Exception ex) {
            Logger.getLogger(vwbReporteInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

    public List<Tipoproducto> getTipoproductos() {
        return tipoproductos;
    }

    public void setTipoproductos(List<Tipoproducto> tipoproductos) {
        this.tipoproductos = tipoproductos;
    }

    public int getTipoproductosel() {
        return tipoproductosel;
    }

    public void setTipoproductosel(int tipoproductosel) {
        this.tipoproductosel = tipoproductosel;
    }

    public List<Producto> getListaportipoproducto() {
        return listaportipoproducto;
    }

    public void setListaportipoproducto(List<Producto> listaportipoproducto) {
        this.listaportipoproducto = listaportipoproducto;
    }

}
