CREATE DATABASE  IF NOT EXISTS `spoj`;
USE spoj;
CREATE TABLE user (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

-- Create the Contest table
CREATE TABLE contest (
    contest_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    end_time TIME NOT NULL
);

-- Create the Problem table
CREATE TABLE problem (
    problem_id INT AUTO_INCREMENT PRIMARY KEY,
    contest_id INT NOT NULL,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    example1_input varchar(500),
    example1_output varchar(500),
    example2_input varchar(500),
    example2_output varchar(500),
    FOREIGN KEY (contest_id) REFERENCES Contest(contest_id)
);

-- Create the Testcase table
CREATE TABLE test_case (
    testcase_id INT AUTO_INCREMENT PRIMARY KEY,
    problem_id INT NOT NULL,
    input TEXT NOT NULL,
    expected_output TEXT NOT NULL,
    FOREIGN KEY (problem_id) REFERENCES Problem(problem_id)
);

-- Create the Submission table
CREATE TABLE submission (
    submission_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    problem_id INT NOT NULL,
    code TEXT NOT NULL,
    status VARCHAR(50) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES User(user_id),
    FOREIGN KEY (problem_id) REFERENCES Problem(problem_id)
);

-- Create the ContestCompletion table
CREATE TABLE contest_completion (
    completion_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    contest_id INT NOT NULL,
    time_taken INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES User(user_id),
    FOREIGN KEY (contest_id) REFERENCES Contest(contest_id)
);