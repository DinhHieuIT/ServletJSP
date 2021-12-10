package dinhhieu.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dinhhieu.dao.PeopleDao;
import dinhhieu.model.People;

@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PeopleDao peopleDao = new PeopleDao();
       
    public register() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("registerpeople.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String phone =request.getParameter("phone");
		String address =request.getParameter("address");
		
		People people = new People();
		people.setName(name);
		people.setPhone(phone);
		people.setAddress(address);
		
		try {
			peopleDao.registerPeople(people);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		if(name !=null && phone != null && address != null) {
		response.sendRedirect("success.jsp");
		}else {
		response.sendRedirect("error.jsp");
		}
	}
		
	}


