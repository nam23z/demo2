create table users
(
    username varchar(50) primary key,
    password varchar(500) not null,
    enabled boolean         not null
);

create table authorities
(
    id  serial primary key,
    username varchar(50) not null,
    authority varchar(50) not null,
    constraint fk_username foreign key (username) references users (username) on delete cascade
);
create table customer
(
    id  serial primary key,
    username varchar(50) not null,
    password varchar(500) not null,
    role varchar(50)      not null
);