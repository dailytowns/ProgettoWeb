<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Enumeration" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Visualizza dettagli</title>

<!-- Link javascript -->
<script src="./js/prenota.js" type="text/javascript"></script>

</head>

	<jsp:useBean id="index" scope="session" class="utils.Index" />
	<jsp:setProperty property="*" name="index" />

<body>
<script type="text/javascript">
var name = getBottonePrenota();

</script>
<%
int ind=0;
int indice=0;
while(ind<10){
	String s = "prenota"+ind;
	if (request.getParameter(s) != null){
		System.out.println("prenota");
		indice = Integer.parseInt(s.substring("prenota".length()), 10);
		System.out.println("indice " + indice);
		break;
	}
	ind++;
}
%>
		
	


</body>
</html>