CREATE DATABASE movie DEFAULT CHARACTER SET UTF8MB4;
use movie;
CREATE TABLE `member` (
	`no`	INT auto_increment primary key	NOT NULL	COMMENT 'primary key',
	`id`	VARCHAR(16)	NOT NULL	COMMENT '사용자 id',
	`pw`	VARCHAR(128)	NOT NULL	COMMENT '사용자 비밀번호(암호화)',
	`name`	VARCHAR(30)	NOT NULL	COMMENT '사용자 이름',
	`email`	VARCHAR(64)	NOT NULL	COMMENT '사용자 이메일',
	`phone`	VARCHAR(64)	NOT NULL	COMMENT '사용자 전화번호',
	`nickName`	VARCHAR(16)	NOT NULL	COMMENT '사용자 닉네임',
	`birth`	DATE	NOT NULL	COMMENT '사용자 생년월일',
	`gender`	VARCHAR(16)	NOT NULL	COMMENT '사용자 성별',
	`profile`	BLOB	NOT NULL	COMMENT '사용자 프로필',
	`role`	INT	NOT NULL	COMMENT '관리자 여부',
	`addr`	VARCHAR(64)	NOT NULL	COMMENT '사용자 주소',
	`createdAt`	TIMESTAMP	NOT NULL	COMMENT '생성 날짜 시간',
	`updatedAt`	TIMESTAMP	NOT NULL	COMMENT '정보수정 날짜 시간'
);

CREATE TABLE `review` (
	`no`	INT auto_increment primary key	NOT NULL	COMMENT 'primary key',
	`content`	longtext	NOT NULL	COMMENT '영화 리뷰 내용',
	`grade`	DOUBLE	NULL	COMMENT '영화 평점',
	`ticketNo`	INT	NULL	COMMENT '영화 티켓 번호',
	`like`	INT	NULL	COMMENT '영화 추천여부',
	`createdAt`	TIMESTAMP	NULL	COMMENT '생성 날짜 시간',
	`updatedAt`	TIMESTAMP	NULL	COMMENT '정보수정 날짜 시간'
);

CREATE TABLE `category` (
	`no`	INT auto_increment primary key	NOT NULL	COMMENT 'primary key',
	`category`	VARCHAR(50)	NULL	COMMENT '영화 카테고리'
);

CREATE TABLE `ticket` (
	`no`	INT auto_increment primary key	NOT NULL	COMMENT 'primary key',
	`lineNo`	INT	NULL	COMMENT '좌석 행 번호',
	`used`	INT	NULL	COMMENT '티켓 사용 여부',
	`createdAt`	TIMESTAMP	NULL	COMMENT '티켓 생성 날짜 시간',
	`updatedAt`	TIMESTAMP	NULL	COMMENT '정보수정 날짜 시간',
	`movieNo`	INT	NOT NULL	COMMENT '영화 번호',
	`memberNo`	INT	NOT NULL	COMMENT '사용자 번호',
	`rowNo`	INT	NOT NULL	COMMENT '좌석 열 번호'
);

CREATE TABLE `movie` (
	`no`	INT auto_increment primary key	NOT NULL	COMMENT 'primary key',
	`title`	VARCHAR(255)	NULL	COMMENT '영화 제목',
	`release`	TIMESTAMP	NULL	COMMENT '영화 개봉일',
	`deadLine`	TIMESTAMP	NULL	COMMENT '영화 상영종료일',
	`grade`	DOUBLE	NULL	COMMENT '영화 평점',
	`time`	TIMESTAMP	NULL	COMMENT '영화 상영길이',
	`createdAt`	TIMESTAMP	NULL	COMMENT '영화 생성 날짜 시간',
	`updatedAt`	TIMESTAMP	NULL	COMMENT '영화 정보수정 날짜시간',
	`rank`	INT	NULL	COMMENT '영화 인기 순위',
	`categoryNo`	INT	NOT NULL	COMMENT '영화 카테고리 넘버',
	`nationNo`	INT	NOT NULL	COMMENT '영화 제작국가',
	`ratingNo`	INT	NOT NULL	COMMENT '영화 심의등급',
	`gradeNo`	INT	NOT NULL	COMMENT '영화 리뷰평점 넘버',
	`contentNo`	INT	NOT NULL	COMMENT '영화 줄거리 넘버'
);

CREATE TABLE `nation` (
	`no`	INT auto_increment primary key	NOT NULL	COMMENT 'primary key',
	`nation`	VARCHAR(128)	NULL	COMMENT '영화 제작국가'
);

CREATE TABLE `filmRating` (
	`no`	INT auto_increment primary key	NOT NULL	COMMENT 'primary key',
	`filmRating`	VARCHAR(128)	NULL	COMMENT '영화 심의등급'
);

CREATE TABLE `grade` (
	`no`	INT auto_increment primary key	NOT NULL	COMMENT 'primary key',
	`reviewNo`	INT	NOT NULL	COMMENT '영화 리뷰 넘버',
	`grade`	DOUBLE	NULL	COMMENT '영화 종합 평점'
);

CREATE TABLE `record` (
	`recordNo`	INT auto_increment primary key	NOT NULL,
	`ticketNo`	INT	NOT NULL,
	`createdAt`	TIMESTAMP	NULL	COMMENT '티켓 구매내역 생성 날짜 시간',
	`updatedAt`	TIMESTAMP	NULL	COMMENT '티켓 정보수정 날짜 시간'
);

CREATE TABLE `store` (
	`no`	INT auto_increment primary key	NOT NULL	COMMENT 'primary key',
	`memberNo`	INT	NOT NULL	COMMENT '유저 넘버',
	`foodNo`	TINYINT	NOT NULL	COMMENT 'primary key',
	`setNo`	TINYINT	NOT NULL	COMMENT '세트 넘버',
	`goodsNo`	TINYINT	NOT NULL	COMMENT '굿즈 넘버',
	`createdAt`	TIMESTAMP	NULL	COMMENT '생성 날짜 시간',
	`updatedAt`	TIMESTAMP	NULL	COMMENT '정보수정 날짜 시간'
);

CREATE TABLE `food` (
	`no`	INT auto_increment primary key	NOT NULL	COMMENT 'primary key',
	`food`	VARCHAR(255)	NULL	COMMENT '음식 이름 / 음료 이름',
	`price`	INT	NULL	COMMENT '음식 가격',
	`createdAt`	TIMESTAMP	NULL	COMMENT '생성 날짜 시간',
	`updatedAt`	TIMESTAMP	NULL	COMMENT '정보수정 날짜 시간'
);

CREATE TABLE `foodSet` (
	`no`	INT auto_increment primary key	NOT NULL	COMMENT 'primary key',
	`foodNoOne`	TINYINT	NULL	COMMENT '음식 번호 1',
	`foodNoTwo`	TINYINT	NULL	COMMENT '음식 번호2',
	`foodNoThree`	TINYINT	NULL	COMMENT '음식 번호3',
	`foodNoFour`	TINYINT	NULL	COMMENT '음식 번호4',
	`price`	INT	NULL	COMMENT '세트 총 가격',
	`createdAt`	TIMESTAMP	NULL	COMMENT '생성 날짜 시간',
	`updatedAt`	TIMESTAMP	NULL	COMMENT '정보수정 날짜 시간'
);

CREATE TABLE `theather` (
	`no`	INT auto_increment primary key	NOT NULL	COMMENT 'primary key',
	`max`	INT	NULL	COMMENT '최대 수용인원',
	`price`	INT	NULL	COMMENT '가격',
	`state`	INT	NULL	COMMENT '상영 가능 상태',
	`content`	longtext	NULL	COMMENT '상영관 정보',
	`createdAt`	TIMESTAMP	NULL	COMMENT '생성 날짜 시간',
	`updatedAt`	TIMESTAMP	NULL	COMMENT '정보수정 날짜 시간'
);

CREATE TABLE `schedule` (
	`no`	INT auto_increment primary key	NOT NULL	COMMENT 'primary key',
	`movieNo`	INT	NOT NULL	COMMENT '영화 번호',
	`theaterNo`	DOUBLE	NOT NULL	COMMENT '상영 극장 번호',
	`date`	TIMESTAMP	NULL	COMMENT '상영 날짜',
	`start`	TIMESTAMP	NULL	COMMENT '상영 시작 시간',
	`end`	TIMESTAMP	NULL	COMMENT '상영 종료 시간',
	`createdAt`	TIMESTAMP	NULL	COMMENT '생성 날짜 시간',
	`updatedAt`	TIMESTAMP	NULL	COMMENT '정보수정 날짜 시간'
);

CREATE TABLE `movieLike` (
	`no`	INT auto_increment primary key	NOT NULL	COMMENT 'primary key',
	`movieNo`	INT	NOT NULL	COMMENT '영화 번호',
	`memberNo`	INT	NOT NULL	COMMENT '유저 넘버'
);

CREATE TABLE `movieContent` (
	`no`	INT auto_increment primary key	NOT NULL	COMMENT 'primary key',
	`short`	VARCHAR(255)	NULL	COMMENT '영화 짧은 줄거리',
	`long`	longtext	NULL	COMMENT '영화 긴 줄거리'
);

CREATE TABLE `goods` (
	`no`	INT auto_increment primary key	NOT NULL	COMMENT 'primary key',
	`goods`	VARCHAR(255)	NULL	COMMENT '굿즈 이름',
	`price`	INT	NULL	COMMENT '굿즈 가격',
	`createdAt`	TIMESTAMP	NULL	COMMENT '생성 날짜 시간',
	`updatedAt`	TIMESTAMP	NULL	COMMENT '정보수정 날짜 시간'
);

CREATE TABLE `theatherRow` (
	`no`	INT auto_increment primary key	NOT NULL	COMMENT 'primary key',
	`theaterNo`	INT	NOT NULL	COMMENT '상영관 번호',
	`row`	VARCHAR(16)	NULL	COMMENT '상영관 열'
);

CREATE TABLE `theaterLine` (
	`no`	INT auto_increment primary key	NOT NULL	COMMENT 'primary key',
	`rowNo`	INT	NOT NULL	COMMENT '상영관 열 번호',
	`line`	VARCHAR(16)	NULL	COMMENT '상영관 행'
);

CREATE TABLE `search` (
	`no`	INT auto_increment primary key	NOT NULL	COMMENT 'primary key',
	`movieNo`	INT	NOT NULL	COMMENT '영화번호',
	`count`	INT	NULL	COMMENT '검색 여부 0/1'
);
-- 자바에서 키값 연결할꺼라 일단 주석처둠
-- ALTER TABLE `member` ADD CONSTRAINT `PK_MEMBER` PRIMARY KEY (
-- 	`no`
-- );

-- ALTER TABLE `review` ADD CONSTRAINT `PK_REVIEW` PRIMARY KEY (
-- 	`no`
-- );

-- ALTER TABLE `category` ADD CONSTRAINT `PK_CATEGORY` PRIMARY KEY (
-- 	`no`
-- );

-- ALTER TABLE `ticket` ADD CONSTRAINT `PK_TICKET` PRIMARY KEY (
-- 	`no`
-- );

-- ALTER TABLE `movie` ADD CONSTRAINT `PK_MOVIE` PRIMARY KEY (
-- 	`no`
-- );

-- ALTER TABLE `nation` ADD CONSTRAINT `PK_NATION` PRIMARY KEY (
-- 	`no`
-- );

-- ALTER TABLE `filmRating` ADD CONSTRAINT `PK_FILMRATING` PRIMARY KEY (
-- 	`no`
-- );

-- ALTER TABLE `grade` ADD CONSTRAINT `PK_GRADE` PRIMARY KEY (
-- 	`no`
-- );

-- ALTER TABLE `record` ADD CONSTRAINT `PK_RECORD` PRIMARY KEY (
-- 	`recordNo`,
-- 	`ticketNo`
-- );

-- ALTER TABLE `store` ADD CONSTRAINT `PK_STORE` PRIMARY KEY (
-- 	`no`
-- );

-- ALTER TABLE `food` ADD CONSTRAINT `PK_FOOD` PRIMARY KEY (
-- 	`no`
-- );

-- ALTER TABLE `foodSet` ADD CONSTRAINT `PK_FOODSET` PRIMARY KEY (
-- 	`no`
-- );

-- ALTER TABLE `theather` ADD CONSTRAINT `PK_THEATHER` PRIMARY KEY (
-- 	`no`
);

ALTER TABLE `schedule` ADD CONSTRAINT `PK_SCHEDULE` PRIMARY KEY (
-- 	`no`,
-- 	`movieNo`,
-- 	`theaterNo`
-- );

-- ALTER TABLE `movieLike` ADD CONSTRAINT `PK_MOVIELIKE` PRIMARY KEY (
-- 	`no`,
-- 	`movieNo`,
-- 	`memberNo`
-- );

-- ALTER TABLE `movieContent` ADD CONSTRAINT `PK_MOVIECONTENT` PRIMARY KEY (
-- 	`no`
-- );

-- ALTER TABLE `goods` ADD CONSTRAINT `PK_GOODS` PRIMARY KEY (
-- 	`no`
-- );

-- ALTER TABLE `theatherRow` ADD CONSTRAINT `PK_THEATHERROW` PRIMARY KEY (
-- 	`no`,
-- 	`theaterNo`
-- );

-- ALTER TABLE `theaterLine` ADD CONSTRAINT `PK_THEATERLINE` PRIMARY KEY (
-- 	`no`,
-- 	`rowNo`
-- );

-- ALTER TABLE `search` ADD CONSTRAINT `PK_SEARCH` PRIMARY KEY (
-- 	`no`,
-- 	`movieNo`
-- );

-- ALTER TABLE `record` ADD CONSTRAINT `FK_ticket_TO_record_1` FOREIGN KEY (
-- 	`ticketNo`
-- )
-- REFERENCES `ticket` (
-- 	`no`
-- );

-- ALTER TABLE `schedule` ADD CONSTRAINT `FK_movie_TO_schedule_1` FOREIGN KEY (
-- 	`movieNo`
-- )
-- REFERENCES `movie` (
-- 	`no`
-- );

-- ALTER TABLE `schedule` ADD CONSTRAINT `FK_theather_TO_schedule_1` FOREIGN KEY (
-- 	`theaterNo`
-- )
-- REFERENCES `theather` (
-- 	`no`
-- );

-- ALTER TABLE `movieLike` ADD CONSTRAINT `FK_movie_TO_movieLike_1` FOREIGN KEY (
-- 	`movieNo`
-- )
-- REFERENCES `movie` (
-- 	`no`
-- );

-- ALTER TABLE `movieLike` ADD CONSTRAINT `FK_member_TO_movieLike_1` FOREIGN KEY (
-- 	`memberNo`
-- )
-- REFERENCES `member` (
-- 	`no`
-- );

-- ALTER TABLE `theatherRow` ADD CONSTRAINT `FK_theather_TO_theatherRow_1` FOREIGN KEY (
-- 	`theaterNo`
-- )
-- REFERENCES `theather` (
-- 	`no`
-- );

-- ALTER TABLE `theaterLine` ADD CONSTRAINT `FK_theatherRow_TO_theaterLine_1` FOREIGN KEY (
-- 	`rowNo`
-- )
-- REFERENCES `theatherRow` (
-- 	`no`
-- );

-- ALTER TABLE `search` ADD CONSTRAINT `FK_movie_TO_search_1` FOREIGN KEY (
-- 	`movieNo`
-- )
-- REFERENCES `movie` (
-- 	`no`
-- );

