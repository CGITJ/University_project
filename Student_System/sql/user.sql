CREATE TABLE `user` (
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO user VALUES ('admin','123');