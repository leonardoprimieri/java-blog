
<%@page import="primieri.leonardo.controllers.PostController"%>
<%@page import="primieri.leonardo.model.Post"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Posts do blog</title>
<link rel="stylesheet" href="./assets/styles/post-blog.css" />
</head>
<body>

	
	
	<jsp:include page="header.jsp" />
	<div class="container-posts">
		
			<%
			List<Post> posts = PostController.getPosts();

			for(Post p : posts) {
	
			
			%> 
			<section class="blog-post">
			<a href=""> <img src="<% out.append(p.getImageURL()); %>"
				alt="any picture..." />
				<div class="blog-post__info">
					<span>  <strong>Postado em: </strong> <% out.append(p.getDate()); %> </span>
					<h1><% out.append(p.getTitle()); %></h1>
					<p><% out.append(p.getDescription()); %></p>
					
				</div>
			</a>
			</section>
			<% } %>
		 

	</div>

</body>
</html>
