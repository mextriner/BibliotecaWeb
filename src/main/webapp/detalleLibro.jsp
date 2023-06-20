<%-- 
    Document   : detalleLibro
    Created on : 28-may-2023, 22:20:22
    Author     : Maximo
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="com.maximo.Dominio.Libro"%>
<%
    Libro libro = (Libro) request.getAttribute("libro");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="includes/head.jsp"/>
    <head>
        <title><%= libro.getTitulo()%>
        </title>
    </head>    
    <body style = "margin-top:8rem">

        <jsp:include page="includes/navbar.jsp"/>
        <div class="row align-items-center mt-3 mb-3" style="margin: 5rem">
            <div class="col-md-6 col-sm-12 text-center">

                <strong><h1><%=libro.getTitulo()%></h1></strong>

                <c:choose>
                    <c:when test="${empty libro.getPortadabase64()}">
                        <img src="foto/book-default.jpg" alt="..." style="padding:2rem">

                    </c:when>
                    <c:otherwise>
                        <img src="data:image/jpg;base64,<%=libro.getPortadabase64()%>" alt="..." style="padding:5rem">

                    </c:otherwise>
                </c:choose>

            </div>
            <div class="col-sm-12 col-md-6 text-center">
                <p>UNIDADES:        <%=libro.getUnidadList().size()%></p>
                <div class="mb-5">
                    <h1><strong>ISBN:        <%= libro.getIsbn()%></strong></h1>
                    <div class="mb-5"><strong>SINOPSIS</strong>: </br><%= libro.getDescripcion()%></div>
                </div>
                <div>
                    <h3>FECHA DE PUBLICACIÓN:</h3>
                    <p><fmt:formatDate value="<%= libro.getFechaPublicacion()%>" pattern="yyyy-MM-dd"/></p>
                </div>
                <div class="mt-5 mb-2">
                    <h3>CATEGORÍAS</h3>
                    <div class="row d-flex justify-content-center" >
                        <c:forEach items="<%= libro.getCategoriaList()%>" var="categoria">
                            <div class="col-md-2 col-sm-12 text-center" >
                                <span class="badge bg-primary">${categoria.nombre}</span>

                            </div>
                        </c:forEach>
                    </div>
                </div>
                <div class="mt-3 mb-2">
                    <h3>AUTORES</h3>
                    <c:forEach items="<%= libro.getAutorList()%>" var="autor">
                        <div><p>${autor.nombre} ${autor.apellido}</p></div>
                    </c:forEach>

                </div>
            </div>
            <div class="row d-flex p-5">
                <div class="col-sm-12 col-md-12 p-5">

                    <table class="table table-striped">
                        <tr>
                            <th scope="col">

                            </th>
                            <th scope="col">
                                ISBN
                            </th>
                            <th scope="col">
                                ID UNIDAD
                            </th>
                            <th scope="col">
                                ESTADO
                            </th>
                        </tr>
                        <c:forEach items="${unidades}" var="unidad">
                            <tr>
                                <td>
                                    <c:if test="${unidad.estado!=0}">
                                        <form action="Usuario?accion=sumarLibro" method="POST">
                                            <input type="hidden" value="${unidad.idUnidad}" name="idUnidad">
                                            <button class="btn btn-info">AÑADIR <i class="fa-solid fa-cart-shopping"></i></button>
                                        </form>

                                    </c:if>
                                </td>
                                <th scope="row">${unidad.libroISBN.getIsbn()}</th>

                                <td> ${unidad.idUnidad}</td>
                                <c:choose>
                                    <c:when test="${unidad.estado == 1}">
                                        <th scope="row">Disponible</th>
                                        </c:when>
                                        <c:otherwise>
                                        <th scope="row">No disponible</th>
                                        </c:otherwise>
                                    </c:choose>

                            </tr>

                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    </body>
    <jsp:include page="includes/footer.jsp"/>
</html>
