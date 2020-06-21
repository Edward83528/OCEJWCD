<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="title" value="JSTL Demo" />

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${title}</title>
    </head>
    <body>
        <h1>${title}</h1>
        
        <h2>c:forEach</h2>
        <c:forEach begin="1" end="10" varStatus="vs" >
            ${vs.index} : Hello!<br/>
        </c:forEach>
        
        <br/>
            
        <c:set var="names" value="Simon,Mary,John,Sam,Jo" />
        <c:forEach var="item" items="${names}" varStatus="vs"  >
            ${vs.count} : ${item}<br/>
        </c:forEach>
        
        <br/>
        
        <c:set var="amount" value="35" />
        
        <h2>c:choose</h2>
        <c:choose>
            <c:when test="${amount < 10}">
                Small than 10.<br/>
            </c:when>
            <c:when test="${amount >= 10 and amount <= 100}">
                Between 10 and 100.<br/>
            </c:when>
            <c:otherwise>
                Great than 100.<br/>
            </c:otherwise>
        </c:choose>
    </body>
</html>
