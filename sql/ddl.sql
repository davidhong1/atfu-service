create schema atfu;

SET collation_connection = 'utf8_general_ci';

ALTER DATABASE atfu CHARACTER SET utf8 COLLATE utf8_general_ci;

create schema atfu collate utf8_general_ci;

create table intention
(
    id bigint unsigned auto_increment
        primary key,
    company varchar(120) null comment '咨询公司',
    contact varchar(120) null comment '联系方式',
    email varchar(120) null comment '电子邮件',
    fax varchar(120) null comment '传真',
    more varchar(1024) null comment '用户备注',
    gmt_create timestamp default CURRENT_TIMESTAMP null,
    gmt_modified timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    deleted tinyint unsigned default 0 null
)
    comment '咨询意向';

create table product
(
    id bigint unsigned auto_increment
        primary key,
    no varchar(30) null comment '产品型号',
    type varchar(30) null comment '产品类别',
    brand varchar(30) null comment '所属品牌',
    package_type varchar(30) null comment '封装类型',
    batch varchar(30) null comment '批次',
    inventory bigint unsigned null comment '库存数量',
    gmt_create timestamp default CURRENT_TIMESTAMP null,
    gmt_modified timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    deleted tinyint unsigned default 0 null
);

create table user
(
    id bigint unsigned auto_increment
        primary key,
    name varchar(30) null,
    pw varchar(120) null,
    phone varchar(30) null,
    email varchar(120) null,
    address varchar(120) null,
    gmt_create timestamp default CURRENT_TIMESTAMP null,
    gmt_modified timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    deleted tinyint unsigned default 0 null
)
    comment '用户';
