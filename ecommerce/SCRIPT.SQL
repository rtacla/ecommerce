CREATE DATABASE `compras` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE compras;

CREATE TABLE `produtos` (
  `codigo` int(11) NOT NULL,
  `descricao` varchar(45) DEFAULT NULL,
  `valor` decimal(19,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `produtos` (`codigo`,`descricao`,`valor`) VALUES (1,'feijao',10.00);
INSERT INTO `produtos` (`codigo`,`descricao`,`valor`) VALUES (2,'arroz',8.00);
INSERT INTO `produtos` (`codigo`,`descricao`,`valor`) VALUES (3,'tomate',5.00);
INSERT INTO `produtos` (`codigo`,`descricao`,`valor`) VALUES (4,'carne',15.00);

COMMIT;