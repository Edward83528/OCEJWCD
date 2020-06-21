<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer</title>
    </head>
    <body>
        <table border='0' cellspacing='0' cellpadding='0' width='640'>
            <tr height='100'>
                <td bgcolor='#E0E0E0' align='center' valign='center' width='160' height='100'>
                    <img src="images/hello.png"/>
                </td>
                <td bgcolor='#E0E0E0' align='center' valign='center' width='480' height='100'>
                    <jsp:include page="/WEB-INF/views/common/banner.jsp">
                        <jsp:param name="subTitle" value="Add Customer" />
                    </jsp:include>                    
                </td>
            </tr>

            <tr valign='top'>
                <td bgcolor='#E0E0E0' width='160' align='left'>
                    <jsp:include page="/WEB-INF/views/common/function.jsp" />
                </td>
                <td width='480' align='left'>
                    <div style='margin-top: 0.1in; margin-left: 0.1in;
                         margin-bottom: 0.1in; margin-right: 0.1in'>
                        <% 
                            List<String> errorMessages = (List<String>)
                                    request.getAttribute("errorMessages");
                            if (errorMessages != null) {
                                out.println("<ul>");

                                for (String message : errorMessages) {
                                    out.println("<li>" + message + "</li>");
                                }

                                out.println("</ul>");
                            } 
                        %>

                        <form action="add_customer.do" method="POST">
                            <table bgcolor="#D0D0D0">
                                <tr>
                                    <td>Name</td>
                                    <% String nameValue = request.getParameter("name"); %>
                                    <td><input name="name" type="text" 
                                               value="<%= (nameValue == null ? "" : nameValue) %>"/></td>
                                </tr>
                                <tr>
                                    <td>Address</td>
                                    <% String addressValue = request.getParameter("address"); %>
                                    <td><input name="address" type="text" 
                                               value="<%= (addressValue == null ? "" : addressValue) %>"/></td>
                                </tr>
                                <tr>
                                    <td>Phone</td>
                                    <% String phoneValue = request.getParameter("phone"); %>
                                    <td><input name="phone" type="text" 
                                               value="<%= (phoneValue == null ? "" : phoneValue) %>"/></td>
                                </tr>
                                <tr>
                                    <td>Notify</td>
                                    <% String notifyValue = request.getParameter("notify"); %>
                                    <td><input name="notify" type="checkbox" value="YES" 
                                               <%= (notifyValue == null ? "" : "checked") %> /></td>
                                </tr>
                                <tr>
                                    <td colspan="2">
                                        <input type="submit"/>
                                    </td>
                                </tr>
                            </table>
                        </form>
                    </div>
                </td>
            </tr>    

            <tr>
                <td width='160'>
                </td>
                <td align='right' width='480'>
                    <jsp:include page="/WEB-INF/views/common/copyright.jsp" />
                </td>
            </tr>
        </table>
    </body>
</html>