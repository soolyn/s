<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>TolkHub</title>
</head>
<body>
<h1><a href="${pageContext.request.contextPath}/index">TalkHub</a></h1>
<h3>토크허브에 회원가입하기</h3>
<form action="${pageContext.request.contextPath}/join-proceed">
    <p>
        <label>아이디</label>
        <div>
            <input type="text" name="id">
        </div>
    </p>
    <p>
        <label>비밀번호</label>
    <div>
        <input type="password" name="password">
    </div>
    </p>
    <p>
        <label>닉네임</label>
    <div>
        <input type="text" name="nickname">
    </div>
    </p>
    <p>
        <label>성별</label>
    <div>
        <vabel><input type="radio" value="남" name="gender"/>남</vabel>
        <vabel><input type="radio" value="여" name="gender"/>여</vabel>
        <vabel><input type="radio" value="비공개" name="gender"/>비공개</vabel>
    </div>
    </p>
    <p>
        <label>출생연도</label>
    <div>
        <select name="birth">
            <c:forEach var="i" begin="1970" end="2025">
                <option value="${i}">${i}년</option>
            </c:forEach>
        </select>
    </div>
    </p>
    <button type="submit">회원가입</button>
</form>
</body>
</html>
