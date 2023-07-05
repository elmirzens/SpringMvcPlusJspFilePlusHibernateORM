<%--
  Created by IntelliJ IDEA.
  User: macbook
  Date: 5/3/23
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <style>
        <%@include file="/WEB-INF/views/css/table.css" %>
    </style>
    <style>
        <%@include file="/WEB-INF/views/css/form.css" %>
    </style>
</head>
<body>
<h1 class="jv">My List</h1>
<table>
    <thead>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>age</th>
        <th>delete</th>
        <th>update</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${all}" var="person">
        <tr>
            <td>${person.id}</td>
            <td>
                <a href="/get/by/${person.id}">${person.name}</a>
            </td>
            <td>${person.age}</td>
            <td>
                <form action="/deleteStudent/${person.id}" method="get">
                    <button type="submit">DELETE</button>
                </form>
            </td>
            <td>
                <form action="/update/${person.id}" method="get">
                    <button type="submit">UPDATE</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/studentForm">add-student</a>
<br>
<a href="/clear">truncate</a>
</body>
</html>