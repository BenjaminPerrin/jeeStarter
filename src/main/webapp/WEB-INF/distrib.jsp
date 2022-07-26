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
        <h1>votre credit est de ${credit}</h1>    
        <table>
         <tr>
           <th>Numero de produit</th>
           <th>Nom</th>
           <th>Quantite</th>
           <th>Prix</th>
         </tr>
           <c:forEach items="${stock}" var="items">
               <tr>
                   <td><c:out value="${items.getId()}"/></td>
                    <td><c:out value="${items.getNom()}"/></td>
                    <td><c:out value="${items.getQuantite()}"/></td>
                    <td><c:out value="${items.getPrix()}"/></td>
               </tr>
           </c:forEach>             
       </table> 
        <form method="POST">
        <fieldset>
         <legend>Ajouter du credit</legend>
         <button type="submit" name="onecredit">+1</button>         
         <button type="submit" name="twocredit">+2</button>

        </fieldset>
        </form>
        <form method="POST">
        <fieldset>
         <legend>Acheter un item</legend>
         numero de l'item: <input type="text" name="id" required>
         <button type="submit" name="submit">Acheter</button>
        <span class="error">${messages.id}</span>         
        </fieldset>
        </form>
        <form method="POST">
        <fieldset>
         <legend>Ajouter du credit</legend>
         combien de credit a ajouter?: <input type="text" name="addCredit" required>
         <button type="submit" name="submit">Ajouter</button> 
         <span class="error">${messages.addCredit}</span>
        </fieldset>
        </form>
    </body>
</html>