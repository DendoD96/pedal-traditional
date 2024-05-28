-- DROP DATABASE is not required, as a new container will not have the redhatpedal database
-- DROP DATABASE IF EXISTS redhatpedal;

CREATE DATABASE redhatpedal
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'C.UTF-8'
    LC_CTYPE = 'C.UTF-8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;
