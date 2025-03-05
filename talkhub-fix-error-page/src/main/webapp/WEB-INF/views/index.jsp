<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>TalkHub</title>
</head>
<body>
<h1><a href="${pageContext.request.contextPath}/index">TalkHub</a></h1>
<c:choose>
    <c:when test="${authentication}">
        <div>
            <a href="${pageContext.request.contextPath}">마이페이지</a>
            <a href="${pageContext.request.contextPath}/logout-proceed">로그아웃</a>
        </div>
    </c:when>
    <c:otherwise>
        <div>
            <a href="${pageContext.request.contextPath}/login">로그인</a>
            <a href="${pageContext.request.contextPath}/join">회원가입</a>
        </div>
    </c:otherwise>
</c:choose>
<p>
    TalkHub 에 오신것을 환영합니다람쥐
</p>
</body>
</html>
