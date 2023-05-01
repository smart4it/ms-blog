CREATE TABLE category
(
    id      uuid PRIMARY KEY      DEFAULT gen_random_uuid(),
    name    varchar(250) NOT NULL,
    created timestamp    NOT NULL DEFAULT (CURRENT_TIMESTAMP at time zone 'utc'),
    updated timestamp    NOT NULL DEFAULT (CURRENT_TIMESTAMP at time zone 'utc')
);