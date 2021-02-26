/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacionCarrito.DAO;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import simulacionCarrito.entities.Carrito;
import simulacionCarrito.entities.CarritoProducto;
import simulacionCarrito.entities.Productos;

/**
 *
 * @author santi
 */
public interface CarritoProductoDAO extends CrudRepository<CarritoProducto,Integer>{
    
    @Transactional(readOnly = true)
    public Optional<CarritoProducto> findByIdProductoAndIdCarrito(Productos producto,Carrito carrito);
    
}
