create database board;
use board;
create table board (
	b_no int primary key auto_increment, 	#글번호
	b_title varchar(100),						#글제목
    b_id varchar(100) not null,					#작성자id
	b_datetime datetime not null,			#작성시간
    b_hit int,								#조회수    
    b_text text,							#글내용
    b_reply_count int,						#댓글수
    b_reply_ori int,						#댓글의 원글 번호
    b_reply_text text						#댓글내용
    ,b_delno int not null
);
drop table board;

#일반글을 썼다고 가정
insert into board (b_title,b_id,b_datetime,b_text,b_hit,b_delno)
values (
'헬로'
,
'cat1'
,
now()
,
'글입니다. 글글.....글....'
,
0
,
0
);

#댓글을 썼다고 가정
insert into board (b_id,b_datetime,b_reply_ori,b_reply_text,b_delno)
values (
'cat1'
,
now()
,
10
,
'댓글임......욕욕욕...'
,
0
);
delete from board;
select * from board;
select * from board where b_no=10;
select * from board where not b_title is null;
select * from board where b_reply_ori=10;
show databases;

select * from board where b_no order by b_no desc;
select count(*) from board;
delete from board where b_no=2;
update board set b_title='1111',b_id= 'cat' ,b_text='들어가나안들어가나확인' where b_no2; 
select * from board where b_delno=0 and b_reply_ori is null;
update board set b_delno=1 where b_no=1; #글삭제 엄밀히 말하면 삭제 아님 안보이게만
update board set b_delno=0 where b_no=1; #글복구

select count(*) from board where b_delno=0;
select * from board where b_delno=1;
select * from board where b_delno=0 and b_no=123 and b_reply_ori=123;
create table sign (
	c_id varchar(15) unique
    ,
    c_pw varchar(20)
    
);
select * from sign;
drop table sign;
# db.st(쿼리) 부분 수정해 java 게시판 하는거 안까먹엇으면

use my_cat;

select * from cat_board;
create table cat_board(
	num int primary key auto_increment, 
    title char(255),
    content text,
    id char(30),
    delNo int,
    count int
);

insert into cat_board values(0,'테스트제목','테스트내용 내용.......','cat4',0);
insert into cat_board values(0,'테스트제목2','테스트내용2 내용.......2','dog3',0);
insert into cat_board values(0,'제목3','내용3 내용...3','3번냥이',0);
Select * from cat_board where delNo=0;
select * from cat_board where delNo=0 and num=3;
update cat_board set title='테스트4',content='테스트내용4',id='테스트id' where num=4;
drop table cat_board;
alter table cat_board add count int;
update cat_board set count=count+1 where num=1;
alter table cat_board modify count int default 0;
update cat_board set count=0 where num=7;

CREATE TABLE PS_BOARD_FREE (
		B_NO INT PRIMARY KEY AUTO_INCREMENT, 			#글번호
		B_TITLE CHAR(100) NOT NULL DEFAULT "",			#글제목
	    B_ID CHAR(50) NOT NULL,							#작성자ID
		B_DATETIME DATETIME NOT NULL DEFAULT now(),		#작성시간
	    B_HIT INT NOT NULL DEFAULT 0,					#조회수    
	    B_TEXT TEXT	NOT NULL,							#글내용, 댓글내용
	    B_REPLY_COUNT INT NOT NULL DEFAULT 0,			#댓글수
	    B_REPLY_ORI INT	NOT NULL DEFAULT -1				#댓글의 원글 번호
	);
    
    #sql: 게시판에 카테고리 칼럼 추가함
ALTER TABLE PS_BOARD_FREE ADD B_CATEGORY CHAR(50);    
UPDATE PS_BOARD_FREE SET B_CATEGORY = "free";