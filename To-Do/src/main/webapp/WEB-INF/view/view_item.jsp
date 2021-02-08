<%--
  Created by IntelliJ IDEA.
  User: gowth
  Date: 2/6/2021
  Time: 11:24 PM
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
    <title>View item</title>
</head>
<body>
<div align="center">
    <table class="table">
        <tr>
            <td><label>ID</label></td>
            <td>
                <c:out value="${todoItem.id}"/>
            </td>
        </tr>
        <tr>
            <td><label>Title</label></td>
            <td>
                <c:out value="${todoItem.title}"/>
            </td>
        </tr>
        <tr>
            <td><label>Deadline</label></td>
            <td>
                <c:out value="${todoItem.deadline}"/>
            </td>
        </tr>
        <tr>
            <td><label>Details</label></td>
            <td>
                <c:out value="${todoItem.details}"/>
            </td>
        </tr>
    </table>

    <c:url var="tableUrl" value="${Mapping.ITEMS}"/>
    <a href="${tableUrl}">Show Table</a>

</div>
</body>
</html>
