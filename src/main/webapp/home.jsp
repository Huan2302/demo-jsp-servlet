<%@ page import="java.util.List" %>
<%@ page import="com.example.model.BookModel" %><%--
  Created by IntelliJ IDEA.
  User: nals_macbook_284
  Date: 11/06/2022
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1px">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Category</th>
    </tr>
    <%
        List<BookModel> list = (List<BookModel>) request.getAttribute("listBook");
        if (list != null) {
            for (BookModel item : list) {
    %>
    <tr>
        <td><%=item.getId()%>
        </td>
        <td><%=item.getName()%>
        </td>
        <td><%=item.getCategory().getName()%>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>
<a href="<%=request.getContextPath()%>/add-book">add book</a><br>
<a href="<%=request.getContextPath()%>/category">list category</a>
</body>
</html>
