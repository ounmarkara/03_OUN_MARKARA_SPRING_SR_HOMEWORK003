INSERT INTO venues (venue_name, location) VALUES
                                              ('Hulk', '123 Rage Rd, Greenvale'),
                                              ('Thor', '456 Thunder St, Asgard City'),
                                              ('Iron Man', '789 Tech Ln, Starkville'),
                                              ('Cap', '321 Patriot Ave, Freedomtown'),
                                              ('Widow', '555 Spy Blvd, Stealth City');

INSERT INTO attendees (attendee_name, email) VALUES
                                                 ('Tom Hanks', 'tom.hanks@email.com'),
                                                 ('Leonardo DiCaprio', 'leo.d@email.com'),
                                                 ('Denzel Washington', 'denzel.w@email.com'),
                                                 ('Robert Downey Jr', 'rdj@email.com'),
                                                 ('Brad Pitt', 'brad.pitt@email.com');

INSERT INTO events (event_name, event_date, venue_id) VALUES

                                                          ('Music Festival', '2025-05-15 18:30:00', 2),
                                                          ('Business Summit', '2025-06-20 09:00:00', 3),

                                                          ('AI Workshop', '2025-08-12 16:00:00', 5);



INSERT INTO event_attendee (event_id, attendee_id) VALUES
                                                       (1, 101),  -- Attendee 101 at Event 1
                                                       (1, 102),  -- Attendee 102 at Event 1
                                                       (2, 103),  -- Attendee 103 at Event 2
                                                       (3, 104),  -- Attendee 104 at Event 3
                                                       (4, 105);  -- Attendee 105 at Event 4


SELECT * FROM event_attendee sc INNER JOIN  attendees a ON sc.attendee_id = a.attendees_id WHERE event_id = 2;

SELECT sc.attendees_id,attendee_name,email FROM attendees sc
                                                 INNER JOIN  event_attendee a
                                                             ON sc.attendees_id = a.attendee_id
WHERE event_id =6 ;

SELECT * FROM attendees sc
                  INNER JOIN  event_attendee a
                              ON sc.attendees_id = a.attendee_id
WHERE event_id = 10;

INSERT INTO event_attendee (event_id, attendee_id)
VALUES


    -- Attendees for event 11 (Workshop Series)
    (6, 6),
    (6, 7),

    -- Attendees for event 12 (Networking Mixer)
    (7, 12),
    (7, 13),
    (7, 10),
    (7, 11);

SELECT * FROM event_attendee sc
                  INNER JOIN  attendees a
                              ON sc.attendee_id = a.attendees_id
WHERE event_id = 7;