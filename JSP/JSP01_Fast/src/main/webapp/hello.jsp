<%--
  Created by IntelliJ IDEA.
  User: 30912
  Date: 2023/2/25
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>hello</h1>

    <%--标签<%    %>中的java代码叫做脚本，<%    %>中的内容，将来Tomcat会自动放到方法中--%>
    <%
        System.out.println("hello jsp~");
        int i=1024;
    %>

    <%--标签<%=    %>中的内容将来Tomcat会自动放到System.out.print()中--%>
    <%="hello"%>
    <%= i %>

    <%--标签<%!    %>中的内容将来Tomcat会自动放到一个类中--%>
    <%!
        String name;
        void show(){};
    %>

</body>
</html>
