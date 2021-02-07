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
    <title>Title</title>
</head>
<body>
<div align="center">

    <c:url var="addUrl" value="${Mapping.ADD_ITEM}"/>
    <a href="${addUrl}">New Item</a>

    <table border="1" cellpadding="5">
        <caption><h2> To Do Items</h2></caption>
        <tr>
            <th>Title</th>
            <th>Deadline</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach var="item" items="${toDoData.items}">
            <c:url var="editUrl" value="${Mapping.ADD_ITEM}">
                <c:param name="id" value="${item.id}"/>
            </c:url>
            <c:url var="deleteUrl" value="${Mapping.DELETE_ITEM}">
                <c:param name="id" value="${item.id}"/>
            </c:url>
            <tr>
                <td><c:out value="${item.title}"/></td>
                <td><c:out value="${item.deadline}"/></td>
                <td><a href="${editUrl}">Edit</a></td>
                <td><a href="${deleteUrl}">Delete</a></td>
            </tr>
        </c:forEach>

    </table>
</div>
</body>
</html>
