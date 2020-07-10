<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
</head>
<body>


	<h1>Please enter user data here</h1>
	<form action="saveUser" method="post">

		<table>

			<tr>
				<td>Login:</td>
				<td><input type="text" name="login" id="login"></td>
			</tr>
			</tr>
				<td>Password:</td>
				<td><input type="password" name="password" id="password"></td>
			</tr>
			</tr>
				<td><input type="submit" value="send"></td>
			</tr>

		</table>



	</form>
	
	
	<table>
	
	<c:forEach  items="${users}"  var="user">
	<tr> <!-- linha -->
	<td style="150px"><c:out value ="${user.login }"></c:out></td><!-- celula -->
	<td><c:out value ="${user.password }"></c:out></td>
	</tr>
	</c:forEach>
	
	</table>
	



</body>
</html>