CREATE TABLE status.company(
    id INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
    name VARCHAR(255) NOT NULL,
    licenses_purchased INTEGER NOT NULL,
    CONSTRAINT id_pk PRIMARY KEY (id)    
) ENGINE = INNODB;

CREATE TABLE status.license_user_company(
    id INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
    company_id INTEGER NOT NULL,
    user_id INTEGER NOT NULL,
    is_active TINYINT NOT NULL,
    expiration_date LONG NOT NULL,
    CONSTRAINT id_pk PRIMARY KEY (id)
) ENGINE = INNODB;

CREATE TABLE status.user(
    id INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
    password VARCHAR(500) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    company_id INTEGER NOT NULL,
    last_login_date LONG NOT NULL,
    CONSTRAINT id_pk PRIMARY KEY (id)
) ENGINE = INNODB;

ALTER TABLE status.user
ADD CONSTRAINT fk_user_company
FOREIGN KEY  user(company_id)
REFERENCES company(id);

ALTER TABLE status.license_user_company
ADD CONSTRAINT fk_license_user_company_company
FOREIGN KEY  license_user_company(company_id)
REFERENCES company(id);

ALTER TABLE status.license_user_company
ADD CONSTRAINT fk_license_user_company_user
FOREIGN KEY  license_user_company(user_id)
REFERENCES user(id);

CREATE TABLE status.state(
    id INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
    name VARCHAR(255) NOT NULL,
    is_interruptible TINYINT NOT NULL,
    CONSTRAINT id_pk PRIMARY KEY (id)
) ENGINE = INNODB;

CREATE TABLE status.user_state(
    id INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
    user_id INTEGER NOT NULL,
    state_id INTEGER NOT NULL,
    create_timestamp LONG NOT NULL,
    CONSTRAINT id_pk PRIMARY KEY (id)
) ENGINE = INNODB;

ALTER TABLE status.user_state 
ADD CONSTRAINT user_user_state
FOREIGN KEY user_state(user_id)
REFERENCES user(id);

ALTER TABLE status.user_state 
ADD CONSTRAINT state_user_state
FOREIGN KEY user_state(state_id)
REFERENCES state(id);

CREATE TABLE status.user_role(
    id INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
    user_id INTEGER NOT NULL,
    role_id INTEGER NOT NULL,
    CONSTRAINT id_pk PRIMARY KEY (id)
) ENGINE = INNODB;

CREATE TABLE status.role(
    id INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
    name VARCHAR(50) NOT NULL,
    CONSTRAINT id_pk PRIMARY KEY (id)
) ENGINE = INNODB;

ALTER TABLE status.user_role 
ADD CONSTRAINT user_user_role
FOREIGN KEY user_role(user_id)
REFERENCES user(id);

ALTER TABLE status.user_role 
ADD CONSTRAINT role_user_role
FOREIGN KEY user_role(role_id)
REFERENCES role(id);


