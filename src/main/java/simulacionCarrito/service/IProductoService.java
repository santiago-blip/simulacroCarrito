/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacionCarrito.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import simulacionCarrito.entities.Productos;


public interface IProductoService {
    
    public List<Productos> listarProductos();
    
    public Page<Productos> findAll(Pageable page);
    
    public Productos buscarProducto(Productos producto);
    
    public void guardarProducto(Productos producto);
    
    public void eliminarProducto(int id);
}
