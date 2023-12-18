<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Comment Page</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Comment ID</th>
                    <th>Post ID</th>
                    <th>Author ID</th>
                    <th>Comment Text</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${comment}" var="comment">
                    <tr>
                        <td>${comment.commentId}</td>
                        <td>${comment.postId}</td>
                        <td>${comment.user.userId}</td>
                        <td>${comment.text}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>