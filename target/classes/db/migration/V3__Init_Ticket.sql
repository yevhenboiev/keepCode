INSERT INTO client (client_name, creation_date, subscriber_id) VALUES ('Igor', now(), 1);

INSERT INTO ticket (date_creation, value, client) VALUES (now(), 1000, 1);

INSERT INTO ticket (date_creation, value, client) VALUES (now(), 2000, 1);

INSERT INTO ticket (date_creation, value, client) VALUES (now(), 3000, 1);

INSERT INTO client (client_name, creation_date, subscriber_id) VALUES ('Oleg', now(), 2);

INSERT INTO ticket (date_creation, value, client) VALUES (now(), 1001, 2);

INSERT INTO ticket (date_creation, value, client) VALUES (now(), 2002, 2);

INSERT INTO ticket (date_creation, value, client) VALUES (now(), 3003, 2)
