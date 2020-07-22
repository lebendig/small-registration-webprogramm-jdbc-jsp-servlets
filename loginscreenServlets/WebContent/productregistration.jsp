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

 <div class="header">
  <a href="#default" class="logo">EasyLife</a>
  <div class="header-right">
    <a class="active" href="acessoliberado.jsp">Home</a>
    <a href="#contact">Contact</a>
    <a href="index.jsp">Exit</a>
  </div>
</div> 


<div class="container">  
	
	<form id="contact" action="ProductServlet" method="post" id="formuser">
<h3>Insert Products</h3>
		<table>
	<tr>
				<td>Id:</td> <!-- readonly="readonly" nao editar e value serve para usar como retorno -->
				<td><input placeholder="Id" tabindex="1" required autofocus type="text" readonly="readonly" name="id" id="id"  value ="${product.id}"></td>
			</tr>

					<tr>
				<td>Name:</td>
				<td><input placeholder="Name"  tabindex="2" required  type="text" name="name" id="name" value = "${product.name}"></td>
			</tr>
			
					<tr>
				<td>Quantity:</td>
				<td><input placeholder="Quantity"  tabindex="3" required  type="text" name="qty" id="qty" value = "${product.qty}"></td>
			</tr>
			
					<tr>
				<td>Price:</td>
				<td><input placeholder="Price"  tabindex="4" required  type="text" name="price" id="price" value = "${product.price}"></td>
			</tr>

			
			
			<tr>
				<td></td><td><button type="submit" value="send" id="contact-submit" data-submit="...Sending" >Submit</button>
				<button type="submit" value="cancel" id="cancel" onclick="document.getElementById('formuser').action = 'ProductServlet?acao=cancel' " >Cancel</button>
				<h3>${msg}</h3> <!-- give back "User already exists" -->
				<h3>${msg2}</h3> 
				</td>
				
			</tr>

		</table>



	</form>
	
	
	
<h2>Registred Products</h2>	
<div class="table-wrapper">

	<table class="fl-table">
	        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Quantity</th>
            <th>Price</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        </thead>
	
	<c:forEach  items="${products}"  var="product" >
	<tr> <!-- linha -->
	<td style="150px">
	<c:out value ="${product.id }"></c:out></td>
	<td style="150px">
	<c:out value ="${product.name }"></c:out></td><!-- celula -->
	<td><c:out value ="${product.qty }"></c:out></td>
	<td><c:out value ="${product.price }"></c:out></td>
	<!--  assim é feito por get !! pois passou por uma url-->
	<td><a href="ProductServlet?acao=delete&productid=${product.id}"><img src="ressources/image/excluir.png" width="19px" height="19px" alt="Delete" title="Delete"></a></td>
	<!-- alt ="" we use when the img cant be shown and title="" is when we put the mouse cursor on the image, its will show the content   -->
	<td><a href="ProductServlet?acao=edit&productid=${product.id}" ><img src="ressources/image/edit.jpg" width="20px" height="20px" alt="Update" title="Update"></a></td>
	</tr>
	</c:forEach>
	
	</table>
</div>


</div>	
	

</body>
</html>