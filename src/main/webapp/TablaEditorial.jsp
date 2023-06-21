<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <jsp:include page="includes/head.jsp"/>
    <head>
        <title>Editoriales
        </title>
    </head>
    <body style = "margin-top:8rem">
        <jsp:include page="includes/navbar.jsp"/>

        <section>
            <h1>BIENVENIDO: </h1>

            <div class="row d-flex justify-content-center px-5">
                <div class="col-md-4 col-sm-12" style="width:66%;">

                    <!--Comenzamos a mostrar los datos-->
                    <h2>Listado de EDITORIALES <a class="text-dark" href="Categoria?accion=grafico"><i class="fa-solid fa-file-circle-plus"></i></a></h2>
                    <table class="table" style="border: solid darkgray 1px;">

                        <tr>
                            <td>ID EDITORIAL</td>
                            <td>Nombre</td>
                            <td>Dirección</td>
                            <td>Num. Libros</td>
                            <td>Editar</td>
                        </tr>
                        <c:forEach items="${editoriales}" var="editorial">
                            <tr style="border: solid black 2px;">
                                <td style="border: solid black 2px;">${editorial.getIdEditorial()}</td>
                                <td style="border: solid black 2px;">${editorial.getNombre()}</td>
                                <td style="border: solid black 2px;">${editorial.getDireccion()}</td>
                                <td style="border: solid black 2px;">${editorial.getLibroList().size()} libros</td>
                                <td style="border: solid black 2px;"><a class="text-primary" href="cargarModifica?clase=editorial&editorialId=${editorial.getIdEditorial()}"><i class="fa-solid fa-pen"></i></a></td>

                            </tr>
                        </c:forEach>

                    </table>
                </div>

        </section>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    </body>
    <jsp:include page="includes/footer.jsp"/>

</html>