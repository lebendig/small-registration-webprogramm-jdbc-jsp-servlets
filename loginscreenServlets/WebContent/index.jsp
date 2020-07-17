<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- prefixo usamos para referecniar a jstl -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="ressources/css/style.css">
</head>
<body>

	<div class="login-page">
		<div class="form">

			<!-- se nao tiver nada de method="" ele vai procurar a Classe Servlet e usar o metodo doGet()-->
			<form action="LoginServlet" method="post" class="login-form">
				login: <input type="text" id="login" name="login"
					placeholder="username"> <br> 
				password: <input
					type="password" id="password" name="password"
					placeholder="password"> <br> 
<!-- 					<input type="submit" value="Save"> -->
						<button type="submit" value="Save">Login</button>


			</form>
		</div>
	</div>
</body>
</html>