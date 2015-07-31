<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s"  uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/reset.css" media="screen" />
<!-- Main CSS File -->
<link rel="stylesheet" type="text/css" href="css/style.css" media="screen" />
<title>Index</title>
</head>
<body>
		<!--=====================================
				Top Fixed Navigation Menu BEGIN
		======================================-->
		<div id="menu_div">
			<div id="navigation">
				<div id="menu">
					<ul id="nav">
						<li><a href="/index.jsp">Index</a></li> 

						<li><a href="#">Beiträge</a></li>
						
						<li><a href="#">Treffen</a></li>
						
						<li><a href="#">Suche</a></li>

						<%
							session = request.getSession(false);
							if(session.getAttribute("user")==null){	
						%>	
						<li><a href="login.jsp">Login</a></li>	
						<%
							}else{
						%>
						<li><s:a action="logout">Logout</s:a></li>	
						<%
							}
						%></li>
						
							
					</ul><!-- #nav END-->					 
				</div><!-- #menu END-->
			</div><!-- #navigation END-->
		</div><!-- #menu_div END-->
		<!--=====================================
				/Top Fixed Navigation Menu END 
		======================================-->
	<div class="clear"></div>
	<div id="container">
		<h2><s:property value = "infoMessage"/></h2>
		<s:form action="login" method = "post">
			<s:textfield name="username" label= "Benutzername"></s:textfield>
			<s:textfield type = "password" name="password" label= "Passwort"></s:textfield>
			<s:submit value = "login"></s:submit>
		</s:form>	
	</div>
</body>
</html>