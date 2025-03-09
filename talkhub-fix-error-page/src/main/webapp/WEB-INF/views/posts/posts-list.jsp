<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 25. 3. 6.
  Time: 오후 5:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>TalkHub</title>
</head>
<body>
<h1><a href="${pageContext.request.contextPath}/index">TalkHub</a></h1>
<h2>게시판</h2>
<a href="${pageContext.request.contextPath}/posts-create">글쓰기</a>

<hr/>
    <c:forEach var="one" items="${posts}">
        <div>
                ${one.id}|
                    <a href="${pageContext.request.contextPath}/posts-list-view?id=${one.id}">
                        [<span style="color: gray">${one.category}]</span>${one.title}
                    </a>|
                        ${one.writerId}|
                        ${one.writedAt}|
                        조회수 : ${one.views}|
                        좋아요 : ${one.likes}
        </div>
        <hr>
    </c:forEach>
</body>
</html>
