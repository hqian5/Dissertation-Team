create database `airline`;
CREATE TABLE `airline`.`booking` (
  `booking_id` int(11) NOT NULL AUTO_INCREMENT,
  `passenger_id` int(11) DEFAULT NULL,
  `flight_id` int(11) DEFAULT NULL,
  `seat_number` int(11) DEFAULT NULL,
  `payment_id` int(11) DEFAULT NULL,
  `discount_id` int(11) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`booking_id`) ,
  UNIQUE KEY `flight_id` (`flight_id`,`passenger_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `airline`.`flight` (
 `flightid` int(11) NOT NULL,
 `flight_number` varchar(30) DEFAULT NULL,
 `departure_time` varchar(30) DEFAULT NULL,
 `arrival_time` varchar(30) DEFAULT NULL,
 `departure_airport` varchar(30) DEFAULT NULL,
 `arrival_airport` varchar(30) DEFAULT NULL,
 `seat_number` int(11) DEFAULT NULL,
 `seat_free` int(11) DEFAULT NULL,
 `price` int(11) DEFAULT NULL,
 `flight_status` varchar(30) DEFAULT NULL,
 PRIMARY KEY (`flightid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `airline`.`iata_code` (
 `code` varchar(16) NOT NULL,
 `name` varchar(64) DEFAULT NULL,
 `country` varchar(64) DEFAULT NULL,
 `city` varchar(16) DEFAULT NULL,
 PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;