<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="net.hello.domain.Customer" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Member Success</title>
    </head>
    <body>
        <h1>Add Member Success</h1>
        Id: ${sessionScope.member.id}<br/>
        Firat Name: ${sessionScope.member.firstName}<br/>
        Last Name: ${sessionScope.member.lastName}<br/>
        Birthdate: ${sessionScope.member.birthDate}<br/>
        Bonus: ${sessionScope.member.bonus}<br/>
        <p><a href="index.html">Home</a></p>
        
        <%
            session.invalidate();
        %>
    </body>
</html>
