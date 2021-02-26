/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacionCarrito.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import simulacionCarrito.DAO.ProductoDAO;
import simulacionCarrito.entities.Productos;
import simulacionCarrito.service.IProductoService;

@Service
public class ProductoServiceImpl implements IProductoService{

    @Autowired
    private ProductoDAO serviceDAO;
    
    @Override
    public List<Productos> listarProductos() {
        return (List<Productos>)serviceDAO.findAll();
    }

    @Override
    public Productos buscarProducto(Productos producto) {
        return serviceDAO.findById(producto.getIdProducto()).orElse(null);
    }

    @Override
    public void guardarProducto(Productos producto) {
        serviceDAO.save(producto);
    }

    @Override
    public void eliminarProducto(int id) {
        serviceDAO.deleteById(id);
    }

//    @Override
//    public Page<Productos> findAll(Pageable page) {
//       return serviceDAO.findAll(page);
//    }
    
}
