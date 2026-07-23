-- Use Case 16: Find Countries with Above-Average Death Counts
SELECT c.Country_Name, SUM(cc.Deaths) AS Total_Deaths
FROM covid_cases cc
INNER JOIN countries c ON cc.Country_Code = c.Country_Code
GROUP BY c.Country_Name
HAVING SUM(cc.Deaths) > (
    SELECT AVG(total_deaths)
    FROM (
        SELECT SUM(Deaths) AS total_deaths
        FROM covid_cases
        GROUP BY Country_Code
    ) AS sub
);

-- Use Case 17: Identify Countries Exceeding Case Threshold
SELECT c.Country_Name
FROM countries c
WHERE c.Country_Code IN (
    SELECT Country_Code
    FROM covid_cases
    GROUP BY Country_Code
    HAVING MAX(Confirmed_Cases) > 1000000
);

-- Use Case 18: Track COVID Waves - State-wise Analysis (example for 'Mumbai')
SELECT Date, Confirmed_Cases
FROM covid_cases
WHERE Country_Code = 'IN' AND State = 'Mumbai'
AND Confirmed_Cases = (
    SELECT MAX(cc2.Confirmed_Cases)
    FROM covid_cases cc2
    WHERE cc2.Country_Code = 'IN'
      AND cc2.State = 'Mumbai'
      AND cc2.Date <= covid_cases.Date
);

-- Use Case 19: Compare Vaccination Coverage (Vaccinated vs Unvaccinated)
SELECT c.Country_Name, v.Vaccinated_People AS Population_Count, 'Vaccinated' AS Status
FROM covid_vaccines v
INNER JOIN countries c ON v.Country_Code = c.Country_Code
UNION
SELECT c.Country_Name, (c.Population - v.Vaccinated_People) AS Population_Count, 'Unvaccinated' AS Status
FROM covid_vaccines v
INNER JOIN countries c ON v.Country_Code = c.Country_Code;

-- Use Case 20: Find Countries Present in Deaths but Not Cases
SELECT DISTINCT d.Country_Code, c.Country_Name
FROM covid_deaths d
LEFT JOIN countries c ON d.Country_Code = c.Country_Code
WHERE d.Country_Code NOT IN (
    SELECT DISTINCT Country_Code
    FROM covid_cases
);
