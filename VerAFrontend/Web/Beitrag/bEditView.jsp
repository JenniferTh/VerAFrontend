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
	<h1>Titel: <s:property value="titel" /></h1>
	<s:textfield type="kategorie" name ="kategorie" value="kategorie"></s:textfield> <br />
	<s:textarea type="inhalt" name ="inhalt" rows="10" cols="50" value="inhalt"></s:textarea>
	<%
		}else{
			
			response.sendRedirect("beitragView.jsp");
		}
		%>
</body>
</html>