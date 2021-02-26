/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacionCarrito.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_carrito_producto")
public class CarritoProducto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carrito_producto")
    private int idCarritoProducto;

    @ManyToOne
    @JoinColumn(name = "id_carrito")
    private Carrito idCarrito;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Productos idProducto;

    @Column(name = "cantidad_producto")
    private int cantidadProducto;

    @Column(name = "total_producto")
    private double totalProducto;

    public CarritoProducto() {

    }

    public int getIdCarritoProducto() {
        return idCarritoProducto;
    }

    public void setIdCarritoProducto(int idCarritoProducto) {
        this.idCarritoProducto= idCarritoProducto;
    }

    public Carrito getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(Carrito idCarrito) {
        this.idCarrito = idCarrito;
    }

    public Productos getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Productos idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public double getTotalProducto() {
        return totalProducto;
    }

    public void setTotalProducto(double totalProducto) {
        this.totalProducto = totalProducto;
    }

    public double getTotalProductoMethod() {
        this.totalProducto = 0;
        totalProducto += this.cantidadProducto * this.idProducto.getPrecioProducto();
        return totalProducto;
    }
}
