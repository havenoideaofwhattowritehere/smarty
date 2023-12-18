<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>User Page</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>User ID</th>
                    <th>User login</th>
                    <th>Subscription Ids</th>
                    <th>Followers Ids</th>
                    <th>Liked Posts Ids</th>
                    <th>Comment Ids</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.userId}</td>
                        <td>${user.login}</td>
                        <td>${user.subscriptionIds}</td>
                        <td>${user.followersIds}</td>
                        <td>${user.likedPostsIds}</td>
                        <c:forEach items="${user.commentIds}" var="commentId">
                            <td>${commentId}</td>
                        </c:forEach>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>