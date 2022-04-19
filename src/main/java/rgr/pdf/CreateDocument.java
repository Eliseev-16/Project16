package rgr.pdf;

import java.io.IOException;
import java.net.URL;

import javax.swing.JOptionPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;

import create.CreatePDF;
import rgr.gui.MainGUI;

// TODO: Auto-generated Javadoc
/**
 * The Class CreateDocument.
 */
public final class CreateDocument {

	/**
	 * Instantiates a new creates the document.
	 *
	 * @param frame the frame
	 */
	public CreateDocument(MainGUI frame) {
		createDocument(frame);
	}

	/**
	 * Creates the document.
	 *
	 * @param frame the frame
	 */
	public void createDocument(MainGUI frame) {
		String[][] NameCell = new String[2][7];
		NameCell[0][0] = "Сумма";
		NameCell[0][1] = Double.toString(frame.getInsurance());
		NameCell[0][2] = Double.toString(frame.getMedicalTax());
		NameCell[0][3] = Double.toString(frame.getSocialTax());
		NameCell[0][4] = Double.toString(frame.getPensionTax());
		NameCell[0][5] = Double.toString(frame.getIncomeTax());
		NameCell[0][6] = Double.toString(frame.getSalary());

		String[] Head = new String[7];
		Head[0] = "";
		Head[1] = "Травматизм";
		Head[2] = "Медицинское";
		Head[3] = "Социальное";
		Head[4] = "Пенсионное";
		Head[5] = "НДФЛ";
		Head[6] = "Итоговая зарплата";

		String Texthat = "                                    Документ вашей зарплаты.";
		String Textgeneral = "Мы посчитали какие налоги вы будете платить с вашей зарплаты, "
				+ "определили сумму каждого из них и узнали вашу итоговую зарплату";
		String TextTable = "                 Таблица 1. Данные о налогах и зарплаты";
		String TextNext = "В этой таблице приведены названия налогов, сумма каждого из них и итоговая заработная плата " +
				"после вычета налогов.";
		String TextPicture = "           Рисунок 1 - QR код НК РФ";
		URL Imagelink=getClass().getResource("/picture/QROfTax.png");
		String Namefile = "Зарплата.pdf";
		BaseFont times = null;
		try {
			times = BaseFont.createFont("/fonts/times.ttf", "cp1251", BaseFont.EMBEDDED);
		} catch (DocumentException e2) {
			e2.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}

		CreatePDF pdf = new CreatePDF(Namefile,times);
		Document document = pdf.getDocument();
		pdf.addText(document, Texthat, 20,true);
		pdf.addText(document, Textgeneral, 14,true);
		pdf.addText(document, TextTable, 14, true);
		pdf.InitTableAndAddHat(document,Head);
		pdf.addRowsInTable(pdf.getTable(), NameCell);
		pdf.addTable(document,pdf.getTable());
		pdf.addText(document, TextNext, 14,true);
		pdf.addPicture(Imagelink, document, 80, 250);
		pdf.addText(document, "", 14,true);
		pdf.addText(document, "", 14,true);
		pdf.addText(document, "", 14,true);
		pdf.addText(document, "", 14,true);
		pdf.addText(document, "", 14,true);
		pdf.addText(document, "", 14,true);
		pdf.addText(document, "", 14,true);
		pdf.addText(document, "", 14,true);
		pdf.addText(document, TextPicture, 14,true);
		pdf.getClose();

		//вывод окна с сообщением о создании файла
		JOptionPane.showMessageDialog(null, "Файл " + Namefile + " создан","Create PDF", JOptionPane.PLAIN_MESSAGE);
	}

}
