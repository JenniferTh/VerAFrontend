
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


	
	<div class="clear"></div>
	<div id="container">
		<%
	session = request.getSession(false);
	if(session.getAttribute("level")!=null){
		String level = session.getAttribute("level").toString();
		if(level.equals("2")||level.equals("3")){	
	%>
<a href="tsuccess.jsp">Treffen erstellen</a>
		  <br>	<%}}%>
		<h2 class="h2">Treffen</h2>
		<table class="table table-bordered table-hover">
		  <thead>
			  <tr>
			    <th>Thema</th>
			    <th>Kategorie</th>
			    <th>Teilnehmer</th>
			    <th>Ort</th>
			    <th>Uhrzeit</th>
			    <th>Datum</th>
			    <th>Info</th>
			    <th></th>
			  </tr>
			  </thead>
			<s:iterator value="meetings">
				<tr>
				<td><s:property value="thema"/></td>
				<td><s:property value="kategorie"/></td>
				<td><s:property value="anzahlTeilnehmer"/>/<s:property value="maxTeilnehmer"/></td>
				<td><s:property value="ort"/></td>
				<td><s:property value="uhrzeit"/></td>
				<td><s:property value="datum"/></td>
				<td><s:property value="info"/></td>
				<%
				session = request.getSession(false);
				if(session.getAttribute("user")!=null){	
				%>
				<td>
					<s:form action="joinMeeting">
						<p>A:<s:property value="treffenID"/>&nbspB:<s:property value="#session['userID']"/></p>
						<s:textfield class="form-control" name="" rows="1" placeholder="A"></s:textfield>
						<s:textfield class="form-control" name="artcID" rows="1" placeholder="B" ></s:textfield>						
						<s:submit class="btn btn-primary" value="Teilnehmen" name="submit"/>
					</s:form>
				</td> 
				<%}else{%>
				<td width="150px"><a class="btn btn-default" href="login.jsp" role="button">Bitte einloggen</a></td>
				<%}%>
				</tr>
		</s:iterator>	
	</table>
</div>	
</body>
</html>