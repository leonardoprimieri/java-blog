<%@page import="primieri.leonardo.model.Category"%>
<%@page import="java.util.List"%>
<%@page import="primieri.leonardo.controllers.CategoryController"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt_BR">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="./assets/styles/create-post.css" />

<link rel="preconnect" href="https://fonts.gstatic.com" />
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;700&display=swap"
	rel="stylesheet" />
<title>Blog do Leel</title>
</head>

<body>
	<section class="container">
		

		<section class="right-side">
			<form action="CreatePostServlet" method="post">
				<h1>O que voce quer falar?</h1>
				<div class="input-group">
					<label for="title">Titulo: </label> 
					<input required type="text" id="title"name="title" />
				</div> 
				<div class="input-group">
					<label for="description">Corpo: </label> <textarea required type="text"
						id="description" name="description" ></textarea> 
				</div>
				
				<div class="input-group">
					<label for="imageURL">URL da imagem: </label> <input required id="imageURL" name="imageURL" type="url" />
				</div>
				
				 
				
				<div class="input-group" style="margin-top: 2rem;">
					<select style="padding: 1rem; border-radius:5px;"  name="cat" id="cat">
					<option>Selecione uma categoria</option>
					<%
						List<Category> cats = CategoryController.getCategories() ;
		
						for(Category cat : cats) {
		
					%>
						
						<option value="<% out.append(cat.getName()); %>"><% out.append(cat.getName()); %></option>
						
						<% } %>
					</select>
				</div>

				<button type="submit">Publicar!</button>
			</form>
		</section>
		<section class="left-side">
			<img src="./assets/images/bglogin.png" alt="ad" />
			<h1>Blog do Leel</h1>
		</section>
	</section>
</body>
</html>
