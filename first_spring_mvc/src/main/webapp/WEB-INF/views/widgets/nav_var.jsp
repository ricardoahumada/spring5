<nav class="navbar navbar-expand-lg bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
      aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link ${param.page==" lista"?"":"active"} " aria-current=" page" href="./lista">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link ${param.page==" create"?"":"active"} " href=" ./create">Alta</a>
        </li>
        <li class="nav-item">
          <a class="nav-link ${param.page==" logout"?"":"active"} " href=" ../users/logout">Salir</a>
        </li>

      </ul>
    </div>
  </div>
</nav>