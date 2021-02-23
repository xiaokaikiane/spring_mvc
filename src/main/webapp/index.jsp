<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<a href="hello">hello world!</a>
<h1>requestMapping测试</h1>
<a herf="haha/hello1">test01-下载方法上的requestMapping</a>
<h1>requestMapping属性测试</h1>
<a href="/haha/handle">handle</a>
<form action="/haha/handle" method="post">
    <input type="submit"/>
</form>
<a href="/haha/handle01">handle01-测试params</a>
<a href="/haha/handle02">handle02-测试headers</a>
<h1>requestMapping--Ant风格的URL</h1>
<a href="/antTest01">精确请求地址-antTest01</a>
<a href="/user/admin">测试PathVariable</a>
</body>
</html>
