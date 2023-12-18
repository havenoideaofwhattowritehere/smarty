<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>User feed Page</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>User ID</th>
                    <th>User login</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.userId}</td>
                        <td>${user.login}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>