package rgr.servlets;

import java.io.IOException;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rgr.DataSource;
import rgr.calculations.ControlClass;
import rgr.pdf.CreateDocument;

// TODO: Auto-generated Javadoc
/**
 * The Class ServletForMainPage.
 */
@WebServlet(name="ServletForMainPage", urlPatterns="/MainServlet") 
public class ServletForMainPage extends HttpServlet{
	
	/**
	 * Do post.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestCalc Calc;
		try {
			Calc = RequestCalc.fromRequestParameters(request);
			Calc.setAsRequestAttributesAndCalculate(request);
			request.getRequestDispatcher("/Calculations.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("errorText", e.getMessage() );
	    	request.getRequestDispatcher("Error.jsp").forward(request, response);
		}
		
	}
	
	/**
	 * The Class RequestCalc.
	 */
	public static class RequestCalc extends DataSource{
		
		/** The surname. */
		private static String surname;
		
		/** The name. */
		private static String name;
		
		/** The patronumic. */
		private static String patronumic;
		
		/** The tariff rate. */
		private static double tariffRate;
		
		/** The work time. */
		private static double workTime;
		
		/** The is resident. */
		private static boolean isResident, isDay;
		
		private static String isResidentString, isDayString;
		
		/**
		 * Instantiates a new request calc.
		 *
		 * @param surname the surname
		 * @param name the name
		 * @param patronumic the patronumic
		 * @param tariffRate the tariff rate
		 * @param workTime the work time
		 * @param isResident the is resident
		 * @throws Exception 
		 */
		private RequestCalc (String surname, String name, String patronumic, String tariffRate,
				String workTime, String isResident, String isDay) throws Exception {
			this.surname = surname;
			this.name = name;
			this.patronumic = patronumic;
			this.tariffRate = Double.parseDouble(tariffRate);
			this.workTime = Double.parseDouble(workTime);
			 if (isResident.equals("Резидент")) {
		            this.isResident=true;
		            isResidentString = "Резидент";
		        } else {
		            this.isResident=false;
		            isResidentString = "Нерезидент";
		        }
			 
			 if (isDay.equals("Подневная")) {
		            this.isDay=true;
		            isDayString = "Подневная";
		        } else {
		            this.isDay=false;
		            isDayString = "Почасовая";
		        }
			 checkExeption();
			}
		
		/**
		 * From request parameters.
		 *
		 * @param request the request
		 * @return the request calc
		 * @throws Exception 
		 */
		public static RequestCalc fromRequestParameters(HttpServletRequest request) throws Exception {
			return new RequestCalc(
			request.getParameter("surname"),
			request.getParameter("name"), 
			request.getParameter("patronumic"), 
			request.getParameter("tariffRate"),
			request.getParameter("workTime"),
			request.getParameter("resident"),
			request.getParameter("period"));
		}
				
		/**
		 * Sets the as request attributes and calculate.
		 *
		 * @param request the new as request attributes and calculate
		 * @throws Exception the exception
		 */
		public void setAsRequestAttributesAndCalculate(HttpServletRequest request) throws Exception {
			String del = "#0.00";
			callSetValue();
			try {
			ControlClass controlClass = new ControlClass(this);
			request.setAttribute("salary", new DecimalFormat(del).format(controlClass.getSalary()));
			request.setAttribute("incomeTax", new DecimalFormat(del).format(controlClass.getIncomeTax()));
			request.setAttribute("pensionTax", new DecimalFormat(del).format(controlClass.getPensionTax()));
			request.setAttribute("medicalTax", new DecimalFormat(del).format(controlClass.getMedicalTax()));
			request.setAttribute("socialTax", new DecimalFormat(del).format(controlClass.getSocialTax()));
			request.setAttribute("injuryTax", new DecimalFormat(del).format(controlClass.getInsurance()));
			request.setAttribute("surname", surname);
			request.setAttribute("name", name);
			request.setAttribute("patronumic", patronumic);
			request.setAttribute("isDay", isDayString);
			request.setAttribute("isResident", isResidentString);
			request.setAttribute("tariffRate", tariffRate);
			request.setAttribute("workTime", workTime);
			//CreateDocument createDocument = new CreateDocument(this);
		}
			catch(Exception e) {
				throw new Exception("В расчётах не так");
			}
		}
		
		@Override
		public void callSetValue() {
			 setValues(surname, name, patronumic, tariffRate, workTime, isResident, isDay );
			
		}

		@Override
		public void checkExeption() throws Exception {
			if(workTime * tariffRate <= 0 || workTime <= 0 || tariffRate <= 0) {
				throw new Exception("Ошибка в введенных данных");
			}
			
		}
	}
}
