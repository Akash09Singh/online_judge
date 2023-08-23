CREATE DATABASE  IF NOT EXISTS `online_judge`;
USE online_judge;
CREATE TABLE User (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

-- Create the Contest table
CREATE TABLE Contest (
    contest_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    end_time DATETIME NOT NULL
);

-- Create the Problem table
CREATE TABLE Problem (
    problem_id INT AUTO_INCREMENT PRIMARY KEY,
    contest_id INT NOT NULL,
    title VARCHAR(255) NOT NULL,
    FOREIGN KEY (contest_id) REFERENCES Contest(contest_id)
);

-- Create the Testcase table
CREATE TABLE Testcase (
    testcase_id INT AUTO_INCREMENT PRIMARY KEY,
    problem_id INT NOT NULL,
    input TEXT NOT NULL,
    expected_output TEXT NOT NULL,
    FOREIGN KEY (problem_id) REFERENCES Problem(problem_id)
);

-- Create the Submission table
CREATE TABLE Submission (
    submission_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    problem_id INT NOT NULL,
    code TEXT NOT NULL,
    status VARCHAR(50) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES User(user_id),
    FOREIGN KEY (problem_id) REFERENCES Problem(problem_id)
);

-- Create the ContestCompletion table
CREATE TABLE ContestCompletion (
    completion_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    contest_id INT NOT NULL,
    time_taken INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES User(user_id),
    FOREIGN KEY (contest_id) REFERENCES Contest(contest_id)
);