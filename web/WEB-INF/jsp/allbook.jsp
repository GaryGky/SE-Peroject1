<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍列表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
                    <small>书籍列表</small>
                </h1>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-3 column">
            <a class="btn btn-primary"
               href="${pageContext.request.contextPath}/book/jumpToadd">委托书籍</a>
            <a class="btn btn-primary"
               href="${pageContext.request.contextPath}/book/allbook">显示图书馆全部书籍
            </a>
        </div>

        <div class="col-md-5 column">
            <form
                    action="${pageContext.request.contextPath}/stu/queryBookByStu"
                    class="form-inline" method="post"
                    style="float: right">
                    <span style="color: red;font-weight:
                                        bold">${error1}</span>
                <input type="number" class="form-control" placeholder="请输入要查询的学号"
                       name="stu_id" required>
                <input type="submit" value="查询已借书籍" class="btn btn-primary">
            </form>
        </div>

        <div class="col-md-4 column">
            <form action="${pageContext.request.contextPath}/book/queryBook"
                  class="form-inline" method="post"
                  style="float: right">
                    <span style="color: red;font-weight:
                                        bold">${error}</span>
                <input type="text" class="form-control"
                       placeholder="请输入要查询的书籍" name="queryBookName" required>
                <input type="submit" value="查询书籍" class="btn btn-primary">
            </form>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>书籍编号</th>
                    <th>书籍名字</th>
                    <th>书籍数量</th>
                    <th>书籍详情</th>
                    <th></th>
                    <th>操作</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach var="book" items="${requestScope.get('list')}">
                    <tr>
                        <td>${book.getBook_id()}</td>
                        <td>${book.getBkName()}</td>
                        <td>${book.getBkCount()}</td>
                        <td>${book.getDescription()}</td>
                        <td></td>
                        <td>
                            <a class="btn btn-primary" style="display: none;"
                               href="${pageContext.request.contextPath}/book/jumpToUpdate?book_id=${book.getBook_id()}">更改</a>
                            <a href="${pageContext.request.contextPath}/book/delete?book_id=${book.getBook_id()}"
                               class="btn btn-primary"
                               style="display: none;">删除</a>
                            <a class="btn btn-primary"
                               href="${pageContext.request.contextPath}/stu/gotoborrowbook?book_id=${book.getBook_id()}">
                                借书</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
