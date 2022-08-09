create table admin(
adminID int identity(1,1) primary key,
account varchar(20),
password varchar(20),
name varchar(20),
sex varchar(10),
birthday date,
cellphone int,
email varchar(40),
img varbinary,
createdate datetime
);

insert into admin values(
'account','password','James','男生','1992-01-01','0987654321','qweqrqweq@gmail.com',null,getdate()
);

create table auth(
adminID int identity(1,1) primary key,
auth varchar(20)
);

insert into auth values(
'最高管理員'
);