insert into ShapeJoind (idstring, type) values('1', 'CIRCLE');
insert into ShapeJoind (idstring, type) values('2', 'TRIANGLE');
insert into CircleJoined (idstring, radius) values('1', 5);
insert into TriangleJoined ( idstring , equal_sites ) values('2', 1);

insert into ShapeSingletable (idString, type, radius, equal_sites) values ('1', 'CIRCLE');
insert into ShapeSingletable (idString, type, radius, equal_sites) values ('2', 'TRIANGLE');

insert into CirclePerclass () values();
insert into TrianglePerclass () values();