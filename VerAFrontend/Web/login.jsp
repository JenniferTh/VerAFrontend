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
<link rel="stylesheet" type="text/css" href="css/bootstrap.css" media="screen" />

<title>Login</title>
</head>
<body>
		<!--=====================================
				Top Fixed Navigation Menu BEGIN
		======================================-->
		<div id="menu_div">
			<div id="navigation">
				<div id="menu">
					<ul id="nav">
						<li><a href="index.jsp">Index</a></li> 

						<li><a href="articleListing.action">Beiträge</a></li>
						
						<li><a href="meetingListing.action">Treffen</a></li>
						
						<li><a href="successSearch.jsp">Suche</a></li>

						<%
							session = request.getSession(false);
							if(session.getAttribute("user")==null){	
						%>	
							<li><a href="login.jsp">Login</a></li>							
						<%
							}else{
						%>
							<li><s:a action="logout">Logout (<s:property value="#session['user']"/>)</s:a></li>	
						<%
							}
						%>
						
							
					</ul><!-- #nav END-->					 
				</div><!-- #menu END-->
			</div><!-- #navigation END-->
		</div><!-- #menu_div END-->
		<!--=====================================
				/Top Fixed Navigation Menu END 
		======================================-->
	<div class="clear"></div>
	<div id="container" align="center">
		<h2><s:property value = "infoMessage"/></h2>
		<%
		session = request.getSession(false);
		if(session.getAttribute("user")==null){	
		%>
		<s:form action="login" method = "post">
			<label class="h2">Login</label>
			<br></br>
			<div class="form-group">
			<s:textfield class="form-control" name="username" label= "Benutzername" placeholder="Benutzername"></s:textfield>
			</div>
			<div class="form-group">
			<s:textfield class="form-control" type = "password" name="password" label= "Passwort" placeholder="Passwort"></s:textfield>
			</div>
			<s:submit value = "login" class="btn btn-default"></s:submit>
		</s:form>
		<%}else{%>	
		Du Bist bereits eingeloggt<br>
		<a href="index.jsp">Hier</a> geht es zurück zum Index
		<%}%>
	</div>	
</body>
</html>