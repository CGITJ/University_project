CREATE TABLE `student` (
  `name` varchar(20) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  `numbersss` varchar(30) DEFAULT NULL,
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO student VALUES ('付丁丁','19','贵州','21104131');
INSERT INTO student VALUES ('紫仁','29','长沙','1432552');
INSERT INTO student VALUES ('李均','15','天津','1321323');
INSERT INTO student VALUES ('王杰','25','秦皇岛','1327689678323');
INSERT INTO student VALUES ('陈杨','35','邢台','9678323');