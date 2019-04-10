<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<% 
      
       
        out.println( "        <h1>Bonjour et Bienvenue veuillez vous identifier</h1>" );
        out.println( "        <h2> " + new Date() + "</h2>" );
        
        out.println( "        <form method='POST' action='controller'>" );
        out.println( "            <label for='txtLogin'>Login :</label>" ); 
        out.println( "            <input id='txtLogin' name='txtLogin' type='text' value='login' autofocus /><br/>" );
        out.println( "            <label for='txtPassword'>Password :</label>" ); 
        out.println( "            <input name='txtPassword' type='password' value='password' /><br/>" );
        out.println( "            <br/>" );
        out.println( "            <input name='btnConnect' type='submit' value='envoyer' /><br/>" );
        out.println( "        </form>" );
		%>
</body>
</html>