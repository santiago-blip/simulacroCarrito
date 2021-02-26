/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacionCarrito.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import simulacionCarrito.entities.Usuario;

/**
 *
 * @author santi
 */
public interface UsuarioDAO extends CrudRepository<Usuario,Integer>{
    
    @Transactional(readOnly = true)
    public Usuario findByUsuario(String usuario);
    
}
