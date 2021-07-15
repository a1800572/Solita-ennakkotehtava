
CREATE TABLE IF NOT EXISTS manufacturer (
id VARCHAR(250) PRIMARY KEY,
ordernumber INT NOT NULL,
responsibleperson VARCHAR(250) NOT NULL,
healthcaredistrict VARCHAR(250) NOT NULL,
vaccine VARCHAR(250) NOT NULL,
injections INT NOT NULL,
arrived VARCHAR(250) NOT NULL
);

CREATE TABLE IF NOT EXISTS vaccine (
vaccinationid VARCHAR(250) PRIMARY KEY,
sourcebottle VARCHAR(250) NOT NULL,
gender VARCHAR(250) NOT NULL,
vaccinationdate VARCHAR(250) NOT NULL
);