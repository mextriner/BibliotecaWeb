<%-- 
    Document   : registroEditorial
    Created on : 06-feb-2023, 10:51:40
    Author     : Alumno Mañana
--%>

<%@page import="com.maximo.Dominio.Categoria"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% Categoria c = (Categoria) request.getAttribute("categoria");%>
<!DOCTYPE html>
<html lang="en">
    <jsp:include page="includes/head.jsp"/>
    <head>
        <title> Categoría: <%= c.getNombre()%>
        </title>
    </head>
    <body class="bg-secondary" style="font-family:monospace;">
        <jsp:include page="includes/navbar.jsp"/>
        <div class="container-fluid bg-dark align-item-center">
            <!--en esta linea se reparten los elementos-->
            <div class="row d-flex justify-content-center">
                <div class="col-sm-12 col-md-4 mt-3 mb-3 text-light">
                    <form method="POST" action="Categoria?accion=editar">
                        <h1 style="font-size: 30px; ;"><strong>REGISTRO CATEGORÍA </strong><i class="fa-solid fa-quote-left"></i></h1>

                        <input type="hidden" name="id" value="<%= request.getAttribute("id")%>">

                        <div class="mb-3">
                            <label for="exampleFormControlInput1" class="form-label">Categoría</label>
                            <input type="text" class="form-control" name="nombre" value="<%= c.getNombre()%>">
                        </div>

                        <div class="mb-4">
                            <label for="exampleFormControlInput1" class="form-label">Descripción</label>
                            <textarea class="form-control" name="descripcion" id="exampleFormControlTextarea1" rows="3"><%= c.getDescripcion()%></textarea>
                        </div>

                        <div class="mt-5 col-12 d-flex justify-content-center align-item-center">
                            <button class="btn btn-outline-info Hadow rounded border" type="submit">ACUALIZAR</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <jsp:include page="includes/footer.jsp"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>

    </body>
</html>
