package pdftest;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.VerticalText;
import java.io.FileOutputStream;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.ColumnText;
import java.io.IOException;

public class PdfTest
{

    public static void main(String[] args)
    {
        createPdf("archi.pdf");
    }
    public static void createPdf(String filename)
    {
        int hojaInicialX = 94;
        int hojaFinalX = 590 - hojaInicialX;
        int hojaInicialY = 840 - 82;
        int hojaFinalY =  82;
        try
        {
            // step 1
        Document document = new Document();
        // step 2
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filename));
        // step 3
        document.open();
        
        //DIBUJANDO RECT:
        int px = hojaInicialX;
        int py = hojaInicialY;
        int sx = hojaFinalX;
        int sy = hojaFinalY;
        PdfContentByte canvas = writer.getDirectContent();
        
        Rectangle hoja = new Rectangle(px, py, sx, sy);
            hoja.setBackgroundColor(BaseColor.LIGHT_GRAY);
            hoja.setBorder(Rectangle.BOX);
            hoja.setBorderWidth(1);
            canvas.rectangle(hoja);
        
        for(int i = 0 ; i < 1; i++)
        {
            Rectangle hAux = new Rectangle((hojaInicialX + 0),(hojaInicialY -  0),(hojaFinalX + 0),(hojaInicialY / 4));
            hAux.setBorder(Rectangle.BOX);
            hAux.setBackgroundColor(BaseColor.GREEN);
            hAux.setBorderWidth(1);
            canvas.rectangle(hAux);
        }
        
        
        /*Rectangle r2 = new Rectangle((hojaInicialX + 17),(hojaInicialY - 17),(hojaInicialX + 52),(hojaInicialY - 150));
        r2.setBackgroundColor(BaseColor.GREEN);
        canvas.rectangle(r2);
        
        
        Rectangle r3 = new Rectangle((hojaFinalX - 17),(hojaInicialY - 17),(hojaFinalX - 52),(hojaInicialY - 150));
        r3.setBackgroundColor(BaseColor.GREEN);
        canvas.rectangle(r3);

        
        Paragraph p1 = new Paragraph("Holaa");
        ColumnText ct = new ColumnText(writer.getDirectContent());
        ct.setSimpleColumn(r2);
        ct.addElement(p1);
        ct.go(); */
        
        
        // step 4
        //document.add(new Paragraph("Hola Pandrusca!"));
        // step 5
        document.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }

    
}
