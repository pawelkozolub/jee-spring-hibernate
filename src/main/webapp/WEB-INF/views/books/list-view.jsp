<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 03/09/2023
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Books</title>
</head>
<body>

<div>
  <a href='<c:url value="/view/book/add"/>'>Add book</a>
</div>
<div>
  <table>
    <tr>
      <th>Id</th>
      <th>Title</th>
      <th>Rating</th>
      <th>Description</th>
      <th>Publisher</th>
      <th>Authors</th>
      <th>Actions</th>
    </tr>
    <c:forEach items="${books}" var="book">
      <tr>
        <td>${book.id}</td>
        <td>${book.title}</td>
        <td>${book.rating}</td>
        <td>${book.description}</td>
        <td>${book.publisher.name}</td>
        <td>
          <ul>
            <c:forEach items="${book.authors}" var="author">
              <li>${author.firstName} ${author.lastName}</li>
            </c:forEach>
          </ul>
        </td>
        <td></td>
      </tr>
    </c:forEach>
  </table>
</div>

</body>
</html>
