Create table customers(
	id int primary key auto_increment,
	name varchar(30) not null unique,
	address varchar(30),
	phone varchar(30)
);

--为 name 字段添加唯一约束：
alter table customers add constraint name_uk unique(name);
