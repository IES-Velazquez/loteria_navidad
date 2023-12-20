<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <script src="js/app.js"></script>
    <title>Loteria Navidad - Registro</title>
    <jsp:include page="../include/bootstrap.jsp"/>

</head>
<body>
<h1>Resultados de la loteria de navidad
</h1>



<div class="container" id="results">
    <div class="row justify-content-center mt-5">
        <div class="col-6">
            <form action="" metod="post">

                <h2>Registro</h2>

                <label for="nombre" class="form-label mt-3">Nombre</label>
                <input type="text" class="form-control" id="nombre" name="nombre" required >

                <label for="usuario" class="form-label mt-3">Usuario</label>
                <input type="text" class="form-control" id="usuario" name="usuario" required >

                <label for="password" class="form-label mt-3">Password</label>
                <input type="password" class="form-control" id="password" name="password" required>


                <input type="submit" class="btn btn-primary w-100 mt-3" value="ATRAS" />

                <input type="submit" class="btn btn-primary w-100 mt-3" value="REGISTRAR" />

            </form>
        </div>
    </div>
</div>

</body>
</html>