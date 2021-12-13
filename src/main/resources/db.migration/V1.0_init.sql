create TABLE if not exists `flat` (
`id` int(11) not null,
`rooms` int(11) not null,
`square` double not null,
`address`varchar(255) not null,
`description` varchar(255) not null ,
`coordinates_id` int(11) not null
);

create table if not exists `photo` (
`id` int(11) not null,
`photo` longblob not null,
`flat_id` int(11) not null
);

create table if not exists `coordinates` (
`id` int(11) not null,
`latitude` varchar(255) not null,
`longitude` varchar(255) not null
)
