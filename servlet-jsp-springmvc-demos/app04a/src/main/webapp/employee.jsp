<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--加上这一句代码表达式语言才会被解析--%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
accept-language: ${header['accept-language']}
<br/>
session id: ${pageContext.session.id}
<br/>
employee: ${requestScope.employee.name}, ${employee.address.city}
<br/>
capital: ${capitals["Canada"]}
</body>
</html>
