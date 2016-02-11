<%@page import="Entity.Struttura"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Conferma salva camera</title>
<!-- File CSS -->
<link href="./css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:useBean id="camera" scope="session" class="Entity.Camera"></jsp:useBean>
<jsp:setProperty property="*" name="camera"/>

<form action="./salvaCamera.jsp" method=post>
		<fieldset>
		<center>
			<table cellpadding=4 cellspacing=2 border=0 background="#CCCCFF">
			<th bgcolor="#CCCCFF" colspan=2>
				<font size=5>Conferma registrazione</font>
				<br>
			</th>
				<tr bgcolor="#c8d8f8">
					<td valign=top> 
						<b>Tipologia<sup>*</sup></b> 
						<br>
						<p><%=camera.getTipologia() %></p>
				
				</tr>
			</table>
		</center>
		</fieldset>
		<input type="submit" value="Submit" >
	</form>


</body>
</html>