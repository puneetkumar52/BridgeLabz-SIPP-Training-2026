-- Reference table for countries
CREATE TABLE countries (
    Country_Code CHAR(3) PRIMARY KEY,
    Country_Name VARCHAR(100) UNIQUE NOT NULL,
    Population BIGINT
);

-- COVID cases table with all constraints applied
CREATE TABLE covid_cases (
    Country_Code CHAR(3) NOT NULL,
    Date DATE NOT NULL,
    Confirmed_Cases INT NOT NULL,
    Deaths INT DEFAULT 0,
    Recoveries INT DEFAULT 0,
    Population BIGINT,
    Last_Updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    -- Composite Primary Key (Use Case 1)
    PRIMARY KEY (Country_Code, Date),

    -- Foreign Key to countries table (Use Case 2)
    FOREIGN KEY (Country_Code) REFERENCES countries(Country_Code),

    -- Check constraint (Use Case 3)
    CONSTRAINT chk_deaths CHECK (Deaths <= Confirmed_Cases),

    -- Unique constraint to prevent duplicate country-date entries (Use Case 5)
    CONSTRAINT unique_country_date UNIQUE (Country_Code, Date)
);
