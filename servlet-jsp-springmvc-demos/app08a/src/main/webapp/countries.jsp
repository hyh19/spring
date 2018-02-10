<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Country List</title>
</head>
<body>
    We operate in these countries:
    <ul>
        <c:forEach items="${countries}" var="country">
            <li>${country.value}</li>
        </c:forEach>
    </ul>
</body>
</html>
