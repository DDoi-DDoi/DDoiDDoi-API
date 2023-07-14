# Database Query Save Data 

## user database



## post database

CREATE TABLE post (
pid INT PRIMARY KEY,
id VARCHAR(255),
title VARCHAR(255),
text VARCHAR(255),

views INT,
up INT
);

INSERT INTO post (pid, id, title, text, views, up)
VALUES
(1, 'abc123', 'First Post', 'This is the first post.', 100, 50),
(2, 'def456', 'Second Post', 'This is the second post.', 200, 75),
(3, 'ghi789', 'Third Post', 'This is the third post.', 300, 100);

## chat database

