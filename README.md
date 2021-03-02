# simulacroCarrito

bd:
CREATE DATABASE simulacioncarrito;
USE simulacioncarrito;

CREATE TABLE tbl_rol(id_rol INT AUTO_INCREMENT,rol VARCHAR(10),PRIMARY KEY(id_rol));
CREATE TABLE tbl_productos(id_producto INT AUTO_INCREMENT,nombre_producto VARCHAR(25),precio_producto DOUBLE,stock_producto INT ,fecha_expedicion Date,PRIMARY KEY(id_producto));
CREATE TABLE tbl_usuario(id_usuario INT AUTO_INCREMENT,id_rol INT ,usuario VARCHAR(25),contraseña_usuario VARCHAR(60),FOREIGN KEY (id_rol) REFERENCES tbl_rol(id_rol),PRIMARY KEY(id_usuario));
CREATE TABLE tbl_carrito(id_carrito INT AUTO_INCREMENT,id_usuario INT, cantidad_producto int,total_producto double,total double,FOREIGN KEY(id_usuario) REFERENCES tbl_usuario (id_usuario) ,PRIMARY KEY(id_carrito));
CREATE TABLE tbl_carrito_producto(id_carrito_producto INT AUTO_INCREMENT,id_carrito INT, id_producto int,FOREIGN KEY(id_carrito) REFERENCES tbl_carrito (id_carrito),FOREIGN KEY(id_producto) REFERENCES tbl_productos (id_producto),PRIMARY KEY(id_carrito_producto));

important data:
insert into tbl_rol() VALUES (1,"ROLE_ADMIN");
insert into tbl_rol() VALUES (2,"ROLE_USER");
