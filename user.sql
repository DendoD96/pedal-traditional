-- DROP DATABASE is not required, as a new container will not have the redhatpedal database
-- DROP DATABASE IF EXISTS redhatpedal;

CREATE DATABASE redhatpedal
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'C'
    LC_CTYPE = 'C'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;
