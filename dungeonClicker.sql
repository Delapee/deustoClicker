USE dungeonClicker;

CREATE TABLE user(
	id VARCHAR(36) PRIMARY KEY NOT NULL,
	name VARCHAR(50) UNIQUE NOT NULL,
	pass VARCHAR(100) NOT NULL,
	email VARCHAR(50) NOT NULL,
	gender VARCHAR(10) NOT NULL,
	age INT(3) NOT NULL,
	level INT(3) DEFAULT 1 NOT NULL,
	expMax INT(10) DEFAULT 1100 NOT NULL,
	expProgress INT(10) DEFAULT 0 NOT NULL,
	gold INT(10) DEFAULT 500 NOT NULL,
	autoClick INT(2) DEFAULT 0 NOT NULL,
	icon VARCHAR(50) NOT NULL,
    stage INT(2) DEFAULT 1 NOT NULL,
    stageLevel INT(2) DEFAULT 1 NOT NULL,
    raidLevel INT(2) DEFAULT 1 NOT NULL);

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
                         0, 0, 9999999, 4, 'icon.png', 1, 1, 1);

INSERT INTO champDrop values ('73913408-ded2-4d01-8665-8ceb735f51e2', 'Mercenario', 200, 75, 1,   0.5,  25);
INSERT INTO champDrop values ('efabd12c-10c2-4093-96ed-eeaf42c49927', 'MPeste',      50, 90, 1,   0.25, 50);
INSERT INTO champDrop values ('498f2cbf-9347-4558-8ba2-379b7630bdf8', 'Pirata',     150, 70, 1,   0.9,  80);
INSERT INTO champDrop values ('71c0a811-e4a0-40f5-bdea-09ff76bc902a', 'Mago',       100, 80, 1.5, 0.8,  75);

INSERT INTO champion values ('b28f15ef-fbd5-4bf7-9458-66a1fde90fc9', 'Mercenario', 1, 10, 1, 200, 75, 1, 0.5,  25, 0, '48e5c975-cbb3-46ee-81dd-0ca7fda3d7d9');
INSERT INTO champion values ('491176f5-9912-42c4-add8-64e92c6af429', 'Mercenario', 1, 20, 2, 200, 75, 1, 0.5,  25, 0, '48e5c975-cbb3-46ee-81dd-0ca7fda3d7d9');
INSERT INTO champion values ('6e88d341-c26e-4484-bf36-1f429cdfbafa', 'Mercenario', 1, 30, 3, 200, 75, 1, 0.5,  25, 0, '48e5c975-cbb3-46ee-81dd-0ca7fda3d7d9');
INSERT INTO champion values ('928e958e-944d-41ec-81d9-04a00d8bd7b7', 'Mercenario', 1, 40, 4, 200, 75, 1, 0.5,  25, 0, '48e5c975-cbb3-46ee-81dd-0ca7fda3d7d9');
INSERT INTO champion values ('d8b2f1d3-5cca-4116-beb5-ed77cbc27f38', 'Mercenario', 1, 50, 5, 200, 75, 1, 0.5,  25, 1, '48e5c975-cbb3-46ee-81dd-0ca7fda3d7d9');

INSERT INTO champion values ('e3f24299-6dcf-4ddb-8b84-0842f4f46620', 'MPeste', 1, 10, 1, 50, 90, 1, 0.25, 50, 0, '48e5c975-cbb3-46ee-81dd-0ca7fda3d7d9');
INSERT INTO champion values ('4e8daeb9-8011-48a3-a11c-970b926a1d94', 'MPeste', 1, 20, 2, 50, 90, 1, 0.25, 50, 0, '48e5c975-cbb3-46ee-81dd-0ca7fda3d7d9');
INSERT INTO champion values ('19be1b41-db19-41bb-8867-9ab792f91315', 'MPeste', 1, 30, 3, 50, 90, 1, 0.25, 50, 0, '48e5c975-cbb3-46ee-81dd-0ca7fda3d7d9');
INSERT INTO champion values ('08251d43-5cbb-48ae-8827-08c9b3844c2a', 'MPeste', 1, 40, 4, 50, 90, 1, 0.25, 50, 0, '48e5c975-cbb3-46ee-81dd-0ca7fda3d7d9');
INSERT INTO champion values ('9baff0cd-0199-4f0a-9ac9-a3613257e24b', 'MPeste', 1, 50, 5, 50, 90, 1, 0.25, 50, 1, '48e5c975-cbb3-46ee-81dd-0ca7fda3d7d9');

INSERT INTO champion values ('dea10c62-9ae9-4dfa-8f2c-8553d36459ef', 'Pirata', 1, 10, 1, 150, 70, 1, 0.9, 80, 0, '48e5c975-cbb3-46ee-81dd-0ca7fda3d7d9');
INSERT INTO champion values ('6aae102c-60e9-49a5-8bf1-59a98a5572d0', 'Pirata', 1, 20, 2, 150, 70, 1, 0.9, 80, 0, '48e5c975-cbb3-46ee-81dd-0ca7fda3d7d9');
INSERT INTO champion values ('17128d63-a4db-4503-81d9-181f28cbe834', 'Pirata', 1, 30, 3, 150, 70, 1, 0.9, 80, 0, '48e5c975-cbb3-46ee-81dd-0ca7fda3d7d9');
INSERT INTO champion values ('6dc30111-ddc1-4512-b29b-43fbaf100c7f', 'Pirata', 1, 40, 4, 150, 70, 1, 0.9, 80, 0, '48e5c975-cbb3-46ee-81dd-0ca7fda3d7d9');
INSERT INTO champion values ('262fec5b-49ac-4b0d-93c7-dc521cdc267b', 'Pirata', 1, 50, 5, 150, 70, 1, 0.9, 80, 1, '48e5c975-cbb3-46ee-81dd-0ca7fda3d7d9');

INSERT INTO champion values ('e1b2a62e-95d2-4fa2-a640-5c4433489fcd', 'Mago', 1, 10, 1, 100, 80, 1.5, 0.8, 75, 0, '48e5c975-cbb3-46ee-81dd-0ca7fda3d7d9');
INSERT INTO champion values ('06f1248d-3ed3-4472-a7ac-387f8251bcfa', 'Mago', 1, 20, 2, 100, 80, 1.5, 0.8, 75, 0, '48e5c975-cbb3-46ee-81dd-0ca7fda3d7d9');
INSERT INTO champion values ('c8caadc2-fdcf-43cc-8e36-77f4f6215912', 'Mago', 1, 30, 3, 100, 80, 1.5, 0.8, 75, 0, '48e5c975-cbb3-46ee-81dd-0ca7fda3d7d9');
INSERT INTO champion values ('41f026da-ea52-4f10-985a-134f771f19c9', 'Mago', 1, 40, 4, 100, 80, 1.5, 0.8, 75, 0, '48e5c975-cbb3-46ee-81dd-0ca7fda3d7d9');
INSERT INTO champion values ('375a0484-9c68-40bf-a1d6-967db06aad65', 'Mago', 1, 50, 5, 100, 80, 1.5, 0.8, 75, 1, '48e5c975-cbb3-46ee-81dd-0ca7fda3d7d9');