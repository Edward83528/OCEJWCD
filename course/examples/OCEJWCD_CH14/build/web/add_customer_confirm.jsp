<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirm Demo</title>
    </head>
    <body>
        <h1>Confirm Demo</h1>
        
        <jsp:useBean id="c" class="net.hello.domain.Customer" />
        
        <jsp:setProperty name="c" property="*" />
                
        Name: <jsp:getProperty name="c" property="name"/><br/>
        Address: <jsp:getProperty name="c" property="address"/><br/>
        Phone: <jsp:getProperty name="c" property="phone"/><br/>
        Notify: <jsp:getProperty name="c" property="notify"/><br/>
        Information: <jsp:getProperty name="c" property="info"/><br/>
        
        <form action="add_customer.do" method="POST">
            <%
                Enumeration pns = request.getParameterNames();
                
                while (pns.hasMoreElements()) {
                    String pn = (String) pns.nextElement();
                    out.println("<input type=\"hidden\" name=\"" +
                            pn + "\" value=\"" + request.getParameter(pn) + "\"/>");
                }
            %>
            <input type='button' value='back' 
               onclick='window.history.back()'/>
            <input type='submit'/>
        </form>
    </body>
</html>
