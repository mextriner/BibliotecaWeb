<%-- 
    Document   : navbar
    Created on : 27-may-2023, 16:12:05
    Author     : Maximo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="container-fluid bg-secondary" style="padding:0;width:100%;">
    <nav class="navbar navbar-expand-lg navbar-light ">
        <div class="container-fluid">
            <a class="navbar-brand" href="Libro?accion=listar"><img src="foto/bibliLogoRec.png" alt="" style="width:35% ;"></a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <div class="bg-ligth">
                    <span class="navbar-toggler-icon"></span>
                </div>

            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">

                    <li class="nav-item dropdown" style="margin-left:5px;">
                        <a class="nav-link text-light" href="cargarModifica?clase=usuario&usr=<%= ""%>">
                            Mi cuenta: <%=""%>
                        </a>

                    </li>

                    <li class="nav-item dropdown" style="margin-left:5px;">
                        <a class="nav-link text-light" href="accion?libros=deafult" id="navbarDropdown" role="button">
                            Libros <i class="fa-solid fa-book-bookmark"></i>
                        </a>
                    </li>


                    <li class="nav-item dropdown" style="margin-left:5px;">
                        <a class="nav-link text-light" href="Libro?accion=carrito" id="navbarDropdown" role="button">
                            Mi carrito <i class="fa-solid fa-cart-shopping"></i>
                        </a>
                    </li>
                    <li class="nav-item dropdown" style="margin-left:5px;width:500px;">
                        <form action="Libro?accion=buscarU" method="post" class="d-flex text-light">

                            <div class="input-group mb-3">
                                <input type="text" style="width:50%;" class="form-control" name="bus" placeholder="Término de búsqueda" aria-label="Recipient's username" aria-describedby="button-addon2">

                                <select name="bestseller" class="form-select" style="width:30%;">
                                    <option selected>BESTSELLER</option>
                                    <option value=0>NO</option>
                                    <option value=1>SÍ</option>
                                </select>

                                <button class="btn btn-outline-info" style="width:20%;" type="submit" id="button-addon2">Buscar</button>
                            </div>                                  
                        </form>
                    </li>
                </ul>
                <form method="post" action="CerrarSesion">
                    <input type="hidden" value="1" name="cerrar">
                    <button class="btn btn-danger" type="submit" value="1" id="button-addon2">CERRAR SESION</button>
                </form>
            </div>
        </div>
    </nav>
</div>


