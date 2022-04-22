package rgr.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rgr.calculations.ControlClass;

@WebServlet(name="ServletForMainPage", urlPatterns="/MainServlet") 
public class ServletForMainPage extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestCalc Calc = RequestCalc.fromRequestParameters(request);
		try {
			Calc.setAsRequestAttributesAndCalculate(request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		request.getRequestDispatcher("/Results.jsp").forward(request, response);
		
	}
	
	public static class RequestCalc {
		private static String surname;
		private static String name;
		private static String patronumic;
		private static String tariffRate;
		private static String workTime;
		private static boolean isResident;
		private  double salary;
		private double incomeTax;
		private double pensionTax;
		private double medicalTax;
		private double socialTax;
		private double injuryTax;
						
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
		
		public static RequestCalc fromRequestParameters(HttpServletRequest request) {
			return new RequestCalc(
			request.getParameter("surname"),
			request.getParameter("name"), 
			request.getParameter("patronumic"), 
			request.getParameter("tariff-rate"),
			request.getParameter("work-time"),
			request.getParameter("isResident"));
			}
				
		public void setAsRequestAttributesAndCalculate(HttpServletRequest request) throws Exception {
			setValues();
			request.setAttribute("salary", salary);
			request.setAttribute("incomeTax", incomeTax);
			request.setAttribute("pensionTax", pensionTax);
			request.setAttribute("medicalTax", medicalTax);
			request.setAttribute("socialTax", socialTax);
			request.setAttribute("injuryTax", injuryTax);
		}
		
		public static String getSurname(){
			return surname;
			
		}
		
		public static String getName(){
			return name;
		}
		
		public static String getPatronumic(){
			return patronumic;
			
		}
		
		public static String getTariffRate(){
			return tariffRate;
			
		}
		
		public static String getWorkTime(){
			return workTime;
			
		}
		
		public static boolean getIsResident(){
			return isResident;
			
		}
		
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
