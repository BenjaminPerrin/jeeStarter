<%-- 
    Document   : welcome
    Created on : 27 juil. 2022, 09:45:17
    Author     : ben
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="/include/header.jsp">
        <jsp:param name="title" value="first java login/welcome" />
    </jsp:include>
    <body>
        <h1>Bonjour ${sessionScope.email} vous etes un ${sessionScope.role}</h1>
    </body>
    <a href="LogoutServlet">logout</a>
</html>
