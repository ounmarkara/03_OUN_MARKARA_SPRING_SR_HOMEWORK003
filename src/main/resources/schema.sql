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

CREATE TABLE events (
                        event_id INT PRIMARY KEY,
                        event_name VARCHAR(255),
                        event_date DATE,
                        venue_id INT,
                        FOREIGN KEY (venue_id) REFERENCES venues(venue_id)
                            ON DELETE CASCADE
                            ON UPDATE CASCADE
);

CREATE TABLE event_attendee (
                                id SERIAL PRIMARY KEY,
                                event_id INT,
                                attendees_id INT,
                                FOREIGN KEY (event_id) REFERENCES events(event_id)
                                    ON DELETE CASCADE
                                    ON UPDATE CASCADE,
                                FOREIGN KEY (attendees_id) REFERENCES attendees(attendees_id)
                                    ON DELETE CASCADE
                                    ON UPDATE CASCADE
);