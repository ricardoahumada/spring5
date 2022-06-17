<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <jsp:include page="../widgets/head.jsp" />

    <jsp:include page="../widgets/nav_var.jsp">
        <jsp:param name="page" value="lista"/>
    </jsp:include>

    <h1>Lista de coches</h1>
    <h2>${mess}</h2>
    <section>
        <a class="btn btn-secondary" href="./crear">Dar de alta nevo</a>
    </section>
    <ul>
        <c:forEach items="${coches}" var="unCoche">
            <li>
                <div>${unCoche.marca}</div>
                <div>${unCoche.tipo}</div>
                <div><a href="./detalle?marca=${unCoche.marca}&tipo=${unCoche.tipo}">Ver detalle</a></div>
            </li>
        </c:forEach>

    </ul>
    <jsp:include page="../widgets/foot.jsp" />