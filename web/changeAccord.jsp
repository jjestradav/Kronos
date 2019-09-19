<%-- 
    Document   : changeAccord
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificado Acuerdo</title>
    </head>
    <body>
        <div>
            <%@include file="principalMenu.jsp" %>
        </div> 
        <div id ="wrapper">


            <section class="container" id="container">
                <div class="row">
                    <div class="col-6">
                        <form action="">
                            <div  class="form-group row">
                                <label for="" class="col-2 col-form-label"> Oficio: </label>
                                <input type="text" class="form-control col-10" name="office"> 
                            </div>

                            <div class="form-group">
                                <label for="" class="col-7 col-form-label">Fecha de sesión:</label>
                                <input type="date" class="form-control col-4" name ="incorporatedDate">
                            </div>

                            <div class="form-group">
                                <label for="" class="col-7 col-form-label">Vencimiento:</label>
                                <input type="date" class="form-control col-4" name="deadline">
                            </div>

                            <div class="form-group">
                                <label for="" class="col-2 col-form-label"> Observaciones</label>
                                <input type="text" placeholder="Digite en este espacio sus observaciones" class="form-control col-10" name ="observations">
                            </div>
                            <div>
                                <label for="">Adjuntar archivo:</label>
                                <input type='file' name='archivo1' id='archivo1' placeholder="Inserte aquí el PDF" required>
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-light">Cancelar</button>
                                <button type="submit" class="btn btn-light">Agregar</button>
                            </div>
                        </form>
                    </div>
            </section>            
        </div>


    </body>
</html>
