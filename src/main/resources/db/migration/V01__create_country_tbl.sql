CREATE TABLE country_data (
  id VARCHAR2(255) NOT NULL,
  country VARCHAR2(255),
  city VARCHAR2(255),
  population number,
  CONSTRAINT pk_country PRIMARY KEY (id)
);