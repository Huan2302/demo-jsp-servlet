<%@ page import="com.example.model.CategoryModel" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: nals_macbook_284
  Date: 14/06/2022
  Time: 00:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    String success = (String) request.getAttribute("success");
    if ( success != null) {
%>
    <p style="color: green"><%=success%></p>
<%
    }
%>

<%
    String fail = (String) request.getAttribute("fail");
    if ( fail != null) {
%>
<p style="color: red"><%=fail%></p>
<%
    }
%>
<table border="1px">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Sửa</th>
        <th>Xoa</th>
    </tr>
    <%
        List<CategoryModel> list = (List<CategoryModel>) request.getAttribute("list");
        for (CategoryModel item : list) {
    %>
    <tr>
        <td><%=item.getId()%>
        </td>
        <td><%=item.getName()%>
        </td>
        <td>
            <a href="<%=request.getContextPath()%>/edit-category?id=<%=item.getId()%>">Sửa</a>
        </td>
        <td>
            <a href="<%=request.getContextPath()%>/del-category?id=<%=item.getId()%>">Xóa</a>
        </td>
    </tr>
    <%
        }
    %>
</table>

<a href="<%=request.getContextPath()%>/add-category">add category</a><br>
<a href="<%=request.getContextPath()%>/home">list book</a>
</body>
</html>
