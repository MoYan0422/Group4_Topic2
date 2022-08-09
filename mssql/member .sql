
create table member(
user_id int identity(1,1) primary key,
nick nvarchar(20) ,
account nvarchar(20) unique not null,
password nvarchar(20) not null,
status int default 1,
name nvarchar(20) ,
img nvarchar(100),	
sex nvarchar(20) ,
birthday date ,
cellphone nvarchar(20) ,
email nvarchar(2000) not null unique,
joinDate date default getdate()
);
insert into member values(
 N'Andy','account','password',3,N'王曉明',N'img/user1.png',N'男生','1988-01-01','0912345678','qweqwrqrq@gmail.com',getdate()),
(N'Lion','11111','11111',1,N'萊恩',N'img/user2.png',N'男生','1996-01-01','0912345679','qweqwrqrq2@gmail.com',getdate()),
(N'Tony','22222','22222',2,N'偷尼',N'img/user3.jpg',N'男生','1998-01-01','0912345677','qweqwrqrq3@gmail.com',getdate()
);

drop table if exists auth;
create table auth(
status int primary key,
idtentitys nvarchar(20) not null
);

insert into auth values
('1',N'學生'),
('2',N'老師'),
('3',N'管理員')
;

select * from member;
select * from auth;