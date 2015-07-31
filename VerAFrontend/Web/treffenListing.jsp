
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
						<li><s:a action="logout">Logout</s:a></li>	
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
	<div id="wrapper-inner" style="position:relative;">
		<div class="wrapper-padding">
			<br></br>
			<div id="content">
				<div class="grid-row">	
					<div class="grid-90">
						<span id="vera-topic-1" class="h2">
							Treffen
						</span>
						<table class="table">
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
									<td><s:property value="maxTeilnehmer"/></td>
									<td><s:property value="ort"/></td>
									<td><s:property value="uhrzeit"/></td>
									<td><s:property value="datum"/></td>
									<td><s:property value="info"/></td>
									<%
									
									%>
									<td><s:form action="joinMeeting" method="post">
									<s:param name="JoinMeeting.meetingID" value="treffenID" />
									<s:submit method="execute" value="Teilnehmen" />
									</s:form></td> 
								</tr>
							</s:iterator>
						</table>
					</div>
				</div>
			</div>	
		</div>
	</div>
</div>	
</body>
</html>