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
  <div id="menu_div">
			<div id="navigation">
				<div id="menu">
					<ul id="nav">
						<li><a href="index.jsp">Index</a></li> 

						<li><a href="articleListing.action">Beitr�ge</a></li>
						
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
	
	<%
	session = request.getSession(false);
	if(session.getAttribute("level")!=null){
		String level = session.getAttribute("level").toString();
		if(level.equals("2")||level.equals("3")){	
	%>
	  <h2 class="h2" align="center"><button type="button" class="btn btn-primary btn-lg">Beitrag erstellen</button></h2>
	<%}}%>

	<div class="clear"></div>
	<div id="container">
	<h2 class="h2">Suchergebnisse</h2>
	<table class="table table-bordered table-hover">

	  <thead>
		  <tr>
		    <th><h3>User</h3></th>
		    <th><h3>E-Mail</h3></th>
		  </tr>
		  </thead>	
		<s:iterator value="userlist">
			<tr>
				<td><s:property value="username"/></td>
				<td><s:property value="mailadress"/></td> 
				<%
				session = request.getSession(false);
				if(session.getAttribute("Username")!=null){	
				%>
				<!-- Hier Verlinkung zur BeitragView einf�gen -->
				<td width="100px"><s:form action="showArticle" method="post">
				<s:param name="showArticle" value="articleID" />
				<s:submit class="btn btn-primary" method="execute" value="Beitrag anzeigen" />
				</s:form></td> 
				<%
				//session.setAttribute("articleID", articleID);
				}else{%>
				<td width="100px"><a class="btn btn-default" href="login.jsp" role="button">Bitte einloggen</a></td>
				<%}%>
			</tr>
		</s:iterator>
	</table>
					
	</div>
</body>
</html>