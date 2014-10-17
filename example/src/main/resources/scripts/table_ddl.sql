create table shape_joined (idString varchar(255 char), type varchar(25 char));
create table triangle_joined(idString varchar(255 char), equal_sites boolean);
create table circle_joined(idString varchar(255 char), radius number);

create table shape_singletable(idString varchar(255 char), type varchar(25 char), equal_sites boolean, radius number);

create table triangle_perclass(idString varchar(255 char), type varchar(25 char), equal_sites boolean);
create table circle_perclass(idString varchar(255 char), type varchar(25 char), radius number);