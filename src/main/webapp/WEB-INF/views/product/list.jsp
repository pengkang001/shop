<%--
  Created by IntelliJ IDEA.
  User: pengkang
  Date: 2019/5/8
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>列表页面</title>
    <script>
        function goPage(pageNum){
            document.getElementById("goPage").value = pageNum;
            document.getElementById("form1").submit();
        }
    </script>
</head>
<body>

<form  id = "form1" action="/product?cmd=list" method="post">
    关键字<input name="key" value="${qo.key}" style="width: 50px"/>&nbsp&nbsp
    最低价 <input name="min" value="${qo.min}" style="width: 50px"/>&nbsp&nbsp
    最高价<input name="max" value="${qo.max}" style="width: 50px"/>&nbsp&nbsp
    是否有货<select name="isEmpty">
        <option></option>
        <option value="false" ${qo.isEmpty == false ? 'selected':''}>有货</option>
        <option value="true" ${qo.isEmpty == true ? 'selected':''}> 无货</option>
    </select>&nbsp&nbsp
    商品种类<select name="dirId">
        <option></option>
        <option value="1" ${qo.dirId == 1 ? 'selected':''}>鼠标</option>
        <option value="2" ${qo.dirId == 2 ? 'selected':''}>键盘</option>
    </select>&nbsp&nbsp
    <input type="submit" value="提交查询" style="width: 80px"><br/>

    <a href="/product?cmd=edit">新增记录 </a>
    <table border="1" width="70%">
        <thead>
        <tr>
            <th>商品名称</th>
            <th>商品售价</th>
            <th>商品库存</th>
            <th>商品类型</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${products}" var="product">
            <tr>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>${product.account}</td>
                <td>
                    <c:choose>
                        <c:when test="${product.dirId==1}">无线鼠标</c:when>
                        <c:when test="${product.dirId==2}">有线鼠标</c:when>
                        <c:when test="${product.dirId==3}">游戏鼠标</c:when>
                    </c:choose>
                </td>
                <td><a href="/product?cmd=edit&id=${product.id}">编辑 </a>|<a
                        href="/product?cmd=delete&id=${product.id}">删除 </a></td>
            </tr>
        </c:forEach>
        </tbody>
        <tfoot>
            <tr>
                <td colspan="6">
                    <a href="javaScript:goPage(1)">首页 </a>&nbsp;&nbsp;
                    <a href="javaScript:goPage(${pageResult.prevPage})">上一页 </a>&nbsp;&nbsp;
                    当前为${pageResult.currentPage}页
                    一共${pageResult.totalPage}页
                    一共${pageResult.totalCount}条
                    <a href="javaScript:goPage(${pageResult.nextPage})">下一页 </a>&nbsp;&nbsp;
                    <a href="javaScript:goPage(${pageResult.totalPage})">末页 </a>&nbsp;&nbsp;
                    每页显示<input name="pageSize" style="width: 50px"/>条&nbsp;&nbsp;
                    跳转至<input id = "goPage" name="currentPage" style="width: 50px"/>页&nbsp;&nbsp;
                </td>
            </tr>

        </tfoot>
    </table>
</form>

</body>
</html>
