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
		RequestCalc Calc = RequestCalc.fromRequestParameters(request, response);
		login = Calc.getLogin();
		password = Calc.getPassword();
		registration(request, response);
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
public void registration(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		SQLAdder.addUser(login, password, "1");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		request.setAttribute("errorText", e.getMessage());
    	request.getRequestDispatcher("/Error.jsp").forward(request, response);
	}
}
}
