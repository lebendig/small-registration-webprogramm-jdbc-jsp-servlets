<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
<link rel="stylesheet" href="ressources/css/sytleregister.css">
</head>
<body>

<div class="container">  
	
	<form id="contact" action="saveUser" method="post" id="formuser">
<h3>Insert User</h3>
		<table>
	<tr>
				<td>Id:</td> <!-- readonly="readonly" nao editar e value serve para usar como retorno -->
				<td><input placeholder="Id" tabindex="1" required autofocus type="text" readonly="readonly" name="id" id="id"  value ="${user.id}"></td>
			</tr>
			<tr>
				<td>Login:</td>
				<td><input placeholder="Login" tabindex="2" required  type="text" name="login" id="login" value = "${user.login}"></td>
			</tr>
			</tr>
				<td>Password:</td>
				<td><input placeholder="Password"  tabindex="3" required  type="password" name="password" id="password" value = "${user.password}"></td>
			</tr>
			
					</tr>
				<td>Name:</td>
				<td><input placeholder="Name"  tabindex="4" required  type="name" name="name" id="name" value = "${user.name}"></td>
			</tr>
			
			
			</tr>
				<td></td><td><button type="submit" value="send" id="contact-submit" data-submit="...Sending" >Submit</button>
				<button type="submit" value="cancel" id="cancel" onclick="document.getElementById('formuser').action = 'saveUser?acao=reset' " >Cancel</button>
				<h3>${msg}</h3> <!-- give back "User already exists" -->
				</td>
				
			</tr>

		</table>



	</form>
	
<h2>Registred Users</h2>	
<div class="table-wrapper">

	<table class="fl-table">
	        <thead>
        <tr>
            <th>ID</th>
            <th>User</th>
            <th>Name</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        </thead>
	
	<c:forEach  items="${users}"  var="user" >
	<tr> <!-- linha -->
	<td style="150px">
	<c:out value ="${user.id }"></c:out></td>
	<td style="150px">
	<c:out value ="${user.login }"></c:out></td><!-- celula -->
	<td><c:out value ="${user.name }"></c:out></td>
	<!--  assim é feito por get !! pois passou por uma url-->
	<td><a href="saveUser?acao=delete&user=${user.id}"><img src="ressources/image/excluir.png" width="19px" height="19px" alt="Delete" title="Delete"></a></td>
	<!-- alt ="" we use when the img cant be shown and title="" is when we put the mouse cursor on the image, its will show the content   -->
	<td><a href="saveUser?acao=edit&user=${user.id}" ><img src="ressources/image/edit.jpg" width="20px" height="20px" alt="Update" title="Update"></a></td>
	</tr>
	</c:forEach>
	
	</table>
</div>


</div>
</body>
</html>