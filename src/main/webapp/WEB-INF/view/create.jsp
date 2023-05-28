<%--
  Created by IntelliJ IDEA.
  User: LAPTOP CU PHO YEN
  Date: 5/27/2023
  Time: 3:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Product</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="users?action=users">List All Users</a>
    </h2>
</center>
<div align="center">
    <form method="post" action="/product?choice=createProduct">
        <table border="1" cellpadding="5">
            <caption>
                <h2>ADD New Product</h2>
            </caption>
            <tr>
                <th>ProductName</th>
                <td>
                    <input type="text" name="p_name" id="p_name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Price:</th>
                <td>
                    <input type="text" name="p_price" id="p_price" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Weight:</th>
                <td>
                    <input type="text" name="p_weight" id="p_weight" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Unit:</th>
                <td>
                    <input type="text" name="unit" id="unit" size="15"/>
                </td>
            </tr>
              <tr>
                <th>right_alway:</th>
                <td>
                    <input type="text" name="right_alway" id="right_alway" size="25"/>
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>
