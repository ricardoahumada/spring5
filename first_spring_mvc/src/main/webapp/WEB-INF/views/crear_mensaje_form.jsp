<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Crear Mensaje</title>
</head>
<body>
    
    <h1>Escribe tu mensaje...</h1>
    <p>${error}</p>
    <form action="" method="POST">
        <input placeholder="id" type="number" name="id" value="${elMensaje.id}" />
        <input placeholder="mensaje" type="text" name="mess" value="${elMensaje.mess}" />
        <button>Enviar!</button>
    </form>
    
</body>
</html>