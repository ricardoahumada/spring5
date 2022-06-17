<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <jsp:include page="../widgets/head.jsp" />

    <jsp:include page="../widgets/nav_var.jsp">
        <jsp:param name="page" value="lista"/>
    </jsp:include>

    <h1>Detalle de coche</h1>

    <div>${elCoche.marca}</div>
    <div>${elCoche.tipo}</div>
    <div>${elCoche.velocidad}</div>
    <div>${elCoche.CV}</div>
    
    <jsp:include page="../widgets/foot.jsp" />