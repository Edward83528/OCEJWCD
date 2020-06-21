<%! private static final String DEFAULT_NAME = "World"; %>
<html>
    <%
        String name = request.getParameter("name");

        if (name == null || name.length() == 0) {
            name = DEFAULT_NAME;
        }
    %>
    <body>
        Hello, <%= name %><br/>      
    </body>
</html>
