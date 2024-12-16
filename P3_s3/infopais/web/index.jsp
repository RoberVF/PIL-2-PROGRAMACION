<%-- 
    Document   : index
    Created on : 03-dic-2024, 8:40:07
    Author     : Aula
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Info Pais</title>
        <script src="https://cdn.tailwindcss.com"></script>
    </head>
    <body>
        <div class="w-full h-full flex justify-center mt-4">
            <div class="bg-zinc-100 mt-4 p-4 rounded-lg shadow-lg">
            <h2 class="text-lg text-center">Introduzca el codigo del pais:</h2>
            <form action="ServletInfoPais" class="mt-4">
                <input type="text" name="ISOcode" class="rounded-lg border-2 px-2 py-1" />
                <button type="submit" class="btn bg-blue-500 rounded-lg px-2 py-1 text-white">
                    Enviar
                </button>
            </form>
         </div>
        </div>
        
        <div>
            
        </div>
        
    </body>
</html>
