<%-- 
    Document   : pairs
    Created on : 25 juil. 2022, 11:03:00
    Author     : ben
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <h1>Ceci est ma premiere page JSP</h1>              
        <c:forEach var="i" begin="1" end="30" step="1" varStatus ="status">
            <c:if test = "${i % 2 == 0}">
                <p> <c:out value = "${i}"/><p>
            </c:if>   
        </c:forEach>


    </body>
</html>