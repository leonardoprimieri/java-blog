package primieri.leonardo.servlets;


import primieri.leonardo.controllers.PostController;
import java.io.IOException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import primieri.leonardo.controllers.PostController;
import primieri.leonardo.model.Post;

@WebServlet("/CreatePostServlet")
public class CreatePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreatePostServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		String title = request.getParameter("title");
		String description = request.getParameter("description");
		
		String imageURL = request.getParameter("imageURL");

		
		PostController.createPost(title, description, imageURL);
		

		response.sendRedirect("posts.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
