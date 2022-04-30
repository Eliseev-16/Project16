package rgr.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rgr.DataSource;
import rgr.calculations.ControlClass;

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
		RequestCalc Calc = RequestCalc.fromRequestParameters(request);
		try {
			Calc.setAsRequestAttributesAndCalculate(request);
		} catch (Exception e) {
			 System.out.println("Ошибка");
		}
		 
		request.getRequestDispatcher("/Calculation.jsp").forward(request, response);
		
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
		
		/** The salary. */
		private  double salary;
		
		/** The income tax. */
		private double incomeTax;
		
		/** The pension tax. */
		private double pensionTax;
		
		/** The medical tax. */
		private double medicalTax;
		
		/** The social tax. */
		private double socialTax;
		
		/** The injury tax. */
		private double injuryTax;
						
		/**
		 * Instantiates a new request calc.
		 *
		 * @param surname the surname
		 * @param name the name
		 * @param patronumic the patronumic
		 * @param tariffRate the tariff rate
		 * @param workTime the work time
		 * @param isResident the is resident
		 */
		private RequestCalc (String surname, String name, String patronumic, String tariffRate,
				String workTime, String isResident, String isDay) {
			this.surname = surname;
			this.name = name;
			this.patronumic = patronumic;
			this.tariffRate = Double.parseDouble(tariffRate);
			this.workTime = Double.parseDouble(workTime);
			 if (isResident.equals("Резидент")) {
		            this.isResident=true;
		        } else {
		            this.isResident=false;
		        }
			 
			 if (isDay.equals("Подневная")) {
		            this.isDay=true;
		        } else {
		            this.isDay=false;
		        }
			}
		
		/**
		 * From request parameters.
		 *
		 * @param request the request
		 * @return the request calc
		 */
		public static RequestCalc fromRequestParameters(HttpServletRequest request) {
			return new RequestCalc(
			request.getParameter("surname"),
			request.getParameter("name"), 
			request.getParameter("patronumic"), 
			request.getParameter("tariff-rate"),
			request.getParameter("work-time"),
			request.getParameter("isResident"),
			request.getParameter("isDay"));
			}
				
		/**
		 * Sets the as request attributes and calculate.
		 *
		 * @param request the new as request attributes and calculate
		 * @throws Exception the exception
		 */
		public void setAsRequestAttributesAndCalculate(HttpServletRequest request) throws Exception {
			callSetValue();
			ControlClass controlClass = new ControlClass(this);
			request.setAttribute("salary", String.format(".2f", controlClass.getSalary()));
			request.setAttribute("incomeTax", String.format(".2f", controlClass.getIncomeTax()));
			request.setAttribute("pensionTax", String.format(".2f", controlClass.getPensionTax()));
			request.setAttribute("medicalTax", String.format(".2f", controlClass.getMedicalTax()));
			request.setAttribute("socialTax", String.format(".2f", controlClass.getSocialTax()));
			request.setAttribute("injuryTax", String.format(".2f", controlClass.getInsurance()));
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
