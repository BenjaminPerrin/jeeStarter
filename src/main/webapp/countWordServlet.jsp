<%-- 
    Document   : count
    Created on : 25 juil. 2022, 11:03:00
    Author     : ben
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="/include/header.jsp">
	<jsp:param name="title" value="New JSP title"/>
    </jsp:include>
    <body>
        <h1>Ceci est ma premiere page JSP</h1>              

        <form method="GET" action="CountWordServlet">
         <label>Inserez une phrase: </label><input type = "text" name = "sentence">
         <br />
         <input type = "submit" value = "Submit" />
      </form>
        <c:if test="${sentenceSize != null}">
        <p>le nombre de mots est de :${sentenceSize}</p>
        </c:if>

    </body>
</html>