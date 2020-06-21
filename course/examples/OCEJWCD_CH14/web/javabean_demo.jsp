<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JavaBean Demo</title>
    </head>
    <body>
        <h1>JavaBean Demo</h1>
        <jsp:useBean id="c" class="net.hello.domain.Customer"/>
        
        <jsp:setProperty name="c" property="name" value="Simon" />
        <jsp:setProperty name="c" property="address" value="Taipei" />
        <jsp:setProperty name="c" property="phone" value="12345678" />
        <jsp:setProperty name="c" property="notify" value="true" />
        
        Name: <jsp:getProperty name="c" property="name"/><br/>
        Address: <jsp:getProperty name="c" property="address"/><br/>
        Phone: <jsp:getProperty name="c" property="phone"/><br/>
        Notify: <jsp:getProperty name="c" property="notify"/><br/>
        Information: <jsp:getProperty name="c" property="info"/><br/>
    </body>
</html>
