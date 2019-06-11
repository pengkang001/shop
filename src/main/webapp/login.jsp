<%--
  Created by IntelliJ IDEA.
  User: pengkang
  Date: 2019/5/8
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆页面</title>
    <% request.getSession().setAttribute("token","token"); %>
</head>
<body>
    <form action = "/login" method="post" >
        用户名<input name="username" style="width:80px" /><br/>
        密码<input name="password" style="width:80px" /><br/>
        <input type="submit" style="width:50px"  value="登陆"/><br/>
    </form>
    <div>${msg}</div>
</body>
</html>
