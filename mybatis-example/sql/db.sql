CREATE DATABASE IF NOT EXISTS test DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

use test;

CREATE TABLE IF NOT EXISTS t_movie (
	mid int(10) NOT NULL,
	title varchar(128) NOT NULL,
	genres varchar(256) NOT NULL,

	PRIMARY KEY(mid)
) ENGINE=InnoDB DEFAULT CHARSET utf8 COLLATE utf8_general_ci;