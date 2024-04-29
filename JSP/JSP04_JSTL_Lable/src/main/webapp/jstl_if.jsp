<%--
  Created by IntelliJ IDEA.
  User: 30912
  Date: 2023/2/25
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="sf" uri="http://java.sun.com/jsp/jstl/core" %><%--这一行需要写JSP的指令，类似于import导入，然后我们才能使用JSTL--%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<sf:if test="${status==1}">
    启用
</sf:if>
<sf:if test="${status==0}">
    禁用
</sf:if>
</body>
</html>
