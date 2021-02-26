/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacionCarrito.DAO;

import org.springframework.data.repository.CrudRepository;
import simulacionCarrito.entities.Carrito;
import simulacionCarrito.entities.Usuario;

/**
 *
 * @author santi
 */
public interface CarritoDAO extends CrudRepository<Carrito,Integer>{
    
    public Carrito findByIdUsuario(Usuario usuario);
    
}
