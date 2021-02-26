/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacionCarrito.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_carrito")
public class Carrito implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carrito")
    private int idCarrito;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario idUsuario;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_carrito")
    private List<CarritoProducto> idCarritoProducto;


    @Column(name = "total")
    private double totalCarrito;

    public double getTotalCarritoMethod() {
        this.totalCarrito = 0;
        for (CarritoProducto carrito : this.idCarritoProducto) {
            totalCarrito += carrito.getTotalProductoMethod();
        }
        return this.totalCarrito;
    }

    public Carrito() {

    }

    public int getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(int idCarrito) {
        this.idCarrito = idCarrito;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<CarritoProducto> getIdCarritoProducto() {
        return idCarritoProducto;
    }

    public void setIdCarritoProducto(List<CarritoProducto> idCarritoProducto) {
        this.idCarritoProducto = idCarritoProducto;
    }


    public double getTotalCarrito() {
        return totalCarrito;
    }

    public void setTotalCarrito(double totalCarrito) {
        this.totalCarrito = totalCarrito;
    }


}
