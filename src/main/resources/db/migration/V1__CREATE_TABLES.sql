CREATE TABLE user (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username varchar(64) not null unique
) engine=MyISAM;

CREATE TABLE todo (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title varchar(64) not null,
    description varchar(500),
    completed BOOLEAN NOT NULL,
    user_id BIGINT NOT NULL
) engine=MyISAM;