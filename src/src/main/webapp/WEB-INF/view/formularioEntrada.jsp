<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<fmt:setBundle basename="interface"/>--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
<%--    <jsp:include page="include/bootstrap.jsp"/>--%>
    <title>Main</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h1 style="color: white; background-color: #386641; text-align: center; padding: 2rem">LOTERIA DE NAVIDAD</h1>
<div class="container mt-5" id="cosa">
<%--    <jsp:include page="include/barra.jsp"/>--%>
    <div class="row justify-content-center mt-5">
        <div class="col-6">
            <!-- Solo saco el formulario de login si no tengo sesion -->
            <c:if test="${sessionScope.usuario==null}">
                <form method="post">
                    <input
                            type="text" class="form-control" id="usuario" name="usuario"
                            placeholder="<fmt:message key="userTag"/>"
                            required>
                    <br>
                    <input type="pass" class="form-control" id="pass"
                           name="pass" placeholder="<fmt:message key="pswdTag"/>" required>
                    <c:if test="${error!=null}">
                        <p class="text-danger text-small mt-3">${error}</p>
                    </c:if>
                    <div style="display: flex; justify-content: space-evenly; margin-top: 1rem">
                        <input type="submit" class="btn btn-primary w-30 mt-3"
                               style="background-color: #6A994E; border: 1px solid #6A994E;
                               border-radius: 0.75rem"
                               value="<fmt:message key = "enterTag"/>"/>

                        <a href="${pageContext.request.contextPath}/RegistroServlet"
                           style="color: white; text-decoration: none">
                            <button type="button" class="btn btn-primary w-30 mt-3"
                                    style="background-color: #6A994E; border: 1px solid #6A994E;
                                        border-radius: 0.75rem">
                                <fmt:message key="linkRegTag"/>
                            </button>
                        </a>
                    </div>
                </form>
            </c:if>
            <c:if test="${sessionScope.usuario!=null}">
                <img class=" img-fluid
                        " src="img/portada.jpg"/>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>