-- Create sequence for user_id
CREATE SEQUENCE user_seq START WITH 1 INCREMENT BY 1;
-- Create sequence for topic_id
CREATE SEQUENCE topic_seq START WITH 1 INCREMENT BY 1;
-- Create sequence for interview_question id
CREATE SEQUENCE interview_quest_seq START WITH 1 INCREMENT BY 1;

-- Create sequence for technology_id
CREATE SEQUENCE technology_seq START WITH 1 INCREMENT BY 1;

-- Create users table
CREATE TABLE users
(
    user_id   BIGINT PRIMARY KEY DEFAULT nextval('user_seq'),
    email     VARCHAR(255) NOT NULL UNIQUE,
    password  VARCHAR(255) NOT NULL,
    firstname VARCHAR(100) NOT NULL,
    lastname  VARCHAR(100) NOT NULL
);

CREATE TABLE technologies
(
    id          BIGINT PRIMARY KEY DEFAULT nextval('technology_seq'),
    name        VARCHAR(255) NOT NULL UNIQUE,
    code        VARCHAR(100) NOT NULL UNIQUE,
    description TEXT,
    created_at  TIMESTAMP          DEFAULT CURRENT_TIMESTAMP
);

-- Create topics table
CREATE TABLE topics
(
    topic_id    BIGINT PRIMARY KEY DEFAULT nextval('topic_seq'),
    technology_id BIGINT,
    title       VARCHAR(255) NOT NULL,
    code        VARCHAR(100) NOT NULL UNIQUE,
    description TEXT,
    CONSTRAINT fk_topics_technology
        FOREIGN KEY (technology_id) REFERENCES technologies (id)
            ON DELETE CASCADE
);

-- Create interview_questions table
CREATE TABLE interview_questions
(
    id       BIGINT PRIMARY KEY DEFAULT nextval('interview_quest_seq'),
    question VARCHAR(500) NOT NULL,
    answer   TEXT         NOT NULL,
    topic_id BIGINT       NOT NULL,
    CONSTRAINT fk_interview_questions_topic FOREIGN KEY (topic_id) REFERENCES topics (topic_id) ON DELETE CASCADE
);

-- Create user_questions table with composite primary key
CREATE TABLE user_questions
(
    user_id          BIGINT NOT NULL,
    question_id      BIGINT NOT NULL,
    is_correct       BOOLEAN DEFAULT FALSE,
    confidence_level TEXT CHECK (confidence_level IN ('UNFAMILIAR', 'LOW', 'MEDIUM', 'ENOUGH', 'HIGH')),
    PRIMARY KEY (user_id, question_id),
    CONSTRAINT fk_user_questions_user FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE,
    CONSTRAINT fk_user_questions_question FOREIGN KEY (question_id) REFERENCES interview_questions (id) ON DELETE CASCADE
);

-- Ensure the sequence is owned by the topics.topic_id column
ALTER SEQUENCE topic_seq OWNED BY topics.topic_id;

-- Ensure the sequence is owned by the users.user_id column
ALTER SEQUENCE user_seq OWNED BY users.user_id;

-- Ensure the sequence is owned by the interview_questions.id column
ALTER SEQUENCE interview_quest_seq OWNED BY interview_questions.id;

ALTER SEQUENCE technology_seq OWNED BY technologies.id;
