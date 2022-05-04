package rgr.pdf;

import java.io.IOException;
import java.net.URL;

import javax.swing.JOptionPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;

import rgr.calculations.ControlClass;
// TODO: Auto-generated Javadoc
//import rgr.servlets.ServletForMainPage.controlClass;

/**
 * The Class CreateDocument.
 */
public  class CreateDocument {

	/** The pdf. */
	private CreatePDF pdf;


	/**
	 * Instantiates a new creates the document.
	 *
	 * @param controlClass the control class
	 * @param surname the surname
	 * @param name the name
	 * @param patronumic the patronumic
	 * @param tariffRate the tariff rate
	 * @param workTime the work time
	 */
	public CreateDocument(ControlClass controlClass, String surname, String name, 
			String patronumic, double tariffRate, double workTime) {
		createDocument(controlClass, surname, name, 
			 patronumic, tariffRate, workTime);
	}


	/**
	 * Creates the document.
	 *
	 * @param controlClass the control class
	 * @param surname the surname
	 * @param name the name
	 * @param patronumic the patronumic
	 * @param tariffRate the tariff rate
	 * @param workTime the work time
	 */
	public void createDocument(ControlClass controlClass, String surname, String name, 
			String patronumic, double tariffRate, double workTime) {
		String[][] NameCell = new String[8][7];
		NameCell[0][0] = "Начислено";
		NameCell[0][1] = Double.toString(workTime);
		NameCell[0][2] = Double.toString(workTime);
		NameCell[0][3] = Double.toString(ControlClass.getFullSalary());
		NameCell[0][4] = "Удержано";
		NameCell[0][5] = Double.toString(workTime);
		NameCell[0][6] = Double.toString(ControlClass.getAmountOfTaxes());
		NameCell[1][4] = "НДФЛ";
		NameCell[1][5] = Double.toString(workTime);
		NameCell[1][6] = Double.toString(controlClass.getIncomeTax());
		NameCell[2][4] = "Отчисления в пенсионный фонд";
		NameCell[2][5] = Double.toString(workTime);
		NameCell[2][6] = Double.toString(controlClass.getPensionTax());
		NameCell[3][4] = "Отчисления в медицинский фонд";
		NameCell[3][5] = Double.toString(workTime);
		NameCell[3][6] = Double.toString(controlClass.getMedicalTax());
		NameCell[4][4] = "Отчисления в социальный фонд";
		NameCell[4][5] = Double.toString(workTime);
		NameCell[4][6] = Double.toString(controlClass.getSocialTax());
		NameCell[5][4] = "Отчисления в страховой фонд";
		NameCell[5][5] = Double.toString(workTime);
    	NameCell[5][6] = Double.toString(controlClass.getInsurance());
		NameCell[6][4] = "Выплачено";
		NameCell[6][5] = Double.toString(workTime);
		NameCell[6][6] = Double.toString(controlClass.getSalary());


     	String[] Head = new String[7];
		Head[0] = "Вид";
		Head[1] = "Период (Дни/Часы)";
    	Head[2] = "Оплачено (Дни/Часы)";
	    Head[3] = "Сумма";
		Head[4] = "Вид";
		Head[5] = "Период (Дни/Часы)";
		Head[6] = "Сумма";

		String Texthat = "                                    Расчётный лист";
		String TextPerson;
		
			TextPerson = surname + " " + name
			+ " " + patronumic;
		
		String Textgeneral = "К выплате:     " + Double.toString(controlClass.getSalary());
		String TextNext = "Тарифная ставка:     " + tariffRate;
		String Namefile = "Расчетный_лист.pdf";
		BaseFont times = null;
		try {
			times = BaseFont.createFont("/fonts/times.ttf", "cp1251", BaseFont.EMBEDDED);
		} catch (DocumentException e2) {
			e2.printStackTrace();
		} catch (IOException e2) {
		e2.printStackTrace();
	}

		CreatePDF pdf = null;
		try {
			pdf = new CreatePDF(Namefile,times);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Document document = pdf.getDocument();
	 	pdf.addText(document, Texthat, 20,true);
		pdf.addText(document, TextPerson, 18, true);
		pdf.addText(document, Textgeneral, 16,true);
		pdf.addText(document, TextNext, 14,true);
		pdf.InitTableAndAddHat(document,Head);
		pdf.addRowsInTable(pdf.getTable(), NameCell);
	pdf.addTable(document,pdf.getTable());
	pdf.getClose();
		//JOptionPane.showMessageDialog(null, "Файл " + Namefile + " создан","Create PDF", JOptionPane.PLAIN_MESSAGE);
		this.pdf = pdf;
}

	/**
	 * Gets the file path.
	 *
	 * @return the file path
	 */
	public String getFilePath(){
		return pdf.getFilePath();
	}

}
