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

// TODO: Auto-generated Javadoc
/**
 * The Class ServletForCoefficients.
 */
@WebServlet(name="ServletForCoefficients", urlPatterns="/CoefficientsServlet") 
public class ServletForCoefficients extends HttpServlet{

	/**
	 * Do post.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
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

	
	/**
	 * The Class RequestCalc.
	 */
	public static class RequestCalc {
		
		/** The pension tax. */
		private double pensionTax;
		
		/** The medical tax. */
		private double medicalTax;
		
		/** The social tax. */
		private double socialTax;
		
		/** The income tax. */
		private double incomeTax;
		
		/** The injury tax. */
		private double injuryTax;
		
		/** The income tax non resident. */
		private double incomeTaxNonResident;
		
		/**
		 * Instantiates a new request calc.
		 *
		 * @param pensionTax the pension tax
		 * @param medicalTax the medical tax
		 * @param socialTax the social tax
		 * @param incomeTax the income tax
		 * @param incomeTaxNonResident the income tax non resident
		 * @param injuryTax the injury tax
		 * @throws ServletException the servlet exception
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		private RequestCalc (String pensionTax, String medicalTax, String socialTax, 
				String incomeTax, String incomeTaxNonResident, String injuryTax) throws ServletException, IOException {
			this.pensionTax = Double.parseDouble(pensionTax);
			this.medicalTax = Double.parseDouble(medicalTax);
			this.socialTax = Double.parseDouble(socialTax);
			this.incomeTax = Double.parseDouble(incomeTax);
			this.injuryTax = Double.parseDouble(injuryTax);
			this.incomeTaxNonResident = Double.parseDouble(incomeTaxNonResident);
			}
		
		/**
		 * From request parameters.
		 *
		 * @param request the request
		 * @param response the response
		 * @return the request calc
		 * @throws ServletException the servlet exception
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
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
		
		/**
		 * Gets the pension tax.
		 *
		 * @return the pension tax
		 */
		public String getPensionTax() {
			return Double.toString(pensionTax);	
		}
		
		/**
		 * Gets the medical tax.
		 *
		 * @return the medical tax
		 */
		public String getMedicalTax() {
			return Double.toString(medicalTax);	
		}
		
		/**
		 * Gets the social tax.
		 *
		 * @return the social tax
		 */
		public String getSocialTax() {
			return Double.toString(socialTax);	
		}
		
		/**
		 * Gets the income tax.
		 *
		 * @return the income tax
		 */
		public String getIncomeTax() {
			return Double.toString(incomeTax);	
		}
		
		/**
		 * Gets the income tax non resident.
		 *
		 * @return the income tax non resident
		 */
		public String getIncomeTaxNonResident() {
			return Double.toString(incomeTaxNonResident);	
		}
		
		/**
		 * Gets the injury tax.
		 *
		 * @return the injury tax
		 */
		public String getInjuryTax() {
			return Double.toString(injuryTax);
		}
	}
}