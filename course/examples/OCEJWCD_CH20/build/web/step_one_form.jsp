<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Step One"/>
<html>
    <head>
        <title>${title}</title>
        <meta charset="UTF-8">
    </head>
    <body>
        <h1>${title}</h1>
        
        <c:if test="${not empty requestScope.errorMessages}">
            <c:forEach var="message" items="${requestScope.errorMessages}">
                <ul>
                    <li>${message}</li>
                </ul>
            </c:forEach>
        </c:if>
        
        <form action="step_one.do" method="POST">
            <table bgcolor="#D0D0D0">
                <tr>
                    <td>First Name</td>
                    <td><input name="firstName" type="text" 
                               value="${param.firstName}"/></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><input name="lastName" type="text" 
                               value="${param.lastName}"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Next"/>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
