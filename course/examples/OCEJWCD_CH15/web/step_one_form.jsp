<%@ page import="java.util.List" %>
<html>
    <head>
        <title>Step One</title>
        <meta charset="UTF-8">
    </head>
    <body>
        <h1>Step One</h1>

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
        
        <form action="step_one.do" method="POST">
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
                    <td colspan="2">
                        <input type="submit" value="Next"/>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
