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
import javax.persistence.Table;

@Entity
@Table(name = "tbl_rol")
public class Rol implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private int idRol;
    
    private String rol;
    
    public Rol(){}
    
    public void setIdRol(int idRol){
        this.idRol = idRol;
    }
    
    public void setRol(String rol){
        this.rol = rol;
    }
    
    public int getIdRol(){
        return this.idRol;
    }
    
    public String getRol(){
        return this.rol;
    }
    
    
}
