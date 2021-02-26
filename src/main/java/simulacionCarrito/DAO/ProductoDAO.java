/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacionCarrito.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import simulacionCarrito.entities.Productos;


public interface ProductoDAO extends JpaRepository<Productos,Integer>{
    
}
