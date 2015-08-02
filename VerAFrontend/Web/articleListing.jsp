<%@page import="action.meetingListing"%>
<%@page import="model.Article"%>
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

						<li><a href="articleListing.action">Beiträge</a></li>
						
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
	<h2 class="h2">Beiträge</h2>
	<table class="table table-bordered table-hover">

	  <thead>
		  <tr>
		    <th><h3>Thema</h3></th>
		    <th><h3>Kategorie</h3></th>
		    <th><h3>Autor</h3></th>
		    <th><h3>Mehr</h3></th>
		  </tr>
		  </thead>
		<s:iterator value="articles">
			<tr>
				<td><s:property value="title"/></td>
				<td><s:property value="category"/></td>
				<td><s:property value="author"/></td> 
				<%
				session = request.getSession(false);
				if(session.getAttribute("user")!=null){	
					int i = 1;
				%>		
				<td width="100px">
					<s:form action="showArticle">
						<s:property value="articleID"/>
						<s:hidden name="artcID" value="articleID"/>
						<s:submit class="btn btn-primary" value="Beitrag anzeigen" name="submit"/>
					</s:form>
				</td> 
				<%
				i++;
				}else{%>
				<td width="100px"><a class="btn btn-default" href="login.jsp" role="button">Bitte einloggen</a></td>
				<%}%>
			</tr>
		</s:iterator>
	</table>
					
	</div>
</body>
</html>