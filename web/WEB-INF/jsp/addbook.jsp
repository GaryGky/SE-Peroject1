<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/3/13
  Time: 9:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add-Book</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
          rel="stylesheet">
    <link rel="icon" href="https://v3.bootcss.com/favicon.ico">


</head>
<body>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>添加书籍</small>
                </h1>
            </div>
        </div>
    </div>

    <div class="row clearfix" style="height: 50px;">
        <div class="col-md-3 column">
            <a class="btn btn-primary"
               href="${pageContext.request.contextPath}/book/allbook">返回
            </a>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/book/addbook"
          method="post">
        <div class="form-group">
            <label for="bkName">书籍名称</label>
            <input type="text" name="bkName" class="form-control" id="bkName"
                   required>
        </div>
        <div class="form-group">
            <label for="bkCount">书籍数量</label>
            <input type="number" class="form-control" name="bkCount" id="bkCount"
                   required>
            <!--placeholder="Password"-->
        </div>
        <div class="form-group">
            <label for="description">书籍描述</label>
            <input type="text" class="form-control" name="description"
                   id="description"
                   required>
            <!--placeholder="Password"-->
        </div>
        <div class="form-group">
            <input type="submit" class="form-control" value="添加">
        </div>

    </form>
</div>
</body>
</html>
