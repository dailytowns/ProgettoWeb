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
<body>
<div id="header">
			<!-- Login Popup -->
			<button type="button" onclick="location.href='./premium.jsp';" id="btnPremium"> Premium </button>

			<div id="dialog-message" title="Login">
				  <form action="./logged.jsp" method="post">
				    <ul>
						<li><input type="text" placeholder="Username" name="userName">
					    <li><input type="password" placeholder="Password" name="password">
					    <input type="submit" id="loginButton" value="Login" >
					</ul>
				  </form>		  
			</div>
		<button type="button" onclick="location.href='registration.html';" id="btnSubmitRegistraStruttura">Registrati</button>
		 			<button id="Accedi">Accedi</button> 
	</div>
	
	<div id="title">
		<h1 align="center" id="Welcome">Welcome to RentFlat!</h1>
		<p align="center" id="Enjoy">Book and enjoy it!</p>
	</div>
	
	<div>
		<form id="input" action="./searchForCriteria.jsp" method=post target="_blank">
  				<input type="text" id="datepickercheckin" placeholder="Check-in" name="checkIn">
  				<input type="text" id="datepickercheckout" placeholder="Check-out" name="checkOut">
  				
  				<select name="numeroOspiti" id="numOsp">
  					<option value=1> 1 ospite </option>
  					<option value=2> 2 ospiti </option>
  					<option value=3> 3 ospiti </option>
  					<option value=4> 3+ ospiti </option>
  				</select>
  				
  				<select name="tipologia">
  					<option value="Hotel"> Hotel </option>
  					<option value="Agriturismo"> Agriturismo </option>
  				</select>
  				<input type="submit" name="submit" value="Search">
  				<br><br><br>
		</form>
	</div>
</body>
</html>