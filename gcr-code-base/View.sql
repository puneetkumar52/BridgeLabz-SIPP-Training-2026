-- Use Case 21: Create View for Latest COVID Data
CREATE VIEW LatestCovidData AS
SELECT c.Country_Name,
       cc.Date,
       cc.Confirmed_Cases,
       cc.Deaths,
       cc.Recoveries
FROM covid_cases cc
INNER JOIN countries c ON cc.Country_Code = c.Country_Code
WHERE cc.Date = (
    SELECT MAX(Date) 
    FROM covid_cases cc2 
    WHERE cc2.Country_Code = cc.Country_Code
);

-- Use Case 22: Build Mortality Rate Function
CREATE FUNCTION CalculateMortalityRate(
    countryCode CHAR(3),
    reportDate DATE
)
RETURNS DECIMAL(5,2)
DETERMINISTIC
BEGIN
    DECLARE deaths INT;
    DECLARE confirmed INT;
    SELECT Deaths, Confirmed_Cases
    INTO deaths, confirmed
    FROM covid_cases
    WHERE Country_Code = countryCode AND Date = reportDate;

    RETURN (deaths * 100.0 / confirmed);
END;

-- Use Case 23: Create Stored Procedure for Data Updates
CREATE PROCEDURE UpdateCovidStats(
    IN countryCode CHAR(3),
    IN reportDate DATE,
    IN newConfirmed INT,
    IN newDeaths INT,
    IN newRecoveries INT
)
BEGIN
    UPDATE covid_cases
    SET Confirmed_Cases = newConfirmed,
        Deaths = newDeaths,
        Recoveries = newRecoveries,
        Last_Updated = CURRENT_TIMESTAMP
    WHERE Country_Code = countryCode AND Date = reportDate;
END;

-- Use Case 24: Implement Recovery Rate Function
CREATE FUNCTION CalculateRecoveryRate(
    countryCode CHAR(3),
    reportDate DATE
)
RETURNS DECIMAL(5,2)
DETERMINISTIC
BEGIN
    DECLARE recovered INT;
    DECLARE confirmed INT;
    SELECT Recoveries, Confirmed_Cases
    INTO recovered, confirmed
    FROM covid_cases
    WHERE Country_Code = countryCode AND Date = reportDate;

    RETURN (recovered * 100.0 / confirmed);
END;

-- Use Case 25: Create Audit Trigger for Data Changes
-- Audit table to store history
CREATE TABLE covid_audit (
    Audit_ID INT AUTO_INCREMENT PRIMARY KEY,
    Country_Code CHAR(3),
    Date DATE,
    Old_Confirmed INT,
    New_Confirmed INT,
    Old_Deaths INT,
    New_Deaths INT,
    Old_Recoveries INT,
    New_Recoveries INT,
    Change_Timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Trigger to log changes
CREATE TRIGGER CovidCases_Audit
AFTER UPDATE ON covid_cases
FOR EACH ROW
BEGIN
    INSERT INTO covid_audit (
        Country_Code, Date,
        Old_Confirmed, New_Confirmed,
        Old_Deaths, New_Deaths,
        Old_Recoveries, New_Recoveries
    )
    VALUES (
        OLD.Country_Code, OLD.Date,
        OLD.Confirmed_Cases, NEW.Confirmed_Cases,
        OLD.Deaths, NEW.Deaths,
        OLD.Recoveries, NEW.Recoveries
    );
END;
