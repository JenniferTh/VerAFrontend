<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Beitrag erstellt</title>
</head>
<body>
	<%
		session=request.getSession(false);
		if(session.getAttribute("Titel")!=null){
	%>
		<h1>Titel: <s:property value="titel" /></h1>
		<h2>Kategorie: <s:property value="kategorie" /></h2>
		<h3><s:property value="inhalt" /></h3>
		<%
		}else{
			
			response.sendRedirect("bsuccess.jsp");
		}
		%>
		
<form action="index.jsp" method="POST">
		<br />
		<input type="submit" name="hauptseite_enter" value="Zur Hauptseite">
</form>	
<form action="" method="post">
		<input type="submit" name="editieren" value="Editieren">
</form>
<label>Antworten: </label>
		<s:textarea type="antwort" name = "Antwort" rows="10" cols="50"></s:textarea>
		<br />
<form action="beitragView.jsp" method="POST">
		<br />
		<input type="submit" name="sendKomment" value="Antworten">
</form>
</body>
</html>