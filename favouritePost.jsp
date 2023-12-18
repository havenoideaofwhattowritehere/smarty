<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Favourite Post Page</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Favourite post ID</th>
                    <th>Text</th>
                    <th>Author ID</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${favouritePost}" var="favouritePost">
                    <tr>
                        <td>${favouritePost.postId}</td>
                        <td>${favouritePost.text}</td>
                        <td>${favouritePost.user.userId}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>