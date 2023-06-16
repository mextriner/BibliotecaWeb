<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <jsp:include page="includes/head.jsp"/>
    <head>
        <title>Préstamos
        </title>
    </head>
    <jsp:include page="includes/navbar.jsp"/>
    <section>
        <h1>BIENVENIDO: </h1>

        <div class="row d-flex justify-content-center px-5">
            

                <!--Comenzamos a mostrar los datos-->
                <h2>Listado de PRÉSTAMOS <a class="text-dark" href="usuarioPdf.php"><i class="fa-solid fa-file-circle-plus"></i></a></h2>
                
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
                            <td style="border: solid black 2px;">${prestamo.getFecha()}</td>
                            <td style="border: solid black 2px;">${prestamo.getUnidadidUnidad().getIdUnidad()}</td>
                            <td style="border: solid black 2px;">${prestamo.getUsuarioidUsuario().getIdUsuario()}</td>
                            <c:choose>
                                <c:when test="${prestamo.getFechaEntrega()!=null}">
                                    <td style="border: solid black 2px;">${prestamo.getFechaEntrega()}</td>

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

                
            

    </section>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</html>