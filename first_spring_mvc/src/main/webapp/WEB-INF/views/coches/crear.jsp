<jsp:include page="../widgets/head.jsp" />

<jsp:include page="../widgets/nav_var.jsp">
    <jsp:param name="page" value="lista" />
</jsp:include>

<h1>Dar de alta coche</h1>
<p>${error}</p>
<form action="" method="POST">
    <div><input type="text" value="${elCoche.marca}" name="marca" placeholder="marca"></div>
    <div><input type="text" value="${elCoche.tipo}" name="tipo" placeholder="tipo"></div>
    <div><input type="text" value="${elCoche.velocidad}" name="velocidad" placeholder="velocidad"></div>
    <div><input type="text" value="${elCoche.CV}" name="CV" placeholder="CV"></div>
    <button class="btn btn-primary">Crear</button>
</form>

<jsp:include page="../widgets/foot.jsp" />