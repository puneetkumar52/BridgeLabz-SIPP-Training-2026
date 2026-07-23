-- Que 1. Create COVID Database Schema
-- Query:
CREATE DATABASE covid_db;
USE covid_db;

-- Table for cases According to question
CREATE TABLE covid_cases (
    Country VARCHAR(100),
    Date DATE,
    Confirmed_Cases INT,
    Deaths INT,
    Recoveries INT,
    Population BIGINT
);

-- Table for deaths According to question
CREATE TABLE covid_deaths (
    Country VARCHAR(100),
    Date DATE,
    Deaths INT,
    Population BIGINT
);

-- Table for vaccines According to question
CREATE TABLE covid_vaccines (
    Country VARCHAR(100),
    Date DATE,
    Vaccinated_People INT,
    Population BIGINT
);

-- Que2. Insert Initial COVID Data
-- Query:
-- India Data Inserted
INSERT INTO covid_cases (Country, Date, Confirmed_Cases, Deaths, Recoveries, Population)
VALUES 
('India', '2020-03-15', 100, 2, 5, 1380000000),
('India', '2020-03-20', 150, 3, 10, 1380000000);

-- USA Data Inserted
INSERT INTO covid_cases (Country, Date, Confirmed_Cases, Deaths, Recoveries, Population)
VALUES 
('USA', '2020-03-15', 200, 5, 20, 331000000),
('USA', '2020-03-20', 300, 10, 50, 331000000);

-- UK Data Inserted
INSERT INTO covid_cases (Country, Date, Confirmed_Cases, Deaths, Recoveries, Population)
VALUES 
('UK', '2020-03-15', 80, 1, 2, 67000000),
('UK', '2020-03-20', 120, 2, 5, 67000000);

-- Que 3. Update Case Information
-- Query:
UPDATE covid_cases
SET Confirmed_Cases = 160
WHERE Country = 'India' AND Date = '2020-03-20';

-- Que 4. Delete Incorrect Records
-- Query: 
-- Example: Delete incorrect country code from table
DELETE FROM covid_cases
WHERE Country = 'IN';

-- Example: Remove duplicate records from table
DELETE FROM covid_cases
WHERE Country = 'India' AND Date = '2020-03-15'
AND Confirmed_Cases = 100
AND Deaths = 2
AND Recoveries = 5;

-- Que 5. Alter Table to Add Vaccination Information
-- Query:
ALTER TABLE covid_cases
ADD COLUMN vaccination_rate DECIMAL(5,2);
