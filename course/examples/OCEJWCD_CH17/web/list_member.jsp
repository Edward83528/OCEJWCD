<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="net.hello.dao.MemberDAOImpl" %>
<%@page import="net.hello.domain.Member" %>
<%@page import="java.util.List" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Member</title>
    </head>
    <body>
        <h1>List Member</h1>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Birthdate</th>
                <th>Bonus</th>
            </tr>
            
            <%
                MemberDAOImpl dao = new MemberDAOImpl();
                List<Member> members = dao.getAllMember();
            
            
                for (Member member : members) {
            %>
                    <tr>
                        <td><%= member.getId() %></td>
                        <td><%= member.getFirstName() %></td>
                        <td><%= member.getLastName() %></td>
                        <td><%= member.getBirthDate() %></td>
                        <td><%= member.getBonus() %></td>
                    </tr>
            <%
                }
            %>
        </table>
        <p><a href="index.html">Home</a></p>
    </body>
</html>
