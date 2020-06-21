<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="net.hello.domain.Customer" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Expression Language Demo</title>
    </head>
    <body>
        <h1>Expression Language Demo</h1>
        <%
            Customer customerRequest = new Customer("Request", "Taipei", "123456", true);
            Customer customerContext = new Customer("Context", "Taipei", "123456", true);
            request.setAttribute("customer", customerRequest);
            request.setAttribute("customer", customerContext);
        %>
        
        Name: <font size='5'>${customer.name}</font><br/>
        Address: ${customer.address}<br/>
        Phone: ${customer.phone}<br/>
        Notify: ${customer.notify}<br/>
    </body>
</html>
