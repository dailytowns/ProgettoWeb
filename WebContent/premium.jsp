<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="Entity.Cliente" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- File CSS -->
<link href="./css/style.css" rel="stylesheet" type="text/css">

<!-- Inclusione delle librerie jQuery -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RentFlat - Sezione Premium</title>
</head>

<jsp:useBean id="cliente" scope="session" class="Entity.Cliente"/>
<jsp:setProperty property="*" name="cliente"/>

<body>

<div id="dialog-message" title="Login">
	  <form action="./premium.jsp" method="post">
	    <ul>
			<li><input type="text" placeholder="Username" name="userName">
		    <li><input type="password" placeholder="Password" name="password">
		    <input type="submit" id="loginButton" value="Login" >
		</ul>
	  </form>		  
</div>

<script language="javascript">
	  <%String user; if((user=request.getParameter("userName"))==null)%>{
		  $(document).ready(function() {
			  var dialog = $('#dialog-message').dialog(
			  	    {
			  	    autoOpen: true,
			  	    height: 350,
			  	    width: 350,
			  	    resizable: false,
			  	    draggable: true,
			  	    title: "Segnala",
			  	    show: { effect: "blind", duration: 800 },
			  	    open: function () {        
			  	            $('#dialog-message').show();
			  	        },
			  	    });
			  dialog.dialog("open");
		  });
	  }
</script>
<%String userName = cliente.getUserName();
Cliente c = new Cliente();
String name = c.recuperaNome(user);
//Aggiungere controllo sul nome e password
if(name != null){
	%>
<div id="header">	
			<p id="benvenuto"> Benvenuto <%=name%></p>
<% }%>

<h1>Diventa un cliente Premium!</h1>
	<p>Indirizzo mail</p>
	<input type="text" name="indirizzoMail" placeholder="Inserisci il tuo indirizzo mail" size="50">
	<br><br><br><br><br>
	<input type="submit" value="Conferma">



</body>
</html>