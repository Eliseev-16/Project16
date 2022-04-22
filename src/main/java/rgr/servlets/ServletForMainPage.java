package rgr.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletForMainPage extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestCalc Calc = RequestCalc.fromRequestParameters(request);
		Calc.setAsRequestAttributesAndCalculate(request);
		 
		request.getRequestDispatcher("/Results.jsp").forward(request, response);
		
	}
	
	private static class RequestCalc {
		private final String surname;
		private final String name;
		private final String patronumic;
		private final String tariffRate;
		private final String workTime;
		private final String isResident;
		private double salary;
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
			this.isResident = isResident;
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
				
		public void setAsRequestAttributesAndCalculate(HttpServletRequest request) {
			request.setAttribute("salary", salary);
			request.setAttribute("incomeTax", incomeTax);
			request.setAttribute("pensionTax", pensionTax);
			request.setAttribute("medicalTax", medicalTax);
			request.setAttribute("socialTax", socialTax);
			request.setAttribute("injuryTax", injuryTax);
		}
	}
}
