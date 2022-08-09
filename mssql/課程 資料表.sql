Drop Table IF Exists course_subject
CREATE TABLE course_subject(
subject_id int primary key identity(1,1),
subject_name nvarchar(100) NOT NULL ,


);
INSERT INTO course_subject(subject_name)
VALUES(N'數學'),
	(N'英文'),
	(N'多益 ');
select * from course_subject;


Drop Table IF Exists course_Education

CREATE TABLE course_Education(
education_id int primary key identity(1,1),
educationLevel nvarchar(100) NOT NULL,

);
INSERT INTO course_Education(EducationLevel)
VALUES(N'國中'),
	  (N'高中'),
	  (N'成人');
select * from course_Education;


Drop Table IF Exists course
create table course (
course_id int primary key identity(1,1),
user_id int,
subject_id int NOT NULL ,
education_id int NOT NULL,
course_name nvarchar(100) not null,
course_introduction nvarchar(1000) not null,
course_price Decimal(11,2) not null,
course_duration nvarchar(50) not null,
enrollment int not null,
course_date date not null,
lecturer_name nvarchar(50) not null,
lecturer_email nvarchar(50) not null,
course_picture nvarchar(max) not null,
FOREIGN KEY (user_id ) REFERENCES member(user_id),
FOREIGN KEY (subject_id ) REFERENCES course_subject(subject_id),
FOREIGN KEY (education_id) REFERENCES course_Education(education_id)
);

INSERT INTO course
VALUES (1,1,1,N'英文好6',N'有感提升閱讀速度，快速抓住句子與文章重點，破解各式英文閱讀測驗，提升作答速度，讀懂原文書籍，有效掌握關鍵意義，大量吸收一手英文資訊！?','799',N'45小時6分','30','2021-9-30',N'王大明','123@gmail.com',N'./images/英文6.png')

INSERT INTO course
VALUES (1,2,2,N'30天變身數學神童',N'在設計各範疇的學習重點時，會將相關的內容編組成不同的學習單位，再依據學生的認知發展，由淺入深，由具體至抽象，將每單位的內容採用螺旋式細分為學習重點。讓學生先學習數學的基本概念，然後逐漸增加深度和闊度。這樣，學生便可以學習運用數學的知識進行觀察、思考及解決問題。','1499',N'90小時27分','90','2020-12-30',N'王中明','456@gmail.com',N'./images/數學30.png')

INSERT INTO course
VALUES (1,3,3,N'多益高分衝刺班',N'新制多益與舊制多益的差異，了解多益聽力四種題型的解題技巧，並練習快速從關鍵字聽出題目重點，加強職場常見英語情境的應對能力及信心','2999',N'180小時56分','180','2022-7-15',N'王小明','789@gmail.com',N'./images/多益高分衝刺班.png')

INSERT INTO course
VALUES (1,2,2,N'拯救菜英文',N'熟悉生活 7 大情境英文，具備基礎會話單字量，英文不再死背！情境教學法讓你學了就會用，學會最道地的美式發音、語調，抑揚頓挫好簡單，學會帶入不同情緒開口說英文，舉一反十最有效','2499',N'30小時16分','300','2018-05-20',N'小蔡','English@gmail.com',N'./images/拯救菜英文.png')

INSERT INTO course
VALUES (1,3,2,N'多益990分保證班',N'不藏私，學會所有高分解題技巧，學會必考多益單字，分析多益題型，掌握題組及作答時間，專職講師追蹤您的進步幅度，專職講師個別分析多益高分答題策略','9990',N'87小時','150','2020-1-18',N'郝哆義','TOEIC@gmail.com',N'./images/多益990分保證班.png')

select * from course;

truncate table course;

drop table course;

select * from course where course_name like '英%';

update course set subject_id = 2 where course_id = 4;