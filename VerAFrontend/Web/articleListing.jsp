
<%@page import="action.JoinMeeting"%>
<%@page import="action.meetingListing"%>
<%@page import="model.Treffen"%>
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

<title>Index</title>
</head>
<body>

<div id="wrapper">

		<!--=====================================
				Top Fixed Navigation Menu BEGIN
		======================================-->
		<div id="menu_div">
			<div id="navigation">
				<div id="menu">
					<ul id="nav">
						<li><a href="index.jsp">Index</a></li> 

						<li><a href="articleListing.action">Beitr�ge</a></li>
						
						<li><a href="meetingListing.action">Treffen</a></li>
						
						<li><a href="#">Suche</a></li>

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
	<div id="container">
	<h2 class="h2">Beitrag</h2>
	<table class="table table-bordered table-hover">
	  <thead>
		  <tr>
		    <th><h3>Thema</h3></th>
		    <th><h3>Kategorie</h3></th>
		    <th><h3>Autor</h3></th>
		    <th></th>
		  </tr>
		  </thead>
		<s:iterator value="articles">
			<tr>
				<td><s:property value="title"/></td>
				<td><s:property value="category"/></td>
				<td><s:property value="author"/></td> 
			</tr>
		</s:iterator>
	</table>
					
	</div>
</div>	
</body>
</html>