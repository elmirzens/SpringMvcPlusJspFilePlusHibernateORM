<%--
  Created by IntelliJ IDEA.
  User: macbook
  Date: 5/3/23
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>INSERT PERSON</title>
    <style>
        .jv{
            color: aqua;
        }
    </style>
</head>
<body>
<h1 class="jv">Save Student</h1>
<form action="/saveStudent" method="post">
    <label>Name:</label><input type="text" name="name">
    <label>age:</label><input type="text" name="age">
    <input type="submit" value="save-person">
</form>
</body>
</html>
