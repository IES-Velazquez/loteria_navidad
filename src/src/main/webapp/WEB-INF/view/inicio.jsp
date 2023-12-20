<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <script src="js/app.js"></script>
    <title>Loteria Navidad</title>
    <link href="/css/style.css" type="text/css" rel="stylesheet">
</head>
<body>
<h1>Resultados de la loteria de navidad
</h1>
<form method="post">
    <label>Usuario<input type="text" name="usuario" id="usuario"></label>
    <label>Password<input type="password" name="pass", id="pass"></label>
</form>
<div>
    <a href="${pageContext.request.contextPath}/RegisterServlet">No te has reguistrado aún</a>
</div>
</body>
</html>