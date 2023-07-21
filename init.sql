-- Connect to the desired database
USE pragma;

-- Create the 'studio' table
CREATE TABLE studio (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL
);

-- Create the 'game' table
CREATE TABLE game (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    rating DECIMAL(3, 1) NOT NULL,
    studio_key INT,
    content TEXT,
    FOREIGN KEY (studio_key) REFERENCES studio(id) ON DELETE CASCADE
);

-- Insert data into Studio table
INSERT INTO
    studio (id, name, city)
VALUES
    (1, 'Wonderstorm', 'New York'),
    (2, 'Arbiter', 'Los Angeles'),
    (3, 'Spiders', 'London');

-- Insert data into Game table
INSERT INTO game (id, name, rating, studio_key, content)
VALUES (1, 'Zelta', 4.5, 2, 'Zelta content'),
       (2, 'Fast2Furious', 3.8, 1, 'Fast2Furious content'),
       (3, 'Bublee', 4.2, 2, 'Bublee content'),
       (4, 'Cars', 4.0, 3, 'Cars content'),
       (5, 'BigCityLife', 4.9, 3, 'BigCityLife content');
