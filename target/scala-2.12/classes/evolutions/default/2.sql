-- Create proposals table

-- !Ups
Create table proposals (
    id serial primary key,
    origin_airport varchar(8) not null ,
    destination_airport varchar(8) not null ,
    meeting_start timestamp with time zone,
    meeting_end timestamp with time zone,
    last_mile_time integer,
    shortest json,
    cheapest json
);

-- !Downs
DROP TABLE proposals;