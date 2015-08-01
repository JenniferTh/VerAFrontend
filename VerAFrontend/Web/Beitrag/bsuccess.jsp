<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/struts-tags" prefix="s" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="bCreate" method="POST">

		<label>Beitragstitel: </label>
			<s:textfield type="titel" name = "titel"></s:textfield>
		<br><br>

	
		<s:select label="Kategorie"
       	name="kategorie"
       	headerKey="-1" headerValue="Bitte Kategorie wählen"
       	list="#{'Judo': 'Judo', 'Handball':'Handball', 'Einrad':'Einrad', 'Fussball':'Fussball', 'Tennis':'Tennis'}"
       	value="kategorie"
       	required="true"
		/>

		<br>

		<label>Inhalt: </label>
			<br />
    		<textarea name="inhalt" rows="10" cols="50"></textarea>
     
		<br />
		
		<input type="submit" name="senden" value="Absenden">
		<input type="submit" name="abbrechen" value="Abbrechen">
		
	</form>	

</body>
</html>