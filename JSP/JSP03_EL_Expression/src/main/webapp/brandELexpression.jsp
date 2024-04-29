<%--
  Created by IntelliJ IDEA.
  User: 30912
  Date: 2023/2/25
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <%--
    以前我们这里要写一大堆那三种标签截断的代码，现在使用EL表达式不需要那么做了只要写下面一句EL表达式即可，数据处理在Servlet中完成了。
    简化了JSP中 从数据库查询到的数据后的封装操作 的代码。
    但是没有 简化数据通过循环使用html展示出来 的代码。
    后面会在将JSTL标签库会简化 数据通过循环使用html展示出来 的代码
    --%>
    ${brands}
</body>
</html>