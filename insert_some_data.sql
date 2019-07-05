INSERT INTO day (name) values ('Lunes');
INSERT INTO day (name) values ('Martes');
INSERT INTO day (name) values ('Miercoles');
INSERT INTO day (name) values ('Jueves');
INSERT INTO day (name) values ('Sabado');
INSERT INTO day (name) values ('Domingo');

Insert INTO specialty (description, name) values ('Especialidad que se ocupa de problemas alimenticios', 'Nutricionista');
Insert INTO specialty (description, name) values ('Especialidad que se ocupa de la salud mental de los pacientes', 'Psicologo');
Insert INTO specialty (description, name) values ('Especialidad que se ocupa de la salud mental de los pacientes', 'Psiquiatra');
Insert INTO specialty (description, name) values ('Resuelve consultas generales', 'Clinico');
Insert INTO specialty (description, name) values ('Profesional que trata problemas en la piel', 'Dermatologo');
Insert INTO specialty (description, name) values ('Especialización en problemas cardiacos', 'Cardiologo');
Insert INTO specialty (description, name) values ('Mejora el habla de las personas', 'Fonodiologo');

Insert INTO role(role) values ("ROLE_USER");
Insert INTO role(role) values ("ROLE_ADMIN");
Insert INTO role(role) values ("ROLE_DOCTOR");

Insert INTO user(address, cuil, dni, fist_name, last_name, role_id, is_bloqued, password) values ("Av. Independencia 89","89898989","8898989","Horacio", "Lopez",2, 0, "hola");
Insert INTO user(address, cuil, dni, fist_name, last_name, role_id, is_bloqued, password) values ("Av. Constitucion 01","09019090","090193191","Ana", "Martinez",2, 0, "hola");
Insert INTO user(address, cuil, dni, fist_name, last_name, role_id, is_bloqued, password) values ("Irigoyen 9191","8931398","1939171","Jorge", "Greco",2, 0, "hola");
Insert INTO user(address, cuil, dni, fist_name, last_name, role_id, is_bloqued, password) values ("Matienzo 9191","290192","931083","Leonel", "Duhalde",2, 0, "hola");
Insert INTO user(address, cuil, dni, fist_name, last_name, role_id, is_bloqued, password) values ("Calle 109 N° 2929","1279283","12792834","Adriana", "Perez",2, 0, "hola");
Insert INTO user(address, cuil, dni, fist_name, last_name, role_id, is_bloqued, password) values ("Calle 27 N°199","3482937","829362","Juliana", "Lopez",2, 0, "hola");

Insert INTO user(address, cuil, dni, fist_name, last_name, role_id, is_bloqued, password) values ("Av. Independencia 90","898933","885989","Cludia", "Lopez",3, 0, "hola");
Insert INTO user(address, cuil, dni, fist_name, last_name, role_id, is_bloqued, password) values ("Av. Constitucion 20","09011520","82929873","Gerardo", "Martinez",3, 0, "hola");
Insert INTO user(address, cuil, dni, fist_name, last_name, role_id, is_bloqued, password) values ("Irigoyen 91","8931398","134452171","Guillermo", "Ferro",3, 0, "hola");
Insert INTO user(address, cuil, dni, fist_name, last_name, role_id, is_bloqued, password) values ("Matienzo 91","290192","93352313","Paulo", "Londra",3, 0, "hola");
Insert INTO user(address, cuil, dni, fist_name, last_name, role_id, is_bloqued, password) values ("Calle 101 N° 2929","1279443","122792834","Ailen", "Wisca",3, 0, "hola");
Insert INTO user(address, cuil, dni, fist_name, last_name, role_id, is_bloqued, password) values ("Calle 37 N°199","3480837","8293462","Pedro", "Villareal",3, 0, "hola");

Insert INTO user(address, cuil, dni, fist_name, last_name, role_id, is_bloqued, password) values ("Avenida Assembler","899388","4000298","Jorge", "Osio",1, 0, "hola");

INSERT INTO doctor (enrollment, fist_name, last_name, specialty_id, user_id) values (1231, 'Horacio', 'Lopez', 2, 1);
INSERT INTO doctor (enrollment, fist_name, last_name, specialty_id, user_id) values (1231, 'Ana', 'Martinez', 2, 2);
INSERT INTO doctor (enrollment, fist_name, last_name, specialty_id, user_id) values (1231, 'Jorge', 'Greco', 3, 3);
INSERT INTO doctor (enrollment, fist_name, last_name, specialty_id, user_id) values (1231, 'Leonel', 'Duhalde', 4, 4);
INSERT INTO doctor (enrollment, fist_name, last_name, specialty_id, user_id) values (1231, 'Adriana', 'Perez', 5, 5);
INSERT INTO doctor (enrollment, fist_name, last_name, specialty_id, user_id) values (1231, 'Juliana', 'Lopez', 5, 6);

Insert INTO user(address, cuil, dni, fist_name, last_name, role_id, is_bloqued, password) values ("Calle 10 N°12","40094782","400947823","Nicole", "Denon",1, 0, "hola");
Insert INTO user(address, cuil, dni, fist_name, last_name, role_id, is_bloqued, password) values ("Calchaqui 87","81981827","819818272","Dario", "Lopez",1, 0, "hola");
Insert INTO user(address, cuil, dni, fist_name, last_name, role_id, is_bloqued, password) values ("Quilmes 933","41982198","419821982","Santiago", "Doti",1, 0, "hola");

Insert INTO turn(attended, date, doctor_id, user_id, hour) values(0, '2019-07-07 ', 2, 1, '18:00' );
Insert INTO turn(attended, date, doctor_id, user_id, hour) values(0, '2019-07-10', 2, 1 , '18:00');
Insert INTO turn(attended, date, doctor_id, user_id, hour) values(0, '2019-07-07', 2, 1 , '18:00');
Insert INTO turn(attended, date, doctor_id, user_id, hour) values(0, '2019-07-07', 2, 1 , '18:00');
Insert INTO turn(attended, date, doctor_id, user_id, hour) values(0, '2019-07-07', 2, 1 , '18:00');
Insert INTO turn(attended, date, doctor_id, user_id, hour) values(0, '2019-07-07', 2, 1 , '18:00');
Insert INTO turn(attended, date, doctor_id, user_id, hour) values(0, '2019-07-07', 2, 1 , '18:00');
Insert INTO turn(attended, date, doctor_id, user_id, hour) values(0, '2019-07-07', 2, 1 , '18:00');
Insert INTO turn(attended, date, doctor_id, user_id, hour) values(0, '2019-07-07', 2, 1 , '18:00');

Insert INTO diagnostic(description, turn_id) values("Morira en 10 dias", 1);
Insert INTO diagnostic(description, turn_id) values("Solo tiene un resfrio", 2);

Insert INTO schedule(hour_since, hour_to, day_id, doctor_id) values("9:00", "18:00", 1, 1);
Insert INTO schedule(hour_since, hour_to, day_id, doctor_id) values("9:00", "18:00", 2, 1);
Insert INTO schedule(hour_since, hour_to, day_id, doctor_id) values("9:00", "18:00", 3, 1);
Insert INTO schedule(hour_since, hour_to, day_id, doctor_id) values("9:00", "18:00", 4, 1);
Insert INTO schedule(hour_since, hour_to, day_id, doctor_id) values("9:00", "18:00", 5, 1);
Insert INTO schedule(hour_since, hour_to, day_id, doctor_id) values("7:00", "16:00", 1, 2);
Insert INTO schedule(hour_since, hour_to, day_id, doctor_id) values("7:00", "16:00", 2, 2);
Insert INTO schedule(hour_since, hour_to, day_id, doctor_id) values("7:00", "16:00", 3, 2);
Insert INTO schedule(hour_since, hour_to, day_id, doctor_id) values("7:00", "16:00", 4, 2);
Insert INTO schedule(hour_since, hour_to, day_id, doctor_id) values("7:00", "16:00", 5, 2);
Insert INTO schedule(hour_since, hour_to, day_id, doctor_id) values("11:00", "20:00", 6, 3);
Insert INTO schedule(hour_since, hour_to, day_id, doctor_id) values("11:00", "20:00", 7, 3);
Insert INTO schedule(hour_since, hour_to, day_id, doctor_id) values("7:00", "16:00", 6, 4);
Insert INTO schedule(hour_since, hour_to, day_id, doctor_id) values("7:00", "16:00", 7, 4);
Insert INTO schedule(hour_since, hour_to, day_id, doctor_id) values("10:00", "20:00", 1, 5);
Insert INTO schedule(hour_since, hour_to, day_id, doctor_id) values("10:00", "20:00", 2, 5);
Insert INTO schedule(hour_since, hour_to, day_id, doctor_id) values("10:00", "20:00", 3, 5);
Insert INTO schedule(hour_since, hour_to, day_id, doctor_id) values("10:00", "20:00", 4, 5);
Insert INTO schedule(hour_since, hour_to, day_id, doctor_id) values("10:00", "20:00", 5, 5);
Insert INTO schedule(hour_since, hour_to, day_id, doctor_id) values("9:00", "18:00", 1, 6);
Insert INTO schedule(hour_since, hour_to, day_id, doctor_id) values("9:00", "18:00", 2, 6);
Insert INTO schedule(hour_since, hour_to, day_id, doctor_id) values("9:00", "18:00", 3, 6);
Insert INTO schedule(hour_since, hour_to, day_id, doctor_id) values("9:00", "18:00", 4, 6);
Insert INTO schedule(hour_since, hour_to, day_id, doctor_id) values("9:00", "18:00", 5, 6);
