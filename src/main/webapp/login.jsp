<%--
  Created by IntelliJ IDEA.
  User: dx
  Date: 2018/8/13
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<div class="container" align="center">
    <form class="form-horizontal"
          action="<%=request.getContextPath()%>/login.action" method="post">
        <div class="form-group">
            <label for="inputUsername" class="col-sm-2 control-label">用户名:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputUsername"
                       placeholder="请输入用户名" name="loginName">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">登陆</button>
            </div>
        </div>
        <p style="color: red">${requestScope.loginError}</p>
    </form>
</div>
</body>
</html>
