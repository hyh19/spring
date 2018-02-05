<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    public String getTodaysDate() {
        return new java.util.Date().toString();
    }
%>
<html>
<head>
    <title>Declarations</title>
</head>
<body>
Today is <%=getTodaysDate()%>
</body>
</html>
