<%-- 
    Document   : count
    Created on : 25 juil. 2022, 11:03:00
    Author     : ben
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <h1>Ceci est ma premiere page JSP</h1>              

      <form action = "countWordsServlet.jsp" method = "GET">
         Inserez une phrase: <input type = "text" name = "sentence">
         <br />
         <input type = "submit" value = "Submit" />
      </form>
        <p>${sentenceSize}</p>

    </body>
</html>