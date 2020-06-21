<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<c:set var="title" value="List Member JSTL"/>
<sql:setDataSource dataSource="jdbc/ocejwcdDB"/>
<sql:query var="members" sql="SELECT * FROM member" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${title}</title>
    </head>
    <body>
        <h1>${title}</h1>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Birthdate</th>
                <th>Bonus</th>
            </tr>
            
            <c:forEach var="member" items="${members.rows}">
                <tr>
                    <td>${member.id}</td>
                    <td>${member.firstName}</td>
                    <td>${member.lastName}</td>
                    <td>${member.birthDate}</td>
                    <td>${member.bonus}</td>
                </tr>
            </c:forEach>            
        </table>
            
        <p><a href="index.html">Home</a></p>
    </body>
</html>
