<%@page import="fr.model.Pizza"%>
<%@page import="java.util.List"%>
<%@page import="fr.dao.PizzaDaoBaseJPA"%>
<%@ page  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste Pizzas</title>
<link
	href="<%= request.getContextPath() %>/css/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
</head>



<body>
	<header>
	<h1>Liste des Pizzas :</h1>
	</header>
	<p>  <c:out value=" ${sessionScope.name} "/></p>
	<div>
		<table class="table">
			<thead>
				<tr>
					<th>#</th>
					<th>Reference</th>
					<th>Nom</th>
					<th>Prix</th>
				</tr>
			</thead>
			<tbody>



				<c:forEach var="pizza" items="${listPizza}">
				<tr>
					<td>${pizza.id}</td>
					<td>${pizza.code}</td>
					<td>${pizza.nom}</td>
					<td>${pizza.prix}</td>
					<td><img class="img-responsive"
						src="<%= request.getContextPath() %>${pizza.url}"
						style="width: 15%" /></td>
						<td><a href="/pizzeria-admin-app/api/pizza/edit?code=${pizza.code}"><button  type="button" class="btn btn-secondary">Modifier</button></a></td>
						
						<td><a href="/pizzeria-admin-app/api/pizza/delete?code=${pizza.code}"><button type="button" class="btn btn-secondary" >Supprimer</button> </a></td>
				</tr>				
				</c:forEach>
				
			</tbody>


		</table>
	</div>
</body>
</html>