<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="calendarDateInput.js"></script>
</head>
<body>

<label>Titel: </label>
	<input type="text"> 
<br><br>

<label>Max. Teilnehmerzahl: </label>
	<input type="number"> 
<br><br>

<form action="select.html"> 
	<label>Kathegorie: </label>
	<select name="top5" size="1"> 
		<option>Judo</option> 
		<option>Handball</option> 
		<option>Einrad</option> 
		<option>Fußball</option> 
		<option>Tennis</option> 
	</select> 
</form>

<br>

<label>Ort: </label>
	<input type="text">
	
<br><br>

<form>
<label>Datum: </label>
<script>DateInput('todaydate', true, 'MON-DD-YYYY');</script>
</form> 
<br>

<form action="select.html"> 
	<label>Uhrzeit: </label>
	<select name="hour" size="1"> 
		<option>0</option> 
		<option>1</option> 
		<option>2</option> 
		<option>3</option> 
		<option>4</option>
		<option>5</option>
		<option>6</option>
		<option>7</option>
		<option>8</option>
		<option>9</option>
		<option>10</option>
		<option>11</option>
		<option>12</option>
		<option>13</option>
		<option>14</option>
		<option>15</option>
		<option>16</option>
		<option>17</option>
		<option>18</option>
		<option>19</option>
		<option>20</option>
		<option>21</option>
		<option>22</option>
		<option>23</option>
	</select> 
	<select name="min" size="1">
		<option>00</option>
		<option>15</option>
		<option>30</option>
		<option>45</option>
	</select>
</form>
    	
	
<br />
<label>Info: </label>
<br />
	<textarea rows="10" cols="50"></textarea>
<br />

<form action="beitragsuccess.jsp" method="POST">
		<br />
		<input type="submit" name="bestaetigen_enter" value="Absenden">
		<input type="submit" name="abbrecheb_enter" value="Abbrechen">
	</form>	


</body>
</html>