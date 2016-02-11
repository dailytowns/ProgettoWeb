<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Entity.Struttura" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- File CSS -->
<link href="./css/style.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Salva le tue camere</title>
</head>
<jsp:useBean id="struttura" scope="session" class="Entity.Struttura"/>
<jsp:useBean id="camera" scope="session" class="Entity.Camera"></jsp:useBean>
<jsp:setProperty name="struttura" property="*" />
<jsp:setProperty property="*" name="camera"/>

<body>
<%
Integer n = (Integer)session.getAttribute("numeroStanze");
if(camera.getTipologia()!=null)
	session.setAttribute("numeroStanze", n-1);
//Da aggiornare a if(n==0) then salvaStruttura?
Struttura.salvaStruttura(struttura);
if(n>0){
%>
<form action="./confermaSalvaCamera.jsp" method=post>
		<fieldset>
		<center>
			<table cellpadding=4 cellspacing=2 border=0 background="#CCCCFF">
			<th bgcolor="#CCCCFF" colspan=2>
				<font size=5>Registra la camera numero <%=1%></font>
				<br>
				<font size=1><sup>*</sup>Campi obbligatori</font>
			</th>
				<tr bgcolor="#c8d8f8">
					<td valign=top> 
						<b>Tipologia<sup>*</sup></b> 
						<br>
						<select name="tipologia" id="tipologia">
		  					<option value="Singola"> Singola </option>
		  					<option value="Doppia"> Doppia </option>
  						</select></td>
  						<td valign=top>
							<b>Prezzo<sup>*</sup></b> 
							<br>
							<input type="text" name="prezzo" size=25  maxlength=5>
						</td>
				</tr>
				
				<tr bgcolor="#c8d8f8">
					<td valign=top>
					<b>Metratura<sup>*</sup></b> 
					<br>
					<input type="text" name="metratura" size=25  maxlength=125>
					</td>
					<td valign=top>
						<b>Servizi<sup>*</sup></b>
						<br>
						<input type="text" name="servizi" size=10 maxlength=10>
					</td>
				</tr>
			</table>
		</center>
		</fieldset>
		<input type="submit" value="Submit"> <input type="reset"  
					value="Reset">
	</form>
<%} else {%>

	<p>Camere da inserire finite </p>

<%}%>
</body>
</html>