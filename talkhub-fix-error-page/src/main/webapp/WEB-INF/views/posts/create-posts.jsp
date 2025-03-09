<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 25. 3. 6.
  Time: 오후 4:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TalkHub</title>
    <style>
        body{
            text-align: center;
        }
    </style>
</head>
<body>
<h1><a href="${pageContext.request.contextPath}/index">TalkHub</a></h1>
<h2>TalkHub 글쓰기</h2>

<form action="${pageContext.request.contextPath}//post-create-proceed">
    <div>
        아이디를 입력해 주세요
        <div>
            <input type="text" name="writerId">
        </div>
    </div>
    <div>
        카테고리를 입력해주세요
        <div>
            <input type="text" name="category">
        </div>
    </div>
    <div>
        제목을 입력해주세요
        <div>
            <input type="text" name="title">
        </div>
    </div>
    <div>
        내용을 입력하세요
        <div>
            <input type="text" name="content">
        </div>
    </div>
    <button type="submit">등록</button>
</form>
</body>
</html>
