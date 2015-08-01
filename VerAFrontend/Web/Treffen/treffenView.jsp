<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Treffen erstellt!</title>
</head>
<body>

	<%
		session=request.getSession(false);
		if(session.getAttribute("Thema")!=null){
	%>
		<h1>Thema: <s:property value="thema" /></h1>
		<h2>Kategorie: <s:property value="kategorie" /></h2>
		<h3>Ort: <s:property value="ort" /></h3>
		<p>Datum: <s:property value="datum" /></p>
		<p>Teilnehmer: <s:property value="maxT" /></p>
		<p>Info: <s:property value="info" /></p>
		<%
		}else{
			response.sendRedirect("tsuccess.jsp");
		}
		%>
		
<form action="index.jsp" method="POST">
		<br />
		<input type="submit" name="hauptseite_enter" value="Zur Hauptseite">
</form>	

<form action="tscuccess" method="POST">
		<br />
		<input type="submit" name="teilnehmen" value="Teilnehmen!">
</form>

</body>
</html>