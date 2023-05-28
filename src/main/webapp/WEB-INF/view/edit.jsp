<%--
  Created by IntelliJ IDEA.
  User: LAPTOP CU PHO YEN
  Date: 5/28/2023
  Time: 7:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit product</title>
</head>
<body>
<center>
  <h1>List product</h1>
  <h2>
    <a href="product?choice=users">List All Users</a>
  </h2>
</center>
<div align="center">
  <form method="post" action="/product?choice=edit">
    <table border="1" cellpadding="5">
      <caption>
        <h2>
          Edit Product
        </h2>
      </caption>
      <c:if test="${product != null}">
        <input type="hidden" name="id" value="<c:out value='${product.id}' />"/>
      </c:if>
      <tr>
        <th>Product Name:</th>
        <td>
          <input type="text" name="name" size="45"
                 value="<c:out value='${product.name}' />"
          />
        </td>
      </tr>
      <tr>
        <th>product price:</th>
        <td>
          <input type="text" name="price" size="45"
                 value="<c:out value='${product.price}' />"
          />
        </td>
      </tr>
      <tr>
        <th>Product weight</th>
        <td>
          <input type="text" name="weight" size="15"
                 value="<c:out value='${product.p_weight}' />"
          />
        </td>
      </tr>
       <tr>
        <th>Product unit</th>
        <td>
          <input type="text" name="unit" size="15"
                 value="<c:out value='${product.unit}' />"
          />
        </td>
      </tr>
      <tr>
        <th>Product unit</th>
        <td>
          <input type="text" name="unit" size="15"
                 value="<c:out value='${product.right_alway}' />"
          />
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
