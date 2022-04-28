INSERT INTO subscriber (creation_date,
                        email,
                        password,
                        role)
VALUES (now(),
        'admin@gmail.com',
        '$2a$12$jQADut2UBqFEZqrhgjajpehc8xeXdSBGhyd3G0ju5.1xFvYu1kX5m',
        1);

INSERT INTO subscriber (creation_date,
                        email,
                        password,
                        role)
VALUES (now(),
        'user@gmail.com',
        '$2a$12$jQADut2UBqFEZqrhgjajpehc8xeXdSBGhyd3G0ju5.1xFvYu1kX5m',
        0);