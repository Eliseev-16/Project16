package rgr.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		request.getRequestDispatcher("/Calculation.jsp").forward(request, response);
		
	}
	
	/**
	 * The Class RequestCalc.
	 */
	public static class RequestCalc {
		
		/** The surname. */
		private static String surname;
		
		/** The name. */
		private static String name;
		
		/** The patronumic. */
		private static String patronumic;
		
		/** The tariff rate. */
		private static String tariffRate;
		
		/** The work time. */
		private static String workTime;
		
		/** The is resident. */
		private static boolean isResident;
		
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
				String workTime, String isResident) {
			this.surname = surname;
			this.name = name;
			this.patronumic = patronumic;
			this.tariffRate = tariffRate;
			this.workTime = workTime;
			 if (isResident.equals("Резидент")) {
		            this.isResident=true;
		        } else {
		            this.isResident=false;
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
			request.getParameter("isResident"));
			}
				
		/**
		 * Sets the as request attributes and calculate.
		 *
		 * @param request the new as request attributes and calculate
		 * @throws Exception the exception
		 */
		public void setAsRequestAttributesAndCalculate(HttpServletRequest request) throws Exception {
			setValues();
			request.setAttribute("salary", salary);
			request.setAttribute("incomeTax", incomeTax);
			request.setAttribute("pensionTax", pensionTax);
			request.setAttribute("medicalTax", medicalTax);
			request.setAttribute("socialTax", socialTax);
			request.setAttribute("injuryTax", injuryTax);
		}
		
		/**
		 * Gets the surname.
		 *
		 * @return the surname
		 */
		public static String getSurname(){
			return surname;
			
		}
		
		/**
		 * Gets the name.
		 *
		 * @return the name
		 */
		public static String getName(){
			return name;
		}
		
		/**
		 * Gets the patronumic.
		 *
		 * @return the patronumic
		 */
		public static String getPatronumic(){
			return patronumic;
			
		}
		
		/**
		 * Gets the tariff rate.
		 *
		 * @return the tariff rate
		 */
		public static String getTariffRate(){
			return tariffRate;
			
		}
		
		/**
		 * Gets the work time.
		 *
		 * @return the work time
		 */
		public static String getWorkTime(){
			return workTime;
			
		}
		
		/**
		 * Gets the checks if is resident.
		 *
		 * @return the checks if is resident
		 */
		public static boolean getIsResident(){
			return isResident;
			
		}
		
		/**
		 * Sets the values.
		 *
		 * @throws Exception the exception
		 */
		public void setValues () throws Exception {
			ControlClass calculate = new ControlClass();
			this.salary = calculate.getSalary();
			this.incomeTax = calculate.getIncomeTax();
			this.pensionTax = calculate.getPensionTax();
			this.medicalTax = calculate.getMedicalTax();
			this.socialTax = calculate.getSocialTax();
			this.injuryTax = calculate.getInsurance();
		}
	}
}
