<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>4 Fantastic Bank</title>
<link rel="icon" href="favicone.png" />
 <link rel='stylesheet' type='text/css' href='style.css' />
 
</head>
<body>
		
      
        <img src="4FantastiquesBank.png">
                <h1>Veuillez vous identifier</h1>
 <!--     <%   out.println( "        <h2> " + new Date() + "</h2>" ); %>  -->
        
        <form method='POST' action='controller'>
        <label for='txtLogin'>Login :</label>
        <input id='txtLogin' name='txtLogin' type='text' value=${login} autofocus /><br/>
         <label for='txtPassword'>Password :</label>
        <input name='txtPassword' type='password' value=${pass} /><br/>
         <br/>
        <input name='btnConnect' type='submit' value='envoyer' class='bouton' /><br/>
        </form>
		
</body>
</html>