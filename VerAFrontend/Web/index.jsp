<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s"  uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index</title>
</head>
<body>
	<h1>Index</h1> 
	<%
		session = request.getSession(false);
		if(session.getAttribute("user")==null){	
	%>	
	<s:form  action="login"  method = "post">
		<s:submit value ="login"></s:submit>
	</s:form>	
	<%
		}else{
	%>
	<p>Herzlich Willkommen <s:property value="username"/></p>
	<s:form  action="logout"  method = "post">
		<s:submit value ="logout"></s:submit>
	</s:form>	
	<%
		}
	%>

</body>
</html>