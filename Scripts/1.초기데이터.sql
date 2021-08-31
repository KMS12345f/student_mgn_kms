-- 내 스키마
DROP SCHEMA IF EXISTS MY_SCHEMA;

-- 내 스키마
CREATE SCHEMA MY_SCHEMA;

-- 학생관리
CREATE TABLE MY_SCHEMA.student (
	sno   INTEGER     NOT NULL COMMENT '학번', -- 학번
	sname VARCHAR(50) NOT NULL COMMENT '성명', -- 성명
	kor   INTEGER     NULL     COMMENT '국어', -- 국어
	eng   INTEGER     NULL     COMMENT '영어', -- 영어
	math  INTEGER     NULL     COMMENT '수학' -- 수학
)
COMMENT '학생관리';

-- 학생관리
ALTER TABLE MY_SCHEMA.student
	ADD CONSTRAINT PK_student -- 학생관리 기본키
		PRIMARY KEY (
			sno,   -- 학번
			sname  -- 성명
		);