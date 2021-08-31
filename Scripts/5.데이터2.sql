select user(), database();

show tables;   -- 테이블 개수 및 종류 확인
desc student;	 -- student테이블 명세 확인

insert into student values(101, '안성용', '사학', '010-1111-1111');
insert into student values(102, '최명기', '영어영문', '010-2222-2222');
insert into student values(103, '김태수', '수학', '010-3333-3333');

select * from student;

-- 과목(subject)
desc subject;

insert into subject values(501, '컴퓨터개론'),(502, '프리토킹'),(503, '리스닝')
,(504, '데이터과학'),(505, '빅데이터');

select * from subject;

desc enroll;

select * from student;
insert into enroll values
  (101, 501, 96)
, (101, 502, 88)
, (101, 503, 79)
, (102, 504, 66)
, (102, 505, 56)
, (103, 502, 67)
, (103, 504, 86);
