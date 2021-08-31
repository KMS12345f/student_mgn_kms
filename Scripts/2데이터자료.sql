select user(),database();

insert into student values (1, '권민성', 93, 95, 96);
insert into student values (2, '아무나', 99, 99, 99);
update student set kor = 99 where sno = 1;
delete from student where sno = 2;
select sno, sname, kor, eng, math from student;
select sno, sname, kor, eng, math from student where sno = 1;