USE dungeonClicker;

CREATE TABLE user(
	id VARCHAR(36) PRIMARY KEY NOT NULL,
	name VARCHAR(50) UNIQUE NOT NULL,
	pass VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	gender VARCHAR(10) NOT NULL,
	age INT(3) NOT NULL,
	level INT(3) NOT NULL,
	expMax INT(10) NOT NULL,
	expProgress INT(10) NOT NULL,
	gold INT(10) NOT NULL,
	autoClick INT(2) NOT NULL,
	icon VARCHAR(50) NOT NULL,
    stage INT(2) DEFAULT 1 NOT NULL,
    stageLevel INT(2) DEFAULT 1 NOT NULL);

CREATE TABLE champion(
	id VARCHAR(36) PRIMARY KEY NOT NULL,
	name VARCHAR(16) NOT NULL,
	level INT(3) NOT NULL,
	levelMax INT(3) NOT NULL,
	rare INT(2) NOT NULL,
	dmg INT(10) NOT NULL,
	accuracy DEC(3,2) NOT NULL,
    attackSpeed DEC(3,2) NOT NULL,
    criticProb DEC(3,2) NOT NULL,
    dodgeProb DEC(3,2) NOT NULL,
    attackP_id VARCHAR(36) NOT NULL,
    attackS_id VARCHAR(36) NOT NULL,
	onSquad BOOL NOT NULL,
    id_user VARCHAR(36) NOT NULL,
    
    FOREIGN KEY(id_user) REFERENCES user(id) ON DELETE CASCADE ON UPDATE CASCADE);

CREATE TABLE champDrop(
    id VARCHAR(36) PRIMARY KEY NOT NULL,
    name VARCHAR(16) NOT NULL,
    dmg INT(10) NOT NULL,
    accuracy DEC(3,2) NOT NULL,
    attackSpeed DEC(3,2) NOT NULL,
    criticProb DEC(3,2) NOT NULL,
    dodgeProb DEC(3,2) NOT NULL);

INSERT INTO user values ('df9ad349-5936-4fb0-9cfc-d94366c6e7e3', 'admin', 'JXMTnpd9uNk=', 'admin@admin.es', 'Hombre', 99, 50,
                         0, 0, 9999999, 4, 'icon.png', 1, 1);

INSERT INTO champDrop values ('73913408-ded2-4d01-8665-8ceb735f51e2', 'Mercenario', 200, 75, 1,   0.5,  25);
INSERT INTO champDrop values ('efabd12c-10c2-4093-96ed-eeaf42c49927', 'MPeste',      50, 90, 1,   0.25, 50);
INSERT INTO champDrop values ('498f2cbf-9347-4558-8ba2-379b7630bdf8', 'Pirata',     150, 70, 1,   0.9,  80);
INSERT INTO champDrop values ('71c0a811-e4a0-40f5-bdea-09ff76bc902a', 'Mago',       100, 80, 1.5, 0.8,  75);