<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>Dar de alta coche</h1>
    <p>${error}</p>
    <form action="" method="POST">
        <div><input type="text" value="${elCoche.marca}" name="marca" placeholder="marca"></div>
        <div><input type="text" value="${elCoche.tipo}" name="tipo" placeholder="tipo"></div>
        <div><input type="text" value="${elCoche.velocidad}" name="velocidad" placeholder="velocidad"></div>
        <div><input type="text" value="${elCoche.CV}" name="CV" placeholder="CV"></div>
        <button>Crear</button>
    </form>
    
</body>
</html>