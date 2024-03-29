<%-- 
    Document   : registroEditorial
    Created on : 06-feb-2023, 10:51:40
    Author     : Alumno Ma�ana
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title> Nueva Editorial
    </title>
</head>
<!DOCTYPE html>
<html lang="en">
    <jsp:include page="includes/head.jsp"/>
    <body style = "margin-top:8rem">
        <jsp:include page="includes/navbar.jsp"/>
        <div class="container-fluid bg-dark text-light align-item-center">
            <!--en esta linea se reparten los elementos-->
            <div class="row d-flex justify-content-center">
                <div class="col-sm-12 col-md-4 mt-3 mb-3">
                    <form method="POST" action="Editorial?accion=insertar">
                        <h1 style="font-size: 30px; ;"><strong>REGISTRO EDITORIAL </strong> <i class="fa-solid fa-typewriter"></i></h1>
                        <div class="mb-3">
                            <label for="exampleFormControlInput1" class="form-label">Editorial</label>
                            <input type="text" class="form-control" name="nombre" placeholder="Nombre">
                        </div>

                        <div class="mb-3">
                            <label for="exampleFormControlInput1" class="form-label">Direcci�n</label>
                            <input type="text" class="form-control" name="direccion" placeholder="Direcci�n">
                        </div>
                        <input type="hidden" name="oculto" value="1">
                        <div class="mt-5 col-12 d-flex justify-content-center align-item-center">
                            <button class="btn btn-outline-success Hadow rounded border" type="submit">REGISTRARSE</button>

                        </div>
                    </form>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    </body>
    <jsp:include page="includes/footer.jsp"/>
</html>
