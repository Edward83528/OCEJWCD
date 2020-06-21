<%@ page import="java.util.List" %>
<html>
    <head>
        <title>Step Two</title>
        <meta charset="UTF-8">
    </head>
    <body>
        <h1>Step Two</h1>

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
        
        <form action="step_two.do" method="POST">
            <table bgcolor="#D0D0D0">
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
    </body>
</html>
