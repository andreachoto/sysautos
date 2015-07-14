package sysautos.bussines.controllers;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.DefaultRequestContext;
import sysautos.bussines.drivers.dvrAmortizacion;
import sysautos.bussines.drivers.dvrCliente;
import sysautos.bussines.drivers.dvrClienteCredito;
import sysautos.bussines.drivers.dvrCredit;
import sysautos.bussines.drivers.dvrRequisitosCliente;
import sysautos.bussines.drivers.dvrTipodeudor;
import sysautos.bussines.entities.Amortizacion;
import sysautos.bussines.entities.Cliente;
import sysautos.bussines.entities.ClienteCredito;
import sysautos.bussines.entities.Credit;
import sysautos.bussines.entities.Requisitos;
import sysautos.bussines.entities.RequisitosCliente;
import sysautos.bussines.entities.Tipodeudor;
import sysautos.bussines.session.MbsMessages;

@ManagedBean(name = "dtCreditoView")
@ViewScoped
public class CCredito2 {

    private static List<Credit> lstcreditos;
    private Credit credito, creditoSeleccion;
    private ClienteCredito clicredsel;
    private Date fecha, fecha1;
    private ClienteCredito clientecredito;
    private Cliente client;
    private Amortizacion objAmortizacion;
    private Tipodeudor tipodeudor;
    private String strFormaPago, strFechaPlazo;
    private int intIdCliente, intTipoDeudor, intFormaPago, intConyuge,
            intGarante1, intConyugeGarante1, intgarante2, intConyugeGarante2,
            idCejero, intPlazo, modo;
    private Timestamp fechaActua;
    private ArrayList<Amortizacion> listaAmt;
    private static ArrayList<Tipodeudor> lstTipodeudor;
    private ArrayList<Integer> listaMeses;
    private boolean verificacion;
    private List<ClienteCredito> lstClienteCredito;
    private List<ClienteCredito> lstRequisitosCliente;
    private List<RequisitosCliente> lstRequisitosClienteid;
    private static List<Cliente> lstClients;
    private List<Requisitos> lstRequisitos;
    private List<Amortizacion> lstAmortizacion;
    
    

    private int resul;

    public CCredito2() {
        credito = new Credit();
        client = new Cliente();
        clientecredito = new ClienteCredito();
        lstcreditos = new ArrayList<>();
        listaAmt = new ArrayList<>();
        objAmortizacion = new Amortizacion();
        lstTipodeudor = new ArrayList<>();
        listaMeses = new ArrayList<>();
        lstClienteCredito = new ArrayList<>();
        lstRequisitosCliente = new ArrayList<>();
        lstAmortizacion=new ArrayList<>();
        lstRequisitosClienteid = new ArrayList<>();
        loadClientes();
        loadTipodeudor();
        this.tipodeudor = new Tipodeudor();
        cargar();
    }

    public CCredito2(ArrayList<Credit>listacredito, Credit objCredito, Credit creditoSeleccion, Date fecha, Date fecha1, ClienteCredito objcli, String strFormaPago, int intIdCliente, int intTipoDeudor, int intFormaPago, int intConyuge, int intGarante1, int intConyugeGarante1, int intgarante2, int intConyugeGarante2, int idCejero, ArrayList<Amortizacion> listaAmt, Amortizacion objAmortizacion, int resul, int modo) {
        this.lstcreditos = listacredito;
        this.credito = objCredito;
        this.creditoSeleccion = creditoSeleccion;
        this.fecha = fecha;
        this.fecha1 = fecha1;
        this.clientecredito = objcli;
        this.strFormaPago = strFormaPago;
        this.intIdCliente = intIdCliente;
        this.intTipoDeudor = intTipoDeudor;
        this.intFormaPago = intFormaPago;
        this.intConyuge = intConyuge;
        this.intGarante1 = intGarante1;
        this.intConyugeGarante1 = intConyugeGarante1;
        this.intgarante2 = intgarante2;
        this.intConyugeGarante2 = intConyugeGarante2;
        this.idCejero = idCejero;
        this.listaAmt = listaAmt;
        this.objAmortizacion = objAmortizacion;
        this.resul = resul;
        this.modo = modo;
    }
   
    //FUNCIONES
    public static void cargar() {
        try {
            lstcreditos = dvrCredit.getuserCreditoList();
            lstTipodeudor = dvrTipodeudor.getTipodeudorList();
            lstClients = dvrCliente.getClienteList();
        } catch (Exception ex) {
            //Util.addErrorMessage("Error en la Aplicacion.");
        }

    }

    public static void loadClientes() {
        try {
            lstClients = dvrCliente.getClienteList();
        } catch (Exception ex) {
            MbsMessages.fatal("Error: " + ex.getMessage());
        }
    }

    public void mostrar(int intOpcion) {
        try {

            if (creditoSeleccion != null) {
                switch (intOpcion) {
                    case 1:
                        DefaultRequestContext.getCurrentInstance().execute(
                                "wdlgActualizar.show()");
                        break;
                    case 2:
                        DefaultRequestContext.getCurrentInstance().execute(
                                "wdlgEliminar.show()");
                        break;
                }

            } else {
                //Util.addSuccessMessage("Objeto no seleccionado.");
            }
        } catch (Exception e) {
            //Util.addErrorMessage("Error en la Aplicacion.");
        }
    }

    public void loadTipodeudor() {
        try {
            this.lstTipodeudor = dvrTipodeudor.getTipodeudorList();
        } catch (Exception ex) {
            MbsMessages.fatal("Error: " + ex.getMessage());
        }
    }

    public void ingresar() {
        try {

            System.err.println("Ingresa Datos Amortizacion");
            long fechasAc = obtieneFecha(fecha1) - obtieneFecha(fecha);
            fechaActua = obtieneFechaTimeStamp(fechasAc);
            credito.setFecha(obtieneFechaTimeStamp(fecha.getTime()));
            credito.setFormapago(strFormaPago);
            credito.setVencimiento(obtieneFechaTimeStamp(fecha1.getTime()));
            credito.setIduser(1);
            ClienteCredito crecli = new ClienteCredito(this.intIdCliente, 0, this.intTipoDeudor);
            this.lstClienteCredito.add(crecli);

            resul = dvrCredit.userCreditoRegister(credito);
            if (resul != 0) {
                this.insertarclientecredito();

                //lstRequisitosCliente = dvrRequisitosCliente.getClientesListByCrdito(resul);

                for (ClienteCredito cliente : lstClienteCredito) {

                    lstRequisitos = (dvrRequisitosCliente.getRequisitosListByTipo(cliente.getIdtipo()));

                    for (Requisitos req : lstRequisitos) {

                      RequisitosCliente rq = new RequisitosCliente(req.getRqtid(),cliente.getIdcli(),resul,false);
                      dvrRequisitosCliente.userReqClienteRegister(rq);

                    }
                }
                generarAmortizacion();
                lstAmortizacion = (dvrAmortizacion.getAmortizacionListByCred(resul) );
                cargar();

            } else {
                //Util.addErrorMessage("Error en la Insercion.");
            }
        } catch (Exception ex) {
            
        }

    }
    
    public void buscar(){
        
        
        
        
        
    }
    
    
    
    
    
    
    

    public void insertarclientecredito() {

        try {
            for (ClienteCredito clientecred : lstClienteCredito) {
                dvrClienteCredito.ClienteCreditoRegister(clientecred, resul);
            }

            DefaultRequestContext.getCurrentInstance().execute("wdlgAmortizacion.hide()");
            MbsMessages.info("Generado Correctamente");
        } catch (Exception ex) {

        }
    }

    public void insertarrequisitosgarante() {

        try {
            for (ClienteCredito clientecred : lstClienteCredito) {
                dvrClienteCredito.ClienteCreditoRegister(clientecred, resul);
            }

            DefaultRequestContext.getCurrentInstance().execute("wdlgAmortizacion.hide()");
            MbsMessages.info("Generado Correctamente");
        } catch (Exception ex) {

        }
    }

    public void insertar() {

        try {
            for (Amortizacion amortizacion : listaAmt) {
                dvrAmortizacion.userAmtRegister(amortizacion);
            }
            //Util.addSuccessMessage("Datos insertados Exitosamente.");
            DefaultRequestContext.getCurrentInstance().execute("wdlgAmortizacion.hide()");
            MbsMessages.error("Generado Correctamente");
        } catch (Exception ex) {
            //Logger.getLogger(CCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void calcularFecha() {
        try {

            long fechasAc = obtieneFecha(fecha1) - obtieneFecha(fecha);
            fechaActua = obtieneFechaTimeStamp(fechasAc);
        } catch (Exception e) {
//            Util.addErrorMessage("Error en la Aplicacion.");
        }
    }

    public void actualizar() {
        try {
//            if (dvrTipodeudor.tipoUpdate(creditoSeleccion) == true) {
//                cargar();
//                DefaultRequestContext.getCurrentInstance().execute(
//                        "wdlgActualizar.hide()");
//                Util.addAlertMessage("Datos Actualizados exitosamente");
//            } else {
//                Util.addErrorMessage("El objeto no se puede Actualizar");
//            }
        } catch (Exception e) {
            //Util.addErrorMessage("Error en la Aplicacion.");
        }
    }

    public void eliminar() {
        try {
//            boolean result = false;
//            result = dvrTipodeudor.tipoDel(creditoSeleccion);
//            if (result == true) {
//                cargar();
//                DefaultRequestContext.getCurrentInstance().execute(
//                        "wdlgEliminar.hide()");
//                Util.addAlertMessage("Datos Eliminados exitosamente");
//            } else {
//                if (result == false) {
//                    Util.addErrorMessage("El objeto Tiene enlazado varios Items? NO se puede Eliminar.");
//                } else {
//                    Util.addErrorMessage("El objeto no se puede Eliminar");
//                }
//            }

        } catch (Exception e) {
            //Util.addErrorMessage("Error en la Aplicacion.");
        }
    }

    public void generarAmortizacion() {
        try {
           // DefaultRequestContext.getCurrentInstance().execute("wdlgAmortizacion.show()");
            double tasap;
            double valorcuota;
            int ncuotas = 0;
            int pagosanio = 0;
            double interes = credito.getInteres().doubleValue();
            double amortizacion = 0;
            double pagointeres;

            double monto = credito.getMonto().doubleValue();
            double saldo = monto;
            int plazo = credito.getPlazo();

            if (this.credito.getFormapago().equals("Mensual")) {
                pagosanio = 12;
            }
            ncuotas = plazo * pagosanio;
            interes = interes / 100;
            double tp = Math.pow((interes + 1), (1 / pagosanio));
            tasap = tp - 0.9;//-1
            double div = 1 - Math.pow((1 + tasap), (-1 * ncuotas));
            valorcuota = (monto * (tasap / div));
            listaAmt.clear();
            objAmortizacion.setAmzcuota(credito.getPlazo());
            objAmortizacion.setCreditoid(resul);

            for (int i = 0; i <= ncuotas; i++) {
                objAmortizacion.setAmzcuota(credito.getPlazo());
                objAmortizacion.setCreditoid(resul);
                if (i != 0) {

                    objAmortizacion.setAmzcuota(i);
                    objAmortizacion.setAmzvalorc(BigDecimal.valueOf(getRedondear(valorcuota)));
                    pagointeres = saldo * (tasap);
                    objAmortizacion.setAmzinteres(BigDecimal.valueOf(getRedondear(pagointeres)));

                    amortizacion = valorcuota - pagointeres;
                    objAmortizacion.setAmortizacion(BigDecimal.valueOf(getRedondear(amortizacion)));

                    saldo = saldo - amortizacion;
                    objAmortizacion.setAmzcapital(BigDecimal.valueOf(getRedondear(saldo)));
                    //objAmortizacion.setAmzfecha(obtieneFechaTimeStamp(fecha.getTime()));
                } else {
                    objAmortizacion.setAmzcuota(i);
                    objAmortizacion.setAmzcapital(BigDecimal.valueOf(getRedondear(monto)));
                }
                this.listaAmt.add(objAmortizacion);
                this.objAmortizacion = new Amortizacion();
            }
            insertar();
            //DefaultRequestContext.getCurrentInstance().execute("wdlgAmortizacion.show()");
        } catch (Exception e) {
        }
    }

    public void addgarante() throws Exception {

        ClienteCredito crecli = new ClienteCredito(this.client.getId(), this.credito.getId(), this.tipodeudor.getId());
        this.lstClienteCredito.add(crecli);
    }

    public void buscartabla() throws Exception{
        
        
        lstAmortizacion=dvrAmortizacion.getAmortizacionListByCred(resul);
        
    }
    
    
    public void delItemDetalle() {
        try {
            ClienteCredito item = this.clicredsel;
            this.lstClienteCredito.remove(item);
            MbsMessages.info("Garante eliminado correctamente!");
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    private static double getRedondear(double numero) {
        return Math.rint(numero * 10000) / 10000;
    }

    public static String obtieneFecha(long fecha) {
        Timestamp fechaFin = null;
        try {
            fechaFin = obtieneFechaTimeStamp(fecha);
        } catch (Exception e) {
        }
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        return formato.format(fechaFin.getTime());
    }

    public static String obtieneMesAnioLetras(long lngfecha) {
        String fecha = obtieneFecha(lngfecha);
        String Mes[] = {"ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"};
        String[] vectorFecha = fecha.split("-");
        int mes = Integer.parseInt(vectorFecha[1]);
        String anio = vectorFecha[2];
        String strFechaRetorno = Mes[mes - 1] + " " + anio;
        return strFechaRetorno;
    }

    public static java.sql.Timestamp obtieneFechaTimeStamp(long fecha) throws ParseException {
        java.sql.Timestamp timeStampDate = new Timestamp(fecha * 1000);
//          java.sql.Timestamp timeStampDate = new Timestamp(fecha);
        return timeStampDate;
    }

    public static java.sql.Time ObtieneHoraDadoString(String hora) {
        long lnMilisegundos = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        try {
            java.util.Date date = sdf.parse(hora);
            lnMilisegundos = date.getTime();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        java.sql.Time sqlTime = new java.sql.Time(lnMilisegundos);
        return sqlTime;
    }

    public static long obtieneFecha(java.util.Date dt) throws ParseException {
        long fecha = dt.getTime();
        return fecha;
    }

//Methods getter and setter of app.
    public List<Credit> getLstcreditos() {
        return lstcreditos;
    }

    public List<Amortizacion> getLstAmortizacion() {
        return lstAmortizacion;
    }

    public void setLstAmortizacion(List<Amortizacion> lstAmortizacion) {
        this.lstAmortizacion = lstAmortizacion;
    }
    
    

    public void setLstcreditos(List<Credit> lstcreditos) {
        this.lstcreditos = lstcreditos;
    }

    public Credit getCredito() {
        return credito;
    }

    public void setCredito(Credit credito) {
        this.credito = credito;
    }

    public Credit getCreditoSeleccion() {
        return creditoSeleccion;
    }

    public void setCreditoSeleccion(Credit creditoSeleccion) {
        this.creditoSeleccion = creditoSeleccion;
    }

    public ClienteCredito getClicredsel() {
        return clicredsel;
    }

    public void setClicredsel(ClienteCredito clicredsel) {
        this.clicredsel = clicredsel;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFecha1() {
        return fecha1;
    }

    public void setFecha1(Date fecha1) {
        this.fecha1 = fecha1;
    }

    public ClienteCredito getClientecredito() {
        return clientecredito;
    }

    public void setClientecredito(ClienteCredito clientecredito) {
        this.clientecredito = clientecredito;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    public Amortizacion getObjAmortizacion() {
        return objAmortizacion;
    }

    public void setObjAmortizacion(Amortizacion objAmortizacion) {
        this.objAmortizacion = objAmortizacion;
    }

    public Tipodeudor getTipodeudor() {
        return tipodeudor;
    }

    public void setTipodeudor(Tipodeudor tipodeudor) {
        this.tipodeudor = tipodeudor;
    }

    public String getStrFormaPago() {
        return strFormaPago;
    }

    public void setStrFormaPago(String strFormaPago) {
        this.strFormaPago = strFormaPago;
    }

    public String getStrFechaPlazo() {
        return strFechaPlazo;
    }

    public void setStrFechaPlazo(String strFechaPlazo) {
        this.strFechaPlazo = strFechaPlazo;
    }

    public int getIntIdCliente() {
        return intIdCliente;
    }

    public void setIntIdCliente(int intIdCliente) {
        this.intIdCliente = intIdCliente;
    }

    public int getIntTipoDeudor() {
        return intTipoDeudor;
    }

    public void setIntTipoDeudor(int intTipoDeudor) {
        this.intTipoDeudor = intTipoDeudor;
    }

    public int getIntFormaPago() {
        return intFormaPago;
    }

    public void setIntFormaPago(int intFormaPago) {
        this.intFormaPago = intFormaPago;
    }

    public int getIntConyuge() {
        return intConyuge;
    }

    public void setIntConyuge(int intConyuge) {
        this.intConyuge = intConyuge;
    }

    public int getIntGarante1() {
        return intGarante1;
    }

    public void setIntGarante1(int intGarante1) {
        this.intGarante1 = intGarante1;
    }

    public int getIntConyugeGarante1() {
        return intConyugeGarante1;
    }

    public void setIntConyugeGarante1(int intConyugeGarante1) {
        this.intConyugeGarante1 = intConyugeGarante1;
    }

    public int getIntgarante2() {
        return intgarante2;
    }

    public void setIntgarante2(int intgarante2) {
        this.intgarante2 = intgarante2;
    }

    public int getIntConyugeGarante2() {
        return intConyugeGarante2;
    }

    public void setIntConyugeGarante2(int intConyugeGarante2) {
        this.intConyugeGarante2 = intConyugeGarante2;
    }

    public int getIdCejero() {
        return idCejero;
    }

    public void setIdCejero(int idCejero) {
        this.idCejero = idCejero;
    }

    public int getIntPlazo() {
        return intPlazo;
    }

    public void setIntPlazo(int intPlazo) {
        this.intPlazo = intPlazo;
    }

    public int getModo() {
        return modo;
    }

    public void setModo(int modo) {
        this.modo = modo;
    }

    public Timestamp getFechaActua() {
        return fechaActua;
    }

    public void setFechaActua(Timestamp fechaActua) {
        this.fechaActua = fechaActua;
    }

    public ArrayList<Amortizacion> getListaAmt() {
        return listaAmt;
    }

    public void setListaAmt(ArrayList<Amortizacion> listaAmt) {
        this.listaAmt = listaAmt;
    }

    public ArrayList<Tipodeudor> getLstTipodeudor() {
        return lstTipodeudor;
    }

    public void setLstTipodeudor(ArrayList<Tipodeudor> lstTipodeudor) {
        this.lstTipodeudor = lstTipodeudor;
    }

    public ArrayList<Integer> getListaMeses() {
        return listaMeses;
    }

    public void setListaMeses(ArrayList<Integer> listaMeses) {
        this.listaMeses = listaMeses;
    }

    public boolean isVerificacion() {
        return verificacion;
    }

    public void setVerificacion(boolean verificacion) {
        this.verificacion = verificacion;
    }

    public List<ClienteCredito> getLstClienteCredito() {
        return lstClienteCredito;
    }

    public void setLstClienteCredito(List<ClienteCredito> lstClienteCredito) {
        this.lstClienteCredito = lstClienteCredito;
    }

    public List<ClienteCredito> getLstRequisitosCliente() {
        return lstRequisitosCliente;
    }

    public void setLstRequisitosCliente(List<ClienteCredito> lstRequisitosCliente) {
        this.lstRequisitosCliente = lstRequisitosCliente;
    }

    public List<RequisitosCliente> getLstRequisitosClienteid() {
        return lstRequisitosClienteid;
    }

    public void setLstRequisitosClienteid(List<RequisitosCliente> lstRequisitosClienteid) {
        this.lstRequisitosClienteid = lstRequisitosClienteid;
    }

    public List<Cliente> getLstClients() {
        return lstClients;
    }

    public void setLstClients(List<Cliente> lstClients) {
        CCredito2.lstClients = lstClients;
    }

    public int getResul() {
        return resul;
    }

    public void setResul(int resul) {
        this.resul = resul;
    }
   
    
  

    
    
    
    
    
    
    
    
    
    
    
    
    
    
      

    
    
    
}
