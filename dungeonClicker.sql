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
	icon VARCHAR(50) NOT NULL);
    
CREATE TABLE attack(
	id VARCHAR(36) PRIMARY KEY NOT NULL,
	buff INT(5) NOT NULL,
	debuff INT(5) NOT NULL,
	cd INT(5) NOT NULL,
    main BOOL NOT NULL);


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
    
    FOREIGN KEY(id_user) REFERENCES user(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(attackP_id) REFERENCES attack(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(attackS_id) REFERENCES attack(id) ON DELETE CASCADE ON UPDATE CASCADE);
    
CREATE TABLE textureChampion(
	id VARCHAR(36) PRIMARY KEY NOT NULL,
    name VARCHAR(20) NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    img VARCHAR(50) NOT NULL);
    
CREATE TABLE textureAttack(
	id VARCHAR(36) PRIMARY KEY NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    img VARCHAR(50) NOT NULL,
    attack_id VARCHAR(36) NOT NULL,
    
    FOREIGN KEY(attack_id) REFERENCES attack(id) ON DELETE CASCADE ON UPDATE CASCADE);

INSERT INTO user values ('df9ad349-5936-4fb0-9cfc-d94366c6e7e3', 'admin', 'admin', 'admin@admin.es', 'Hombre', 99, 50,
                         0, 0, 9999999, 4, 'icon.png');
    