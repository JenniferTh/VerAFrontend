<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s"  uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<blink>
	<s:property value = "infoMessage"/>
	
</blink>

	<form action="login" method = "post">
		<table cellpadding = "4" cellspacing = "4" border = "1" align = "center">
			<tr><td>Login:</td><td><input id ="username" type="text" name = "username"/></td></tr>
			<tr><td>Passwort:</td><td><input id ="password" type="text" name = "password"/></td></tr>
			<tr><td colspan ="2" align ="center"><input type ="submit" value = "login"> 
		</table>
	</form>	
</body>
</html>