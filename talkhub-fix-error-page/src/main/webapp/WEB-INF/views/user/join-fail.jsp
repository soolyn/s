<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>TalkHub</title>
</head>
<body>
<h1><a href="${pageContext.request.contextPath}/index">TalkHub</a></h1>
<h2>토크허브에 회원가입하기</h2>
<form action="${pageContext.request.contextPath}/join-proceed"method="post">
    <p>
        <label>아이디</label>
        <div>
            <input type="text" name="id">
        </div>
    </p>
    <p style="color: red; font-size: small">${idError}</p>
    <p>
        <label>비밀번호</label>
    <div>
        <input type="password" name="password">
    </div>${passError}
    </p>
    <p style="color: red; font-size: small">${passError}</p>
    <p>
        <label>닉네임</label>

    <div>
        <input type="text" name="nickname">
    </div>
    <p style="color: red; font-size: small">${nickError}</p>
    </p>
    <p>
        <label>성별</label>
    <div>
        <label><input type="radio" value="남" name="gender"/>남</label>
        <label><input type="radio" value="여" name="gender"/>여</label>
        <label><input type="radio" value="비공개" name="gender" checked/>비공개</label>
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
