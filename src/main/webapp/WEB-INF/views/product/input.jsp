<%--
  Created by IntelliJ IDEA.
  User: pengkang
  Date: 2019/5/8
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>表单页面</title>
</head>
<body>
<form action="/product?cmd=update" method="post">
    <input name="id" type="hidden" value="${product.id}"
           style="width: 200px"/><br/>
    商品名称<input name="productName" value="${product.name}"
               style="width:
    200px"/><br/>
    商品售价<input name="salePrice" value="${product.price}"
               style="width: 200px"/><br/>
    商品存货<input name="account" value="${product.account}"
               style="width: 200px"/><br/>
    商品类型 <select name="dirId">
    <option></option>
    <option value="1" ${product.dirId == 1 ? 'selected':''}>无线鼠标</option>
    <option value="2" ${product.dirId == 2 ? 'selected':''}>有线鼠标</option>
    <option value="2" ${product.dirId == 3 ? 'selected':''}>游戏鼠标</option>
</select><br/>
    <input type="submit" value="提交表单"  style="width: 100px"/><br>

</form>

</body>
</html>
