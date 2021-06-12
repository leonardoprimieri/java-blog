package primieri.leonardo.servlets;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import primieri.leonardo.model.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String emailProp = request.getParameter("email");
		String passwordProp = request.getParameter("password");

		User user1 = new User();
		user1.setEmail("leo.primieri@gmail.com");
		user1.setPassword("leonardo");

		List<User> users = new ArrayList<User>();
		users.add(user1);
		
		User currentUser = new User();
		currentUser.setEmail(emailProp);
		currentUser.setPassword(passwordProp);

		
		User AuthorizedUser = new User();
	
		AuthorizedUser.setEmail(emailProp);
		AuthorizedUser.setPassword(passwordProp);
		
		if(users.contains(currentUser)) {
			response.sendRedirect("posts.jsp");
		} else {
			
			response.sendRedirect("index.jsp");
		}
		
		

		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
