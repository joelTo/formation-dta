<%@page import="fr.model.Client"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Client Pizzeria</title>
<script src="https://code.jquery.com/jquery-1.12.3.js"></script>
<link
	href="<%= request.getContextPath() %>/css/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
</head>


<body>
<table class="table">
			<thead>
				<tr>
					<th>Nom</th>
					<th>Prenom</th>
					<th>email</th>
					<th>Mot de passe</th>
				</tr>
			</thead>
			<tbody id="tbody_data">
		</table>
</body>

<script>
(function() {
	   var flickerAPI = "http://localhost:8080/pizzeria-admin-app/api/clients";
	     $.getJSON( flickerAPI, {
	       format: "json"
	     })
	     .done(function( data ) {
	    	 data.forEach(function(i, elem){
	    		 $('#tbody_data').html('<p> Nom: ' + elem.id + '</p>');
	             $('#tbody_data').append('<p>Prenom : ' + elem.lastname+ '</p>');
	             $('#tbody_data').append('<p>email : ' + elem.email+ '</p>');
	             $('#tbody_data').append('<p>mot de passe : ' + elem.mdp+ '</p>');
	    	 })
	    	 

	     });
	 })();
</script>

</html>