<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/3/13
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎回家</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
          rel="stylesheet">
    <link rel="icon" href="https://v3.bootcss.com/favicon.ico">


</head>
<body>
<div class="container" style="position: relative;top: 100px;">
    <form action="${pageContext.request.contextPath}/goto/login" method="post">
        <div class="form-group">
            <label for="stu_id">学号</label>
            <input type="number" class="form-control" id="stu_id"
                   placeholder="stu_id" name="stu_id">
        </div>

        <div class="form-group">
            <label for="stu_name">姓名</label>
            <input type="text" class="form-control" id="stu_name"
                   name="stu_name"
                   placeholder="stu_name">
        </div>

        <div class="form-group">
            <label for="pwd">Password</label>
            <input type="password" class="form-control" id="pwd" name="pwd"
                   placeholder="pwd">
        </div>

        <button type="submit" class="btn btn-default">Register</button>
    </form>
</div>
</body>
</html>
