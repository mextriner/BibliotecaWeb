
<%@page import="java.util.concurrent.TimeUnit"%>
<%@page import="java.util.Date"%>
<%@page import="java.lang.Math"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.maximo.Dominio.Usuario"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String user = "";
    HttpSession sesion = request.getSession();

    if (sesion.getAttribute("usuario") != null) {
        user = (String) sesion.getAttribute("usuario");
    } else {
        response.sendRedirect("inicioSesion.jsp");
    }
    Usuario usuario = (Usuario) request.getAttribute("usuario");
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    long diff = TimeUnit.DAYS.convert(Math.abs(usuario.getFechaNac().getTime() - (new Date()).getTime()), TimeUnit.MILLISECONDS);
    long years = diff / 365;
%>
<!DOCTYPE html>
<html lang="en">

    <jsp:include page="includes/head.jsp"/>
    <head>
        <title> Usuario: <%= usuario.getNombre()%>
        </title>

    </head>
    <body style = "margin-top:8rem">
        <jsp:include page="includes/navbar.jsp"/>


        <!-- INFO DE MI CUENTA -->
        <!-- NOMBRE, APELLIDOS, CORREO, ETC. -->
        <div class="container-fluid" style="margin:5rem">
            <div class="container-fluid align-item-center">
                <!--en esta linea se reparten los elementos-->
                <div class="row d-flex justify-content-center text-center" style="font-family:monospace; color: aliceblue;">
                    <h5 class="text-dark" style="font-family:monospace; font-size : 46px; color: #ffffff;"><strong>CUENTA: <%= usuario.getIdUsuario()%> <i class="fa-solid fa-user"></i></strong></h5>
                    <div class="col-sm-12 col-md-4 mt-3 mb-3 text-light bg-dark p-5" style="border-radius: 5%;">
                        <form class="mb-5" method="post" action="Usuario?accion=editar">
                            <div class="mb-3">
                                <label for="exampleFormControlInput1" class="form-label">Contraseña</label>
                                <input type="password" class="form-control" name="clave" placeholder="Contraseña" required>
                            </div>
                            <div>
                                <input type="hidden" class="form-control" name="usuario" value="<%= usuario.getIdUsuario()%>">
                            </div>
                            <div class="mb-3">
                                <label for="exampleFormControlInput1" class="form-label">Nombre</label>
                                <input type="text" class="form-control" name="nombre" value="<%= usuario.getNombre()%>">
                            </div>

                            <div class="mb-3">
                                <label for="exampleFormControlInput1" class="form-label">Apellidos</label>
                                <input type="text" class="form-control" name="apellido" value="<%= usuario.getApellido()%>">
                            </div>

                            <div class="mb-3">
                                <label for="exampleFormControlInput1" class="form-label">Direccion</label>
                                <input type="text" class="form-control" name="direccion" value="<%= usuario.getDireccion()%>" required>
                            </div>
                            <div class="mt-5 mb-5 pb-3">
                                <label for="exampleFormControlInput1" class="form-label">Fecha de Nacimiento: <fmt:formatDate value="${usuario.getFechaNac()}" pattern="yyyy-MM-dd"/> (<%= years%> años) </label>
                                <input type="date" class="form-control" name="fechaNac" value="" required>
                            </div>

                            <div class="mt-5 col-12 d-flex justify-content-center align-item-center">
                                <button class="btn btn-outline-info Hadow rounded border" name="actualizar" type="submit">
                                    ACTUALIZAR
                                    CUENTA
                                </button>
                            </div>
                        </form>
                    </div>
                </div>

            </div>
            <h2>Mis libros</h2>
            <div class="d-flex justify-content-center">
                <table class="table table-hover">
                    <tr class="text-center">
                        <th>ISBN</th>
                        <th>TÍTULO</th>
                        <th>FECHA INICIO</th>
                        <th>FECHA FINALIZACIÓN</th>
                        <th></th>
                    </tr>
                    <c:forEach items="${prestamos}" var="prestamo" >
                        <tr class="text-center">
                            <th>${prestamo.getUnidadidUnidad().getLibroISBN().getIsbn()}</th>
                            <th>${prestamo.getUnidadidUnidad().getLibroISBN().getTitulo()}</th>
                            <th><fmt:formatDate value="${prestamo.getFecha()}" pattern="yyyy-MM-dd HH:mm:ss" /></th>
                                <c:choose>
                                    <c:when test="${prestamo.getFechaEntrega() != null}">

                                    <th><fmt:formatDate value="${prestamo.getFechaEntrega()}" pattern="yyyy-MM-dd HH:mm:ss" /></th>
                                    <th></th>
                                    </c:when>
                                    <c:otherwise>
                                    <th>SIN ENTREGAR</th>
                                    <th>
                                        <form action="Prestamo?accion=entregar" method="post">
                                            <input type="hidden" name="prestamo" value="${prestamo.getIdPrestamo()}">
                                            <button>ENTREGAR</button>
                                        </form>
                                    </th>
                                </c:otherwise>

                            </c:choose>
                        </tr>
                    </c:forEach>
                </table>
            </div>

        </div>
        <jsp:include page="includes/footer.jsp"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    </body>

</html>