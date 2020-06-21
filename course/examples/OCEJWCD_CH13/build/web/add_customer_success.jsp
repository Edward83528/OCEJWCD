<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="net.hello.domain.Customer" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Customer Success</title>
    </head>
    <body>
        <h1>Add Customer Success</h1>
        
        <% Customer customer = (Customer) request.getAttribute("customer"); %>
        
        Name: <%= customer.getName() %><br/>
        Address: <%= customer.getAddress() %><br/>
        Phone: <%= customer.getPhone() %><br/>
        Notify: <%= (customer.isNotify() ? "YES" : "NO") %><br/>
        
        <p><a href="index.html">Home</a></p>
    </body>
</html>
