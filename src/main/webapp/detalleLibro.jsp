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
    <jsp:include page="includes/navbar.jsp"/>
    <div class="row align-items-center">
        <div class="col-md-6 col-sm-12 text-center">

            <h1><%=libro.getTitulo()%></h1>

            <c:if test="${!empty libro.getPortada()}">
                <img src=" https://asia-dev.scholasticinternational.com/sites/all/themes/scholastic_asia/images/default-book.png" alt="..." style="padding:2rem">
            </c:if>
            <c:if test="${empty libro.getPortada()}">

                <img src="data:image/jpg;base64,<%=libro.getPortadabase64()%>" alt="..." style="padding:5rem">
            </c:if>

        </div>
        <div class="col-sm-12 col-md-6 text-center">
            <p>UNIDADES:        <%=libro.getUnidadList().size()%></p>
            <div class="mb-3" style="height:120px;">
                <p>ISBN:        <%= libro.getIsbn()%></p>
                <p>DESCRIPCIÓN: <%= libro.getDescripcion()%></p>
            </div>
            <input type="hidden" name="idLibro" value='${libro.getIsbn()}'>


        </div>
    </div>
    <jsp:include page="includes/footer.jsp"/>
</html>
