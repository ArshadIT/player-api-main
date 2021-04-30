--DROP TABLE IF EXISTS game;

-- CREATE TABLE game (
--   game_id INT AUTO_INCREMENT PRIMARY KEY,
--   game_name VARCHAR(250) NOT NULL
-- );

INSERT INTO game ( game_name) VALUES
  ('Dota'),
  ('Fortnite'),
  ('COD');

INSERT INTO geography (region) VALUES
  ('Asia'),
  ('Europe'),
  ('US');

INSERT INTO game_level (level_description, game_id) VALUES
  ('stage 1', 1),
  ('stage 2', 1),
  ('stage 3', 1);

INSERT INTO game_level (level_description, game_id) VALUES
  ('Chapter 1', 2),
  ('Chapter 2', 2),
  ('Chapter 3', 2);

INSERT INTO game_level (level_description, game_id) VALUES
  ('level 1', 3),
  ('level 2', 3),
  ('level 3', 3);

INSERT INTO interest_level (level_description) VALUES
  ('noob'),
  ('pro'),
  ('Invincible');

INSERT INTO player (player_name, gender, nick_name, geography_id) VALUES
  ('Mudassar', 'Male', 'Moha_7', 2),
  ('Arshad', 'Male', 'Fortnite', 1);

INSERT INTO player_interest (player_id, game_id, interest_level_id) VALUES
  (1, 1, 1),
  (1, 2, 2),
  (2, 1, 2),
  (2, 2, 1),
  (2, 3, 3);


INSERT INTO player_game_level (player_id, game_id, game_level_id, credit_amount) VALUES
  (1, 1, 1, 150),
  (2, 2, 2, 220);



