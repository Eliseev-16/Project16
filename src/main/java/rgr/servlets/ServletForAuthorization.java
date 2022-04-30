package rgr.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="ServletForAuthorization", urlPatterns="/AuthorizationServlet") 
public class ServletForAuthorization extends HttpServlet{
	
	private String login, password;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		checkLogin(request, response);
	}
	
	public static class RequestCalc {
		
		private String login;
		private String password;
		
		private RequestCalc (String login, String password) throws ServletException, IOException {
			this.login = login;
			this.password = password;
			}
		
		public static RequestCalc fromRequestParameters(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			return new RequestCalc(
			request.getParameter("log"),
			request.getParameter("password")
			);
			}
		
		public String getLogin() {
			return login;
			
		}
		
		public String getPassword() {
			return password;
		}
		}
	
	public void checkLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestCalc Calc = RequestCalc.fromRequestParameters(request, response);
		login = Calc.getLogin();
		password = Calc.getPassword();
		if(login.equals("Иванов") && password.equals("Иван")) {
			request.getRequestDispatcher("/Admin.jsp").forward(request, response);
		}
		
		if(login.equals("Петров") && password.equals("Петя")) {
			request.getRequestDispatcher("/Index.jsp").forward(request, response);
		}
	}
}
