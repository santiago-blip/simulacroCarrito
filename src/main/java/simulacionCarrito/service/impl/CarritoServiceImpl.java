/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacionCarrito.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simulacionCarrito.DAO.CarritoDAO;
import simulacionCarrito.entities.Carrito;
import simulacionCarrito.entities.Usuario;
import simulacionCarrito.service.ICarritoService;

@Service
public class CarritoServiceImpl implements ICarritoService{

    @Autowired
    private CarritoDAO serviceDAO;
    
    @Override
    public void guardarCarro(Carrito carrito) {
        serviceDAO.save(carrito);
    }

    @Override
    public Carrito findByIdUsuario(Usuario usuario) {
        return serviceDAO.findByIdUsuario(usuario);
    }
    
}
