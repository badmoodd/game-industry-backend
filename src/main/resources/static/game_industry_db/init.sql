CREATE TYPE user_role AS ENUM ('ROLE_ADMIN', 'ROLE_USER');
CREATE CAST (VARCHAR AS user_role) WITH INOUT AS IMPLICIT;

CREATE TABLE users
(
    email     VARCHAR(255) PRIMARY KEY,
    username  VARCHAR(255),
    password  VARCHAR(255),
    user_role user_role
);

CREATE TABLE games
(
    game_id      SERIAL PRIMARY KEY,
    title        VARCHAR(255),
    genre        VARCHAR(255),
    release_date DATE,
    developer    VARCHAR(255)
);

CREATE TABLE players
(
    player_id     SERIAL PRIMARY KEY,
    username      VARCHAR(255),
    email         VARCHAR(255),
    date_of_birth DATE,
    country       VARCHAR(255)
);

CREATE TABLE achievements
(
    achievement_id SERIAL PRIMARY KEY,
    name           VARCHAR(255),
    description    TEXT,
    game_name      VARCHAR(255)
);

CREATE TABLE tournaments
(
    tournament_id SERIAL PRIMARY KEY,
    name          VARCHAR(255),
    game_name     VARCHAR(255),
    start_date    DATE,
    end_date      DATE,
    organizer     VARCHAR(255)
);

CREATE TABLE player_statistics
(
    stat_id     SERIAL PRIMARY KEY,
    player_name VARCHAR(255),
    game_name   VARCHAR(255),
    wins        INT,
    losses      INT,
    draws       INT,
    points      INT
);

CREATE TABLE player_friends
(
    friendship_id SERIAL PRIMARY KEY,
    player_name   VARCHAR(255),
    friend_name   VARCHAR(255)
);

CREATE TABLE player_inventory
(
    inventory_id SERIAL PRIMARY KEY,
    player_name  VARCHAR(255),
    item_name    VARCHAR(255),
    quantity     INT
);

CREATE TABLE player_progress
(
    progress_id   SERIAL PRIMARY KEY,
    player_name   VARCHAR(255),
    game_name     VARCHAR(255),
    current_level INT,
    experience    INT
);

CREATE TABLE game_reviews
(
    review_id   SERIAL PRIMARY KEY,
    game_name   VARCHAR(255),
    player_id   VARCHAR(255),
    rating      INT,
    review_text TEXT
);

CREATE TABLE game_publishers
(
    publisher_id SERIAL PRIMARY KEY,
    name         VARCHAR(255),
    country      VARCHAR(255)
);

INSERT INTO game_publishers (name, country)
VALUES ('CD Projekt RED', 'Польша'),
       ('4A Games', 'Украина'),
       ('Maxis', 'США'),
       ('Nintendo', 'Япония'),
       ('Bethesda Game Studios', 'США'),
       ('Rockstar North', 'Великобритания'),
       ('Rockstar Games', 'США'),
       ('Valve Corporation', 'США'),
       ('BioWare', 'Канада'),
       ('Naughty Dog', 'США'),
       ('Mojang Studios', 'Швеция'),
       ('EA Vancouver', 'Канада');


-- Таблица games
INSERT INTO games (title, genre, release_date, developer)
VALUES ('Ведьмак 3: Дикая Охота', 'Action/RPG', '2015-05-19', 'CD Projekt RED'),
       ('Метро 2033', 'Шутер от первого лица', '2010-03-16', '4A Games'),
       ('Ведьмак 2: Убийцы королей', 'Action/RPG', '2011-05-17', 'CD Projekt RED'),
       ('Симс 4', 'Симулятор жизни', '2014-09-02', 'Maxis'),
       ('Wii Sports', 'Спортивный симулятор', '2006-11-19', 'Nintendo'),
       ('The Elder Scrolls V: Skyrim', 'Action/RPG', '2011-11-11', 'Bethesda Game Studios'),
       ('GTA V', 'Action/Adventure', '2013-09-17', 'Rockstar North'),
       ('Red Dead Redemption 2', 'Action/Adventure', '2018-10-26', 'Rockstar Games'),
       ('Counter-Strike: Global Offensive', 'Шутер от первого лица', '2012-08-21', 'Valve Corporation'),
       ('The Witcher', 'Action/RPG', '2007-10-26', 'CD Projekt RED'),
       ('Mass Effect 2', 'Action/RPG', '2010-01-26', 'BioWare'),
       ('Uncharted 4: Путь вора', 'Action/Adventure', '2016-05-10', 'Naughty Dog'),
       ('The Last of Us', 'Action/Adventure', '2013-06-14', 'Naughty Dog'),
       ('Minecraft', 'Sandbox', '2011-11-18', 'Mojang Studios'),
       ('FIFA 21', 'Спортивный симулятор', '2020-10-09', 'EA Vancouver');

-- Таблица players
INSERT INTO players (username, email, date_of_birth, country)
VALUES ('Игрок1', 'player1@example.com', '1990-01-01', 'Россия'),
       ('Геймер2000', 'gamer2000@example.com', '2000-05-15', 'Украина'),
       ('Лучик_95', 'luchik95@example.com', '1995-12-30', 'Беларусь'),
       ('GamerGuy', 'gamerguy@example.com', '1985-07-20', 'Казахстан'),
       ('ПрофессорИгр', 'professorigra@example.com', '1978-03-10', 'Россия'),
       ('ИгроФанат123', 'igrofanat123@example.com', '1998-09-25', 'Украина'),
       ('АртёмКиллер', 'artemkiller@example.com', '1982-11-05', 'Беларусь'),
       ('ЖелезныйГеймер', 'zheleznygamer@example.com', '1993-04-17', 'Россия'),
       ('СуперСтример', 'superstreamer@example.com', '1996-08-08', 'Казахстан'),
       ('МастерИгры', 'masterigry@example.com', '1989-02-14', 'Украина'),
       ('ГеймингХакер', 'gaminghacker@example.com', '1975-06-23', 'Россия'),
       ('ИгровойГуру', 'igrovoiguru@example.com', '1987-10-03', 'Беларусь'),
       ('МистерИгровой', 'misterigrovoy@example.com', '1991-07-12', 'Украина'),
       ('ГеймПассион', 'gamepassion@example.com', '1984-09-18', 'Россия');

-- Таблица achievements
INSERT INTO achievements (name, description, game_name)
VALUES ('Покоритель Новиграда', 'Достижение за завершение всех квестов в Новиграде.', 'Ведьмак 3: Дикая Охота'),
       ('Метрополитен', 'Достижение за прохождение игры Метро 2033.', 'Метро 2033'),
       ('Воин Гейральта', 'Достижение за прохождение Ведьмака 2 на самом высоком уровне сложности.',
        'Ведьмак 2: Убийцы королей'),
       ('Миллионер', 'Достижение за накопление миллиона симолеонов в Симс 4.', 'Симс 4'),
       ('Король бейсбола', 'Достижение за выигрыш всех турниров в Wii Sports.', 'Wii Sports'),
       ('Довакин', 'Достижение за завершение основной сюжетной линии в Skyrim.', 'The Elder Scrolls V: Skyrim'),
       ('Главный грабитель', 'Достижение за успешное завершение ограбления в GTA V.', 'GTA V'),
       ('Охотник за приключениями', 'Достижение за охоту на 50 разных видов животных в Red Dead Redemption 2.',
        'Red Dead Redemption 2'),
       ('Глобальный стрелок', 'Достижение за победу в 100 матчах в CS:GO.', 'Counter-Strike: Global Offensive'),
       ('Волшебник', 'Достижение за завершение основной сюжетной линии в The Witcher.', 'The Witcher'),
       ('Спаситель галактики', 'Достижение за спасение галактики в Mass Effect 2.', 'Mass Effect 2'),
       ('Сокровища Эльдорадо', 'Достижение за нахождение всех сокровищ в Uncharted 4.', 'Uncharted 4: Путь вора'),
       ('Выживший', 'Достижение за выживание в постапокалиптичном мире в The Last of Us.', 'The Last of Us'),
       ('Строитель мира', 'Достижение за построение самого большого замка в Minecraft.', 'Minecraft'),
       ('Чемпион лиги', 'Достижение за победу в Лиге в FIFA 21.', 'FIFA 21');

-- Таблица tournaments
INSERT INTO tournaments (name, game_name, start_date, end_date, organizer)
VALUES ('Турнир ведьмаков', 'Ведьмак 3: Дикая Охота', '2023-07-15', '2023-07-20', 'Гильдия Ведьмаков'),
       ('Metro Madness', 'Метро 2033', '2022-09-05', '2022-09-10', 'Metro Last Light Company'),
       ('Gwent Grand Prix', 'The Witcher', '2024-02-20', '2024-02-25', 'Gwent Masters'),
       ('CS:GO Clash', 'Counter-Strike: Global Offensive', '2023-11-10', '2023-11-15', 'ESL Gaming'),
       ('FIFA Fun Cup', 'FIFA 21', '2024-05-01', '2024-05-07', 'EA Sports');

-- Таблица player_statistics
INSERT INTO player_statistics (player_name, game_name, wins, losses, draws, points)
VALUES ('Игрок1', 'The Elder Scrolls V: Skyrim', 150, 50, 20, 3200),
       ('Геймер2000', 'Counter-Strike: Global Offensive', 230, 100, 40, 4500),
       ('Лучик_95', 'FIFA 21', 180, 80, 30, 3900),
       ('GamerGuy', 'GTA V', 300, 150, 60, 6000),
       ('ПрофессорИгр', 'Mass Effect 2', 120, 40, 10, 2600),
       ('ИгроФанат123', 'Red Dead Redemption 2', 280, 120, 50, 5200),
       ('АртёмКиллер', 'The Witcher', 200, 90, 30, 4200),
       ('ЖелезныйГеймер', 'Minecraft', 350, 200, 80, 7000),
       ('СуперСтример', 'Uncharted 4: Путь вора', 190, 70, 20, 3800),
       ('МастерИгры', 'The Last of Us', 270, 110, 40, 5500),
       ('ГеймингХакер', 'Metro 2033', 110, 30, 10, 2400),
       ('ИгровойГуру', 'Sims 4', 160, 60, 25, 3300),
       ('МистерИгровой', 'Wii Sports', 280, 150, 70, 5600),
       ('ГеймПассион', 'Minecraft', 400, 180, 90, 8000);

-- Таблица player_friends
INSERT INTO player_friends (player_name, friend_name)
VALUES ('Игрок1', 'Геймер2000'),
       ('Геймер2000', 'Лучик_95'),
       ('Лучик_95', 'GamerGuy'),
       ('GamerGuy', 'ПрофессорИгр'),
       ('ПрофессорИгр', 'ИгроФанат123'),
       ('ИгроФанат123', 'АртёмКиллер'),
       ('АртёмКиллер', 'ЖелезныйГеймер'),
       ('ЖелезныйГеймер', 'СуперСтример'),
       ('СуперСтример', 'МастерИгры'),
       ('МастерИгры', 'ГеймингХакер'),
       ('ГеймингХакер', 'ИгровойГуру'),
       ('ИгровойГуру', 'МистерИгровой'),
       ('МистерИгровой', 'ГеймПассион'),
       ('ГеймПассион', 'Игрок1');

-- Таблица player_inventory
INSERT INTO player_inventory (player_name, item_name, quantity)
VALUES ('Игрок1', 'Меч', 1),
       ('Геймер2000', 'Аптечка', 3),
       ('Лучик_95', 'Ключи', 10),
       ('GamerGuy', 'Деньги', 100000),
       ('ПрофессорИгр', 'Книга заклинаний', 1),
       ('ИгроФанат123', 'Лошадь', 1),
       ('АртёмКиллер', 'Зелье здоровья', 5),
       ('ЖелезныйГеймер', 'Кирка', 1),
       ('СуперСтример', 'Пистолет', 2),
       ('МастерИгры', 'Карта', 1),
       ('ГеймингХакер', 'Броня', 1),
       ('ИгровойГуру', 'Семена', 20),
       ('МистерИгровой', 'Бейсбольная бита', 1),
       ('ГеймПассион', 'Футбольный мяч', 2);

-- Таблица player_progress
INSERT INTO player_progress (player_name, game_name, current_level, experience)
VALUES ('Игрок1', 'The Elder Scrolls V: Skyrim', 50, 50000),
       ('Геймер2000', 'Counter-Strike: Global Offensive', 30, 30000),
       ('Лучик_95', 'FIFA 21', 40, 40000),
       ('GamerGuy', 'GTA V', 70, 70000),
       ('ПрофессорИгр', 'Mass Effect 2', 20, 20000),
       ('ИгроФанат123', 'Red Dead Redemption 2', 60, 60000),
       ('АртёмКиллер', 'The Witcher', 45, 45000),
       ('ЖелезныйГеймер', 'Minecraft', 80, 80000),
       ('СуперСтример', 'Uncharted 4: Путь вора', 35, 35000),
       ('МастерИгры', 'The Last of Us', 65, 65000),
       ('ГеймингХакер', 'Metro 2033', 25, 25000),
       ('ИгровойГуру', 'Sims 4', 55, 55000),
       ('МистерИгровой', 'Wii Sports', 75, 75000),
       ('ГеймПассион', 'Minecraft', 85, 85000);

-- Таблица game_reviews
INSERT INTO game_reviews (game_name, player_id, rating, review_text)
VALUES ('Ведьмак 3: Дикая Охота', 'Игрок1', 9, 'Отличная игра, интересный сюжет и красивая графика.'),
       ('Метро 2033', 'Геймер2000', 8, 'Атмосферный мир и хорошая история.'),
       ('Симс 4', 'Лучик_95', 7, 'Затягивает на долгие часы, но быстро начинает надоедать.'),
       ('Wii Sports', 'GamerGuy', 8, 'Отличная игра для развлечения в компании друзей.'),
       ('Counter-Strike: Global Offensive', 'ПрофессорИгр', 10, 'Лучший шутер всех времен!'),
       ('The Witcher', 'ИгроФанат123', 9, 'Захватывающий мир и интересные квесты.'),
       ('Uncharted 4: Путь вора', 'АртёмКиллер', 9, 'Отличная графика и захватывающий сюжет.'),
       ('The Last of Us', 'ЖелезныйГеймер', 10, 'Глубокий сюжет и эмоциональные персонажи.'),
       ('Minecraft', 'СуперСтример', 9, 'Бесконечные возможности для творчества и выживания.'),
       ('FIFA 21', 'МастерИгры', 8, 'Отличный футбольный симулятор, но с некоторыми недостатками.');

-- Добавление администратора в таблицу users
INSERT INTO users (email, username, password, user_role)
VALUES ('admin@gmail.com', 'Admin Dio', '$2a$12$aeAsytC/mleJtA3.J8HqRuUIDZNykndDQSisT3q4b7LvQbmZlpnFi', 'ROLE_ADMIN'),
       ('user@gmail.com', 'User Josuke', '$2a$12$OkpOdefcZIr9kgo0aLXE0e3qWhv6lDuXA828y4Dw5UyCVYCOsoxVO', 'ROLE_USER');
-- first user (admin) 'admin@gmail.com', 'admin'
-- second user (user) 'user@gmail.com', 'user'