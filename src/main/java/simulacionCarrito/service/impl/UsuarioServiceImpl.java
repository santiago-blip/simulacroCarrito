/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacionCarrito.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simulacionCarrito.DAO.UsuarioDAO;
import simulacionCarrito.entities.Usuario;
import simulacionCarrito.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

    @Autowired
    private UsuarioDAO serviceDAO;
    
    @Override
    public void registrarUsuario(Usuario usario) {
        serviceDAO.save(usario);
    }

    @Override
    public Usuario buscarPorNombre(String nombre) {
       return serviceDAO.findByUsuario(nombre);
    }
    
}
