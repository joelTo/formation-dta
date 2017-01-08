<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Se connecter</title>
</head>
<body>

	<form method="post" class="form-horizontal">
<fieldset>

<!-- Form Name -->
<legend>Login</legend>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Email</label>
  <div class="col-md-4">
    <input id="textinput" name="textinput" type="text" placeholder="xxxxx@gmail.com" class="form-control input-md">
    
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="passwordinput">Password</label>
  <div class="col-md-4">
    <input id="passwordinput" name="passwordinput" type="password" placeholder="" class="form-control input-md">
    
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton"></label>
  <div class="col-md-4">
    <button type="submit" id="singlebutton" name="singlebutton" class="btn btn-primary">Entrez</button>
    <a href="/api/login/SignOut"><button type="submit" id="singlebutton" name="singlebutton" class="btn btn-primary">Deconnexion</button></a>
  </div>
</div>

</fieldset>
</form>
	

</body>
</html>