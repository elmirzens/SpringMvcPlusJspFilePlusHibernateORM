<%--
  Created by IntelliJ IDEA.
  User: macbook
  Date: 5/3/23
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PERSON PROFILE</title>
    <style>
        <%@include file="/WEB-INF/views/css/table.css" %>
    </style>
    <style>
        <%@include file="/WEB-INF/views/css/form.css" %>
    </style>
</head>
<body>
<table border="1px">
    <thead>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>age</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${person.id}</td>
        <td>${person.name}</td>
        <td>${person.age}</td>
    </tr>
    </tbody>
</table>
<a href="/">roll-back</a>
</body>
</html>