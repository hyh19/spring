<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="easy" tagdir="/WEB-INF/tags" %>
Today's date:
<br/>
<easy:varDemo>
    In long format: ${longDate}
    <br/>
    In short format: ${shortDate}
</easy:varDemo>