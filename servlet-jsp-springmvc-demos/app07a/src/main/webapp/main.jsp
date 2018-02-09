<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="easy" tagdir="/WEB-INF/tags" %>
<%--header 是 JSP 隐藏对象--%>
Your referer header: ${header.referer}
<br/>
<easy:doBodyDemo>
    ${header.referer}
</easy:doBodyDemo>
<a href="viewReferer.jsp">View</a> the referer as a Session attribute.