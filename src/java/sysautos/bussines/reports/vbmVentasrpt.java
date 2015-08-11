/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.reports;

import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import sysautos.bussines.classes.rptCliente;
import sysautos.bussines.drivers.dvrCliente;
import sysautos.bussines.entities.Cliente;
import sysautos.bussines.session.MbsMessages;

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
    private int tipo;
    private int parameter;
    private Date from;
    private Date until;
    private List<Cliente> clientes;

    public vbmVentasrpt() {
        this.clientes = new ArrayList<>();

    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getUntil() {
        return until;
    }

    public void setUntil(Date until) {
        this.until = until;
    }

    public int getParameter() {
        return parameter;
    }

    public void setParameter(int parameter) {
        this.parameter = parameter;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void generar() throws Exception {
        switch (this.tipo) {
            case 1:
                if (this.parameter == 2) {
                    this.clientes = dvrCliente.getClienteList();
                    rptCliente rptCli = new rptCliente();
                    this.clientes.stream().forEach((cli) -> {
                        rptCli.addDetalle(cli);
                    });

                    String path = "/reports/rptclientes.jasper";
                    File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath(path));
                    JasperPrint jp = JasperFillManager.fillReport(jasper.getPath(), null, rptCli);

                    HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
                    response.addHeader("ContentType", "attachment; application/pdf");
                    ServletOutputStream stream = response.getOutputStream();
                    JasperExportManager.exportReportToPdfStream(jp, stream);
                    stream.flush();
                    //stream.close();
                    FacesContext.getCurrentInstance().responseComplete();
                } else {
                    MbsMessages.error("Este tipo de reporte no puede generarse con los parametros selecionados");
                }
                break;
            case 2:
                if (this.parameter == 2) {
                    MbsMessages.info("Reporte de Inventario");
                } else {
                    MbsMessages.error("Este tipo de reporte no puede generarse con los parametros selecionados");
                }
                break;
            case 3:
                switch (this.parameter) {
                    case 0: {
                        MbsMessages.info("Reporte de Ventas por fechas");
                        break;
                    }
                    case 1: {
                        MbsMessages.info("Reporte de Ventas en rango de Fechas");
                        break;
                    }
                    case 2: {
                        MbsMessages.info("Reporte Todas las ventas");
                        break;
                    }
                }
                break;
            default:
                MbsMessages.error("Este tipo de reporte no puede generarse con los parametros ingresados");
                break;
        }
    }

}
