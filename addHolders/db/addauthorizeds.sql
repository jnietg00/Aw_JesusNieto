
DROP DATABASE addauthorizeds;

CREATE DATABASE addauthorizeds;

GRANT ALL ON addauthorizeds.* TO addauthouser@'%' IDENTIFIED BY 'paddauthouser';
GRANT ALL ON addauthorizeds.* TO addauthouser@localhost IDENTIFIED BY 'paddauthouser';

USE addauthorizeds;

CREATE TABLE IF NOT EXISTS account (
	idAccount int(5) NOT NULL,
	PRIMARY KEY (idAccount)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;


CREATE TABLE IF NOT EXISTS authorized (
	dniNumber int(8) NOT NULL,
	dniLetter char(1) COLLATE utf8_spanish_ci NOT NULL,
	name varchar(40) COLLATE utf8_spanish_ci NOT NULL,
	idAccount int(10) NOT NULL,
	PRIMARY KEY (dniNumber)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

ALTER TABLE authorized
	ADD CONSTRAINT fk_AUTHORIZED_ACCOUNT1 FOREIGN KEY (idAccount) REFERENCES account (idAccount) ON DELETE NO ACTION ON UPDATE NO ACTION;
/*CREATE INDEX authorizeds_name ON authorizeds(name)*/;