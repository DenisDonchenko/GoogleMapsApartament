CREATE TABLE IF NOT EXISTS flat
(
    id             INT(11)      NOT NULL,
    rooms          INT(11)      NOT NULL,
    square         DOUBLE       NOT NULL,
    address        VARCHAR(255) NOT NULL,
    description    VARCHAR(255) NOT NULL,
    coordinates_id INT(11)      NOT NULL
);

CREATE TABLE IF NOT EXISTS photo
(
    id      INT(11)  NOT NULL,
    photo   TINYBLOB NOT NULL,
    flat_id INT(11)  NOT NULL
);

CREATE TABLE IF NOT EXISTS coordinates
(
    id        INT(11)      NOT NULL,
    latitude  VARCHAR(255) NOT NULL,
    longitude VARCHAR(255) NOT NULL
)
