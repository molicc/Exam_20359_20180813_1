<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>FilmList</title>

    <!-- Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">
    <form class="form-inline" action="/AddFilmServlet.action" onsubmit="submit_insert()">
        <div class="form-group">
            <label for="title">title</label> <input type="text"
                                                    class="form-control" id="title" placeholder="请输入标题" name="title">
        </div>
        <div class="form-group">
            <label for="description">description</label> <input type="text"
                                                                class="form-control" id="description"
                                                                placeholder="请输入描述"
                                                                name="description">
        </div>
        <select name="language_id">
            <option value="1">English</option>
            <option value="2">Italian</option>
            <option value="3">Japanese</option>
            <option value="4">Mandarin</option>
            <option value="5">French</option>
            <option value="6">German</option>
        </select>
        <button type="submit" class="btn btn-default">添加</button>
    </form>
    <table class="table">
        <tr>
            <td align="center">电影ID</td>
            <td align="center">电影标题</td>
            <td align="center">电影描述</td>
            <td align="center">语种</td>
            <td align="center">
                选择修改语种
            </td>
            <td align="center">
                删除
            </td>
            <td align="center">
                修改
            </td>
        </tr>
        <c:forEach items="${films}" var="film">
            <form class="form-inline" action="/EditFilmServlet.action" onsubmit="submit_update()">
                <tr>
                    <input type="hidden" name="film_id" value="${film.film_id}">
                    <td align="center">${film.film_id}</td>
                    <td align="center"><input type="text"
                                              class="form-control"
                                              value=${film.title}
                                              name="title"></td>
                    <td align="center"><input type="text"
                                              class="form-control"
                                              value=${film.description}
                                              name="description"></td>
                    <td align="center">${film.language}</td>
                    <td align="center">
                        <select name="language_id">
                            <option value="1">English</option>
                            <option value="2">Italian</option>
                            <option value="3">Japanese</option>
                            <option value="4">Mandarin</option>
                            <option value="5">French</option>
                            <option value="6">German</option>
                        </select>
                    </td>
                    <td align="center">
                        <button type="button" class="btn btn-danger " onclick="drop(${film.film_id})">删除</button>
                    </td>
                    <td align="center">
                        <button type="submit" class="btn btn-primary ">修改</button>
                    </td>
                </tr>
            </form>

        </c:forEach>
    </table>
</div>

<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
    function drop(id) {
        var flag = confirm("确认要删除电影？")
        if (flag==true){
            window.location = "/DeleteFilmServlet.action?film_id=" + id;
        }
    }
    function submit_update() {
        return confirm("确认更新电影信息?");
    }
    function submit_insert() {
        return confirm("确认添加新电影?");
    }

</script>
</body>
</html>