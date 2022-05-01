package rgr.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rgr.sqlManager.SQLReader;

@WebServlet(name="ServletForAuthorization", urlPatterns="/AuthorizationServlet") 
public class ServletForAuthorization extends HttpServlet{
	
	private String login, password;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			checkLogin(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("errorMsg", e.getMessage() );
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
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
	
	public void checkLogin(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		RequestCalc Calc = RequestCalc.fromRequestParameters(request, response);
		login = Calc.getLogin();
		password = Calc.getPassword();
		if(login.equals("user") && password.equals("user")) {
			request.getRequestDispatcher("/Index.jsp").forward(request, response);
		}
		
		else if(SQLReader.readUser(login, password) == 1) {
			request.getRequestDispatcher("/Index.jsp").forward(request, response);
		}
		
		else if (SQLReader.readUser(login, password) == 2) {
			request.getRequestDispatcher("/Admin.jsp").forward(request, response);
		}
		else throw new Exception("Неверно введены логин или пароль");
		}
}
