
-- Add Routes

-- !Ups

create table routes (id serial primary key, "from" varchar(8) not null, "to" varchar(8) not null, depart_time int not null, arrive_time int not null, airline varchar(64) not null);

insert into routes ("from", "to", depart_time, arrive_time, airline)
values ('AMS', 'BRU', 420, 450, 'KLM');

insert into routes ("from", "to", depart_time, arrive_time, airline)
values ('AMS', 'BRU', 500, 530, 'KLM');

insert into routes ("from", "to", depart_time, arrive_time, airline)
values ('BRU', 'DUS', 480, 510, 'EAS');

insert into routes ("from", "to", depart_time, arrive_time, airline)
values ('BRU', 'DUS', 600, 645, 'KLM');

insert into routes ("from", "to", depart_time, arrive_time, airline)
values ('DUS', 'PRS', 830, 860, 'RYN');

insert into routes ("from", "to", depart_time, arrive_time, airline)
values ('DUS', 'PRS', 900, 955, 'RYN');

insert into routes ("from", "to", depart_time, arrive_time, airline)
values ('AMS', 'PRS', 1000, 1040, 'RYN');

insert into routes ("from", "to", depart_time, arrive_time, airline)
values ('AMS', 'DUS', 700, 735, 'EAS');

-- !Downs
DROP TABLE routes;