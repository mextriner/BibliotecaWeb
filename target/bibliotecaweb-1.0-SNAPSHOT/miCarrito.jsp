<%@page import="com.maximo.Dominio.Libro"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.maximo.Service.Interfaz.iLibroService"%>
<%
    String user = "";
    HttpSession sesion = request.getSession();
    if (sesion.getAttribute("usuario") != null) {
        user = (String) sesion.getAttribute("usuario");
    } else {
        response.sendRedirect("inicioSesion.jsp");
    }
    String msj = "";
    if (request.getAttribute("msj") != null) {
        msj = (String) request.getAttribute("msj");
    }
%>
<!DOCTYPE html>
<html lang="en">
    <jsp:include page="includes/head.jsp"/>
    <head>
        <title> Carrito
        </title>
    </head>    
    <jsp:include page="includes/navbar.jsp"/>


    <body style = "margin-top:8rem">
        <div class="container-fluid">
            <div class="row" style="padding:100px;">
                <h1>MI CARRITO <i class="fa-solid fa-cart-shopping"></i></h1>
                <p class="text-danger bg-light" style="font-size:50px"><strong><%= msj%></strong></p>
                        <c:if test="${carrito != null}">
                    <table class="table">
                        <tr>
                            <th scope="col">

                            </th>
                            <th scope="col">

                            </th>
                            <th scope="col">
                                ISBN
                            </th>
                            <th scope="col">
                                UNIDADES
                            </th>
                            <th scope="col">
                                ESTADO
                            </th>
                        </tr>
                        <c:forEach items="${carrito}" var="unidad">
                            <tr>
                                <td>
                                    <form action="Unidad?accion=procesar" method="POST">
                                        <input type="hidden" value="${unidad.idUnidad}" name="idUnidad">
                                        <button class="btn btn-info">SOLICITAR PRÉSTAMO</button>
                                    </form>
                                </td>
                                <td>
                                    <form action="Unidad?accion=quitar" method="POST">
                                        <input type="hidden" value="${unidad.idUnidad}" name="idUnidad">
                                        <button class="btn btn-danger"><i class="fa-solid fa-square-minus"></i> QUITAR</button>

                                    </form>
                                </td>
                                <th scope="row">${unidad.libroISBN.getIsbn()}</th>
                                <th scope="row">${unidad.idUnidad}</th>
                                <td>${unidad.estado}</td>

                            </tr>
                        </c:forEach>

                    </table>
                </c:if>
                <c:if  test="${carrito == null}">
                    <h1>No hay libros en el carrito</h1>
                </c:if>
            </div>
        </div>



        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    </body>
    <jsp:include page="includes/footer.jsp"/>
</html>