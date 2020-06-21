<%@page import="java.util.*" %>
<%@taglib prefix="mst" uri="http://macspeed.net/jsp/ctl/myclassictag" %>

<%
    List items = new ArrayList();

    items.add("One");
    items.add("Two");
    items.add("Three");
    items.add("Four");
    items.add("Five");

    request.setAttribute("items", items);
%>
<html>
    <body>
        <mst:myClassicListTag items="${items}" />
    </body>
</html>
