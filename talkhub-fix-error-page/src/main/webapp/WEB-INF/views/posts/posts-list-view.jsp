<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 25. 3. 6.
  Time: 오후 5:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TalkHub</title>
</head>
<body>
<h1><a href="${pageContext.request.contextPath}/index">TalkHub</a></h1>
<h2>[${posts.category}] ${posts.title}</h2>
<div>${posts.writerId}</div>
<div>${posts.writedAt}</div>
<p>
    ${posts.content}
</p>
<div style="color: gray">
    조회수 : ${posts.views}
    <form action="${pageContext.request.contextPath}/posts-like-proceed">
        <button type="submit" value="${posts.id}" name="id">좋아요</button><span> : ${posts.likes}</span>
    </form>
</div>
</body>
</html>
