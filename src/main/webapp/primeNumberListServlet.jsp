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
      <form method="GET" action="PrimeNumberListServlet">
         <label>debut: </label><input type = "text" name = "start">
         <br />
         <label>fin: </label><input type = "text" name = "end">
         <br />
         <input type = "submit" value = "Submit" />
      </form>
        <c:if test="${numbers != null}">
            <c:forEach items="${numbers}" var="item" varStatus="status">
                ${item}<br/>
            </c:forEach>
        </c:if>
      

    </body>
</html>