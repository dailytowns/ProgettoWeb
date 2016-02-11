<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>
<jsp:useBean id="struttura" scope="session" class="Entity.Struttura"/>
<jsp:setProperty property="*" name="struttura"/>

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
						<p><%=struttura.getTipologia()%></p>
					<td  valign=top>
						<b>Nome<sup>*</sup></b>
						<br>
						<p><%=struttura.getNome()%></p>
				</tr>
				
				<tr bgcolor="#c8d8f8">
					<td valign=top>
					<b>Sito Web<sup>*</sup></b> 
					<br>
					<p><%=struttura.getSitoWeb()%></p>
					</td>
					<td  valign=top>
					<b>Numero Stanze<sup>*</sup></b> 
					<br>
					<p><%=struttura.getNumeroStanze() %></p>
				</tr>
				
				<tr bgcolor="#c8d8f8">
					<td valign=top>
						<b>Paese<sup>*</sup></b>
						<br>
						<p><%=struttura.getPaese()%></p>
					</td>
					<td valign=top>
						<b>CAP<sup>*</sup></b>
						<br>
						<p><%=struttura.getCap()%></p>
					</td>
				</tr>
				<tr bgcolor="#c8d8f8">
					<td valign=top>
					<b>Città<sup>*</sup></b> 
					<br>
					<p><%=struttura.getCitta()%></p></td>
					<td  valign=top>
					<b>Indirizzo<sup>*</sup></b>
					<br>
					<p><%=struttura.getIndirizzo()%></p></td>
				</tr>
				<tr bgcolor="#c8d8f8">
					<td  align=center colspan=2>
					<input type="submit" value="Submit"> <input type="reset"  
					value="Reset">
					</td>
				</tr>
			</table>
		</center>
		</fieldset>
	</form>
	<%session.setAttribute("numeroStanze", struttura.getNumeroStanze()); %>
</body>
</html>