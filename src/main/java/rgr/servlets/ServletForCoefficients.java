package rgr.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rgr.servlets.ServletForCoefficients.RequestCalc;
import rgr.sqlManager.SQLAdder;
import rgr.sqlManager.SQLReader;

@WebServlet(name="ServletForCoefficients", urlPatterns="/CoefficientsServlet") 
public class ServletForCoefficients extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		RequestCalc Calc = RequestCalc.fromRequestParameters(request, response);
		SQLAdder.addCoefficients(Calc.getIncomeTax(), Calc.getIncomeTaxNonResident(),
				Calc.getPensionTax(), Calc.getMedicalTax(), Calc.getSocialTax(), Calc.getInjuryTax());
		request.setAttribute("errorMsg", "Коэффициенты добавлены в базу");
    	request.getRequestDispatcher("/Admin.jsp").forward(request, response);
		}
		catch(Exception e) {
			request.setAttribute("errorMsg", e.getMessage());
	    	request.getRequestDispatcher("/Admin.jsp").forward(request, response);
		}
	}

	
	public static class RequestCalc {
		
		private double pensionTax;
		private double medicalTax;
		private double socialTax;
		private double incomeTax;
		private double injuryTax;
		private double incomeTaxNonResident;
		
		private RequestCalc (String pensionTax, String medicalTax, String socialTax, 
				String incomeTax, String incomeTaxNonResident, String injuryTax) throws ServletException, IOException {
			this.pensionTax = Double.parseDouble(pensionTax);
			this.medicalTax = Double.parseDouble(medicalTax);
			this.socialTax = Double.parseDouble(socialTax);
			this.incomeTax = Double.parseDouble(incomeTax);
			this.injuryTax = Double.parseDouble(injuryTax);
			this.incomeTaxNonResident = Double.parseDouble(incomeTaxNonResident);
			}
		
		public static RequestCalc fromRequestParameters(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			return new RequestCalc(
			request.getParameter("pensionTax"),
			request.getParameter("medicalTax"),
			request.getParameter("socialTax"),
			request.getParameter("incomeTax"),
			request.getParameter("incomeTaxNonResident"),
			request.getParameter("injuryTax")
			);
			}
		public String getPensionTax() {
			return Double.toString(pensionTax);	
		}
		
		public String getMedicalTax() {
			return Double.toString(medicalTax);	
		}
		
		public String getSocialTax() {
			return Double.toString(socialTax);	
		}
		
		public String getIncomeTax() {
			return Double.toString(incomeTax);	
		}
		
		public String getIncomeTaxNonResident() {
			return Double.toString(incomeTaxNonResident);	
		}
		
		public String getInjuryTax() {
			return Double.toString(injuryTax);
		}
	}
}