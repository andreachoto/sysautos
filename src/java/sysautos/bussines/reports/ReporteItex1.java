/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.reports;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

/**
 *
 * @author Joffre Vargas
 */
public class ReporteItex1 {

    final String IMAGE_FOLDER = "imagenes";

    public void preProcessPDF(Object document, Paragraph paragrap, Phrase phrase, PdfPTable dt,
            String fecha, String cliente, String numfac, String modopago) throws IOException, BadElementException, DocumentException {
        final Document pdf = (Document) document;
        pdf.setPageSize(PageSize.A4.rotate());
        HeaderFooter footer = new HeaderFooter(new Phrase("P�gina "), true);
        HeaderFooter head = new HeaderFooter(new Phrase("DETALLE VENTA \n\n"
                + "Fecha: " + fecha + "\n"
                + "Cliente: " + cliente + "  Nro Factura" + numfac + "\n"
                + "Forma de pago: " + modopago + "\n"
                + "\n\n"), false);
        head.setAlignment(0);

        pdf.setHeader(head);
        pdf.setFooter(footer);
        // pdf.newPage();
        pdf.open();
        float[] colsWidth = {30f, 100f, 30f};
        PdfPTable pdfTable = new PdfPTable(colsWidth);
//        PdfPCell celda = new PdfPCell(getImage("espochs.jpg"));
        PdfPCell celda1 = new PdfPCell(paragrap);
//        PdfPCell celda2 = new PdfPCell(getImage("fcp.png"));
//        celda.setBorder(0);
        celda1.setBorder(0);
//        celda2.setBorder(0);
//        celda.setHorizontalAlignment(Cell.ALIGN_LEFT);
        celda1.setHorizontalAlignment(Cell.ALIGN_CENTER);
//        celda2.setHorizontalAlignment(Cell.ALIGN_RIGHT);
//        pdfTable.addCell(celda);
        pdfTable.addCell(celda1);
//        pdfTable.addCell(celda2);
        pdf.add(pdfTable);
        pdf.add(phrase);
        //Tabla 2 Parametro
        if (dt != null) {
            pdf.add(dt);
        }
    }

    private Image getImage(String imageName) throws IOException, BadElementException {
        final Image image = Image.getInstance(getAbsolutePath(imageName));
        image.scalePercent(20f);
        return image;
    }

    private String getAbsolutePath(String imageName) {
        final ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        final StringBuilder logo = new StringBuilder().append(servletContext.getRealPath(""));
        logo.append(File.separator).append(IMAGE_FOLDER);
        logo.append(File.separator).append(imageName);
        return logo.toString();
    }
}
