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
        <h1>Lista de coches</h1>
        <h2>${mess}</h2>
        <ul>
            <c:forEach items="${coches}" var="unCoche">
                <li>
                    <div>${unCoche.marca}</div>                    
                    <div>${unCoche.tipo}</div>                    
                </li>
            </c:forEach>

        </ul>

    </body>

    </html>