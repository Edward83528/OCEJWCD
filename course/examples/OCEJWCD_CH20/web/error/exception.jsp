<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exception</title>
    </head>
    <body>
        <h1>Exception</h1>
        <%= exception %>
        <hr/>
        <%
            exception.printStackTrace(new java.io.PrintWriter(out));
        %>
    </body>
</html>
