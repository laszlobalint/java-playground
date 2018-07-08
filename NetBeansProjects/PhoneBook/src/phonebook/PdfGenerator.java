package phonebook;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import static java.awt.SystemColor.text;
import java.io.FileOutputStream;

public class PdfGenerator {
    public void pdfGenerator(String fileName, String testText) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(fileName + ".pdf"));
            document.open();
            Image image1 = Image.getInstance(getClass().getResource("/logo.jpg"));
            image1.scaleToFit(200, 86);
            image1.setAbsolutePosition(200f, 750f);
            document.add(image1);
            document.add(new Paragraph("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" + text, FontFactory.getFont("Fonttype", BaseFont.IDENTITY_H, BaseFont.EMBEDDED)));
            Chunk signature = new Chunk("\n\n Generated using Phonebook applicaton.");
            Paragraph base = new Paragraph(signature);
            document.add(base);
        } catch (Exception e) {
            e.printStackTrace();
        }
        document.close();
    }
    
}
