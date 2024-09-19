create database restaurante;

use restaurante;

create table plato(
    id int auto_increment primary key,
    nombre varchar(100),
    precio decimal,
    disponibilidad boolean
);

create table mesa(
    id int auto_increment primary key,
    numero_mesas int unique,
    ocupada boolean
);