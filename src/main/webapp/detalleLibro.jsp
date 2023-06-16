<%-- 
    Document   : detalleLibro
    Created on : 28-may-2023, 22:20:22
    Author     : Maximo
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <body>

        <jsp:include page="includes/navbar.jsp"/>
        <div class="row align-items-center mt-3 mb-3">
            <div class="col-md-6 col-sm-12 text-center">

                <h1><%=libro.getTitulo()%></h1>

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
                <div class="mb-3" style="height:120px;">
                    <p>ISBN:        <%= libro.getIsbn()%></p>
                    <p>DESCRIPCIÓN: <%= libro.getDescripcion()%></p>
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
                                <th scope="row">${unidad.idUnidad}</th>
                                <td> ${unidad.estado}</td>

                            </tr>

                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
        <jsp:include page="includes/footer.jsp"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    </body>
</html>
