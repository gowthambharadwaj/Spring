<%--
  Created by IntelliJ IDEA.
  User: gowth
  Date: 2/6/2021
  Time: 6:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.learning.util.Mapping" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>My Tasks</title>
</head>
<body>
<caption><h2>Things to-do</h2></caption>
<div align="center">
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th>Title</th>
            <th>Deadline</th>
            <th>View</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <c:forEach var="item" items="${todoData.items}">

            <c:url var="viewUrl" value="${Mapping.VIEW_ITEM}">
                <c:param name="id" value="${item.id}"/>
            </c:url>

            <c:url var="editUrl" value="${Mapping.ADD_ITEM}">
                <c:param name="id" value="${item.id}"/>
            </c:url>

            <c:url var="deleteUrl" value="${Mapping.DELETE_ITEM}">
                <c:param name="id" value="${item.id}"/>
            </c:url>

            <tr>
                <td><c:out value="${item.title}"/></td>
                <td><c:out value="${item.deadline}"/></td>
                <td><a href="${viewUrl}">View</a></td>
                <td><a href="${editUrl}">Edit</a></td>
                <td><a href="${deleteUrl}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <c:url var="addUrl" value="${Mapping.ADD_ITEM}"/>
    <a href="${addUrl}">Add a new task</a>
</div>
</body>
</html>
