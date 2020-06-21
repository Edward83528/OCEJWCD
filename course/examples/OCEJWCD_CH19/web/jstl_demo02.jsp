<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="title" value="JSTL Demo 02" />

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${title}</title>
    </head>
    <body>
        <h1>${title}</h1>
        
        <jsp:useBean id="now" class="java.util.Date" />
        
        <fmt:requestEncoding value="UTF-8" />
        
        <h2>fmt:formatDate - date</h2>
        Date: <fmt:formatDate value="${now}" type="date" pattern="yyyy-MM-dd"/><br/>
        Date full: <fmt:formatDate value="${now}" type="date" dateStyle="full"/><br/>
        Date long: <fmt:formatDate value="${now}" type="date" dateStyle="long"/><br/>
        Date short: <fmt:formatDate value="${now}" type="date" dateStyle="short"/><br/>
        <br/>
        
        <h2>fmt:formatDate - time</h2>
        Time full: <fmt:formatDate value="${now}" type="time" timeStyle="full"/><br/>
        Time long: <fmt:formatDate value="${now}" type="time" timeStyle="long"/><br/>
        Time short: <fmt:formatDate value="${now}" type="time" timeStyle="short"/><br/>
        <br/>
        
        <h2>fmt:parseDate</h2>
        <fmt:parseDate var="birthdate" value="2000/01/05" pattern="yyyy/MM/dd" />
        Parse date: ${birthdate}<br/>
        <br/>
        
        <h2>fmt:setBundle and fmt:message</h2>
        <fmt:setBundle basename="net.hello.resources.Messages" />
        Message title: <fmt:message key="title"/><br/>
        Message greeting: <fmt:message key="greeting"/><br/>
        
        <fmt:bundle basename="net.hello.resources.Messages2">
            Message2 title: <fmt:message key="title"/><br/>
            Message2 greeting: <fmt:message key="greeting"/><br/>
        </fmt:bundle>
            
        <fmt:message key="greeting2">
            <fmt:param value="Simon"/>
            <fmt:param value="${now}"/>
            <fmt:param value="${now}"/>
        </fmt:message>
            
        <p><a href="https://docs.oracle.com/javase/7/docs/api/java/text/MessageFormat.html">java.text.MessageFormat</a></p>
        
        <h2>functions</h2>
        <c:set var="name" value="Simon Johnson" />
        
        Length: ${fn:length(name)}<br/>
        UpperCase: ${fn:toUpperCase(name)}<br/>
        LowerCase: ${fn:toLowerCase(name)}<br/>
        
        <c:forEach items="${fn:split(name, ' ')}" var="item" varStatus="c">
            ${c.index} : ${item}<br>
        </c:forEach>
            
    </body>
</html>
