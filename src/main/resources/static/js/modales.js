var sesion = document.getElementById("modalIniciar");
if (sesion !== null) {
    var contenedor = document.getElementById("contenedorSesion");
    var modal = document.getElementById("modalSesion");
    sesion.addEventListener("click", (e) => {
        e.preventDefault();
        contenedor.classList.toggle("mostrarSesion");
        modal.classList.toggle("mostrarModalSesion");
    });
}


//LINKS
var registro = document.getElementById("linkRegistro");
var session = document.getElementById("linkSesion");
if (registro && session !== null) {
    var modalS = document.getElementById("modalSesion");
    var modalR = document.getElementById("modalRegistro");
    registro.addEventListener("click", () => {
        console.log("dio en registro");
        modalS.classList.toggle("mostrarModalSesion");
        modalR.classList.toggle("mostrarModalSesion");
    });
    session.addEventListener("click", () => {
        console.log("dio en sesion");
        modalS.classList.toggle("mostrarModalSesion");
        modalR.classList.toggle("mostrarModalSesion");
    });
}

//MODAL PRODUCTOS
var btnAdd = document.querySelector("#btnAddProducto");
if (btnAdd !== null) {
    var containerProducto = document.querySelector("#containerModalProducto");
    var modalProducto = document.querySelector("#modalProducto");
    btnAdd.addEventListener("click", function () {
        containerProducto.classList.toggle("mostrarContenedorProducto");
        modalProducto.classList.toggle("mostrarModalProducto");
    });
}

//CERRAR MODALES

window.addEventListener("click", e => {
    //SESION
    var contenedor = document.getElementById("contenedorSesion");
    var modal = document.getElementById("modalSesion");
    var modalR = document.getElementById("modalRegistro");
    if (e.target === contenedor) {
        if (modalR.classList.contains('mostrarModalSesion')) {
            modalR.classList.toggle("mostrarModalSesion");
        }
        if (modal.classList.contains('mostrarModalSesion')) {
            modal.classList.toggle("mostrarModalSesion");
        }
        contenedor.classList.toggle("mostrarSesion");
    }
    //PRODUCTO
    var containerProducto = document.querySelector("#containerModalProducto");
    var modalProducto = document.querySelector("#modalProducto");
    if (e.target === containerProducto) {
        containerProducto.classList.toggle("mostrarContenedorProducto");
        modalProducto.classList.toggle("mostrarModalProducto");
    }
});