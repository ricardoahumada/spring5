CREATE SCHEMA `bananawhatsappdb` ;

USE mysql;

CREATE USER 'bananauser'@'%' IDENTIFIED BY 'banana123';

GRANT ALL PRIVILEGES ON bananawhatsappdb.* TO 'bananauser'@'%';
FLUSH PRIVILEGES;