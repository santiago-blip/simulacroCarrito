$(document).ready(function () {
    $(".eliminarProducto").click(function () {
        var id = $(this).parent().find(".valorIdProducto").val();
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
        var url = "ControllerCarrito?accion=EliminarCarrito";
        $.ajax({
            type: 'GET',
            url: "/eliminar",
            data: "id=" + id,
            success: function (data, textStatus, jqXHR) {
                swal("El producto ha sido eliminado", {
                    icon: "success",
                }).then(()=>{
                    parent.location.href = "/";
                });
                
            }
        });
    }
});


