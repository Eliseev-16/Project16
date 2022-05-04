package rgr.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rgr.servlets.ServletForAuthorization.RequestCalc;
import rgr.sqlManager.SQLAdder;

@WebServlet(name="ServletForRegistration", urlPatterns="/Registration") 
public class ServletForRegistration extends HttpServlet{
	
	private String login, password;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		RequestCalc Calc = RequestCalc.fromRequestParameters(request, response);
		login = Calc.getLogin();
		password = Calc.getPassword();
		registration(request, response);
		}
		catch(Exception e) {
			request.setAttribute("errorMsg", e.getMessage());
	    	request.getRequestDispatcher("/Registration.jsp").forward(request, response);
		}
		
	}
public static class RequestCalc {
		
		private String login;
		private String password;
		
		private RequestCalc (String login, String password) throws ServletException, IOException {
			this.login = login;
			this.password = password;
			}
		
		public String getLogin() {
			return login;
			
		}
		
		public String getPassword() {
			return password;
		}
		
		public static RequestCalc fromRequestParameters(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			return new RequestCalc(
			request.getParameter("log"),
			request.getParameter("password")
			);
			}
		
		}
public void registration(HttpServletRequest request, HttpServletResponse response) throws Exception {
		SQLAdder.addUser(login, password, "1");
		request.getRequestDispatcher("/Login.jsp").forward(request, response);
}
}
