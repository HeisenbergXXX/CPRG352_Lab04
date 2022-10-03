<%--
  Created by IntelliJ IDEA.
  User: Bennett
  Date: 29-Sep-22
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>viewnote JSP</title>
</head>
<body>
<div><h1>Simple Note Keeper</h1></div>
<div><h2>View Note</h2></div>
<div>
        <div>
            <b>Title: </b>${note.title}
        </div>
        <div>
        <br>
            <b>Contents: </b><br>${note.contents}
        </div>
        <br>
        <a href="note?edit">Edit</a>
</div>

</body>
</html>
