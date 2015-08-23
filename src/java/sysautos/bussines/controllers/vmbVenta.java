package sysautos.bussines.controllers;

import com.lowagie.text.BadElementException;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPTable;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import sysautos.bussines.common.Genericas;
import sysautos.bussines.drivers.dvrCliente;
import sysautos.bussines.drivers.dvrDetalleventa;
import sysautos.bussines.drivers.dvrModopago;
import sysautos.bussines.drivers.dvrProducto;
import sysautos.bussines.drivers.dvrProveedor;
import sysautos.bussines.drivers.dvrTipoproducto;
import sysautos.bussines.drivers.dvrVenta;
import sysautos.bussines.entities.Cliente;
import sysautos.bussines.entities.Detalleventa;
import sysautos.bussines.entities.Modopago;
import sysautos.bussines.entities.Venta;
import sysautos.bussines.entities.Producto;
import sysautos.bussines.entities.Proveedor;
import sysautos.bussines.entities.Tipoproducto;
import sysautos.bussines.entities.User;
import sysautos.bussines.reports.ReporteItex1;
import sysautos.bussines.session.MbsMessages;

@ManagedBean(name = "dtVentaView")
@ViewScoped

public final class vmbVenta implements Serializable {

    //atributos del bean
    private String accion;
    private Date date;
    private Venta venta;
    private List<Proveedor> proveedores;
    private List<Detalleventa> ventaitems;
    private Detalleventa itemventa, itemselect;
    private List<Tipoproducto> tiposproducto;
    private Tipoproducto tipprod_select;
    private List<Producto> productos;
    private List<Cliente> clientes;
    private Cliente clientesel;
    private List<Modopago> modopagos;
    private Modopago mdopagosel;
    private boolean factura;

    public vmbVenta() throws Exception {
        this.accion = "INS";
        this.venta = new Venta();
        this.ventaitems = new ArrayList<>();
        this.itemventa = new Detalleventa();
        this.itemselect = new Detalleventa();
        this.tipprod_select = new Tipoproducto();
        this.loadProveedores();
        this.loadTipoproductos();
        this.clientes = dvrCliente.getClienteList();
        this.clientesel = new Cliente();
        this.modopagos = dvrModopago.getModopagoList();
        this.mdopagosel = new Modopago();
    }

    String datrepfecha;
    String datrepcliente;
    String datrepnumfactura;
    String datrepmodopago;

    public void cargardatosreporte() {
        DateFormat fecha = new SimpleDateFormat("yyyy/MM/dd");
        datrepfecha = fecha.format(date);
        for (Cliente valor : clientes) {
            if (valor.getId() == venta.getClitid()) {
                datrepcliente = valor.getNombre() + " " + valor.getApellido();
            }
        }
        datrepnumfactura = venta.getNumfac();
        for (Modopago valor : modopagos) {
            if (valor.getId() == venta.getMpgid()) {
                datrepmodopago = valor.getNombre();
            }
        }
    }

    public void preProcessPDF(Object document) throws IOException, BadElementException, DocumentException {
        //*****++++ este es el encabezado
        final Paragraph paragrap = new Paragraph("China Motors \n");

        final Phrase phrase = new Phrase("\n ");
        ///
        PdfPTable dt = null;
        //
        ReporteItex1 obRepItx = new ReporteItex1();
        obRepItx.preProcessPDF(document, paragrap, phrase, dt, datrepfecha, datrepcliente, datrepnumfactura, datrepmodopago);
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }

    public List<Detalleventa> getVentaitems() {
        return ventaitems;
    }

    public void setVentaitems(List<Detalleventa> ventaitems) {
        this.ventaitems = ventaitems;
    }

    public Detalleventa getItemventa() {
        return itemventa;
    }

    public void setItemventa(Detalleventa itemventa) {
        this.itemventa = itemventa;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Detalleventa getItemselect() {
        return itemselect;
    }

    public void setItemselect(Detalleventa itemselect) {
        this.itemselect = itemselect;
    }

    public List<Tipoproducto> getTiposproducto() {
        return tiposproducto;
    }

    public void setTiposproducto(List<Tipoproducto> tiposproducto) {
        this.tiposproducto = tiposproducto;
    }

    public Tipoproducto getTipprod_select() {
        return tipprod_select;
    }

    public void setTipprod_select(Tipoproducto tipprod_select) {
        this.tipprod_select = tipprod_select;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Cliente getClientesel() {
        return clientesel;
    }

    public void setClientesel(Cliente clientesel) {
        this.clientesel = clientesel;
    }

    public List<Modopago> getModopagos() {
        return modopagos;
    }

    public void setModopagos(List<Modopago> modopagos) {
        this.modopagos = modopagos;
    }

    public Modopago getMdopagosel() {
        return mdopagosel;
    }

    public void setMdopagosel(Modopago mdopagosel) {
        this.mdopagosel = mdopagosel;
    }

    public boolean isFactura() {
        return factura;
    }

    public void setFactura(boolean factura) {
        this.factura = factura;
    }

    //Metodos de logica    
    public void loadProveedores() {
        try {
            this.proveedores = dvrProveedor.getProveedorList();
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void loadTipoproductos() {
        try {
            this.tiposproducto = dvrTipoproducto.getTipoproductoList();
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void loadproductosbyTipoID() {
        try {
            this.productos = dvrProducto.getProductoListByTipoID(this.tipprod_select.getId());
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void loadProductos() {
        try {
            this.productos = dvrProducto.getProductoList();
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void addItemDetalle() {
        try {
            BigDecimal vu = this.itemventa.getValoruni();
            Double sbt, tot, desc = 0.0;
            this.itemventa.setProducto(dvrProducto.getProductoById(this.itemventa.getPdtid()));
            int stock = this.itemventa.getProducto().getStock();
            int cant = this.itemventa.getCantidad();
            if ((stock > 0) && (cant <= stock)) {
                sbt = vu.doubleValue() * this.itemventa.getCantidad();
                tot = sbt - desc;
                if (this.itemventa.getPdtid() != -1) {
                    if (this.itemventa.getCantidad() > 0) {
                        Detalleventa item = new Detalleventa(0, 0, this.itemventa.getPdtid(), this.itemventa.getCantidad(),
                                this.itemventa.getValoruni(), BigDecimal.valueOf(sbt), BigDecimal.valueOf(desc), BigDecimal.valueOf(tot));
                        this.ventaitems.add(item);
                    } else {
                        MbsMessages.error("Ingrese la cantidad de productos al Item de Venta");
                    }
                } else {
                    MbsMessages.error("Seleccione un producto para agregar Items al venta");
                }
            } else {
                MbsMessages.warn("Stock insuficiente para la presente venta!");
            }

        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void delItemDetalle() {
        try {
            Detalleventa item = this.itemselect;
            this.ventaitems.remove(item);
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void register() {
        try {
            Date dat = this.date;
            if ((this.venta.getClitid() != -1) && (this.venta.getMpgid() != -1)) {
                //calculo de totales en funcion de los items
                double tot = 0.0;
                for (Detalleventa item : this.ventaitems) {
                    tot = tot + item.getValtotal().doubleValue();
                }
                double iva = tot * 0.12;
                double baseimp = tot - iva;
                //setear valores totales de venta
                Venta vta = this.venta;
                HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                User user = (User) httpSession.getAttribute("user");
                vta.setUsrid(user.getId());
                vta.setFecha(Genericas.parsDatetoTimestamp(dat));
                vta.setEstado("Pedido");
                vta.setSubtotal(BigDecimal.valueOf(baseimp));
                vta.setIva(BigDecimal.valueOf(iva));
                vta.setTotal(BigDecimal.valueOf(tot));
                vta.setCancelado(Boolean.FALSE);
                if (this.isFactura()) {
                    vta.setFechafac(Genericas.parsDatetoTimestamp(dat));
                } else {
                    vta.setNumfac("");
                }
                int id = dvrVenta.ventaRegister(vta);
                if (id != 0) {
                    //Guardar items del venta
                    for (Detalleventa item : this.ventaitems) {
                        item.setVtaid(id);
                        dvrDetalleventa.detalleventaRegister(item);
                        int stock = item.getProducto().getStock();
                        item.getProducto().setStock(stock-item.getCantidad());
                        dvrProducto.setStockProducto(item.getProducto());
                        cargardatosreporte();
                    }
                    //refescamos la lista de ventas
                    MbsMessages.info("Venta creada exitosamente!");
                } else {
                    MbsMessages.error("No se pudo insertar el registro!");
                }
            } else {
                MbsMessages.error("Debe seleccionar el Cliente y Forma de Pago!");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void update() {
    }

    public void loadpriceProducto(int id) {
        try {
            Producto prod = dvrProducto.getProductoById(id);
            this.itemventa.setValoruni(prod.getValorunit());
        } catch (Exception ex) {
            Logger.getLogger(vmbVenta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
