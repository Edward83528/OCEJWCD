<%! 
    private String email = "service@google.com";

    public void jspInit() {
        ServletConfig config = getServletConfig();
        String emailIni = config.getInitParameter("email");
        if (emailIni != null) {
            email = emailIni;
        }
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>init_param</title>
    </head>
    <body>
        <h1>init_param</h1>
        <%-- EMail: <%= config.getInitParameter("email") %> --%>
        EMail: <%= email %>
    </body>
</html>
