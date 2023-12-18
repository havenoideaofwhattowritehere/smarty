<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Posts liked by user Page</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>liked post ID</th>
                    <th>Text</th>
                    <th>Author ID</th>
                    <th>Comments</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${likedPosts}" var="likedPost">
                    <tr>
                        <td>${likedPost.postId}</td>
                        <td>${likedPost.text}</td>
                        <td>${likedPost.user.userId}</td>
                        <c:forEach items="${likedPost.comments}" var="comment">
                        <tr>
                            <td>${comment.text}</td>
                        </tr>
                        </c:forEach>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>