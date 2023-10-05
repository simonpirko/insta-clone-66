create schema new_db_instagram_clone;


Use new_db_instagram_clone;


CREATE TABLE IF NOT EXISTS Account
(
    id                INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    username          VARCHAR(255)                   NOT NULL,
    email             VARCHAR(255)                   NOT NULL,
    password          VARCHAR(255)                   NOT NULL,
    avatar            MEDIUMBLOB,
    bio               VARCHAR(255),
    registration_date DATE                           NOT NULL
);


CREATE TABLE IF NOT EXISTS Post
(
    id          INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    account_id  INT                            NOT NULL,
    content     MEDIUMBLOB                     NOT NULL,
    description VARCHAR(255),
    post_date DATE NOT NULL ,
    FOREIGN KEY (account_id) REFERENCES Account (id)
);


CREATE TABLE IF NOT EXISTS likes
(
    id         INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    account_id INT                            NOT NULL,
    post_id    INT                            NOT NULL,
    FOREIGN KEY (account_id) REFERENCES Account (id),
    FOREIGN KEY (post_id) REFERENCES Post (id)
);


CREATE TABLE IF NOT EXISTS Comment
(
    id           INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    account_id   INT                            NOT NULL,
    post_id      INT                            NOT NULL,
    text         VARCHAR(255),
    comment_date DATETIME                       NOT NULL,
    FOREIGN KEY (account_id) REFERENCES Account (id),
    FOREIGN KEY (post_id) REFERENCES Post (id)
);


CREATE TABLE IF NOT EXISTS Follower
(
    id           INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    follower_id  INT                            NOT NULL,
    following_id INT                            NOT NULL,
    FOREIGN KEY (follower_id) REFERENCES Account (id),
    FOREIGN KEY (following_id) REFERENCES Account (id)
);
