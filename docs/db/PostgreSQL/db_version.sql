-- Table: users

-- DROP TABLE users;

CREATE TABLE users
(
  id serial NOT NULL,
  name character varying(40),
  date time with time zone,
  CONSTRAINT "PK" PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE users
  OWNER TO postgres;
