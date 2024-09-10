CREATE SCHEMA `accounts_db` ;

USE mysql;

CREATE USER 'account_user'@'%' IDENTIFIED BY 'acc123';

GRANT ALL PRIVILEGES ON accounts_db.* TO 'account_user'@'%';
FLUSH PRIVILEGES;
