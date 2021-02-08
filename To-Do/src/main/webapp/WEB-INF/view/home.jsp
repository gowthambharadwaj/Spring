<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gowth
  Date: 2/7/2021
  Time: 12:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.learning.util.Mapping" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Add Item</title>
    <title>To-Do List</title>
</head>
<body>

<div align="center">
    <h2>
        <p>
            Welcome to your Task Manager.
        </p>
    </h2>
    <h3><p>
        This is a new way to keep track of important things that you need to do. This is a Java - Spring Boot
        application developed to ease out the burden of managing your time.
    </p>
    </h3>
</div>
<div align="center">
    <c:url var="itemsLink" value="${Mapping.ITEMS}"/>
    <h2><a href="${itemsLink}">Show Todo Items</a></h2>
</div>
</body>

</html>
