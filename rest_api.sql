CREATE DATABASE IF NOT EXISTS restapi DEFAULT CHARACTER SET utf8;

CREATE USER IF NOT EXISTS 'prac_user'@'localhost' IDENTIFIED BY '1111';

GRANT ALL PRIVILEGES ON restapi.* TO 'prac_user'@'localhost';
FLUSH PRIVILEGES;

USE restapi;

CREATE TABLE IF NOT EXISTS Post (
                                    id INT NOT NULL AUTO_INCREMENT,
                                    title VARCHAR(100),
                                    content VARCHAR(1000),
                                    PRIMARY KEY (id)
) ENGINE = InnoDB;