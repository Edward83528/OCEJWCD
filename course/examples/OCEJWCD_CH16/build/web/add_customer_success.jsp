<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="net.hello.domain.Customer" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Customer Success</title>
    </head>
    <body>
        <h1>Add Customer Success</h1>
        Name: ${sessionScope.customer.name}<br/>
        Address: ${sessionScope.customer.address}<br/>
        Phone: ${sessionScope.customer.phone}<br/>
        Notify: ${sessionScope.customer.notify}<br/>
        <p><a href="index.html">Home</a></p>
        
        <%
            session.invalidate();
        %>
    </body>
</html>
