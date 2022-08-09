DROP TABLE  IF EXISTS Cart;
create table Cart(
	id int primary key identity(1,1),
	user_id int, 
	item_id int,
	itemName nvarchar(50) not null,
	count int,
	price Decimal(11,2) not null
	FOREIGN KEY (user_id ) REFERENCES member(user_id),
	--FOREIGN KEY (item_id ) REFERENCES course(course_id ) 
);


DROP TABLE  IF EXISTS Order_user;
create table Order_user(
	order_id nvarchar(50) primary key,
	user_id int, 
	date datetime not null,
	status int not null,
	totoalcount int,
	discount nvarchar(20) ,
	totoalprice Decimal(11,2) not null
	FOREIGN KEY (user_id ) REFERENCES member(user_id),
);


DROP TABLE  IF EXISTS OrderItem;
create table OrderItem(
	id int primary key identity(1,1),
	order_id nvarchar(50) ,
	item_id int,
	name nvarchar(50),
	count int,
	price Decimal(11,2) not null
	FOREIGN KEY (order_id ) REFERENCES Order_user(order_id),
	--FOREIGN KEY (item_id) REFERENCES course(course_id)
);


truncate table Cart;
truncate table Order_user;
truncate table OrderItem;

select m.user_id , m.account, m.name , m.email,
o.order_id, o.date, o.status, o.totoalcount, o.discount, o.totoalprice 
from Order_user o join member m on  o.user_id = m.user_id　where o.user_id = 1;

select m.user_id , m.account, m.name , m.email,o.order_id, o.date, o.status, o.totoalcount, o.discount, o.totoalprice from Order_user o join member m on  o.user_id = m.user_id　
where m.account like '%%' or m.name like N'%%'　or o.order_id like ?;

select * from Order_user where user_id = 1 and status = 2