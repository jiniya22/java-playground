create table person(
                       id bigint primary key auto_increment,
                       name varchar(255),
                       age int,
                       address varchar(255)
);

insert into person(name, age, address) values('jini', 22, 'seoul');
insert into person(name, age, address) values('coco', 24, 'paris');
insert into person(name, age, address) values('lily', 31, 'tokyo');