<%--
  Created by IntelliJ IDEA.
  User: LAPTOP CU PHO YEN
  Date: 5/28/2023
  Time: 9:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="/product?choice=createFrom">Add New User</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>price</th>
            <th>weight</th>
            <th>unit</th>
            <th>right_alway</th>
        </tr>
        <c:forEach var="product" items="${list}">
            <tr>
                <td><c:out value="${product.p_id}"/></td>
                <td><c:out value="${product.p_name}"/></td>
                <td><c:out value="${product.p_price}"/></td>
                <td><c:out value="${product.p_weight}"/></td>
                <td><c:out value="${product.unit}"/></td>
                <td><c:out value="${product.right_alway}"/></td>

                <td>
                    <a href="/product?choice=edit&id=${product.p_id}">Edit</a>
                    <a href="/product?choice=delete&id=${product.p_id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<form method="post" action="/product?choice=find">
    <label>
        <input type="text" name="name" placeholder="enter you nameProduct" size="45">
    </label>
    <button type="submit">Search</button>

</form>
</body>
</html>
