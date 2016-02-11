<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Entity.Camera" %>
<%@ page import="java.util.*" %>
<%@ page import="Entity.Segnalazione" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- File CSS -->
<link href="./css/style.css" rel="stylesheet" type="text/css">

<!-- Inclusione delle librerie jQuery -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

<!-- File Javascript -->
<script src="./js/segnalaPopup.js"></script>
<script src="./js/segnala.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rentflat - Ricerca</title>
</head>



<body>
<jsp:useBean id="camera" scope="session" class="Entity.Camera"/>
<jsp:setProperty property="*" name="camera"/>
<jsp:useBean id="segnalazione" scope="request" class="Entity.Segnalazione"/>
<jsp:setProperty property="*" name="segnalazione"/>
<!-- Per evitare di confondere Camera con CameraBean -->
<jsp:useBean id="data" scope="session" class="Entity.Data"/>
<jsp:setProperty property="*" name="data"/>


<%
ArrayList<Integer> arrId = new ArrayList<Integer>();
arrId = (ArrayList<Integer>)session.getAttribute("arrayId");

if(segnalazione.getTipoSig() != null){
	Segnalazione sig = new Segnalazione();
	Camera cam = camera;
	cam.setIdCamera(arrId.get(camera.getIndice()));
	sig.setCamera(camera);
	sig.setTipoSig(segnalazione.getTipoSig());
	if(segnalazione.getDescrizione()!=null)
		sig.setDescrizione(segnalazione.getDescrizione());
	sig.salva();
}
%>
<!--  
La cartella corrente è C:\Users\feder_000\jee-latest-released2\eclipse come
suggerisce la stringa ritornata da System.out.println(System.getProperty("user.dir")); -->
<%
	ArrayList<Camera> ac = new ArrayList<Camera>();
	ArrayList<Integer> arrayId = new ArrayList<Integer>();
	//aggiungere setId
	ac = Camera.recuperaCamere(data.getCheckIn(), data.getCheckOut(), camera.getTipologia(), camera.getNumeroOspiti());
	
	int j=0;
	
	for(Camera c : ac){
		String[] s = c.getArrayFoto();
		arrayId.add(j, c.getIdCamera());
		
		%>
			<div id="container">
				<div style="width: 20%; float:left">
   					<p>Camera #<%=j%></p>
   					<br>
					<p><%=c.getNumeroOspiti()%></p>
					<p><%=c.getPrezzo()%></p>
					<p><%=c.getServizi()%></p>
					<button  class="Segnala" >Segnala foto</button>					
				</div>
					<%for(int k = 0; s[k]!=null; k++){%>
						<div style="width: 80%; text-align: right">
		  					 <br><img src="data:image/jpg;base64,<%=s[k]%>" height="200" width="300"><br>
				</div>			
			</div>
			<%		
		}
	%>
		<br><br><br>
	<hr>
<%j++; //Indice per le camere
} //Indice per aggiungere gli id%>

<%session.setAttribute("arrayId", arrayId);%>
<div title="Segnala foto" id="signal-dialog">
	<form action="./searchForCriteria.jsp" method="post">
		<div>
			<input type="text" placeholder="Inserisci il numero della camera da segnalare" name="indice" size="51">
		</div>
		   	<select name="tipoSig">
						<option value="1"> Contenuto inappropriato </option>
						<option value="2"> Non corrispondono al vero </option>
				</select>
			<textarea placeholder="Puoi inserire un messaggio personale" name="descrizione" rows="4" cols="50" ></textarea>
				<br><br><br>
		    <input type="submit" name="submitButton" value="Invia Segnalazione">
	</form>		  
</div>


</body>
</html>
