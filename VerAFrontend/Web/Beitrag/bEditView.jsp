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
	<%
		session=request.getSession(false);
		if(session.getAttribute("Titel")!=null){
	%>
	<form action="bEdit" method="post">
	<input type="hidden" name="bid" value=bid>
	<label>Beitragstitel: </label>
			<s:textfield type="titel" name = "titel" value=titel></s:textfield>
		<br><br>
		<h1>Kategorie: <s:property value="kategorie" /></h1>
		<s:textarea type="inhalt" name="inhalt" value=inhalt />
	<%
		}else{
			response.sendRedirect("beitragsView.jsp");
		}
	%>
	<input type="submit" name="editieren" value="Editieren">
	</form>
</body>
</html>