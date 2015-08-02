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
		
		<div class="clear"></div>
		<div id="container">	
		<s:iterator value ="article">
			<br><br>
			<div id="content">
				<div class="grid-row">	
					<div class="grid-66">
						<span id="vera-topic-1" class="h2">
							<s:property value="title"/> 
						</span>
						<br><br>
						<span id="vera-topic-1" class="h3">
							<cite title="Source Title">in <s:property value="category"/></cite>
						</span>
					</div>
				</div>
			</div>	
			<br><br>		
			<blockquote>
				<p><s:property value="content"/></p>
				<footer><s:property value="author"/></footer>
			</blockquote>
			<br><br>
			<h2>Kommentare</h2>
			<br>
			
			<form action="postComment" method="POST">
				<br>
				<label>Kommentar:</label>
		    	<textarea class="form-control" name="commentary" rows="3"></textarea>
		     	<br>
				<p>A:<s:property value="artcID"/>&nbspB:<s:property value="#session['userID']"/></p>
				<s:textfield class="form-control" name="articleID" rows="1" placeholder="A"></s:textfield>
				<s:textfield class="form-control" name="mitgliedsnummer" rows="1" placeholder="B" ></s:textfield>							
				<input class="btn btn-primary" type="submit" name="senden" value="Absenden">				
			</form>	
			
			<br><br>
			<table class="table table-bordered table-hover">
				<s:iterator value="comments">
					<tr>
						<td><s:property value="author"/></td>
						<td><s:property value="date"/></td>
					</tr>
					<tr>
						<td><p><s:property value="comment"/></p><br><br></td>
					</tr>
				</s:iterator>
			</table>
		</s:iterator>
		</div>
</body>
</html>