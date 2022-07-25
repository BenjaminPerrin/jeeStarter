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
      <form method="GET" action="PrimeNumberServlet">
         <label>Inserez unnombre: </label><input type = "text" name = "nb">
         <br />
         <input type = "submit" value = "Submit" />
      </form>
        <c:if test="${nb != null}">
        <c:forEach items="${numbers}" var="item" varStatus="status">
            ${item}<br/>
        </c:forEach>
        </c:if>
      

    </body>
</html>