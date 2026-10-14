drop database if exists mandatvm_db;
create database mandatvm_db;
use mandatvm_db;

create table usuario(
    id_usuario int auto_increment primary key,
    user_name varchar(30) not null,
    user_password varchar(30) not null,
    user_status boolean not null
);

create table sectorempresarial(
    id_sector int auto_increment primary key,
    nombre_rubro varchar(30) not null,
    encargado_contacto varchar(30) not null
);

create table asignacionpractica(
    id_asignacion int auto_increment primary key,
    nombre_alumno varchar(50) not null,
    nombre_empresa varchar(50) not null,
    telefono_oficina varchar(15) not null,
    id_sector int not null,
    foreign key (id_sector) references sectorempresarial(id_sector)
);

insert into usuario(user_name, user_password, user_status) values
    ('ludvinxd', '1234', true),
    ('ludvingod', '1234', false);

insert into sectorempresarial(nombre_rubro, encargado_contacto) values
    ('banca', 'ludvinxd'),
    ('tecnologia', 'ludvinxd'),
    ('industria', 'ludvinxd');

create view view_read_asignacion as
select a.id_asignacion, a.nombre_alumno, a.nombre_empresa, a.telefono_oficina, a.id_sector, s.nombre_rubro
from asignacionpractica a
inner join sectorempresarial s on a.id_sector = s.id_sector;

delimiter $$

create procedure sp_validar_usuario(in p_user_name varchar(30), in p_user_password varchar(30))
begin
    select id_usuario, user_name, user_status
    from usuario
    where user_name = p_user_name and user_password = p_user_password;
end$$

create procedure sp_crear_asignacion(in p_nombre_alumno varchar(50), in p_nombre_empresa varchar(50), in p_telefono_oficina varchar(15), in p_id_sector int)
begin
    insert into asignacionpractica(nombre_alumno, nombre_empresa, telefono_oficina, id_sector)
    values (p_nombre_alumno, p_nombre_empresa, p_telefono_oficina, p_id_sector);
end$$

create procedure sp_actualizar_asignacion(in p_id_asignacion int, in p_nombre_alumno varchar(50), in p_nombre_empresa varchar(50), in p_telefono_oficina varchar(15), in p_id_sector int)
begin
    update asignacionpractica
    set nombre_alumno = p_nombre_alumno,
        nombre_empresa = p_nombre_empresa,
        telefono_oficina = p_telefono_oficina,
        id_sector = p_id_sector
    where id_asignacion = p_id_asignacion;
end$$

create procedure sp_eliminar_asignacion(in p_id_asignacion int)
begin
    delete from asignacionpractica where id_asignacion = p_id_asignacion;
end$$

delimiter ;
