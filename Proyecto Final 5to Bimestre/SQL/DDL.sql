-- DDL --
create DATABASE tienda;
use tienda;
show TABLES;
show databases;
drop database tienda;

create table if not exists tbl_usuario(
id int not null auto_increment,
primary key(id),
unique (id),
usuario varchar (50),
password varchar (50),
nombre varchar (50),
email varchar (50),
id_tipo int (10)
);

select * from tbl_preveedor;

create table if not exists tbl_cliente(
id_cliente int not null auto_increment,
primary key(id_cliente),
unique (id_cliente),
nombre varchar (50),
apellido varchar (50),
direccion varchar (50),
telefono varchar (50),
email varchar (50),
estado_activo boolean

);

create table if not exists tbl_proveedor(
id_proveedor int not null auto_increment,
primary key(id_proveedor),
unique (id_proveedor),
proveedor varchar (50),
producto varchar (50),
estado_activo boolean

);

drop table tbl_proveedores;
create table if not exists tbl_producto(
id_producto  int not null AUTO_INCREMENT,
PRIMARY KEY (id_producto),
unique (id_producto),
producto varchar (50),
marca varchar (50),
precio varchar (50),
estado_activo boolean
);

drop table tbl_producto;

create table if not exists tbl_compra(
id_compra  int not null AUTO_INCREMENT,
PRIMARY KEY (id_compra),
unique (id_compra),
id_producto int not null,
id_cliente int not null,
fecha_compra varchar (50),
estado_activo boolean
);

drop table tbl_compra;


create table if not exists tbl_venta(
id_venta int not null AUTO_INCREMENT,
PRIMARY KEY (id_venta),
unique (id_venta),
fecha_venta varchar (50)
);

create table if not exists tbl_detalle_compra_venta(
id_detalle_compra_venta int not null AUTO_INCREMENT,
primary key (id_detalle_compra_venta),
unique (id_detalle_compra_venta),
id_compra int not null,
id_venta int not null,
foreign key (id_compra) references tbl_compra(id_compra),
foreign key (id_venta) references tbl_venta(id_venta)
);
