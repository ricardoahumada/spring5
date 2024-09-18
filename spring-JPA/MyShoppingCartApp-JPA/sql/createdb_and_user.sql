CREATE SCHEMA `productos_db` ;

USE mysql;

CREATE USER 'productos_user'@'%' IDENTIFIED BY 'prod123';

GRANT ALL PRIVILEGES ON productos_db.* TO 'productos_user'@'%';
FLUSH PRIVILEGES;
