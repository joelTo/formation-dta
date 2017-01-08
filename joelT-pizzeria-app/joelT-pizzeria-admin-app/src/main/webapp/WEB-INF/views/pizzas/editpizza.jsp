<%@page import="fr.model.Pizza"%>
<%@page import="java.util.List"%>
<%@page import="fr.dao.PizzaDaoBaseJPA"%>
<%@ page  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Pizza</title>
<link
	href="<%= request.getContextPath() %>/css/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<c:set var="pizza" value="${PizzaAModifer}"/>
<body>

<div>
<form class="form-horizontal" method="post">
<fieldset>

<!-- Form Name -->
<legend>Edition Pizza</legend>

<%    String oldCode = (String) request.getAttribute("OldCode");%>


<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="codePizza">Code</label>  
  <div class="col-md-4">
  <input id="codePizza" name="codePizza" type="text" value="${pizza.code}" class="form-control input-md">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="libellePizza">Libellé Pizza :</label>  
  <div class="col-md-4">
  <input id="libellePizza" name="libellePizza" type="text" value="${pizza.nom}"  class="form-control input-md">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="prixPizza">Prix :</label>  
  <div class="col-md-4">
  <input id="prixPizza" name="prixPizza" type="text" value="${pizza.prix}" class="form-control input-md">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="catPizza">Catégorie :</label>  
  <div class="col-md-4">
  <input id="catPizza" name="catPizza" type="text" value="${pizza.catPizza}" class="form-control input-md">
    
  </div>
</div>

<!-- File Button --> 
<div class="form-group">
  <label class="col-md-4 control-label" for="imgImport">Photos</label>
  <div class="col-md-4">
    <input id="imgImport" name="imgImport" class="input-file" type="file">
  </div>
</div>

<!-- Button (Double) -->
<div class="form-group">
  <label class="col-md-4 control-label" for="buttonAdd"></label>
  <input type="hidden" name="oldCode" value="<%=oldCode%>"> 
  <div class="col-md-8">
													
    <button type="submit" id="buttonAdd" name="buttonAdd" class="btn btn-success">Valider</button>
   <button id="buttonCancel" name="buttonCancel" class="btn btn-danger">Annuler</button>
  </div>
</div>



</fieldset>
</form>

</div>

</body>
</html>