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
		<br>
		<h2>Suche</h2>
		<br><br>
<form action="search" method="POST"> 
		<s:select 
       	name="Suchoption"
       	headerKey="-1" headerValue="Bitte Such-Option wählen"
       	list="#{'User': 'User', 'Beitrag':'Beitrag'}"
       	value="suchoption"
       	required="true"
		/>
		<s:textfield type="term" name = "term"></s:textfield>
		<input class="btn btn-default" type="submit" name="suche" value="Suche">
</form>
	
<hr><br>	
</div>
</body>
</html>