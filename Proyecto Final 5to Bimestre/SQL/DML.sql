use tienda;
-- DML --
-- DML --

insert into tbl_Cliente (nombre,apellido,direccion,telefono,email)
values 
('Oscar','Monterroso','17 avenida F 10-15 zona 22','41574862','omonterroso-2022141@kinal.edu.gt'),
('Marcelino','Barriga','17 avenida F 10-15 zona 22','48956487','Mbarriga-2022142@kinal.edu.gt'),
('Felix','Varela','17 avenida F 10-15 zona 22','23654885','fvarela-2022143@kinal.edu.gt'),
('Irene','Mancebo','17 avenida F 10-15 zona 22','23365412','imancebo-2022144@kinal.edu.gt'),
('Eusebia','Tenorio','17 avenida F 10-15 zona 22','77894451','etenorio-2022145@kinal.edu.gt'),
('Jose','Mari','17 avenida F 10-15 zona 22','11564726','jmari-2022146@kinal.edu.gt'),
('Joaquin','Puente','17 avenida F 10-15 zona 22','22987445','jpuente-2022147@kinal.edu.gt'),
('Luis','Estrada','17 avenida F 10-15 zona 22','34456846','lestrada-2022148@kinal.edu.gt'),
('Hugo','Duran','17 avenida F 10-15 zona 22','41558977','hduran-2022149@kinal.edu.gt'),
('Reyes','Farre','17 avenida F 10-15 zona 22','98564231','rfarre-2022150@kinal.edu.gt');

select * from tbl_proveedor;

insert into tbl_Producto (producto,marca,precio)
values
('Olla','Le Creuset','456'),
('Sarten antiadherente','Todo Revestido','255'),
('Cuchillo de sierra','Cuisinart','60'),
('Tabla de cortar','Royal Doulton','20'),
('Rayador','Farberware','35'),
('Abrelatas','Littala','15'),
('Tijeras de cocina','Tefal','20'),
('Espatula','Kitchenaid','25'),
('Batidor','Oster','560'),
('Escurridor','Patito','16');

select * from tbl_usuario;

insert into tbl_Proveedor (proveedor,producto)
values
('Le Creuset','Olla'),
('Todo Revestido','Sarten antiadherente'),
('Cuisinart','Cuchillo de sierra'),
('Royal Doulton','Tabla de cortar'),
('Farberware','Rayador'),
('Littala','Abrelatas'),
('Tefal','Tijeras de cocina'),
('Kitchenaid','Espatula'),
('Oster','Batidor'),
('Patito','Escurridor');