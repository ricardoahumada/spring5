<jsp:include page="../widgets/head.jsp" />

<h1>Bienvenido</h1>
<h2>Identificate!</h2>

<p>${error}</p>
<form action="" method="POST">
    <div><input type="email" name="email" placeholder="Email" value=""></div>
    <div><input type="password" name="password" placeholder="Tu password" value=""></div>
    <button>Entrar</button>
</form>

<jsp:include page="../widgets/foot.jsp" />