<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="errorHandler.jsp" %>
Deliberately throw an exception
<%
    Integer.parseInt("Throw me");
%>
