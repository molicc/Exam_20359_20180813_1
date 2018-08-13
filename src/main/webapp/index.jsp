<%--
  Created by IntelliJ IDEA.
  User: dx
  Date: 2018/7/21
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>首页</title>
    <link rel="stylesheet"
          href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
</head>
<body>

<div class="container" align="center">
    <a class="btn btn-default" href="<%=request.getContextPath()%>/login.jsp" role="button" style="margin: 50px;">登录</a>
    <a class="btn btn-default" href="<%=request.getContextPath()%>/filmlist.action" role="button"style="margin: 50px;">查看电影列表</a>
</div>
</body>
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script
        src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>
</html>
