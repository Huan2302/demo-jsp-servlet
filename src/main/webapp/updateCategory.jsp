<%@ page import="com.example.model.CategoryModel" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: nals_macbook_284
  Date: 15/06/2022
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="" method="post">
  <lable>name:</lable><input type="text" value="<%=request.getAttribute("nameold")%>" name="name"><br>
  <input type="submit">
</form>
</body>
</html>
