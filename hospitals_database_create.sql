create table diagnostic (id bigint not null auto_increment, description varchar(255), turn_id bigint, primary key (id)) engine=InnoDB
create table doctor (id bigint not null auto_increment, enrollment varchar(255), fist_name varchar(255), last_name varchar(255), specialty_id bigint, primary key (id)) engine=InnoDB
create table role (id bigint not null auto_increment, role varchar(255), primary key (id)) engine=InnoDB
create table schedule (id bigint not null auto_increment, day varchar(255), hour_since datetime, hour_to datetime, doctor_id bigint, primary key (id)) engine=InnoDB
create table specialty (id bigint not null auto_increment, description varchar(255), name varchar(255), primary key (id)) engine=InnoDB
create table turn (id bigint not null auto_increment, attended bit not null, date datetime, doctor_id bigint, user_id bigint, primary key (id)) engine=InnoDB
create table user (id bigint not null auto_increment, address varchar(255), cuil varchar(255), dni varchar(255), fist_name varchar(255), last_name varchar(255), role_id bigint, primary key (id)) engine=InnoDB
alter table diagnostic add constraint FKq2s0e15hv5aaufa9tmg5of6lp foreign key (turn_id) references turn (id)
alter table doctor add constraint FK76m1ns8iqrliu3uowj77dlng4 foreign key (specialty_id) references specialty (id)
alter table schedule add constraint FKqixlhugy7jvrwut9o2s6hqnu8 foreign key (doctor_id) references doctor (id)
alter table turn add constraint FKhmty9fvn7augymtnaj31uwst9 foreign key (doctor_id) references doctor (id)
alter table turn add constraint FK7sig8em75iwhfxdlafewitjf3 foreign key (user_id) references user (id)
alter table user add constraint FKn82ha3ccdebhokx3a8fgdqeyy foreign key (role_id) references role (id)
create table diagnostic (id bigint not null auto_increment, description varchar(255), turn_id bigint, primary key (id)) engine=InnoDB
create table doctor (id bigint not null auto_increment, enrollment varchar(255), fist_name varchar(255), last_name varchar(255), specialty_id bigint, primary key (id)) engine=InnoDB
create table role (id bigint not null auto_increment, role varchar(255), primary key (id)) engine=InnoDB
create table schedule (id bigint not null auto_increment, day varchar(255), hour_since datetime, hour_to datetime, doctor_id bigint, primary key (id)) engine=InnoDB
create table specialty (id bigint not null auto_increment, description varchar(255), name varchar(255), primary key (id)) engine=InnoDB
create table turn (id bigint not null auto_increment, attended bit not null, date datetime, doctor_id bigint, user_id bigint, primary key (id)) engine=InnoDB
create table user (id bigint not null auto_increment, address varchar(255), cuil varchar(255), dni varchar(255), fist_name varchar(255), last_name varchar(255), role_id bigint, primary key (id)) engine=InnoDB
alter table diagnostic add constraint FKq2s0e15hv5aaufa9tmg5of6lp foreign key (turn_id) references turn (id)
alter table doctor add constraint FK76m1ns8iqrliu3uowj77dlng4 foreign key (specialty_id) references specialty (id)
alter table schedule add constraint FKqixlhugy7jvrwut9o2s6hqnu8 foreign key (doctor_id) references doctor (id)
alter table turn add constraint FKhmty9fvn7augymtnaj31uwst9 foreign key (doctor_id) references doctor (id)
alter table turn add constraint FK7sig8em75iwhfxdlafewitjf3 foreign key (user_id) references user (id)
alter table user add constraint FKn82ha3ccdebhokx3a8fgdqeyy foreign key (role_id) references role (id)
