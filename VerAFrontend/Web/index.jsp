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
	<div id="wrapper-inner" style="position:relative;">
		<div class="wrapper-padding">
		<br></br>
			<%
				session = request.getSession(false);
				if(session.getAttribute("user")!=null){	
			%>	
			<span id="vera-topic-1" class="h2">Herzlich Willkommen <s:property value="#session['user']"/></span>
			<%
				}else{
			%>
			<span id="vera-topic-1" class="h2">Herzlich willkommen auf VerA</span>
			<%
				}
			%>
			<br></br>
			<br></br>

			<div id="content">
				<div class="grid-row">	
					<div class="grid-66">
						<span id="vera-topic-1" class="h2">
							Neue Beiträge
						</span>
					</div>
					<div class="grid-33">
						<span id="vera-topic-1" class="h2">
							Aktuelle Treffen
						</span>
					</div>
				</div>
			</div>	
		</div>
	</div>
</div>	
	
</body>
</html>
