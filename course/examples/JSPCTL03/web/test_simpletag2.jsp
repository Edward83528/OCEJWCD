<%@page import="java.util.*" %>
<%@taglib prefix="mst" uri="http://macspeed.net/jsp/ctl/mysimpletag" %>
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
        <mst:mySimpleListTag items="${items}" />
    </body>
</html>
