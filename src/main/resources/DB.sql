drop database Test;
create database Test;
use Test;
create table brand(
	id bigint primary key auto_increment,
    brand_name varchar(100)
);

create table category(
	id bigint primary key auto_increment,
    cate_code varchar(20),
    cate_name varchar(50)
);

create table sub_category(
	id bigint primary key auto_increment,
    sub_cate_code varchar(20),
    sub_cate_name varchar(50),
    cate_id bigint,
    foreign key (cate_id) references category(id)
);

create table status(
	id bigint primary key auto_increment, 
    status_name varchar(100)
);

create table product(
	id bigint primary key auto_increment,
    subcate_id bigint,
    product_name varchar(100),
    color varchar(50),
    quantity bigint,
    sell_price double,
    origin_price double,
    description varchar(1000),
    status_id bigint,
    foreign key(status_id) references status(id),
    foreign key(subcate_id) references sub_category(id)
);

create table product_brand(
	product_id bigint,
    brand_id bigint,
    foreign key(product_id) references product(id),
    foreign key(brand_id) references brand(id)
);

INSERT INTO `test`.`brand` (`brand_name`) VALUES ('Iphone');
INSERT INTO `test`.`brand` (`brand_name`) VALUES ('Samsung');
INSERT INTO `test`.`brand` (`brand_name`) VALUES ('Acer');
INSERT INTO `test`.`brand` (`brand_name`) VALUES ('Dell');
INSERT INTO `test`.`brand` (`brand_name`) VALUES ('Dior');
INSERT INTO `test`.`brand` (`brand_name`) VALUES ('Gucci');

INSERT INTO `test`.`status` (`status_name`) VALUES ('Còn hàng');
INSERT INTO `test`.`status` (`status_name`) VALUES ('Hết hàng');

INSERT INTO `test`.`category` (`cate_code`, `cate_name`) VALUES ('1', 'Máy tính');
INSERT INTO `test`.`category` (`cate_code`, `cate_name`) VALUES ('2', 'Điện thoại');
INSERT INTO `test`.`category` (`cate_code`, `cate_name`) VALUES ('3', 'Mỹ phẩm');

INSERT INTO `test`.`sub_category` (`sub_cate_code`, `sub_cate_name`, `cate_id`) VALUES ('SB1', 'Máy tính Gamming', '1');
INSERT INTO `test`.`sub_category` (`sub_cate_code`, `sub_cate_name`, `cate_id`) VALUES ('SB2', 'Máy tính Văn Phòng', '1');
INSERT INTO `test`.`sub_category` (`sub_cate_code`, `sub_cate_name`, `cate_id`) VALUES ('SB3', 'Điện thoại cảm ứng', '2');
INSERT INTO `test`.`sub_category` (`sub_cate_code`, `sub_cate_name`, `cate_id`) VALUES ('SB4', 'Điện thoại cầm tay', '2');
INSERT INTO `test`.`sub_category` (`sub_cate_code`, `sub_cate_name`, `cate_id`) VALUES ('SB5', 'Mỹ phẩm Son', '3');
INSERT INTO `test`.`sub_category` (`sub_cate_code`, `sub_cate_name`, `cate_id`) VALUES ('SB6', 'Mỹ phẩm Phấn', '3');













