<%--
  Created by IntelliJ IDEA.
  User: 11316
  Date: 2021/2/23
  Time: 23:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>数据输出</title>
</head>
<body>
<h1>你好!</h1>
pageContext,${pageScope.msg}<br/>
request,${requestScope.msg}<br/>
session,${sessionScope.msg}<br/>
application,${applicationScope.msg}<br/>
</body>
</html>
