<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Usuarios</title>
    </head>
    <body>
        <h1>Listado de Editoriales</h1>
        <ul>
            <c:forEach items="${editoriales}" var="editorial">
                <li><a href="${editorial.idEditorial}"> ${editorial.nombre} ${editorial.direccion}</a> </li>
            </c:forEach>
        </ul>
    </body>
</html>