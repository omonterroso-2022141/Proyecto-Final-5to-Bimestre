use tienda;
-- sp y views --

-- vistas --
-- vistas --

create view mostrar_clientes AS
select id_cliente, nombre,apellido,direccion,telefono,email
from tbl_Cliente;

create view mostrar_usuarios AS
select id, usuario,password,nombre,email,id_tipo
from tbl_Usuario;

create view mostrar_compras AS
select id_compra, fecha_compra
from tbl_Compra;

create view mostrar_ventas AS
select id_venta, fecha_venta
from tbl_Venta;

create view mostrar_detalle_compra_venta AS
select id_detalle_compra_venta, id_compra, id_venta
from tbl_detalle_compra_venta;

-- PROCEDURES --
-- AGREGAR --
DELIMITER //
create procedure sp_agregar_cliente
(in nombre varchar(50),in apellido varchar(50), in direccion varchar(50), in telefono varchar(50),email varchar(50), estado_activo boolean)
begin
insert into tbl_cliente(nombre,apellido,direccion,telefono,email,estado_activo)
values (nombre,apellido,direccion,telefono,email,estado_activo);
end //
DELIMITER ;

select * from tbl_cliente;
drop procedure sp_agregar_cliente;

DELIMITER //
create procedure sp_agregar_usuario
(in _usuario varchar(50),in _contraseña varchar(50), in _id_cliente int(10),_estado_activo boolean, _rol boolean)
begin
insert into tbl_usuario(_usuario,_contraseña,_id_cliente,_estado_activo,_rol)
values (_usuario,_contraseña,_id_cliente,_estado_activo,_rol);
end //
DELIMITER ;

select * from tbl_usuario;

DELIMITER //
create procedure sp_agregar_producto
(in producto varchar(50),in marca varchar(50), in precio varchar(50),estado_activo boolean)
begin
insert into tbl_producto(producto,marca,precio,estado_activo)
values (producto,marca,precio,estado_activo);
end //
DELIMITER ;

drop procedure sp_agregar_proveedores;
select * from tbl_producto;

DELIMITER //
create procedure sp_agregar_proveedor
(in proveedor varchar(50),in producto varchar(50),estado_activo boolean)
begin
insert into tbl_proveedor(proveedor,producto,estado_activo)
values (proveedor,producto,estado_activo);
end //
DELIMITER ;

DELIMITER //
create procedure sp_agregar_compra
(in _id_compra int ,in _id_producto int, in _id_cliente int,_fecha_compra varchar (50) ,_estado_activo boolean)
begin
insert into tbl_compra(_id_compra,_id_producto,_id_cliente,_fecha_compra,_estado_activo)
values (_id_compra,_id_producto,_id_cliente,_fecha_compra,_estado_activo);
end //
DELIMITER ;

select * from tbl_compra;

DELIMITER //
create procedure sp_agregar_venta
(in _id_venta int ,in _fecha_compra varchar(50))
begin
insert into tbl_compra(_id_venta,_fecha_compra)
values (_id_venta,_fecha_compra);
end //
DELIMITER ;

DELIMITER //
create procedure sp_agregar_detalle
(in _id_detalle_compra_venta int ,in id_compra int, in id_venta int)
begin
insert into tbl_detalle_compra_venta(_id_detalle_compra_venta,id_compra,id_venta)
values (_id_detalle_compra_venta,id_compra,id_venta);
end //
DELIMITER ;

-- eliminar --
DELIMITER //
create procedure eliminar_cliente
(in id_producto int)
begin
delete from tbl_Cliente
where id_cliente = id_cliente;
end//
DELIMITER ;

DELIMITER //
create procedure eliminar_usuario
(in id_usuario int)
begin
delete from tbl_Usuario
where id_usuario = id_usuario;
end//
DELIMITER ;

DELIMITER //
create procedure eliminar_producto (in id int)
begin
delete from tbl_Producto where id_producto= id;
end//
DELIMITER ;

DELIMITER //
create procedure eliminar_proveedor (in id int)
begin
delete from tbl_Proveedor where id_proveedor= id;
end//
DELIMITER ;

drop procedure eliminar_cliente;


call eliminar_producto(4);

-- ACTUALIZAR --
DELIMITER //
create procedure actualizar_cliente
(in id_cliente int, in nombre varchar(50),in apellido varchar(50), in direccion varchar(50), in telefono varchar(50),email varchar(50))
begin
update tbl_cliente
set id_cliente= id_cliente, nombre = nombre , apellido = apellido, direccion = direccion, telefono =  telefono ,email = email,estado_activo = estado_activo
where tbl_cliente.id_cliente = id_cliente;
end//
DELIMITER ;

DELIMITER //
create procedure actualizar_usuario
(in _usuario varchar(50),in _contraseña varchar(50), in _id_cliente int(10))
begin
update tbl_Usuario
set usuario = _usuario , contraseña = _contraseña, id_cliente = _id_cliente
where tbl_usuario.id_usuario = id_usuario;
end//
DELIMITER ;

DELIMITER //
create procedure actualizar_producto(in id_producto int,in producto varchar (50), in marca varchar(50), in precio varchar(50))
begin
update tbl_Producto
set id_producto = id_producto, producto = producto , marca = marca, precio = precio, estado_activo = estado_activo
where tbl_producto.id_producto = id_producto;
end//
DELIMITER ;

DELIMITER //
create procedure actualizar_proveedor(in id_proveedor int,in proveedor varchar(50),in producto varchar (50))
begin
update tbl_Proveedor
set id_proveedor= id_proveedor,proveedor = proveedor, producto = producto , estado_activo = estado_activo
where tbl_proveedor.id_proveedor = id_proveedor;
end//
DELIMITER ;

drop procedure actualizar_cliente;	

call actualizar_proveedor (2,"Home","Cafetera");

select * from tbl_proveedor;

-- Mostrar --
DELIMITER //
create procedure sp_mostrarProducto()
begin
select * from tbl_producto;
end //
DELIMITER ;

DELIMITER //
create procedure sp_mostrarProveedor()
begin
select * from tbl_proveedor;
end//
DELIMITER;

DELIMITER //
create procedure sp_mostrarCliente()
begin
select * from tbl_cliente;
end//
DELIMITER;

DELIMITER //
create procedure sp_mostrarUsuario()
begin
select * from tbl_usuario;
end //
DELIMITER 
set global time_zone = "-5:00";


