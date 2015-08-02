<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="calendarDateInput.js"></script>
</head>
<body>
	<form action="tCreate" method="POST">
		<label>Thema: </label>
		<s:textfield type="text" name = "thema"></s:textfield>
		<br><br>

		<label>Max. Teilnehmerzahl: </label>
		<s:textfield type="number" name = "maxT"></s:textfield>
		<br><br>

		<s:select label="Kategorie"
       	name="kategorie"
       	headerKey="-1" headerValue="Bitte Kategorie wählen"
       	list="#{'Judo': 'Judo', 'Handball':'Handball', 'Einrad':'Einrad', 'Fussball':'Fussball', 'Tennis':'Tennis'}"
       	value="kategorie"
       	required="true"
		/>
		<br>

		<label>Ort: </label>
		<s:textfield type="text" name = "ort"></s:textfield>	
		<br><br>


    	<label>Datum: </label>: <input type="date" name="datum" placeholder="03-08-2015">
  		
 		<label>Uhrzeit: </label>
		<s:textfield type="text" name = "uhrzeit" placeholder="14:30"></s:textfield>
		
		<br />
		
		<label>Info: </label>
		<br />
		<s:textarea type="text" name = "Info" rows="10" cols="50"></s:textarea>
		<br ><br >
		
		<input type="submit" name="senden" value="Absenden">
		<input type="submit" name="abbrechen" value="Abbrechen">
		
	</form>	

</body>
</html>