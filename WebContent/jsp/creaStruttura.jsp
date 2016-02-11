<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- File CSS -->
<link href="../css/style.css" rel="stylesheet" type="text/css">
<body>
<jsp:useBean id="struttura" scope="session" class="Entity.Struttura"/>
<jsp:setProperty property="*" name="struttura"/>
<jsp:useBean id="cliente" scope="session" class="Entity.Cliente"/>
<jsp:setProperty property="*" name="cliente"/>
<%session.setAttribute("cliente", cliente); %>
	<form action="./confermaSalvaStruttura.jsp" method=post>
		<fieldset>
		<center>
			<table cellpadding=10 cellspacing=2 border=0 style="width:100%; heigth:100%">
				<tr>
					<td style="font-style:italic">Registra la tua struttura</td>
				<tr>
					<td><sup>*Campi obbligatori</sup></td></tr>
			
				<tr>
					<td valign=top> 
						<b>Tipologia<sup>*</sup></b> 
						<br>
						<select name="tipologia" id="tipologia">
		  					<option value="Hotel"> Hotel </option>
		  					<option value="Agriturismo"> Agriturismo </option>
  						</select></td>
					<td  valign=top>
						<b>Nome<sup>*</sup></b>
						<br>
						<input type="text" name="nome" id="nome" size=15 maxlength=20></td>
				</tr>
				
				<tr>
					<td valign=top>
					<b>Sito Web<sup>*</sup></b> 
					<br>
					<input type="text" name="sitoWeb" size=25  maxlength=125>
					</td>
					<td  valign=top>
					<b>Numero Stanze<sup>*</sup></b> 
					<br>
					<input type="text" name="numeroStanze" id="numeroStanze" size=5  maxlength=5></td>
				</tr>
				
				<tr>
					<td valign=top>
						<b>Paese<sup>*</sup></b>
						<br>
						<input type="text" name="paese" size=10 maxlength=10>
					</td>
					<td valign=top>
						<b>CAP<sup>*</sup></b>
						<br>
						<input type="text" name="cap" size=10 id="cap"  maxlength=10>
					</td>
				</tr>
				<tr>
					<td valign=top>
					<b>Città<sup>*</sup></b> 
					<br>
					<input type="text" name="citta" id="citta" size=10 value=""  
					maxlength=10></td>
					<td  valign=top>
					<b>Indirizzo<sup>*</sup></b>
					<br>
					<input type="text" name="indirizzo" id="indirizzo" size=30 value=""  
					maxlength=30></td>
				</tr>
			</table>
		</center>
		</fieldset>
			<input type="submit" value="Invia"> <input type="reset" value="Reset">
	</form>

</body>
</html>