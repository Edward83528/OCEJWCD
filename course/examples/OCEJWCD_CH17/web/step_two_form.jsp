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
                    <td>Birthdate</td>
                    <td><input name="birthDate" type="text" 
                               value="${param.birthDate}"/></td>
                </tr>
                <tr>
                    <td>Bonus</td>
                    <td><input name="bonus" type="text"
                               value="${param.bonus}"/></td>
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
