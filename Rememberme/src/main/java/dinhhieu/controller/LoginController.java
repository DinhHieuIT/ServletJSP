package dinhhieu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public LoginController() {
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String remember = request.getParameter("remember");
		
		if(username !=null && password != null && username.length()>0 && password.length()>0) {
			if(username.equals("dinhhieu") && password.equals("1234")) {
				HttpSession session = request.getSession();
				session.setAttribute("nameloged", username);
				
				Cookie cookieName = new Cookie("cookiename",username);
				cookieName.setMaxAge(60 * 60 *24);
				Cookie cookiePass = new Cookie("cookiepass",password);
				Cookie cookieRemember = new Cookie("cookieremember",remember);
				
				response.addCookie(cookieName);
				response.addCookie(cookiePass);
				response.addCookie(cookieRemember);
				
				response.sendRedirect(request.getContextPath());
			}else {
				HttpSession session = request.getSession();
				session.setAttribute("message1", "username is incorrect");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("message2", "username and password need to have value");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
	}


