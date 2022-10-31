CREATE TABLE `car` (
  `code` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `carno` int(11) NOT NULL,
  `year` int(11) NOT NULL,
  `km` int(11) DEFAULT NULL,
  `price` int(11) NOT NULL,
  `kind` varchar(10) NOT NULL,
  `fuel` varchar(10) NOT NULL,
  `regdate` timestamp NOT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci