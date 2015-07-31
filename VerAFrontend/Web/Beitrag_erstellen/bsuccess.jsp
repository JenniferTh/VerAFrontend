<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<label value="titel">Beitragstitel: </label>
	<input type="text"> 
	
<br><br>

<form action="select.html"> 
	<label>Kathegorie: </label>
	<select name="top5" size="1"> 
		<option>Judo</option> 
		<option>Handball</option> 
		<option>Einrad</option> 
		<option>Fußball</option> 
		<option>Tennis</option> 
	</select> 
</form>

<br>

<label>Inhalt: </label>
	<br />
    <textarea rows="10" cols="50"></textarea>
     
<form action="bsuccess.jsp" method="POST">
		<br />
		<input type="submit" name="senden" value="Absenden">
		<input type="submit" name="abbrechen" value="Abbrechen">
</form>	

</body>
</html>