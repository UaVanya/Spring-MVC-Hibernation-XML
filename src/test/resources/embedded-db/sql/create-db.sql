drop table PUPILS if exists;

CREATE TABLE PUPILS (
  id INTEGER IDENTITY,
  firstname VARCHAR(45) NOT NULL,
  surname VARCHAR(45) NOT NULL,
  classroom VARCHAR(45) NOT NULL,
  address VARCHAR(70) NOT NULL,
  knowledge_level VARCHAR(6) NOT NULL
);