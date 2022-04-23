package rgr.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rgr.servlets.ServletForMainPage.RequestCalc;

@WebServlet(name="ServletForMainPage", urlPatterns="/AuthorizationServlet") 
public class ServletForAuthorization extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestCalc Calc = RequestCalc.fromRequestParameters(request, response);
		
	}
	
	public static class RequestCalc {
		
		private String login;
		private String password;
		
		private RequestCalc (String login, String password, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			this.login = login;
			this.password = password;
			checkLogin(request, response);
			}
		
		public static RequestCalc fromRequestParameters(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			return new RequestCalc(
			request.getParameter("log"),
			request.getParameter("password"), 
			request, 
			response
			);
			}
		
		public void checkLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			if(login.equals("Иванов") && password.equals("Иван")) {
				request.getRequestDispatcher("/Admin.jsp").forward(request, response);
			}
			
			if(login.equals("Петров") && password.equals("Петя")) {
				request.getRequestDispatcher("/Index.jsp").forward(request, response);
			}
		}
	}
}
