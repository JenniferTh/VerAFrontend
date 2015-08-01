<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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


		<label>Datum: </label>
		<script>DateInput('todaydate', true, 'MON-DD-YYYY');</script>
		<br>
 
		<s:select label="Uhrzeit"
       	name="uhr_h"
       	headerKey="-1" headerValue="Stunde"
       	list="#{'0': '0', '1':'1', '2':'2', '3':'3', '4':'4', '5':'5', '6':'6', '7':'7', '8':'8', '9':'9', '10':'10', '11':'11', '12':'12', '13':'13', '14':'14', '15':'15', '16':'16', '17':'17', '18':'18', '19':'19', '20':'20', '21':'21', '22':'22', '23':'23'}"
       	value="hour"
       	required="true"
		/>
		<s:select label=""
       	name="uhr_min"
       	headerKey="-1" headerValue="Minute"
       	list="#{'00': '00', '15':'15', '30':'30', '45':'45', '37':'37'}"
       	value="minute"
       	required="true"
		/>	
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