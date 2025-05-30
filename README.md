This project automates several test cases on the [Dribbble](https://dribbble.com) website using Selenium WebDriver, TestNG, and Java. It also integrates with a MySQL database to fetch dynamic test data such as user credentials and color filters.
---
## 🔧 Technologies Used
- Java
- Selenium WebDriver
- TestNG
- MySQL (JDBC)
- Apache Commons IO (for screenshot handling)
- Maven (project structure)
- ChromeDriver
---
## 🧪 Test Cases Overview

- **SignUp**  
  Automates user registration using random user data fetched from a MySQL database.

- **Filtersinlogoutmode**  
  Applies a color filter on the homepage while logged out, then takes a screenshot of the results.

- **TimeframeFilter**  
  Selects a random timeframe filter from a dropdown menu (e.g., Past Week, Past Month).

- **TypeInSearch**  
  Tests search functionality by entering valid keywords and then clearing/changing the input.

- **TypeInSearchGibberish**  
  Enters gibberish in the search bar to trigger a "No results found" message, then captures a screenshot.

- **FiltersBar**  
  Navigates through filter bar arrows to explore additional filter options.

- **PopularButton**  
  Randomly selects either "Popular" or "New & Noteworthy" from a dropdown filter and applies it.

- **LoginP**  
  Logs in with hardcoded user credentials and takes a screenshot after successful login.

- **LoginN**  
  Logs in using a randomly selected user from the database (no password verification).

- **Filtersinloginmode**  
  Performs a search and applies filters while logged in, followed by a screenshot capture.
