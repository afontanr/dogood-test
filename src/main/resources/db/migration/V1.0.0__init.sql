create table dogood.rol
(
    id   serial primary key,
    name varchar(100)
);

create table dogood.users
(
    id       serial primary key,
    username varchar(255) unique not null,
    rol      int,
    constraint fk_rol
        foreign key (rol)
            references rol (id)
);

create table dogood.record_type
(
    id   serial primary key,
    type varchar(255)
);

create table dogood.records
(
    id        serial primary key,
    user_from int,
    user_to   int,
    type      int,
    amount    int,
    constraint fk_user_from
        foreign key (user_from)
            references users (id),
    constraint fk_user_to
        foreign key (user_to)
            references users (id),
    constraint fk_type
        foreign key (type)
            references record_type (id)
);

insert into dogood.rol(name)
values ('PLAYER');
insert into dogood.rol(name)
values ('ADMIN');

insert into dogood.users(username, rol)
values ('player1', 1);
insert into dogood.users(username, rol)
values ('player2', 1);
insert into dogood.users(username, rol)
values ('admin', 2);
insert into dogood.users(username, rol)
values ('player3', 1);

insert into dogood.record_type (type)
values ('EARNING');
insert into dogood.record_type (type)
values ('PENALTY');
insert into dogood.record_type (type)
values ('DONATION');

INSERT INTO dogood.records ( user_from, user_to, "type", amount) VALUES (3, 1, 1, 15);
INSERT INTO dogood.records (user_from, user_to, "type", amount) VALUES (3, 1, 1, 11);
INSERT INTO dogood.records (user_from, user_to, "type", amount) VALUES (3, 1, 2, 8);
INSERT INTO dogood.records ( user_from, user_to, "type", amount) VALUES (1, 2, 3, 8);
INSERT INTO dogood.records (user_from, user_to, "type", amount) VALUES (3, 2, 1, 28);
INSERT INTO dogood.records (user_from, user_to, "type", amount) VALUES (3, 2, 2, 11);
INSERT INTO dogood.records (user_from, user_to, "type", amount) VALUES (2, 1, 3, 4);
INSERT INTO dogood.records (user_from, user_to, "type", amount) VALUES (3, 4, 1, 19);
