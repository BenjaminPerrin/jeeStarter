<%-- 
    Document   : login
    Created on : 27 juil. 2022, 09:44:20
    Author     : ben
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="/include/header.jsp">
        <jsp:param name="title" value="first java login" />
    </jsp:include>
    <body>
        <h1>Login</h1>
        <form method="POST">
            <fieldset>
                <legend>Login</legend>
                email<input type="email" name="email" required>                
                password<input type="password" name="password" required>
                <button type="submit" name="submit">login</button> 
                <span class="error">${messages.login}</span>
            </fieldset>
        </form>
    </body>
</html>
