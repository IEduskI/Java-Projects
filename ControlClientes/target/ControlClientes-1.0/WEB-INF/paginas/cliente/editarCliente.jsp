<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/1ab1bfce36.js" crossorigin="anonymous"></script>

        <title>Editar Cliente</title>
    </head>
    <body>
        <!-- Cabecero -->
        <jsp:include page="/WEB-INF/paginas/comunes/cabecero.jsp" />

        <form action="${pageContext.request.contextPath}/ServletControlador?accion=modificar&idCliente=${cliente.idCliente}"
              method="post" class="was-validated">

            <!-- Botones de navegacion -->
            <jsp:include page="/WEB-INF/paginas/comunes/botonesEdicion.jsp" />

            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Editar Cliente</h4>
                                </div>

                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="nombre">Nombre: </label>
                                        <input type="text" class="form-control" name="nombre" value="${cliente.nombre}" required>
                                    </div>

                                    <div class="form-group">
                                        <label for="apellido">Apellido: </label>
                                        <input type="text" class="form-control" name="apellido" value="${cliente.apellido}" required>
                                    </div>

                                    <div class="form-group">
                                        <label for="email">Email: </label>
                                        <input type="email" class="form-control" name="email" value="${cliente.email}" required>
                                    </div>

                                    <div class="form-group">
                                        <label for="telefono">Telefono: </label>
                                        <input type="tel" class="form-control" minlength="8" maxlength="8" name="telefono" value="${cliente.telefono}" required>
                                    </div>

                                    <div class="form-group">
                                        <label for="saldo">Saldo: </label>
                                        <input type="number" step="0.01" class="form-control" name="saldo" value="${cliente.saldo}" required>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                </div>
            </section>

        </form>
        <!-- Footer -->
        <jsp:include page="/WEB-INF/paginas/comunes/piePagina.jsp" />

        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js" integrity="sha384-VHvPCCyXqtD5DqJeNxl2dtTyhF78xXNXdkwX1CZeRusQfRKp+tA7hAShOK/B/fQ2" crossorigin="anonymous"></script>

    </body>
</html>
