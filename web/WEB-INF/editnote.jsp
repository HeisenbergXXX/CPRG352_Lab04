<%--
  Created by IntelliJ IDEA.
  User: Bennett
  Date: 29-Sep-22
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Note - JSP</title>
</head>
<body>
<div><h1>Simple Note Keeper</h1></div>
<div><h2>Edit Note</h2></div>
    <form action="note" method="post">
        <div><b>Title: </b><input type="text" name="title" value="${note.title}"></div>
        <div><b>Contents: </b><textarea name="contents" rows="10" cols="50">${note.contents}</textarea></div>
        <br>
        <input type="submit" value="Save"/>
    </form>
        <c:if test="${error}">
            <p>Please fill in both title and contents!</p>
        </c:if>
</body>
</html>
