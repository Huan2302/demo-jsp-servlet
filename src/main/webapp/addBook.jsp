<%@ page import="com.example.model.CategoryModel" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: nals_macbook_284
  Date: 11/06/2022
  Time: 22:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="" method="post">
    <lable>name:</lable>
    <input type="text" name="name"><br>
    <lable>category:</lable>
    <select name="category_id">
        <%
            List<CategoryModel> list = (List<CategoryModel>) request.getAttribute("listCategory");
            for (CategoryModel item : list) {
        %>
        <option value="<%=item.getId()%>"><%=item.getName()%></option>
        <%
            }
        %>
    </select>
    <br>
    <input type="submit">
</form>
</body>
</html>
