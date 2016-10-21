<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Provincias</title>

        <link rel="stylesheet" href="../../css/bootstrap.css">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h1>Provincias de ${pais.nombre}</h1>
                </div>
            </div>
            
            <hr/>
            
            <div class="row">
                <div class="col-md-6">
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>
                                    ID
                                </th>
                                <th>
                                    Nombre
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="provincia" items="${provincias}">
                                <tr>
                                    <td>${provincia.id}</td>
                                    <td>${provincia.nombre}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                
                <div class="col-md-6">
                    <form action="PaisController.java" mothod="post">
                        <label name="nombre">Nombre</label>
                        <input type="text" name="nombre">
                        <label name="pais">País</label>
                        <input type="text" name="pais">
                        <%=
                            String nombre = request.getParameter("nombre");
                            String pais = request.getParameter("pais");
                            // Provincia provincia = new Provincia(); TODO
                        %>
                        <input type="submit" value="Insertar" action="PaisController.agregarProvincia(provincia)">
                    </form>
                    
                </div>
            </div>
            
        </div>
            
                
        
        
    </body>
</html>
