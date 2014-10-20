insert into ShapeJoined (idstring) values('1');
insert into ShapeJoined (idstring) values('2');
insert into CircleJoined (idstring, radius) values('1', 5);
insert into TriangleJoined ( idstring , equal_sites ) values('2', 1);

insert into ShapeSingletable (idString, dtype, radius, equalsites) values ('1', 'CircleJoined', 42, null);
insert into ShapeSingletable (idString, dtype, radius, equalsites) values ('2', 'TriangleJoined', null, 0);

insert into CirclePerclass (idString, radius) values('1', 23);
insert into TrianglePerclass (idString, equalsites) values('2', 1);