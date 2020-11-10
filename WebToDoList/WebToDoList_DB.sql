DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS todo;

SET GLOBAL time_zone = '+1:00';

CREATE SCHEMA IF NOT EXISTS `webtodolist` DEFAULT CHARACTER SET utf8 ;
USE `webtodolist`;

CREATE TABLE IF NOT EXISTS `webtodolist`.`user` (
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `role` VARCHAR(7) NOT NULL,
  PRIMARY KEY (`username`));
  
  CREATE TABLE IF NOT EXISTS `webtodolist`.`todo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(200) DEFAULT NULL,
  PRIMARY KEY (`id`));
  
INSERT INTO `webtodolist`.`user` (`username`, `password`, `role`) VALUES ('teachertoto', 'toto', 'teacher');
INSERT INTO `webtodolist`.`user` (`username`, `password`, `role`) VALUES ('studentlolo', 'lolo', 'student');
select * from user;