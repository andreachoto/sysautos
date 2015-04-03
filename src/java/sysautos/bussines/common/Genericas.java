/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.common;

//import com.toedter.calendar.JDateChooser;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class Genericas {

    //METODOS PARA MANEJAR CLASES, FORMULARIOS Y OBJETOS DE FORMULARIOS
    //Verifica si una ventana fue ya abierta.
//    public static boolean existeVentana(Class formulario, JDesktopPane contenidos) {
//        boolean respuesta = false;
//        for (Component component : contenidos.getComponents()) {
//            if (component.getClass().equals(formulario)) {
//                respuesta = true;
//                break;
//            }
//        }
//        return respuesta;
//    }

    //Centra un jinternalframe a la pantalla.
//    public static void centrarVentana(JInternalFrame formulario) {
//        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
//        Dimension ventana = formulario.getSize();
//        formulario.setLocation((pantalla.width - ventana.width) / 2, (pantalla.height - ventana.height) / 2);
//    }
//
//    //Centra un jinternalframe a la pantalla.
//    public static void centrarVentana(JFrame formulario) {
//        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
//        Dimension ventana = formulario.getSize();
//        formulario.setLocation((pantalla.width - ventana.width) / 2, (pantalla.height - ventana.height) / 2);
//    }
//
//    //Cargar un componente tipo combobox dado una lista
//    public static void cargarCombo(JComboBox combobox, List datos) {
//        DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
//        datos.stream().forEach((dato) -> {
//            modeloCombo.addElement(dato);
//        });
//        combobox.setModel(modeloCombo);
//    }

//    //Carga una lista mediante el modelo
//    public static void cargaLista(DefaultListModel Model, List lista, JList listado) {
//        //Model.clear();
//        lista.stream().forEach((elemento) -> {
//            Model.addElement(elemento);
//        });
//        listado.setModel(Model);
//    }

//////    // Metodo de habilitar/deshabilitar un container y sus hijos
//////    public static void setEnableContainer(Container c, boolean band) {
//////        Component[] components = c.getComponents();
//////        c.setEnabled(band);
//////        for (Component component : components) {
//////            component.setEnabled(band);
//////            if (component instanceof Container) {
//////                setEnableContainer((Container) component, band);
//////            }
//////        }
//////    }
//////
//////    // Metodo de habilitar/deshabilitar los componentes tipo texto de un container
//////    public static void setEnableContainerText(Container c, boolean band) {
//////        Component[] components = c.getComponents();
//////        for (Component component : components) {
//////            if (component instanceof JTextField) {
//////                component.setEnabled(band);
//////            } else if (component instanceof JPasswordField) {
//////                component.setEnabled(band);
//////            }
//////        }
//////    }
//////
//////    // Metodo de limpia cajas de texto de container de componentes tipo panel
//////    public static void clearInputText(Container c) {
//////        Component[] components = c.getComponents();
//////        for (Component component : components) {
//////            //Limpia todos los JTextField de un JPanel
//////            if (component instanceof JTextField) {
//////                ((JTextField) component).setText("");
//////            } else if (component instanceof JPasswordField) {
//////                ((JPasswordField) component).setText("");
//////            }
//////        }
//////    }
//////
//////    // Metodo de limpia cajas de texto de container de componentes con paneles interiores
//////    public static void clearContainerText(Container c) {
//////        Component[] components = c.getComponents();
//////        for (Component component : components) {
//////            //Envia un panel que contiene componentes
//////            if (component instanceof JPanel) {
//////                //Limpia todos los JTextField de un JPanel
//////                clearInputText((JPanel) component);
//////            }
//////        }
//////    }

//    //Toma la fecha de jdatechooser y transforma a un tipo date.
//    public static java.util.Date getdateSelected(JDateChooser jdcfecha) {
//        java.util.Date fec = jdcfecha.getDate();
//        java.util.Date fecha = new java.util.Date(fec.getTime());
//        return fecha;
//    }
//
//    //Toma la fecha de jdatechooser y transforma a un tipo Timestamp.
//    public static Timestamp getTimestampSelected(JDateChooser jdcfecha) {
//        java.util.Date fec = jdcfecha.getDate();
//        Timestamp fecha = new Timestamp(fec.getTime());
//        return fecha;
//    }

    //METODOS PARA MANEJAR CADENAS A FECHAS TIMESTAMP Y DATE 
    //Convertir una cadena a fecha
    public static java.util.Date convertStringtoDate(String fecha) {
        String[] datos = fecha.split("-");
        Calendar cal = Calendar.getInstance();
        int anio = Integer.parseInt(datos[0]);
        int mes = Integer.parseInt(datos[1]) - 1;
        int dia = Integer.parseInt(datos[2]);
        cal.set(anio, mes, dia);
        return new java.util.Date(cal.getTimeInMillis());
    }

    //Convertir una cadena formato '2014-10-12' a Timestamp
    public static Timestamp convertStringtoTimestamp(String fecha) {
        String[] datos = fecha.split("-");
        Calendar cal = Calendar.getInstance();
        int anio = Integer.parseInt(datos[0]);
        int mes = Integer.parseInt(datos[1]) - 1;
        int dia = Integer.parseInt(datos[2]);
        cal.set(anio, mes, dia);
        java.util.Date fec = new java.util.Date(cal.getTimeInMillis());
        Timestamp tsfec = new Timestamp(fec.getTime());
        return tsfec;
    }

    //Convertir una cadena formato "yyyy-MM-dd hh:mm:ss" a Timestamp
    public static Timestamp parseStrtoTimestamp(String str) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        java.util.Date parsedTimeStamp = (java.util.Date) dateFormat.parse(str);
        Timestamp timestamp = new Timestamp(parsedTimeStamp.getTime());
        return timestamp;
    }

    //Convertir tiemStamp a Cadena segun un formato
    public static String convertTimeStamptoStrFormat(Timestamp tsdate, String format) {
        String result = "";
        if (tsdate != null) {
            SimpleDateFormat formatter = new SimpleDateFormat(format);
            result = formatter.format((Date) tsdate);
        }
        return result;
    }

    //Convertir tiemStamp a Fecha tipo date
    public static Date convertTimeStamptoDate(Timestamp tsdate) {
        Date result = new Date();
        if (tsdate != null) {
            result = new Date(tsdate.getTime());
        }
        return result;
    }

    public static BigDecimal getDiffHourslab(String fecini, String fecfin) {
        BigDecimal result = null;
        try {
            Date dinicio = null, dfinal = null;
            long milis1, milis2, diff;
            long labhours = 0, resthour = 0;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            // PARSEO STRING A DATE
            dinicio = sdf.parse(fecini);
            dfinal = sdf.parse(fecfin);
            //INSTANCIA DEL CALENDARIO GREGORIANO
            Calendar cinicio = Calendar.getInstance();
            Calendar cfinal = Calendar.getInstance();

            //ESTABLECEMOS LA FECHA DEL CALENDARIO CON EL DATE GENERADO ANTERIORMENTE
            cinicio.setTime(dinicio);
            cfinal.setTime(dfinal);
            milis1 = cinicio.getTimeInMillis();
            milis2 = cfinal.getTimeInMillis();
            diff = milis2 - milis1;
            // calcular la diferencia en segundos
            long diffSegundos = Math.abs(diff / 1000);
            // calcular la diferencia en minutos
            long diffMinutos = Math.abs(diff / (60 * 1000));
            long restominutos = diffMinutos % 60;
            // calcular la diferencia en horas
            long diffHoras = (diff / (60 * 60 * 1000));
            // calcular la diferencia en dias
            long diffdias = Math.abs(diff / (24 * 60 * 60 * 1000));

            if (diffdias > 0) {
                labhours = (diffdias * 24) - (diffdias * 16);
                if ((diffHoras - (diffdias * 24)) > 8) {
                    resthour = 8;
                } else {
                    resthour = diffHoras - (diffdias * 24);
                }
            } else {
                if (diffHoras > 8) {
                    resthour = 8;
                }
            }
            labhours = labhours + resthour;
            result = BigDecimal.valueOf(labhours);
        } catch (ParseException ex) {
            Logger.getLogger(Genericas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public static BigDecimal getDiffHours(String fecini, String fecfin) {
        BigDecimal result = null;
        try {
            Date dinicio = null, dfinal = null;
            long milis1, milis2, diff;
            long dayhours = 0, resthour = 0;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            // PARSEO STRING A DATE
            dinicio = sdf.parse(fecini);
            dfinal = sdf.parse(fecfin);
            //INSTANCIA DEL CALENDARIO GREGORIANO
            Calendar cinicio = Calendar.getInstance();
            Calendar cfinal = Calendar.getInstance();

            //ESTABLECEMOS LA FECHA DEL CALENDARIO CON EL DATE GENERADO ANTERIORMENTE
            cinicio.setTime(dinicio);
            cfinal.setTime(dfinal);
            milis1 = cinicio.getTimeInMillis();
            milis2 = cfinal.getTimeInMillis();
            diff = milis2 - milis1;
            // calcular la diferencia en segundos
            long diffSegundos = Math.abs(diff / 1000);
            // calcular la diferencia en minutos
            long diffMinutos = Math.abs(diff / (60 * 1000));
            long restominutos = diffMinutos % 60;
            // calcular la diferencia en horas
            long diffHoras = (diff / (60 * 60 * 1000));
            // calcular la diferencia en dias
            long diffdias = Math.abs(diff / (24 * 60 * 60 * 1000));

            if (diffdias > 0) {
                dayhours = (diffdias * 24);
            } 
            dayhours = dayhours + diffHoras;
            result = BigDecimal.valueOf(dayhours);
        } catch (ParseException ex) {
            Logger.getLogger(Genericas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    //Convertir String a Decimal
    public static BigDecimal parseStrtoBigdecimal(String str) {
        return new BigDecimal(str);
    }

    //Extraer la extension de un path de archivo
    public static String getExtensionfile(String str) {
        String ext = "*";
        String path[] = str.split("\\.");
        if (path.length > 1) {
            ext = path[1];
        }
        return ext;
    }

}
