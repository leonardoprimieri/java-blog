<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt_BR">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="./assets/styles/login.css" />

<link rel="preconnect" href="https://fonts.gstatic.com" />
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;700&display=swap"
	rel="stylesheet" />
<title>Blog do Leel</title>
</head>

<body>
	<section class="container">
		<section class="left-side">
			<img src="./assets/images/bglogin.png" alt="ad" />
			<h1>Blog do Leel v2.0</h1>
		</section>
		
		<section class="right-side">
			<form action="LoginServlet" method="POST">
				<h1>Faca login na plataforma</h1>
				<div class="input-group">
					<label for="email">Email: </label> <input  required type="email" id="email"
						name="email" />
				</div>
				<div class="input-group">
					<label for="password">Senha: </label> <input required type="password"
						id="password" name="password" />
				</div>
				
				

				<button type="submit">Entrar</button>
				
				
			</form>
		</section>
	</section>
</body>
</html>
