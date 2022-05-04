package rgr.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import create.CreatePDF;
import rgr.calculations.ControlClass;
import rgr.pdf.CreateDocument;
import rgr.servlets.ServletForMainPage.RequestCalc;

@WebServlet(name="ServletForDocument", urlPatterns="/Document") 
public class ServletForDocument extends HttpServlet{
	
	private RequestCalc requestCalc;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/pdf");
//		try {
//			Document document = new Document();
//			PdfWriter.getInstance(document, response.getOutputStream());
//			document.open();
//			document.add(new Paragraph("Helloy world"));
//			document.add(new Paragraph(new Date().toString()));
//			document.close();
//		}
//		catch(DocumentException de)
//		{
//			throw new IOException(de.getMessage());
//		}
    CreateDocument createDocument = new CreateDocument(requestCalc);
		
    request.getRequestDispatcher("/Calculations.jsp").forward(request, response);
	}
	
	public  void setValue(RequestCalc requestCalc) {
		this.requestCalc = requestCalc;
	}
}
