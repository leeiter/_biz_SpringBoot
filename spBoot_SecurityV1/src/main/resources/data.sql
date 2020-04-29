   drop table if exists tbl_users;       
 create table tbl_users (
       id bigint not null auto_increment,
        account_non_expired bit not null,
        account_non_locked bit not null,
        address varchar(255),
        credentials_non_expired bit not null,
        email varchar(255),
        enabled bit not null,
        password varchar(255),
        phone varchar(255),
        username varchar(64),
        primary key (id)
    ) engine=InnoDB;
