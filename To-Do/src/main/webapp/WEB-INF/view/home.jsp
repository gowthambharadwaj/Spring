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
    <title>To-Do List</title>
</head>
<body>
    <div>
        <c:url var="itemsLink" value="${Mapping.ITEMS}"/>
        <h2><a href="${itemsLink}">My To-Do list</a> </h2>
    </div>
</body>
</html>
