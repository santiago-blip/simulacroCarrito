/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacionCarrito.service;

import simulacionCarrito.entities.Carrito;
import simulacionCarrito.entities.CarritoProducto;
import simulacionCarrito.entities.Productos;

/**
 *
 * @author santi
 */
public interface ICarritoProductoService {
    
    public void guardarCarritoProducto(CarritoProducto carritoProducto);
    
    public CarritoProducto buscarCarrito(int id);
    
    public CarritoProducto buscarSiExiste(Productos producto,Carrito carrito);
    
    public void eliminarCarritoProducto(int id);
    
}
