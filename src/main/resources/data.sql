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
INSERT INTO events (event_id, event_name, event_date, venue_id) VALUES
                                                                    (1, 'Tech Conference 2025', '2025-06-15', 2),
                                                                    (2, 'Music Festival', '2025-07-20', 2);

INSERT INTO event_attendee (event_id, attendees_id) VALUES
                                                       (2, 3);

SELECT * FROM event_attendee sc INNER JOIN  attendees a ON sc.attendees_id = a.attendees_id WHERE event_id = 2;

SELECT sc.attendees_id,attendee_name,email FROM attendees sc
                                                 INNER JOIN  event_attendee a
                                                             ON sc.attendees_id = a.attendees_id
WHERE event_id =2 ;