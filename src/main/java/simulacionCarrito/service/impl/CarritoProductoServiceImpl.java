/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacionCarrito.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simulacionCarrito.DAO.CarritoProductoDAO;
import simulacionCarrito.entities.Carrito;
import simulacionCarrito.entities.CarritoProducto;
import simulacionCarrito.entities.Productos;
import simulacionCarrito.service.ICarritoProductoService;

@Service
public class CarritoProductoServiceImpl implements ICarritoProductoService{

    @Autowired
    private CarritoProductoDAO serviceDAO;
    
    @Override
    public void guardarCarritoProducto(CarritoProducto carritoProducto) {
        serviceDAO.save(carritoProducto);
    }

    @Override
    public void eliminarCarritoProducto(int id) {
        serviceDAO.deleteById(id);
    }

    @Override
    public CarritoProducto buscarSiExiste(Productos producto,Carrito carrito) {
        return serviceDAO.findByIdProductoAndIdCarrito(producto,carrito).orElse(null);
    }

    @Override
    public CarritoProducto buscarCarrito(int id) {
        return serviceDAO.findById(id).orElse(null);
    }
    
}
