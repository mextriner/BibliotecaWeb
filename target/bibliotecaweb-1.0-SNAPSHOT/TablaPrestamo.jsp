<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<%

    String media = request.getAttribute("media").toString();

%>


<html lang="en">

    <jsp:include page="includes/head.jsp"/>
    <head>
        <title>Préstamos
        </title>
    </head>
    <jsp:include page="includes/navbar.jsp"/>
    <body style = "margin-top:8rem">
        <h1>BIENVENIDO: </h1>

        <div class="row d-flex justify-content-center px-5 mb-5">


            <!--Comenzamos a mostrar los datos-->
            <h2>Listado de PRÉSTAMOS <a class="text-dark" href="usuarioPdf.php"><i class="fa-solid fa-file-circle-plus"></i></a></h2>
            <h3>Media de horas por préstamo: <%= media%> horas / préstamo</h3>
            <table>
                <tr>
                    <th>Fecha</th>
                    <th>Unidad</th>
                    <th>Usuario</th>
                    <th>Fecha de Entrega</th>
                    <th>Eliminar</th>
                    <th>Editar</th>
                </tr>
                <c:forEach items="${prestamos}" var="prestamo">
                    <tr>
                        <td style="border: solid black 2px;"><fmt:formatDate value="${prestamo.getFecha()}" pattern="dd-MM-yyyy HH:mm:ss"/></td>
                        <td style="border: solid black 2px;">${prestamo.getUnidadidUnidad().getIdUnidad()}</td>
                        <td style="border: solid black 2px;">${prestamo.getUsuarioidUsuario().getIdUsuario()}</td>
                        <c:choose>
                            <c:when test="${prestamo.getFechaEntrega()!=null}">
                                <td style="border: solid black 2px;"><fmt:formatDate value="${prestamo.getFechaEntrega()}" pattern="dd-MM-yyyy HH:mm:ss"/></td>


                            </c:when>
                            <c:otherwise>
                                <td style="border: solid black 2px;">Sin entregar</td>

                            </c:otherwise>
                        </c:choose>
                        <td style="border: solid black 2px;"><a class="text-danger" href=""><i class="fa-solid fa-trash"></i></a></td>
                        <td style="border: solid black 2px;"><a class="text-primary" href=""><i class="fa-solid fa-pen"></i></a></td>

                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
    <jsp:include page="includes/footer.jsp"/>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</html>