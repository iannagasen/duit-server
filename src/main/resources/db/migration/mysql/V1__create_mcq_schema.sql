CREATE TABLE IF NOT EXISTS topic (
  id          INTEGER     PRIMARY KEY AUTO_INCREMENT,
  topic       VARCHAR(20) NOT NULL
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS question_types (
  id          INTEGER PRIMARY KEY AUTO_INCREMENT,
  type        VARCHAR(255)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS  mcq (
  id          INTEGER PRIMARY KEY AUTO_INCREMENT,
  topic_id    INTEGER NOT NULL,
  question    VARCHAR(1023) NOT NULL,

  FOREIGN KEY (topic_id) REFERENCES topic(id)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS identification (
  id          INTEGER PRIMARY KEY AUTO_INCREMENT,
  topic_id    INTEGER NOT NULL,
  term        VARCHAR(1023),
  description VARCHAR(2047),
  explanation VARCHAR(1023),

  FOREIGN KEY (topic_id) REFERENCES topic(id)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS mcq_choices (
  id          INTEGER PRIMARY KEY AUTO_INCREMENT,
  mcq_id      INTEGER NOT NULL,
  choice      VARCHAR(1023) NOT NULL,
  explanation VARCHAR(2047),
  is_correct  VARCHAR(1),
  
  FOREIGN KEY (mcq_id) REFERENCES mcq(id)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS mcq_quiz (
  id          INTEGER PRIMARY KEY AUTO_INCREMENT,
  topic_id    INTEGER,
  date_taken  DATETIME,
  time_taken  INTEGER,

  FOREIGN KEY (topic_id) REFERENCES topic(id)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS mcq_quiz_item (
  id          INTEGER PRIMARY KEY AUTO_INCREMENT,
  quiz_id     INTEGER,
  mcq_id      INTEGER,
  choice_id   INTEGER,

  FOREIGN KEY (quiz_id) REFERENCES mcq_quiz(id),
  FOREIGN KEY (mcq_id) REFERENCES mcq(id),
  FOREIGN KEY (choice_id) REFERENCES mcq_choices(id)
)