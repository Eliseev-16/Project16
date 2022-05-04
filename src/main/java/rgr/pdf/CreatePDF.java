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

// TODO: Auto-generated Javadoc
/**
 * The Class CreatePDF.
 */
public class CreatePDF {
    
    /** The times. */
    private BaseFont times = null;
    
    /** The namefile. */
    private String namefile;
    
    /** The Name cell hat. */
    private String[] NameCellHat;
    
    /** The array cell. */
    private String[][] arrayCell;
    
    /** The document. */
    private Document document;
    
    /** The Size. */
    private int Size;
    
    /** The Size cell. */
    private int SizeCell;
    
    /** The table. */
    private PdfPTable table;
    
    /** The filepath. */
    private String filepath;


    /**
     * Instantiates a new creates the PDF.
     *
     * @param namefile the namefile
     * @param BaseFontPDF the base font PDF
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public CreatePDF(String namefile, BaseFont BaseFontPDF) throws IOException {
        this.namefile = namefile;
        this.times = BaseFontPDF;
        this.document = new Document();

        URL basePathS = this.getClass ().getResource("");
        String basePath = basePathS.getPath();
        if (basePath.toLowerCase().contains("web-inf")) basePath = basePath.substring(0,basePath.indexOf("WEB-INF"));

        filepath=basePath+namefile;


        try {
            PdfWriter.getInstance(document, new FileOutputStream(filepath));
        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        }

        this.document.open();
    }

    /**
     * Adds the rows.
     *
     * @param table the table
     * @param arrayCell the array cell
     */
    private void addRows(PdfPTable table, String[][] arrayCell) {
        int SizeTwo = arrayCell.length;
        int SizeOne = arrayCell[0].length;

        for(int j = 0; j < SizeTwo; ++j) {
            for(int i = 0; i < SizeOne; ++i) {
                table.addCell(new Phrase(arrayCell[j][i], new Font(this.times, 14.0F)));
            }
        }

    }

    /**
     * Sets the header.
     *
     * @param table the table
     * @param NameCellHat the name cell hat
     */
    private void setHeader(PdfPTable table, String[] NameCellHat) {
        for(int i = 0; i < NameCellHat.length; ++i) {
            PdfPCell header = new PdfPCell();
            header.setBackgroundColor(BaseColor.LIGHT_GRAY);
            header.setBorderWidth(2.0F);
            header.setPhrase(new Phrase(NameCellHat[i], new Font(this.times, 14.0F)));
            table.addCell(header);
        }

    }

    /**
     * Gets the document.
     *
     * @return the document
     */
    public Document getDocument() {
        return this.document;
    }

    /**
     * Gets the close.
     *
     * @return the close
     */
    public void getClose() {
        this.document.close();
    }

    /**
     * Gets the file path.
     *
     * @return the file path
     */
    public String getFilePath(){
        return filepath;
    }

    /**
     * Adds the picture.
     *
     * @param url the url
     * @param document the document
     * @param position1 the position 1
     * @param position2 the position 2
     */
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

    /**
     * Adds the text.
     *
     * @param document the document
     * @param Text the text
     * @param SizeFont the size font
     * @param Space the space
     */
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

    /**
     * Inits the table and add hat.
     *
     * @param document the document
     * @param NameCellHat the name cell hat
     */
    public void InitTableAndAddHat(Document document, String[] NameCellHat) {
        this.table = new PdfPTable(NameCellHat.length);
        this.setHeader(this.table, NameCellHat);
    }

    /**
     * Gets the table.
     *
     * @return the table
     */
    public PdfPTable getTable() {
        return this.table;
    }

    /**
     * Adds the rows in table.
     *
     * @param Table the table
     * @param arrayCell the array cell
     */
    public void addRowsInTable(PdfPTable Table, String[][] arrayCell) {
        this.addRows(Table, arrayCell);
    }

    /**
     * Adds the table.
     *
     * @param document the document
     * @param Table the table
     */
    public void addTable(Document document, PdfPTable Table) {
        try {
            document.add(Table);
        } catch (DocumentException var4) {
            var4.printStackTrace();
        }

    }
}
