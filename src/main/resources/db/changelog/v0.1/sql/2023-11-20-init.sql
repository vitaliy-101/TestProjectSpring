-- liquibase formatted sql
-- changeset vitaliy:2023-11-20-init
create table if not exists `user`
(
  id INT AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  age INT,
  text VARCHAR(300),
  CONSTRAINT pk_user primary key (id),
  CONSTRAINT uq_user_name unique (name)
);
create table if not exists phone
(
  id INT AUTO_INCREMENT,
  model VARCHAR(120) NOT NULL,
  `year` INT,
  user_id INT NOT NULL,
  CONSTRAINT pk_phone primary key (id),
  CONSTRAINT uq_phone_model unique (model),
  CONSTRAINT fk_phone_user_id  FOREIGN KEY (user_id) REFERENCES `user` (id) ON DELETE CASCADE
);
create table if not exists developer
(
  id INT AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  country VARCHAR(100) NOT NULL,
  CONSTRAINT pk_developer primary key (id),
  CONSTRAINT uq_developer_name unique (name)
);
create table if not exists programming_language
(
  id INT AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  type VARCHAR(100) NOT NULL,
  CONSTRAINT pk_programming_language primary key (id)
);
create table if not exists developer_programming_language
(
  developer_id INT NOT NULL,
  programming_language_id INT NOT NULL,
  CONSTRAINT fk_developer_programming_language_developer_id  FOREIGN KEY (developer_id) REFERENCES developer (id) ON DELETE CASCADE,
  CONSTRAINT fk_developer_programming_language_programming_language_id  FOREIGN KEY (programming_language_id) REFERENCES programming_language (id) ON DELETE CASCADE
);

