/*CREATE TABLE albums (
    album_id INTEGER AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    artist VARCHAR(255) ,
    release_date DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE musics (
    music_id INTEGER AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    duration TIME,
    album_id INTEGER NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (album_id) REFERENCES albums(album_id) ON dELETE CASCADE
);*/

CREATE TABLE partCategory (
    partId VARCHAR(100) PRIMARY KEY,
    partName VARCHAR(100)
);

CREATE TABLE setCategory (
    setId VARCHAR(100) PRIMARY KEY,
    setName VARCHAR(100)
);

CREATE TABLE training (
    trainingId INTEGER AUTO_INCREMENT PRIMARY KEY,
    partId VARCHAR(100) NOT NULL,
    workout VARCHAR(100),
    registrationDate DATE NOT NULL,
    setId VARCHAR(100) NOT NULL,
    rep LONG NOT NULL,
    weight DOUBLE,
    memo VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (partId) REFERENCES partCategory(partId),
    FOREIGN KEY (setId) REFERENCES setCategory(setId)
);

CREATE TABLE users (
    user_id INTEGER AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(60) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE userData (
    userDataId INTEGER AUTO_INCREMENT PRIMARY KEY,
    hHeight DOUBLE NOT NULL,
    hWeight DOUBLE NOT NULL,
    bmi DOUBLE,
    registrationDate DATE NOT NULL
);



