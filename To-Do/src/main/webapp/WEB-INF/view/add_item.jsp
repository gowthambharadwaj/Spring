<%--
  Created by IntelliJ IDEA.
  User: gowth
  Date: 2/6/2021
  Time: 11:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.learning.util.AttributeName" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Add Item</title>
</head>
<body>

<form:form method="POST" modelAttribute="${AttributeName.TODO_ITEM}">
    <div class="form-group">
        <table class="table">
            <tr>
                <td><label>ID</label></td>
                <td>
                    <form:input path="id" disabled="true"/>
                </td>
            </tr>
            <tr>
                <td><label>Title</label></td>
                <td><form:input path="title"/></td>
            </tr>
            <tr>
                <td><label>Deadline</label></td>
                <td><form:input path="deadline"/></td>
            </tr>
            <tr>
                <td><label >Details</label></td>
                <td><form:textarea path="details"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit"/></td>
            </tr>
        </table>
    </div>
</form:form>

</body>
</html>
