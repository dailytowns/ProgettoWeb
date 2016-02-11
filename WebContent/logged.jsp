<%@page import="java.lang.ProcessBuilder.Redirect" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*, java.util.*" %>
<%@ page import="Entity.Cliente" %>
<!DOCTYPE html> <html> 
<head>

<!-- File CSS -->
<link href="./css/style.css" rel="stylesheet" type="text/css">

<!-- Inclusione delle librerie jQuery -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

<!-- File Javascript -->
<script src="./js/date.js"></script>
<script src="./js/loginPopup.js"></script>

<meta charset="ISO-8859-1">

<!-- Titolo visibile sulla scheda -->
<title>RentFlat</title>
</head>
<jsp:useBean id="cliente" scope="session" class="Entity.Cliente"/>
<jsp:setProperty property="*" name="cliente"/>

<body>
<!-- Il nome del cliente non viene passato dal form, devo recuperarlo in altro modo -->
	<div id="header">
		
		<% 
		
		String user = cliente.getUserName();
		Cliente c = new Cliente();
		String name = c.recuperaNome(user);
		if(name != null){
			%>
		<p id="benvenuto"> Benvenuto <%=name%></p>
		<%
		} else { %>
		<button id="Accedi"> Accedi </button> 
			<div id="dialog-message" title="Login">
				  <form action="./logged.jsp" method="post">
				    <ul>
						<li><input type="text" placeholder="Username" name="userName">
					    <li><input type="password" placeholder="Password" name="password">
					    <input type="submit" id="loginButton" value="Login">
					</ul>
				  </form>		  
			</div>
			<%}%>
			
			
		
		<button type="button" onclick="location.href='./premium.jsp';" id="btnPremium"> Premium </button>
		<button type="button" onclick="location.href='gestisciProfilo.html';" value="GestisciProfilo" id="btnGestione"> Gestione Profilo </button>
		<button type="button" onclick="location.href='inserisciLocazione.html';" value="InserisciLocazione" id="btnInserisciLocazione"> Inserisci Locazione </button>
	</div>
	<div id="title">
		<h1 align="center">Welcome to RentFlat!</h1>
		<p align="center">Book and enjoy it!</p>
	</div>
	<div>
		<form id="input" action="./searchForCriteria.jsp">
			<fieldset>
  				<input type="text" id="datepickercheckin" placeholder="Check-in">
  				<input type="text" id="datepickercheckout" placeholder="Check-out">
  				<select>
  					<option value="ospiti"> Numero ospiti... </option>
  					<option value="1 ospite"> 1 ospite </option>
  					<option value="2 ospiti"> 2 ospiti </option>
  					<option value="3 ospiti"> 3 ospiti </option>
  					<option value="3+ ospiti"> 3+ ospiti </option>
  				</select>
  				<select>
  					<option value="Hotel"> Hotel </option>
  					<option value="Agriturismo"> Agriturismo </option>
  				</select>
  				<input type="submit" name="submit" value="Search">
  				<br><br><br>
			</fieldset> 
		</form>
	</div>
</body>
</html>