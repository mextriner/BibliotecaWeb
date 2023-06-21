
<%@page import="com.maximo.Dominio.Libro"%>
<%@page import="com.maximo.Dominio.Usuario"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Libro libro = (Libro) request.getAttribute("libro");
%>
<!DOCTYPE html>
<html lang="en">

    <jsp:include page="includes/head.jsp" />
    <head>
        <title> Libro: <%= libro.getTitulo()%>
        </title>
    </head>
    <body class="text-light" style = "margin-top:8rem">
        <!--LA BARRA DE NAVEGACION-->
        <jsp:include page="includes/navbar.jsp" />

        <div class="container-fluid align-item-center">
            <!--en esta linea se reparten los elementos-->
            <div class="row d-flex justify-content-center text-center" style="font-family:monospace; color: aliceblue;">
                <h5 style="font-family:monospace; font-size : 46px; color: #ffffff;"><strong>LIBRO: <%= libro.getIsbn()%> <i class="fa-solid fa-book"></i></strong></h5>
                <div class="col-sm-12 col-md-4 mt-3 mb-3 text-light bg-dark p-5" style="border-radius: 5%;">
                    <form method="POST" action="Libro?accion=editar" enctype="multipart/form-data">



                        <div class="col-md-12 col-sm-12 mb-3 mt-4">
                            <h1 style="font-size: 30px; ;"><strong>EDITAR LIBRO</strong></h1>
                            <div class="mb-3">
                                <label for="exampleFormControlInput1" class="form-label">Libro</label>
                                <input type="text" class="form-control" name="titulo" value="<%= libro.getTitulo()%>">
                                <input type="hidden" name="isbn" value="<%= libro.getIsbn()%>">

                            </div>


                            <div class="mb-3">
                                <label for="exampleFormControlInput1" class="form-label">Fecha Publicación: <p><fmt:formatDate value="<%= libro.getFechaPublicacion()%>" pattern="dd-MM-yyyy"/></p></label>
                                <input type="date" class="form-control" name="fecha" placeholder="Fecha" required>
                            </div>
                            <div class="mb-3">
                                <label for="formFile" class="form-label">Portada</label>
                                <input type="file" class="form-control" name="portada" placeholder="Ruta de imagen" id="formFile"> 
                            </div>
                            <div class="mb-5">
                                <label for="exampleFormControlInput1" class="form-label">Número de Unidades</label>
                                <input type="numeric" class="form-control" name="unidades" placeholder="Unidades" required>
                            </div>                            

                            <label for="inputState" class="form-label">Bestseller</label>
                            <div class="form-floating mb-4">
                                <select name="bestseller" class="form-select" required>
                                    <option value=0>NO</option>
                                    <option value=1>SÍ</option>
                                </select>
                            </div>
                            <div class="mb-4">
                                <label for="exampleFormControlInput1" class="form-label">Descripción</label>
                                <textarea class="form-control" name="descripcion" id="exampleFormControlTextarea1" rows="3" required><%= libro.getDescripcion()%></textarea>
                            </div>
                            <div class="mb-3">
                                <label for="inputState" class="form-label">Editorial: <%= libro.getEditorialidEditorial() %></label>
                                <div class="form-floating">

                                    <select name="editorial" class="form-select" required>
                                        <option selected></option>
                                        <c:forEach items="${editoriales}" var="editorial">
                                            <option value=${editorial.idEditorial}>${editorial.idEditorial} ${editorial.nombre}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="mb-3 col-sm-12 col-md-1">
                            <button class="btn btn-outline-info Hadow rounded border" type="submit">ACTUALIZAR</button>
                        </div>
                    </form>
                    <a class="mt-2 text-danger" href="">ELIMINAR LIBRO</a>
                </div>
            </div>

        </div>
    </div>
    <!--AQUÍ VAN LAS CARDS-->
    <!--FOOTER-->
    <jsp:include page="includes/footer.jsp" />

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</body>

</html>