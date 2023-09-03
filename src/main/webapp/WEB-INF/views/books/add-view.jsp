<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 03/09/2023
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add book</title>
</head>
<body>
<form:form method="post" modelAttribute="book">
  Title: <form:input path="title"/><br>
  Rating: <form:input path="rating"/><br>
  Description: <form:textarea path="description"/><br>
  Publisher: <form:select path="publisher.id" items="${publisherList}" itemLabel="name" itemValue="id"/><br>
  Author: <br>
  <form:button>Add</form:button>
</form:form>
</body>
</html>
