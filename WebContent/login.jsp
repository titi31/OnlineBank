<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Accédez à votre espace client Banque Populaire</title>
        <link rel="stylesheet" type="text/css" href="style.css" />
    </head>
    <body>
    
    <center>
             <img class="logo" src="BanquePopulaire.png">
    </center>
    
        <h1>Authentification</h1>
    
        <form method="post" action="controller">
            <label for='txtLogin'>Login</label>
            <input id='txtLogin' name='txtLogin' type='text' value='${login}' autofocus /> <br/>
            <label for='txtPassword'>Password</label>
            <input name='txtPassword' type='password' value='${password}' /> <br><br>
            <input name='btnConnect' type='submit' class="bouton" value="Envoyer"/> <br/>
                        <br/><br/>
            <div class="errorMessage">${errorMessage}</div>            
        </form>
    

    
    </body>
</html>