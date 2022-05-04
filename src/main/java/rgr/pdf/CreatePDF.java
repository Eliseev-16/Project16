//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package rgr.pdf;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class CreatePDF {
    private BaseFont times = null;
    private String namefile;
    private String[] NameCellHat;
    private String[][] arrayCell;
    private Document document;
    private int Size;
    private int SizeCell;
    private PdfPTable table;
    private String filepath;


    public CreatePDF(String namefile, BaseFont BaseFontPDF) throws IOException {
        this.namefile = namefile;
        this.times = BaseFontPDF;
        this.document = new Document();

        URL basePathS = this.getClass ().getResource("");
        String basePath = basePathS.getPath();
        if (basePath.toLowerCase().contains("classes")) basePath = basePath.substring(0,basePath.indexOf("classes") + 7) + "/";

        filepath=basePath+namefile;


        try {
            PdfWriter.getInstance(document, new FileOutputStream(filepath));
        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        }

        this.document.open();
    }

    private void addRows(PdfPTable table, String[][] arrayCell) {
        int SizeTwo = arrayCell.length;
        int SizeOne = arrayCell[0].length;

        for(int j = 0; j < SizeTwo; ++j) {
            for(int i = 0; i < SizeOne; ++i) {
                table.addCell(new Phrase(arrayCell[j][i], new Font(this.times, 14.0F)));
            }
        }

    }

    private void setHeader(PdfPTable table, String[] NameCellHat) {
        for(int i = 0; i < NameCellHat.length; ++i) {
            PdfPCell header = new PdfPCell();
            header.setBackgroundColor(BaseColor.LIGHT_GRAY);
            header.setBorderWidth(2.0F);
            header.setPhrase(new Phrase(NameCellHat[i], new Font(this.times, 14.0F)));
            table.addCell(header);
        }

    }

    public Document getDocument() {
        return this.document;
    }

    public void getClose() {
        this.document.close();
    }

    public String getFilePath(){
        return filepath;
    }

    public void addPicture(URL url, Document document, int position1, int position2) {
        Image img = null;

        try {
            img = Image.getInstance(url.toString());
        } catch (BadElementException var8) {
            var8.printStackTrace();
        } catch (MalformedURLException var9) {
            var9.printStackTrace();
        } catch (IOException var10) {
            var10.printStackTrace();
        }

        img.setAbsolutePosition((float)position1, (float)position2);

        try {
            document.add(img);
        } catch (DocumentException var7) {
            var7.printStackTrace();
        }

    }

    public void addText(Document document, String Text, int SizeFont, boolean Space) {
        Paragraph paragraph = new Paragraph();
        Paragraph paragraphadd = new Paragraph(Text, new Font(this.times, (float)SizeFont));
        paragraphadd.setAlignment(3);
        paragraph.add(paragraphadd);

        try {
            document.add(paragraph);
        } catch (DocumentException var10) {
            var10.printStackTrace();
        }

        paragraph.clear();
        if (Space) {
            String string_pdf3 = " ";
            paragraph.add(new Paragraph(string_pdf3, new Font(this.times, 14.0F)));

            try {
                document.add(paragraph);
            } catch (DocumentException var9) {
                var9.printStackTrace();
            }
        }

        paragraph = null;
    }

    public void InitTableAndAddHat(Document document, String[] NameCellHat) {
        this.table = new PdfPTable(NameCellHat.length);
        this.setHeader(this.table, NameCellHat);
    }

    public PdfPTable getTable() {
        return this.table;
    }

    public void addRowsInTable(PdfPTable Table, String[][] arrayCell) {
        this.addRows(Table, arrayCell);
    }

    public void addTable(Document document, PdfPTable Table) {
        try {
            document.add(Table);
        } catch (DocumentException var4) {
            var4.printStackTrace();
        }

    }
}
