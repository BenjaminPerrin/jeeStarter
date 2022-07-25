<%-- 
    Document   : first
    Created on : 22 juil. 2022, 15:01:05
    Author     : ben
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="/include/header.jsp">
	<jsp:param name="title" value="New JSP title First"/>
    </jsp:include>
    <body>
        <h1>Ceci est ma premiere page JSP</h1>        
        <c:set var='name' value='bob'/>
        <h1>Bonjour <c:out value="${name}"/></h1>        


    </body>
</html>
