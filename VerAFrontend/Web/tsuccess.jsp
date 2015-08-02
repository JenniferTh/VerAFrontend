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
	<form action="tCreate" method="POST">
		<br>
		<label>Thema: </label>
		<s:textfield class="form-control" type="text" name = "thema"></s:textfield>
		<br><br>

		<label>Max. Teilnehmerzahl: </label>
		<s:textfield class="form-control" type="number" name = "maxT"></s:textfield>
		<br><br>

		<s:select label="Kategorie"
       	name="kategorie"
       	headerKey="-1" headerValue="Bitte Kategorie wählen"
       	list="#{'Judo': 'Judo', 'Handball':'Handball', 'Einrad':'Einrad', 'Fussball':'Fussball', 'Tennis':'Tennis'}"
       	value="kategorie"
       	required="true"
		/>
		<br>

		<label>Ort: </label>
		<s:textfield class="form-control" type="text" name = "ort"></s:textfield>	
		<br><br>


    	<label>Datum: </label>: <input type="date" name="datum" placeholder="03-08-2015">
  		
 		<label>Uhrzeit: </label>
		<s:textfield class="form-control" type="text" name = "uhrzeit" placeholder="14:30"></s:textfield>
		
		<br />
		
		<label>Info: </label>
		<br />
		<s:textarea class="form-control" type="text" name = "Info" rows="10" cols="50"></s:textarea>
		<br ><br >
		
		<input class="btn btn-default" type="submit" name="senden" value="Absenden">
		<input class="btn btn-default" type="submit" name="abbrechen" value="Abbrechen">
		
	</form>	
</div>
</body>
</html>
