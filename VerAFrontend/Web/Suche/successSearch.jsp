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

<form action="search" method="POST"> 
		<s:select 
       	name="Suchoption"
       	headerKey="-1" headerValue="Bitte Such-Option wählen"
       	list="#{'User': 'User', 'Beitrag':'Beitrag'}"
       	value="suchoption"
       	required="true"
		/>
		<s:textfield type="term" name = "term"></s:textfield>
		<input type="submit" name="suche" value="Suche">
</form>
	
<hr><br>	

</body>
</html>