create database `airline`;
CREATE TABLE `airline`.`booking` (
  `booking_id` int(11) NOT NULL AUTO_INCREMENT,
  `passenger_id` int(11) DEFAULT NULL,
  `flight_id` int(11) DEFAULT NULL,
  `seat_id` int(11) DEFAULT NULL,
  `payment_id` int(11) DEFAULT NULL,
  `discount_id` int(11) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`booking_id`) ,
  UNIQUE KEY `flight_id` (`flight_id`,`passenger_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `airline`.`flight` (
  `flight_id` int(11) NOT NULL,
  `name` varchar(64) DEFAULT NULL,
  `airport_departure` int(11) DEFAULT NULL,
  `airport_destination` int(11) DEFAULT NULL,
  `departure_date` date DEFAULT NULL,
  `departure_time` time DEFAULT NULL,
  `destination_date` date DEFAULT NULL,
  `destination_time` time DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `description` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`flight_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `airline`.`seat` (
  `seat_id` int(11) NOT NULL,
  `flight_id` int(11) NOT NULL,
  `location_x` int(11) DEFAULT NULL,
  `location_y` int(11) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `booked` int(11) DEFAULT '0',
  PRIMARY KEY (`flight_id`,`seat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;