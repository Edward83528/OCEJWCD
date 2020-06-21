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
                    <td>First Name</td>
                    <td><input name="firstName" type="text" 
                               value="${param.firstName}"/></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><input name="lastName" type="text" 
                               value="${param.lastName}"/></td>
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
