package rgr.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rgr.sqlManager.SQLReader;

// TODO: Auto-generated Javadoc
/**
 * The Class ServletForAuthorization.
 */
@WebServlet(name="ServletForAuthorization", urlPatterns="/AuthorizationServlet") 
public class ServletForAuthorization extends HttpServlet{
	
	/** The password. */
	private String login, password;
	
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
			checkLogin(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("errorMsg", e.getMessage() );
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
	}

	
	/**
	 * The Class RequestCalc.
	 */
	public static class RequestCalc {
		
		/** The login. */
		private String login;
		
		/** The password. */
		private String password;
		
		/**
		 * Instantiates a new request calc.
		 *
		 * @param login the login
		 * @param password the password
		 * @throws ServletException the servlet exception
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		private RequestCalc (String login, String password) throws ServletException, IOException {
			this.login = login;
			this.password = password;
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
			request.getParameter("log"),
			request.getParameter("password")
			);
			}
		
		/**
		 * Gets the login.
		 *
		 * @return the login
		 */
		public String getLogin() {
			return login;
			
		}
		
		/**
		 * Gets the password.
		 *
		 * @return the password
		 */
		public String getPassword() {
			return password;
		}
		}
	
	/**
	 * Check login.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws Exception the exception
	 */
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
