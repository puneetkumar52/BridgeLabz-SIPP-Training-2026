-- Use Case 1: Find Highest Confirmed Cases using INNER JOIN
SELECT c.Country_Name, cc.Confirmed_Cases
FROM covid_cases cc
INNER JOIN countries c ON cc.Country_Code = c.Country_Code
WHERE cc.Date = '2020-03-20'
ORDER BY cc.Confirmed_Cases DESC
LIMIT 1;

-- Use Case 2: Join COVID Deaths and Vaccination Data (LEFT JOIN)
SELECT d.Country_Code, d.Date, d.Deaths, v.Vaccinated_People
FROM covid_deaths d
LEFT JOIN covid_vaccines v
ON d.Country_Code = v.Country_Code AND d.Date = v.Date;

-- Use Case 3: Analyze Deaths by Continent (INNER JOIN + GROUP BY)
SELECT ct.Continent_Name, SUM(cc.Deaths) AS Total_Deaths
FROM covid_cases cc
INNER JOIN countries c ON cc.Country_Code = c.Country_Code
INNER JOIN continents ct ON c.Continent_Code = ct.Continent_Code
GROUP BY ct.Continent_Name;

-- Use Case 4: Calculate Average New Deaths Per Day (AVG + ORDER BY)
SELECT Date, AVG(Deaths) AS Avg_Deaths
FROM covid_cases
GROUP BY Date
ORDER BY Date;

-- Use Case 5: Find Countries with Highest Infection Rates
SELECT c.Country_Name,
       (SUM(cc.Confirmed_Cases) * 100.0 / c.Population) AS Infection_Rate
FROM covid_cases cc
INNER JOIN countries c ON cc.Country_Code = c.Country_Code
GROUP BY c.Country_Name, c.Population
ORDER BY Infection_Rate DESC;
