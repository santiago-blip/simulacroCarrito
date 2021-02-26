$(document).ready(function () {
    $(".eliminarCarrito").click(function () {
        var id = $(this).parent().find(".valorIdCarrito").val();
        swal({
            title: "¿Seguro que quiere eliminar el producto?",
            text: "Se eliminará el producto",
            icon: "warning",
            buttons: true,
            dangerMode: true,
        }).then((willDelete) => {
            if (willDelete) {
                eliminar(id);
            } else {
                swal("No se ha eliminado ningun producto");
            }
        });
    });

    function eliminar(id) {
        $.ajax({
            type: 'GET',
            url: "/eliminar/carrito",
            data: "id=" + id,
            success: function (data, textStatus, jqXHR) {
                swal("El producto ha sido eliminado", {
                    icon: "success",
                }).then(() => {
                    parent.location.href = "/carrito";
                });

            }
        });
    }

    //AUMENTO DE CANTIDAD
    $(".aumentarCarrito").click(function () {
        var id = $(this).parent().find(".valorIdCarrito").val();
        var cantidad = $(this).parent().find(".aumentarCarrito").val();
        console.log("la id es: ", id);
        console.log("El valor de la id es: ", cantidad);
        $.ajax({
            type: 'GET',
            url: "/carrito/cantidad",
            data: "cantidadCamb=" + cantidad + "&idCAMB=" + id,
            success: function (data, textStatus, jqXHR) {
                parent.location.href = "/carrito";
            }
        });
    });

});


