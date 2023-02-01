<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Usuarios</title>
    </head>
    <body>
        <h1>Listado de Usuarios</h1>
        <ul>
            <c:forEach items="${usuarios}" var="usuario">
                <li><a href="${usuario.idUsuario}"> ${usuario.idUsuario} ${usuario.clave}</a> </li>
            </c:forEach>
        </ul>
    </body>
</html>