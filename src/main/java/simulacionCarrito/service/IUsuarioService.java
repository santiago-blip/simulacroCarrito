/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacionCarrito.service;

import simulacionCarrito.entities.Usuario;


public interface IUsuarioService {
    
    public void registrarUsuario(Usuario usario);
    
    public Usuario buscarPorNombre(String nombre);
}
