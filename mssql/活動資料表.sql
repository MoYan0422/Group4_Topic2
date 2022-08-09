drop table activity_participants;
drop table activitys;







create table activitys (
id int IDENTITY(100000,1) PRIMARY KEY,
title nvarchar(50) not null,
content nvarchar(500) not null,
start_time datetime not null,
end_time datetime not null,
imgPath nvarchar(100)
)
INSERT INTO activitys(title,content,start_time,end_time)
VALUES (N'文山分館「游於藝（三）–幸福手作書」報名開始囉!',
N'過去一千多年來，書籍一直是全球最重要的書面紀錄形式，人們透過翻閱書籍，探尋世界的秘密，獲得樂趣。而書的製程是一種複雜的迷人工藝，文山分館本次特別邀請李明足老師，帶領親子朋友們進入手工書的世界中，一同動手創作屬於自己的小書。同時結合7至9月「獨藝無二，手作生活」主題書展，期望帶給民眾手作職人的魅力。',
N'2022-08-27 08:30:00','2022-08-27 12:00:00');
INSERT INTO activitys(title,content,start_time,end_time)
VALUES (N'北投分館「夏納北投涼‧閱讀綠書房」書展，邀您共享閱讀趣！',
N'今年度以炎炎夏日中「與地球一起納涼」為概念發想，規劃「綠建築」、「海洋」、「綠色生活」三種主題的書展。綠建築以「生態、節能、減廢、健康」四大範疇立基，建構符合環境友善的建築，身處其中可以感受自然風的涼爽，是納涼的好地方；海洋孕育豐富的生命，包含繽紛多彩的生態系，夏日到海邊戲水除了是納涼的好選擇，亦可藉此認識生態環境；綠色生活則從日常出發，著眼食衣住行育樂，從生活中落實節能減碳，感受身心沉澱後，「心靜自然涼」的狀態。',
'2022-07-15 08:30:00',
'2022-08-27 12:00:00');


select * from activitys;


create table member(
user_id int identity(1,1) primary key,
nick nvarchar(20) not null,
account nvarchar(20) unique not null,
password nvarchar(20) not null,
status int not null,
name nvarchar(20) not null,
img varbinary,
sex nvarchar(20) not null,
birthday date not null,
cellphone int not null,
email nvarchar(20) not null unique,
joinDate datetime not null
);
insert into member values(
N'Lion','account','password',1,N'王曉明',null,N'男生','1988-01-01','0912345678','qweqwrqrq@gmail.com',getdate()
);


create table activity_participants(
activity_id int,
user_id int,
FOREIGN KEY(activity_id) REFERENCES activitys(id),
FOREIGN KEY (user_id ) REFERENCES member(user_id ))
INSERT INTO activity_participants (activity_id,user_id)
VALUES (100000 , 1)




select * from activitys;
select * from activity_participants;