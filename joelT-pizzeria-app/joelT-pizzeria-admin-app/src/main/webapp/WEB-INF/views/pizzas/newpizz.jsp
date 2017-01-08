<%@ page  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Pizza</title>
<link
	href="<%= request.getContextPath() %>/css/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
<div>
<form class="form-horizontal">
<fieldset>




<!-- Form Name -->
<legend>Nouvelle Pizza</legend>



<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="codePizza">Code</label>  
  <div class="col-md-4">
  <input id="codePizza" name="codePizza" type="text" placeholder=" exemple : MAR" class="form-control input-md">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="libellePizza">Libellé Pizza :</label>  
  <div class="col-md-4">
  <input id="libellePizza" name="libellePizza" type="text" placeholder="exemple : MARGARITA" class="form-control input-md">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="prixPizza">Prix :</label>  
  <div class="col-md-4">
  <input id="prixPizza" name="prixPizza" type="text" placeholder="exemple : 18,52" class="form-control input-md">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="catPizza">Catégorie :</label>  
  <div class="col-md-4">
  <input id="catPizza" name="catPizza" type="text" placeholder="SANS_VIANDE" class="form-control input-md">
    
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
  <div class="col-md-8">

    <button id="buttonAdd" name="buttonAdd" class="btn btn-success">Ajouter</button>
    <button id="buttonCancel" name="buttonCancel" class="btn btn-danger">Annuler</button>
  </div>
</div>

</fieldset>
</form>

</div>

</body>
</html>