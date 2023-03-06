<%--
  Created by IntelliJ IDEA.
  User: macbook
  Date: 5/3/23
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UPDATE PERSON</title>
    <style><%@include file="/WEB-INF/views/css/form.css"%></style>
</head>
<body>
<h2>Update Person</h2>
<form action="/real/update/${person.id}" method="post">
    <label>Name:</label><input value="${person.name}" type="text" name="name">
    <label>age:</label><input value="${person.age}" type="text" name="age">
    <input type="submit" value="update-person">
</form>
</body>
</html>
