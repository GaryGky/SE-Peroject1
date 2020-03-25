<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="https://v3.bootcss.com/favicon.ico">
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
          rel="stylesheet">

    <title>Library</title>

    <style>
        body {
            background-image: url("https://pic.qyer.com/album/user/2130/73/Q0hWQh0EaU4/index/1360x900");
            background-repeat: round;
            background-attachment: scroll;
        }
    </style>
</head>

<body>
<div class="container">
    <div
            style="right: 70px;top: 200px; width: 400px;height: 300px;position: absolute;background-color:rgba(0, 0, 0, 0.548);opacity: 0.8;">
        <div style="height: 50px;">
                <span style="left: 20px;position: relative;font-size:large;
            font-weight: bold; color:aliceblue;">Login</span>
        </div>
        <div style="left: 10px;">
            <form action="${pageContext.request.contextPath}/user/login" method="post" class="form-horizontal"
                  style="left: 20px;position:
                relative;">
                    <span style="color: red;font-weight:
                                        bold">${error}</span>
                <div class="form-group">
                    <label for="userName" class="col-sm-2 control-label" style="color:aliceblue;">UserName</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" name="userName" id="userName"
                               placeholder="UserName">
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-2 control-label" style="color:aliceblue;">Password</label>
                    <div class="col-sm-8">
                        <input type="password" class="form-control" name="password" id="password"
                               placeholder="Password">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <div class="checkbox">
                            <input type="checkbox"> <span style="color:aliceblue;">Remember Me</span>
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-2">
                        <button type="submit" class="btn btn-default">Sign in
                        </button>
                    </div>

                    <div class="col-sm-offset-2 col-sm-3">
                        <a href="${pageContext.request.contextPath}/register">
                            <button type="button" class="btn btn-default">Register
                            </button>
                        </a>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

</body>

</html>