DROP TABLE  IF EXISTS voucher;
create table voucher(
	id int primary key identity(1,1),
	number nvarchar(20),
	discount Decimal(3,1),
	life int
);