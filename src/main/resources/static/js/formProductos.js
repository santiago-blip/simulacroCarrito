$("#formProductos").submit(function (e) {
    e.preventDefault();
    var nombre = $("#nombreProducto").val();
    var precio = $("#precioProducto").val();
    var stock = $("#stockProducto").val();
    var fecha = $("#fechaExpedicion").val();


    if (nombre === "" || nombre.trim() === "") {
        $("#lblnombreErr").html("<span style='color:red;'>El nombre no debe estar vacío</span>");
        $("#nombreProducto").focus();
        return false;
    } else {
        $("#lblnombreErr").html("<span></span>");
    }
//    } else {
//        $("#lblnombreErr").empty(); o .remove();
//        return false;
//    }

    if (isNaN(precio)) {
        $("#lblprecioErr").html("<span style='color:red;'>El precio no debe ser con letras</span>");
        $("#precioProducto").focus();
        return false;
    } else {
        $("#lblprecioErr").html("<span></span>");
    }
    if (precio === "" || precio.trim() === "") {
        $("#lblprecioErr").html("<span style='color:red;'>El precio no debe estar vacío</span>");
        $("#precioProducto").focus();
        return false;
    } else {
        $("#lblprecioErr").html("<span></span>");
    }
    if (isNaN(stock)) {
        $("#lblstockErr").html("<span style='color:red;'>El stock no debe ser una letra</span>");
        $("#stockProducto").focus();
        return false;
    } else {
        $("#lblstockErr").html("<span></span>");
    }
    if (stock === "" || stock.trim() === "") {
        $("#lblstockErr").html("<span style='color:red;'>El stock no debe estar vacío</span>");
        $("#stockProducto").focus();
        return false;
    } else {
        $("#lblstockErr").html("<span></span>");
    }
    if (fecha === "") {
        console.log("Si entra a la validación;");
        $("#lblfechaErr").html("<span style='color:red;'>La fecha no debe estar vacía</span>");
        $("#fechaExpedicion").focus();
        return false;
    } else {
        $("#lblfechaErr").html("<span></span>");
    }

    $.ajax({
        type: 'GET',
        url: "/producto",
        data: {"nombreProducto": nombre, "precioProducto": precio, "stockProducto": stock, "fechaExpedicion": fecha},
        success: function (data, textStatus, jqXHR) {
//            
            swal({
                title: "Good job!",
                text: "You clicked the button!",
                icon: "success",
                button: "Aww yiss!"
            });
            setTimeout(() => {
                parent.location.href = "/";
            }, 1000);
        }
    });
    var containerProducto = document.querySelector("#containerModalProducto");
    var modalProducto = document.querySelector("#modalProducto");
    containerProducto.classList.toggle("mostrarContenedorProducto");
    modalProducto.classList.toggle("mostrarModalProducto");

});

