<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Lista de coches</title>
    </head>

    <body>
        <h1>Detalle de coche</h1>
        
        <div>${elCoche.marca}</div>
        <div>${elCoche.tipo}</div>
        <div>${elCoche.velocidad}</div>
        <div>${elCoche.CV}</div>
    </body>

    </html>