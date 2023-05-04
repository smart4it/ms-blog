CREATE TABLE article
(
    id      uuid PRIMARY KEY       DEFAULT gen_random_uuid(),
    title   varchar(1024) NOT NULL,
    content text          NOT NULL,
    created timestamp     NOT NULL DEFAULT (CURRENT_TIMESTAMP at time zone 'utc'),
    updated timestamp     NOT NULL DEFAULT (CURRENT_TIMESTAMP at time zone 'utc')
);