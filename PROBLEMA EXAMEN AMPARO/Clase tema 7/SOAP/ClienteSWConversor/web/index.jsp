
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Introduzca la info solicitada</h1>
        <form action="respuesta">
            Angulo en grados: <input type="text" name="angulo" value="" size="10" /><br>
            <select name="operacion">
                <option>Convertir a radianes</option>
                <option>Tipo de angulo</option>
                <option>Angulo suplementario</option>
            </select><br>
            <input type="submit" value="Enviar" />
        </form>
    </body>
</html>
