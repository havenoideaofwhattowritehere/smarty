<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Posts Page</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Post ID</th>
                    <th>Text</th>
                    <th>Author ID</th>
                    <th>Comments</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${posts}" var="post">
                    <tr>
                        <td>${post.postId}</td>
                        <td>${post.text}</td>
                        <c:forEach items="${post.comments}" var="comment">
                            <tr>
                                <td>${comment.text}</td>
                            </tr>
                        </c:forEach>
                    </tr>
                </c>
            </tbody>
        </table>
    </body>
</html>