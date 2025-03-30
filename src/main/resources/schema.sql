CREATE TABLE IF NOT EXISTS venues(
                                     venue_id SERIAL PRIMARY KEY,
                                     venue_name VARCHAR (25) NOT NULL ,
                                     location VARCHAR

);

CREATE TABLE IF NOT EXISTS attendees(
    attendees_id SERIAL PRIMARY KEY,
    attendee_name VARCHAR (25) NOT NULL ,
    email VARCHAR (25) NOT NULL
);


CREATE TABLE events
(
    event_id   serial PRIMARY KEY,
    event_name varchar(50)                                                          NOT NULL,
    event_date timestamp                                                            NOT NULL,
    venue_id   int REFERENCES venues (venue_id) ON DELETE CASCADE ON UPDATE CASCADE NOT NULL
);



CREATE TABLE event_attendee
(
    id          serial PRIMARY KEY,
    event_id    int REFERENCES events (event_id) ON DELETE CASCADE ON UPDATE CASCADE       NOT NULL,
    attendee_id int REFERENCES attendees (attendees_id) ON DELETE CASCADE ON UPDATE CASCADE NOT NULL
);