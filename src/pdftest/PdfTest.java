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
import java.util.ArrayList;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfPage;
import com.itextpdf.text.pdf.PdfTemplate;
import modelo.Ticket;

public class PdfTest
{
    
    public static void main(String[] args)
    {
        ArrayList<Ticket> ticketList = new ArrayList<Ticket>();
        ticketList.add(new Ticket(15, 18));
        ticketList.add(new Ticket(11, 8));
        ticketList.add(new Ticket(10, 11));
        ticketList.add(new Ticket(5, 28));
        createPdf("archi.pdf",ticketList);
    }
    public static void createPdf(String filename,ArrayList<Ticket> ticketList)
    {
        ArrayList<Rectangle> rectangulosList = new ArrayList<Rectangle>();
        int hojaInicialX = 94;
        int hojaFinalX = 590 - hojaInicialX;
        int hojaFinalY = 840 - 82;
        int hojaInicialY =  82;
        try
        {
            // step 1
        Document document = new Document();
        // step 2
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filename));
        // step 3
        document.open();
        
        //DIBUJANDO RECT:
        int xhi = hojaInicialX;
        int yhi = hojaInicialY;
        int xhf = hojaFinalX;
        int yhf = hojaFinalY;
        int alturaHoja = yhf - yhi;
        int alturaHojaDiv4 = alturaHoja /4;
        PdfContentByte canvas = writer.getDirectContent();
        
        Rectangle hoja = new Rectangle(xhi, yhi, xhf, yhf);
            hoja.setBackgroundColor(BaseColor.LIGHT_GRAY);
            hoja.setBorder(Rectangle.BOX);
            hoja.setBorderWidth(1);
            canvas.rectangle(hoja);
            System.out.println("hoja (" + xhi +"," + yhi + "," + xhf + "," + yhf+ ") | altura: " +alturaHoja);
        
            //los 4 eventos:
            int quedoEn = yhi;
            int xri,yri,xrf,yrf;
            
        for(int i = 0 ; i < 4; i++)
        {
            xri = xhi;
            yri = quedoEn;
            xrf = xhf;
            yrf = yri + alturaHojaDiv4 ;
            quedoEn = yrf;
            Rectangle hAux = null;
            BaseColor color = null;
            if(i == 0 || i == 2)
            {
                color = BaseColor.GREEN;
            }
            else if(i == 1 || i == 3)
            {
                color = BaseColor.RED;
            }
            System.out.println("r"+ i + " = " + xri + "," + yri + "," + xrf + "," +yrf);
            
            hAux = new Rectangle(xri,yri,xrf,yrf);
            
            hAux.setBackgroundColor(color);
            hAux.setBorder(Rectangle.BOX);
            hAux.setBorderWidth(1);
            canvas.rectangle(hAux);
            
            //RECTANGULOS INTERIORES:
            int rixi = xri + 10;
            int rixf = xri + 30;
            int riyi = yri + 20;
            int riyf = yrf - 20;
            
            //RECTANGULO INTERIOR 1:
            Rectangle rInterior1 = new Rectangle(rixi,riyi,rixf,riyf);
            rInterior1.setBackgroundColor(BaseColor.WHITE);
            canvas.rectangle(rInterior1);
            
            ColumnText ct = new ColumnText(canvas);
            ct.setSimpleColumn(rInterior1);
            ct.addElement(new Paragraph("Fila " + ticketList.get(i).getNumeroFila()));
            ct.go();
            
            int ri2xi = xrf - 10;
            int ri2xf = xrf - 30;
            int ri2yi = yri + 20;
            int ri2yf = yrf - 20;
            
            //RECTANGULO INTERIOR 2:
            Rectangle rInterior2 = new Rectangle(ri2xi,ri2yi,ri2xf,ri2yf);
            rInterior2.setBackgroundColor(BaseColor.WHITE);
            canvas.rectangle(rInterior2);
            
            ColumnText ct2 = new ColumnText(canvas);
            ct2.setSimpleColumn(rInterior2);
            ct2.addElement(new Paragraph("Butaca " + ticketList.get(i).getNumeroButaca()));
            ct2.go();
            
            
            //template:
            int imgWidth = 50;
            int imgHeight = 50;
            PdfTemplate template = canvas.createTemplate(imgWidth, imgHeight);
            
           /* Rectangle r = new Rectangle(ri2xi,ri2yi,ri2xf,ri2yf);
            r.setBackgroundColor(BaseColor.YELLOW);
            canvas.rectangle(r);

            ColumnText ct2 = new ColumnText(template);
            ct.setSimpleColumn(0, 0, imgWidth, imgHeight);
            ct.addElement(new Paragraph("Butaca 16"));
            ct.go();
            
            
            
            Image textImg = Image.getInstance(template);
            
            //Asign the dimentions of the image, in this case, the text
            textImg.setInterpolation(true);
            textImg.scaleAbsolute(imgWidth, imgHeight);
            textImg.setRotationDegrees((float)180);
            textImg.setAbsolutePosition(0,0);

            //Add the text to the pdf
            document.add(textImg);*/
          
           
           //IMG:
          
            String nombreIMG = "img.jpg";
            Image image = Image.getInstance(nombreIMG);
            image.setRotation(10);
            //document.add(image);

            //
            // Rotate image in degree using the setRotationDegree method
            //
            //String url = "http://localhost/xampp/img/xampp-logo-new.gif";
            //image = Image.getInstance(url);
            //image.setRotationDegrees(90);
            //document.add(image);
        
        
        }
       
        
        /*Rectangle r2 = new Rectangle((hojaInicialX + 17),(hojaInicialY - 17),(hojaInicialX + 52),(hojaInicialY - 150));
        r2.setBackgroundColor(BaseColor.GREEN);
        canvas.rectangle(r2);
        
        
        Rectangle r3 = new Rectangle((hojaFinalX - 17),(hojaInicialY - 17),(hojaFinalX - 52),(hojaInicialY - 150));
        r3.setBackgroundColor(BaseColor.GREEN);
        canvas.rectangle(r3);

        */
        
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
