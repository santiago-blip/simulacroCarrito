/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacionCarrito.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import simulacionCarrito.Paginador.Paginator;
import simulacionCarrito.entities.Carrito;
import simulacionCarrito.entities.CarritoProducto;
import simulacionCarrito.entities.Productos;
import simulacionCarrito.entities.Rol;
import simulacionCarrito.entities.Usuario;
import simulacionCarrito.service.ICarritoProductoService;
import simulacionCarrito.service.ICarritoService;
import simulacionCarrito.service.IProductoService;
import simulacionCarrito.service.IUsuarioService;

@Controller
public class AppController {

    @Autowired
    private IProductoService productoService;
    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private ICarritoService carritoService;

    @Autowired
    private ICarritoProductoService carritoProductoService;

    private BCryptPasswordEncoder passwordEncode() {
        return new BCryptPasswordEncoder();
    }

    @RequestMapping(value = {"/", "/index", "/home"}, method = RequestMethod.GET)
    public String index(Productos producto, Model model) { //@RequestParam(name = "page", defaultValue = "0") int page, 
//        Pageable pageRequest = PageRequest.of(page, 4); //El 4 es para indicar cuántos registros por página.
//        Page<Productos> productos = productoService.findAll(pageRequest);
//        
//        Paginator<Productos> pageRender = new Paginator<>("/", productos);
//        System.out.println("Pag actual ".concat(String.valueOf(pageRender.getPaginaActual())));
//        model.addAttribute("productos", productos);
//        model.addAttribute("page", pageRender);
        model.addAttribute("productos", productoService.listarProductos());
        model.addAttribute("producto", producto);
        return "index";
    }

    @RequestMapping(value = "/registrarse")
    public String registrarse(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password, @RequestParam(name = "url") String url, Usuario usuario) {
        if (username.length() > 0 && password.length() > 0) {
            usuario.setUsuario(username);
            usuario.setPass(this.passwordEncode().encode(password));
            Rol rol = new Rol();
            rol.setIdRol(2);
            usuario.setIdRol(rol);
            usuarioService.registrarUsuario(usuario);
            Carrito carrito = new Carrito();
            carrito.setIdUsuario(usuario);
            carritoService.guardarCarro(carrito);
        }
        return "redirect:" + url;
    }

    @RequestMapping(value = "/producto", method = RequestMethod.GET)
    public String productoAdd(Productos producto, Model model) {
        System.out.println("nombreProducto: " + producto.getNombreProducto());
        System.out.println("precioProducto: " + producto.getPrecioProducto());
        System.out.println("stockProducto: " + producto.getStockProducto());
        System.out.println("fechaProducto: " + producto.getFechaExpedicion());
        System.out.println("imagen: " + producto.getRutaImg());
//        if (!foto.isEmpty()) {
//            String path = "D://ProgramasDevops//ImgExternal";
//            try {
//                byte[] bytes = foto.getBytes();
//                System.out.println("PATH: " + path);
//                Path fullPath = Paths.get(path + "//" + foto.getOriginalFilename());
//                System.out.println("FULL PATH: " + fullPath);
//                Files.write(fullPath, bytes);
//                producto.setRutaImg(foto.getOriginalFilename());
//
//            } catch (IOException e) {
//                System.out.println("Error al guardar la imagen y el producto: ".concat(e.toString()));
//                flash.addFlashAttribute("error", "No se pudo guardar correctamente el producto");
//                return "redirect:/";
//            }
//        }
        productoService.guardarProducto(producto);
        model.addAttribute("success", "Se ha agregado el cliente con éxito");
        return "redirect:/";
    }

    @RequestMapping(value = "/ver/{id}")
    public String ver(@PathVariable(name = "id") int id, Productos producto, Model model) {
        producto.setIdProducto(id);
        producto = productoService.buscarProducto(producto);
        if (producto == null) {
            System.out.println("Entra en null");
            return "redirect:/";
        }
        model.addAttribute("producto", producto);
        return "ver";
    }

    @RequestMapping(value = "/ver/imagen", method = RequestMethod.POST)
    public String addImagenVer(Productos producto, @RequestParam("file") MultipartFile foto, Model model) {
        producto = productoService.buscarProducto(producto);
        if (!foto.isEmpty()) {
            String path = "D://ProgramasDevops//ImgExternal";
            try {
                byte[] bytes = foto.getBytes();
                System.out.println("PATH: " + path);
                Path fullPath = Paths.get(path + "//" + foto.getOriginalFilename());
                System.out.println("FULL PATH: " + fullPath);
                Files.write(fullPath, bytes);
                producto.setRutaImg(foto.getOriginalFilename());

            } catch (IOException e) {
                System.out.println("Error al guardar la imagen y el producto: ".concat(e.toString()));
//                model.addAttribute("error", "No se pudo guardar correctamente el producto");
                return "redirect:/";
            }
        }
        productoService.guardarProducto(producto);
        model.addAttribute("success", "");
        return "redirect:/ver/" + producto.getIdProducto();
    }

    @PostMapping("/editar/producto")
    public String editar(Productos producto, @RequestParam(name = "file") MultipartFile file) {
        if (!file.isEmpty()) {
            String path = "D://ProgramasDevops//ImgExternal";
            try {
                byte[] bytes = file.getBytes();
                System.out.println("PATH: " + path);
                Path fullPath = Paths.get(path + "//" + file.getOriginalFilename());
                System.out.println("FULL PATH: " + fullPath);
                Files.write(fullPath, bytes);
                producto.setRutaImg(file.getOriginalFilename());
            } catch (IOException e) {
                System.out.println("Error al guardar la imagen y el producto: ".concat(e.toString()));
                return "redirect:/";
            }
        }
        Productos producto2 = productoService.buscarProducto(producto);
        if (producto.getRutaImg() == null) {
            producto.setRutaImg(producto2.getRutaImg());
        }

        //Condición para elimiar la img de la carpeta solo si no se usa en otro producto.
        if (producto2.getRutaImg() != null) {
            //Se vuelve a "mapear" la ruta donde se guardan las imágenes.
            Path pathImg = Paths.get("D://ProgramasDevops//ImgExternal//").resolve(producto2.getRutaImg()).toAbsolutePath();
            File archivoImg = pathImg.toFile();

            //Si el archivo existe y se puede leer.
            if (archivoImg.canRead() && archivoImg.exists()) {
                int contadorImg = 0, noEliminar = 0;
                List<Productos> lista = productoService.listarProductos();
                System.out.println("Producto imagen ".concat(producto2.getRutaImg()));
                for (Productos c : lista) {
                    if (c.getRutaImg() != null) {
                        if (c.getRutaImg().equals(producto2.getRutaImg())) {
                            contadorImg++;
                        }
                    } else {
                        noEliminar = 1;
                    }
                }
                if (contadorImg > 1 || noEliminar > 0) {
                    System.out.println("No se elimina");
                } else {
                    if (archivoImg.delete()) {
                        System.out.println("Se ha eliminado la imagen del archivo");
                    }
                }
            }
        }
        productoService.guardarProducto(producto);
        return "redirect:/ver/" + producto.getIdProducto();
    }

    @GetMapping("/eliminar")
    public String eliminar(@RequestParam(name = "id") int id, Productos producto) {
        producto.setIdProducto(id);
        producto = productoService.buscarProducto(producto);
        if (producto != null) {
            System.out.println("Entro en condición producto != null");
            if (producto.getRutaImg() != null) {
                Path pathImg = Paths.get("D://ProgramasDevops//ImgExternal//").resolve(producto.getRutaImg()).toAbsolutePath();
                File archivoImg = pathImg.toFile();

                //Si el archivo existe y se puede leer.
                if (archivoImg.canRead() && archivoImg.exists()) {
                    int contadorImg = 0, noEliminar = 0;
                    List<Productos> lista = productoService.listarProductos();
                    System.out.println("Producto imagen ".concat(producto.getRutaImg()));
                    for (Productos c : lista) {
                        if (c.getRutaImg() != null) {
                            if (c.getRutaImg().equals(producto.getRutaImg())) {
                                contadorImg++;
                            }
                        } else {
                            noEliminar = 1;
                        }
                    }
                    if (contadorImg > 1 || noEliminar > 0) {
                        System.out.println("No se elimina");
                    } else {
                        if (archivoImg.delete()) {
                            System.out.println("Se ha eliminado la imagen del archivo");
                        }
                    }
                }
            }
            productoService.eliminarProducto(producto.getIdProducto());
        }
        return "redirect:/";
    }
    @RequestMapping(value = "/carrito", method = RequestMethod.GET)
    public String carrito(Authentication auth,Usuario usuario,Model model){
         usuario = usuarioService.buscarPorNombre(auth.getName());
         Carrito carrito = usuario.getIdCarrito();
         carrito.setTotalCarrito(carrito.getTotalCarritoMethod());
         carritoService.guardarCarro(carrito);
         model.addAttribute("carrito",carrito);
          return "carrito";
    }

    @RequestMapping(value = "/carrito/{id}", method = RequestMethod.GET)
    public String addCarrito(@PathVariable(name = "id") int id, Productos producto, Usuario usuario, Carrito carrito, CarritoProducto carritoProducto, Authentication auth, RedirectAttributes flash) {
        CarritoProducto oldCarritoProducto = new CarritoProducto();
        System.out.println("Usuario: ".concat(auth.getName()));
        usuario = usuarioService.buscarPorNombre(auth.getName());
        carrito = carritoService.findByIdUsuario(usuario);
        System.out.println("Carrito: ".concat(String.valueOf(carrito.getIdCarrito())));
        producto.setIdProducto(id);
        producto = productoService.buscarProducto(producto);
        if (producto != null) {
            oldCarritoProducto = carritoProductoService.buscarSiExiste(producto,carrito);
            if (oldCarritoProducto != null) {
                int cantidad = 0;
                cantidad = oldCarritoProducto.getCantidadProducto();
                cantidad++;
                oldCarritoProducto.setCantidadProducto(cantidad);
                oldCarritoProducto.setTotalProducto(oldCarritoProducto.getTotalProductoMethod());
                carritoProductoService.guardarCarritoProducto(oldCarritoProducto);
                flash.addFlashAttribute("addProduct");
                return "redirect:/";
            } else {
                usuario = usuarioService.buscarPorNombre(auth.getName());
                System.out.println("Usuario: ".concat(auth.getName()));
                carrito = carritoService.findByIdUsuario(usuario);
                carritoProducto.setIdProducto(producto);
                carritoProducto.setIdCarrito(carrito);
                carritoProducto.setCantidadProducto(1);
                carritoProducto.setTotalProducto(carritoProducto.getTotalProductoMethod());
                carritoProductoService.guardarCarritoProducto(carritoProducto);
                flash.addFlashAttribute("addProduct");
                return "redirect:/";
            }
        }
        return "redirect:/";
    }
    
    @RequestMapping(value = "/carrito/cantidad")
    public String cambiarCantidad(@RequestParam(name = "cantidadCamb") int cantidad,@RequestParam(name = "idCAMB") int id, CarritoProducto carrito){
        carrito = carritoProductoService.buscarCarrito(id);
        carrito.setCantidadProducto(cantidad);
        carrito.setTotalProducto(carrito.getTotalProductoMethod());
        carritoProductoService.guardarCarritoProducto(carrito);
        return "redirect:/carrito";
    }
    
    @RequestMapping(value = "/eliminar/carrito",method = RequestMethod.GET)
    public String eliminarCarrito(@RequestParam(name = "id") int id){
        carritoProductoService.eliminarCarritoProducto(id);
        return "redirect:/carrito";
    }
}
