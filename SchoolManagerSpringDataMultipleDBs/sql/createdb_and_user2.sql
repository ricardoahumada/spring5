CREATE SCHEMA `schooldb2` ;

USE mysql;

CREATE USER 'schooluser2'@'%' IDENTIFIED BY 'school1232';

GRANT ALL PRIVILEGES ON schooldb2.* TO 'schooluser2'@'%';
FLUSH PRIVILEGES;