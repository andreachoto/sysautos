package sysautos.bussines.controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package sysautos.bussines.controllers;
//
//import java.io.Serializable;
//import java.sql.Date;
//import java.sql.Timestamp;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ViewScoped;
//import javax.rmi.CORBA.Util;
//import org.primefaces.context.DefaultRequestContext;
//import sysautos.bussines.drivers.dvrCliente;
//import sysautos.bussines.drivers.dvrClienteCredito;
//import sysautos.bussines.drivers.dvrCredit;
//import sysautos.bussines.drivers.dvrTipodeudor;
//import sysautos.bussines.drivers.dvrUser;
//import sysautos.bussines.entities.Amortizacion;
//import sysautos.bussines.entities.Cliente;
//import sysautos.bussines.entities.ClienteCredito;
//import sysautos.bussines.entities.Credit;
//import sysautos.bussines.entities.Tipodeudor;
//import sysautos.bussines.session.MbsMessages;
//
///**
// *
// * @author DISMAGIC0985043396
// */
//@ManagedBean(name = "dtCreditoView")
//@ViewScoped
//public final class vmbCredit implements Serializable {
//
//   
//
//    /**
//     * Creates a new instance of CCredit
//     */
//    private Credit credito, creditoSelect;
//    private Cliente client, garante;
//    private Tipodeudor tipodeudor;
//    private ClienteCredito clientecred;
//    private List<Credit> lstcreditos;
//    private List<Cliente> lstGarantes;
//    private List<Cliente> lstClients;
//    private List<ClienteCredito> lstClienteCredito;
//    private List<Tipodeudor> lstTipoDeudor;
//   // private Date fecha;
//    private String strFormaPago, strFechaPlazo;
//    private int intIdCliente, intTipoDeudor, intFormaPago, intConyuge,
//            intGarante1, intConyugeGarante1, intgarante2, intConyugeGarante2,
//            idCejero, intPlazo, modo;
//    private Timestamp fechaActua;
//    
//    
//    
//    /////////////////////////////
//   
//    private Date fecha, fecha1;
//    private ClienteCredito objcli;
// 
//
//    private Amortizacion objAmortizacion;
//    private int resul;
//    
//    
//    
//    
//    
//    
//    
//
//    public vmbCredit() throws Exception {
//        this.client = new Cliente();
//        this.credito = new Credit();
//        this.creditoSelect = new Credit();
//        this.clientecred = new ClienteCredito();
//        this.tipodeudor = new Tipodeudor();
//        this.loadcredito();
//        lstGarantes = new ArrayList<>();
//        lstClienteCredito = new ArrayList<>();
//        lstTipoDeudor = new ArrayList<>();
//        lstcreditos = dvrCredit.getuserCreditoList();
 //      this.loadClientes();
//        this.loadTipodeudor();
//        //this.loadClienteCredito();
//    }
//
//    public Tipodeudor getTipodeudor() {
//        return tipodeudor;
//    }
//
//    public void setTipodeudor(Tipodeudor tipodeudor) {
//        this.tipodeudor = tipodeudor;
//    }
//
//    public List<Tipodeudor> getLstTipoDeudor() {
//        return lstTipoDeudor;
//    }
//
//    public void setLstTipoDeudor(List<Tipodeudor> lstTipoDeudor) {
//        this.lstTipoDeudor = lstTipoDeudor;
//    }
//
//    public ClienteCredito getClientecred() {
//        return clientecred;
//    }
//
//    public void setClientecred(ClienteCredito clientecred) {
//        this.clientecred = clientecred;
//    }
//
//    public List<ClienteCredito> getLstClienteCredito() {
//        return lstClienteCredito;
//    }
//
//    public void setLstClienteCredito(List<ClienteCredito> lstClienteCredito) {
//        this.lstClienteCredito = lstClienteCredito;
//    }
//
//    public Credit getCredito() {
//        return credito;
//    }
//
//    public void setCredito(Credit credito) {
//        this.credito = credito;
//    }
//
//    public Credit getCreditoSelect() {
//        return creditoSelect;
//    }
//
//    public void setCreditoSelect(Credit creditoSelect) {
//        this.creditoSelect = creditoSelect;
//    }
//
//    public Cliente getClient() {
//        return client;
//    }
//
//    public void setClient(Cliente client) {
//        this.client = client;
//    }
//
//    public Cliente getGarante() {
//        return garante;
//    }
//
//    public void setGarante(Cliente garante) {
//        this.garante = garante;
//    }
//
//    public List<Credit> getLstcreditos() {
//        return lstcreditos;
//    }
//
//    public void setLstcreditos(List<Credit> lstcreditos) {
//        this.lstcreditos = lstcreditos;
//    }
//
//    public List<Cliente> getLstGarantes() {
//        return lstGarantes;
//    }
//
//    public void setLstGarantes(List<Cliente> lstGarantes) {
//        this.lstGarantes = lstGarantes;
//    }
//
//    public List<Cliente> getLstClients() {
//        return lstClients;
//    }
//
//    public void setLstClients(List<Cliente> lstClients) {
//        this.lstClients = lstClients;
//    }
//
//   
//    public void setFecha(Date fecha) {
//        this.fecha = fecha;
//    }
//
//    /*metodos publicos*/
//    public void loadcredito() {
//        try {
//            this.lstcreditos = dvrCredit.getuserCreditoList();
//        } catch (Exception ex) {
//            MbsMessages.fatal("Error 1: " + ex.getMessage());
//        }
//    }
//
//    public void loadClientes() {
//        try {
//            this.lstClients = dvrCliente.getClienteList();
//        } catch (Exception ex) {
//            MbsMessages.fatal("Error: " + ex.getMessage());
//        }
//    }
//
//    public void loadTipodeudor() {
//        try {
//            this.lstTipoDeudor = dvrTipodeudor.getTipodeudorList();
//        } catch (Exception ex) {
//            MbsMessages.fatal("Error: " + ex.getMessage());
//        }
//    }
//
//    public void loadClienteCredito() {
//        try {
//            this.lstClienteCredito = dvrClienteCredito.getAplicarList();
//        } catch (Exception ex) {
//            MbsMessages.fatal("Error: " + ex.getMessage());
//        }
//    }
//
//    public void register() {
//
////        try {
////
////            //fechaActua = obtieneFechaTimeStamp(fechasAc);
////            //credito.setFecha(obtieneFechaTimeStamp(fecha.getTime()));
////            //credito.setFormapago(strFormaPago);
////            //credito.setVencimiento(obtieneFechaTimeStamp(fecha.getTime()));
////            credito.setIduser(1);
////            credito.setPlazo(5);
////            int resul = dvrCredit.userCreditoRegister(this.credito);
////            if (resul != 0) {
////                MbsMessages.info(" Creado exitosamente!");
////
////            } else {
////
////            }
////        } catch (Exception ex) {
////            // Logger.getLogger(CProfile.class.getName()).log(Level.SEVERE, null, ex);
////        }
//        
//        
//        try {
//
//            long fechasAc = vmbCredit.obtieneFecha(fecha);
//            fechaActua = obtieneFechaTimeStamp(fechasAc);
//            credito.setFecha(obtieneFechaTimeStamp(fecha.getTime()));
//            credito.setFormapago(strFormaPago);
//            credito.setVencimiento(obtieneFechaTimeStamp(fecha.getTime()));
//            credito.setIduser(dvrUser.getUserById(idCejero).getId());
//            //credito.setUsuario(dvrUser.getUserById(idCejero).getFisrtname());
//            //credito.setUsuarioNombre(dvrUser.getUserById(idCejero).getLastname());
//            resul = dvrcredito2.userCreditoRegister(credito, intIdCliente, intTipoDeudor, modo);
//            if (resul != 0) {
//                Util.addSuccessMessage("Datos insertados Exitosamente.");
//                cargar();
//
//            } else {
//                Util.addErrorMessage("Error en la Insercion.");
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(CProfile.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//       
//    }
//    
//    
//    public static String obtieneFecha(long fecha) {
//        Timestamp fechaFin = null;
//        try {
//            fechaFin = obtieneFechaTimeStamp(fecha);
//        } catch (Exception e) {
//        }
//        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
//        return formato.format(fechaFin.getTime());
//    }
//    
//    
//    
//
//    public void addgarante() throws Exception {
//
//        ClienteCredito crecli = new ClienteCredito(this.client.getId(), 0, this.tipodeudor.getId());
//        this.lstClienteCredito.add(crecli);
//
//    }
//
////    public void insertar() {
////
////        try {
////            for (Amortizacion amortizacion : listaAmt) {
////                dvrAmortizacion.userAmtRegister(amortizacion);
////            }
////            Util.addSuccessMessage("Datos insertados Exitosamente.");
////            DefaultRequestContext.getCurrentInstance().execute("wdlgAmortizacion.hide()");
////        } catch (Exception ex) {
////            Logger.getLogger(CCliente.class.getName()).log(Level.SEVERE, null, ex);
////        }
////    }
//    public void calcularFecha() {
//        try {
//
//            //long fechasAc = obtieneFecha(fecha) - obtieneFecha(fecha);
//            //fechaActua = obtieneFechaTimeStamp(fechasAc);
//        } catch (Exception e) {
//            //Util.addErrorMessage("Error en la Aplicacion.");
//        }
//    }
//
//    public void actualizar() {
//        try {
////            if (dvrTipodeudor.tipoUpdate(creditoSeleccion) == true) {
////                cargar();
////                DefaultRequestContext.getCurrentInstance().execute(
////                        "wdlgActualizar.hide()");
////                Util.addAlertMessage("Datos Actualizados exitosamente");
////            } else {
////                Util.addErrorMessage("El objeto no se puede Actualizar");
////            }
//        } catch (Exception e) {
//            //Util.addErrorMessage("Error en la Aplicacion.");
//        }
//    }
//
//    public void eliminar() {
//        try {
////            boolean result = false;
////            result = dvrTipodeudor.tipoDel(creditoSeleccion);
////            if (result == true) {
////                cargar();
////                DefaultRequestContext.getCurrentInstance().execute(
////                        "wdlgEliminar.hide()");
////                Util.addAlertMessage("Datos Eliminados exitosamente");
////            } else {
////                if (result == false) {
////                    Util.addErrorMessage("El objeto Tiene enlazado varios Items? NO se puede Eliminar.");
////                } else {
////                    Util.addErrorMessage("El objeto no se puede Eliminar");
////                }
////            }
//
//        } catch (Exception e) {
////            Util.addErrorMessage("Error en la Aplicacion.");
//        }
//    }
//
////    public void generarAmortizacion() {
////        try {
////
////            double tasap;
////            double valorcuota;
////            double interes;
////            int numcuotas = credito.getCrtplazo();
////            double amortizacion = 0;
////            double saldo = credito.getCrtmonto().doubleValue();
////            objAmortizacion.setAmzcuota(credito.getCrtplazo());
////            tasap = Math.pow((1 + 10), (1 / 12 - 1));
////            objAmortizacion.setCreditoid(resul);
////            for (int i = 1; i < numcuotas; i++) {
////                valorcuota = (credito.getCrtmonto().doubleValue()) * (tasap / (1));
////                objAmortizacion.setAmzvalorc(BigDecimal.valueOf(getRedondear(valorcuota)));
////                interes = saldo * tasap;
////                objAmortizacion.setAmzinteres(BigDecimal.valueOf(getRedondear(interes)));
////                amortizacion = valorcuota * interes * 0.15;
////                objAmortizacion.setAmortizacion(BigDecimal.valueOf(getRedondear(amortizacion)));
////                saldo = saldo - amortizacion;
////                objAmortizacion.setAmortizacion(BigDecimal.valueOf(getRedondear(saldo)));
////                objAmortizacion.setAmzfecha(obtieneFechaTimeStamp(fecha.getTime()));
////                listaAmt.add(objAmortizacion);
////            }
////            insertar();
////            DefaultRequestContext.getCurrentInstance().execute("wdlgAmortizacion.show()");
////        } catch (Exception e) {
////        }
////    }
//    //<editor-fold defaultstate="collapsed" desc="Set y Get">
//    private static double getRedondear(double numero) {
//        return Math.rint(numero * 10000) / 10000;
//    }
//
//    
//
//    public static String obtieneMesAnioLetras(long lngfecha) {
//        String fecha = obtieneFecha(lngfecha);
//        String Mes[] = {"ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"};
//        String[] vectorFecha = fecha.split("-");
//        int mes = Integer.parseInt(vectorFecha[1]);
//        String anio = vectorFecha[2];
//        String strFechaRetorno = Mes[mes - 1] + " " + anio;
//        return strFechaRetorno;
//    }
//
//    public static java.sql.Timestamp obtieneFechaTimeStamp(long fecha) throws ParseException {
//        java.sql.Timestamp timeStampDate = new Timestamp(fecha * 1000);
////          java.sql.Timestamp timeStampDate = new Timestamp(fecha);
//        return timeStampDate;
//    }
//
//    public static java.sql.Time ObtieneHoraDadoString(String hora) {
//        long lnMilisegundos = 0;
//        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
//        try {
//            java.util.Date date = sdf.parse(hora);
//            lnMilisegundos = date.getTime();
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        java.sql.Time sqlTime = new java.sql.Time(lnMilisegundos);
//        return sqlTime;
//    }
//
//}
