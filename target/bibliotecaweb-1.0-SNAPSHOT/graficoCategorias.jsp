<%@page import="com.maximo.Dominio.Categoria"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.maximo.Service.Interfaz.iCategoriaService"%>
<%
    String user = "";
    HttpSession sesion = request.getSession();
    String msj = "";
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
        <div style="margin-left: 7rem ; margin-top: 10rem">
            <h2>Número de Horas Por Categoría</h2>
            <div class="row" style="align-items:flex-end;">
                <c:forEach items="${categorias.keySet()}" var="categoria">
                    <div class="col col-sm-1 col-md-1">
                        <div class="bg-primary" style="height: ${categorias.get(categoria)}rem;">

                        </div>
                    </div>
                </c:forEach>
            </div>
            <hr style="border-top:2px black solid">
            <div class="row" style="align-items:flex-start;">
                <c:forEach items="${categorias.keySet()}" var="categoria">

                    <div class="col col-sm-1 col-md-1 text-center">
                        <p>${categoria.nombre}:</p>
                        <strong><p> ${categorias.get(categoria)} horas</p></strong> 

                    </div> 
                </c:forEach>
            </div>

        </div>



        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    </body>
    <jsp:include page="includes/footer.jsp"/>

</html>