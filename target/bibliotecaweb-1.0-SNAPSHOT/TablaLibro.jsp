<%@page import="com.maximo.Dominio.Libro"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.maximo.Service.Interfaz.iLibroService"%>

<%
    String user = "";
    HttpSession sesion = request.getSession();
    String msj = "";
    if (request.getAttribute("msj") != null) {
        msj = "Resultado de: " + ((String) request.getAttribute("msj")).toUpperCase();

    }
    if (sesion.getAttribute("usuario") != null) {
        user = (String) sesion.getAttribute("usuario");
    } else {
        response.sendRedirect("inicioSesion.jsp");
    }
    boolean isAdmin = user.equals("admin");
%>
<!DOCTYPE html>
<html lang="en">
    <jsp:include page="includes/head.jsp"/>
    <body class="bg-ligth" style="font-family:monospace;">
        <jsp:include page="includes/navbar.jsp"/>

        <div class="container-fluid" style="margin-top: 10rem">
            <h2><%= msj%></h2>
            <c:forEach items="${libros.keySet()}" var="libro">
                <div class="row d-flex align-items-center" style="background-color: whitesmoke; margin: 3rem">
                    <div class="col-md-2 col-sm-12 d-flex justify-content-left mt-2 mb-3">
                        <img width="180rem" style="margin:0; padding: 0" src="data:image/jpg;base64,${libro.portadabase64}">
                    </div>
                    <div class="col-md-8 col-sm-12 text-center">
                        <article>
                            <h3>${libro.titulo}.</h3><h5> ISBN: ${libro.isbn}</h5>
                            <p>${libro.descripcion}</p> <c:if test="<%= isAdmin%>" ><p>${libros.get(libro)} PRÉSTAMOS</p></c:if>

                            </article>
                        </div>
                        <div class="col-md-2 col-sm-12">
                        <c:choose>
                            <c:when test="<%= isAdmin%>">
                                <div class="container-fluid d-flex justify-content-center">
                                    <div class="row d-flex align-items-center">
                                        <div class="col-md-5 col-sm-6">
                                            <form action="NuevoLibro?accion=editar" method="POST">
                                                <input type="hidden" name="idLibro" value='${libro.getIsbn()}'>
                                                <button class="btn btn-outline-primary" type="submit" name="editar" id="button-addon2">EDITAR</button>
                                            </form>

                                        </div>
                                        <div class="col-md-7 col-sm-6">
                                            <form action="Libro?accion=detalleLibro" method="POST">
                                                <input type="hidden" name="ISBN" value='${libro.getIsbn()}'>
                                                <button class="btn btn-outline-success" type="submit" name="verDetalle" id="button-addon2">Ver Más</button>
                                            </form>

                                        </div>

                                    </div>

                                </div>
                            </c:when>
                            <c:otherwise>
                                <form action="Libro?accion=detalleLibro" method="POST">
                                    <input type="hidden" name="ISBN" value='${libro.getIsbn()}'>
                                    <button class="btn btn-outline-success" type="submit" name="verDetalle" id="button-addon2">Ver Más</button>
                                </form>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </c:forEach>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    </body>
    <jsp:include page="includes/footer.jsp"/>

</html>