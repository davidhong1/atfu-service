# 创建数据库
create schema atfu default character set utf8mb4 collate utf8mb4_unicode_ci;

# 创建表
use atfu;

create table intention
(
    id           bigint unsigned auto_increment
        primary key,
    company      varchar(120)                               null comment '咨询公司',
    contact      varchar(120)                               null comment '联系方式',
    email        varchar(120)                               null comment '电子邮件',
    fax          varchar(120)                               null comment '传真',
    more         varchar(1024)                              null comment '用户备注',
    gmt_create   timestamp        default CURRENT_TIMESTAMP null,
    gmt_modified timestamp        default CURRENT_TIMESTAMP null,
    deleted      tinyint unsigned default 0                 null
)
    comment '咨询意向';

create table product
(
    id           bigint unsigned auto_increment
        primary key,
    no           varchar(30)                                null comment '产品型号',
    type         varchar(30)                                null comment '产品类别',
    brand        varchar(30)                                null comment '所属品牌',
    package_type varchar(30)                                null comment '封装类型',
    batch        varchar(30)                                null comment '批次',
    inventory    bigint unsigned                            null comment '库存数量',
    gmt_create   timestamp        default CURRENT_TIMESTAMP null,
    gmt_modified timestamp        default CURRENT_TIMESTAMP null,
    deleted      tinyint unsigned default 0                 null
)
    comment '产品';

create table user
(
    id           bigint unsigned auto_increment
        primary key,
    name         varchar(30)                                null,
    pw           varchar(120)                               null,
    phone        varchar(30)                                null,
    email        varchar(120)                               null,
    address      varchar(120)                               null,
    gmt_create   timestamp        default CURRENT_TIMESTAMP null,
    gmt_modified timestamp        default CURRENT_TIMESTAMP null,
    deleted      tinyint unsigned default 0                 null
)
    comment '用户';

# 添加product记录
INSERT INTO atfu.product (id, no, type, brand, package_type, batch, inventory, gmt_create, gmt_modified, deleted) VALUES (5, '56237', '闪存', 'micron', '贴片', '1', 8769, '2019-04-11 00:30:32', '2019-04-14 14:36:43', 0);
INSERT INTO atfu.product (id, no, type, brand, package_type, batch, inventory, gmt_create, gmt_modified, deleted) VALUES (6, '29322', '闪存', 'micron', '贴片', '2', 8769, '2019-04-11 00:30:38', '2019-04-14 14:36:43', 0);
INSERT INTO atfu.product (id, no, type, brand, package_type, batch, inventory, gmt_create, gmt_modified, deleted) VALUES (7, '2223', '闪存', 'micron', '贴片', '3', 8769, '2019-04-11 00:30:44', '2019-04-14 14:36:43', 0);
INSERT INTO atfu.product (id, no, type, brand, package_type, batch, inventory, gmt_create, gmt_modified, deleted) VALUES (8, '2223', '闪存', 'micron', '贴片', '4', 9023, '2019-04-11 00:30:50', '2019-04-14 14:36:43', 0);
INSERT INTO atfu.product (id, no, type, brand, package_type, batch, inventory, gmt_create, gmt_modified, deleted) VALUES (9, '2223', '闪存', 'micron', '贴片', '5', 9023, '2019-04-11 00:30:55', '2019-04-14 14:36:43', 0);
INSERT INTO atfu.product (id, no, type, brand, package_type, batch, inventory, gmt_create, gmt_modified, deleted) VALUES (10, '123930', '闪存', 'micron', '贴片', '6', 9023, '2019-04-11 00:31:01', '2019-04-14 14:36:43', 0);
INSERT INTO atfu.product (id, no, type, brand, package_type, batch, inventory, gmt_create, gmt_modified, deleted) VALUES (11, '283', '闪存', 'micron', '贴片', '7', 9023, '2019-04-11 00:31:06', '2019-04-14 14:36:43', 0);
INSERT INTO atfu.product (id, no, type, brand, package_type, batch, inventory, gmt_create, gmt_modified, deleted) VALUES (12, '9023', 'led灯珠', 'micron', '贴片', '8', 9023, '2019-04-11 00:31:21', '2019-04-11 00:31:21', 0);
INSERT INTO atfu.product (id, no, type, brand, package_type, batch, inventory, gmt_create, gmt_modified, deleted) VALUES (13, '9130', 'R1500电阻', 'micron', '贴片', '9', 9023, '2019-04-11 00:31:51', '2019-04-14 14:36:43', 0);
INSERT INTO atfu.product (id, no, type, brand, package_type, batch, inventory, gmt_create, gmt_modified, deleted) VALUES (14, '40922', 'R1500电阻', 'micron', '贴片', '10', 9023, '2019-04-11 00:31:58', '2019-04-14 14:36:43', 0);
INSERT INTO atfu.product (id, no, type, brand, package_type, batch, inventory, gmt_create, gmt_modified, deleted) VALUES (15, '78320', 'R1500电阻', 'micron', '贴片', '11', 9023, '2019-04-11 00:32:06', '2019-04-14 14:36:43', 0);
INSERT INTO atfu.product (id, no, type, brand, package_type, batch, inventory, gmt_create, gmt_modified, deleted) VALUES (16, '9304', 'LED', 'micron', '贴片', '12', 9023, '2019-04-11 00:32:18', '2019-04-14 14:36:43', 0);
INSERT INTO atfu.product (id, no, type, brand, package_type, batch, inventory, gmt_create, gmt_modified, deleted) VALUES (17, '2930', 'LED', 'micron', '贴片', '13', 9023, '2019-04-11 00:32:32', '2019-04-14 14:36:43', 0);
INSERT INTO atfu.product (id, no, type, brand, package_type, batch, inventory, gmt_create, gmt_modified, deleted) VALUES (18, '293070', 'LED', 'micron', '贴片', '14', 9023, '2019-04-11 00:32:36', '2019-04-14 14:36:43', 0);
INSERT INTO atfu.product (id, no, type, brand, package_type, batch, inventory, gmt_create, gmt_modified, deleted) VALUES (19, '12323', 'LED灯珠', 'micron1', '贴片', '15', 9023, '2019-04-11 00:32:44', '2019-04-14 14:36:43', 0);