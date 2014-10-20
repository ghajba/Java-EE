create table shapejoined (idString varchar(255 char) primary key);
create table trianglejoined(idString varchar(255 char) primary key, equalsites boolean);
create table circlejoined(idString varchar(255 char) primary key, radius number);

create table shapesingletable(idString varchar(255 char) primary key, dtype varchar(25 char), equalsites boolean, radius number);

create table triangleperclass(idString varchar(255 char) primary key, equalsites boolean);
create table circleperclass(idString varchar(255 char) primary key, radius number);