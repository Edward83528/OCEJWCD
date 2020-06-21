<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer</title>
    </head>
    <body>
        <table border='0' cellspacing='0' cellpadding='0' width='640'>
            <tr height='100'>
                <td bgcolor='#E0E0E0' align='center' valign='center' width='160' height='100'>
                    <img src="images/hello.png"/>
                </td>
                <td bgcolor='#E0E0E0' align='center' valign='center' width='480' height='100'>
                    <jsp:include page="/WEB-INF/views/common/banner.jsp">
                        <jsp:param name="subTitle" value="Welcome" />
                    </jsp:include>                    
                </td>
            </tr>

            <tr valign='top'>
                <td bgcolor='#E0E0E0' width='160' align='left'>
                    <jsp:include page="/WEB-INF/views/common/function.jsp" />
                </td>
                <td width='480' align='left'>
                    <div style='margin-top: 0.1in; margin-left: 0.1in;
                         margin-bottom: 0.1in; margin-right: 0.1in'>
                        <p>
                            Hello! OCEJWCD!
                        </p>
                    </div>
                </td>
            </tr>    

            <tr>
                <td width='160'>
                </td>
                <td align='right' width='480'>
                    <jsp:include page="/WEB-INF/views/common/copyright.jsp" />
                </td>
            </tr>
        </table>
    </body>
</html>
