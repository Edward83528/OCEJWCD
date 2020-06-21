<%@ attribute name="fontColor" required="false" rtexprvalue="true" %>
<%@tag body-content="tagdependent" %>

<table border="0" width="60%" bgcolor="#ffffcc">
    <tr><td>
    <font color="${fontColor}"><jsp:doBody/></font>
    </td></tr>
</table>
