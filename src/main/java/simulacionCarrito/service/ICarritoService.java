/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacionCarrito.service;

import simulacionCarrito.entities.Carrito;
import simulacionCarrito.entities.Usuario;

/**
 *
 * @author santi
 */
public interface ICarritoService {
    
    public void guardarCarro(Carrito carrito);
    
    public Carrito findByIdUsuario(Usuario usuario);
}
