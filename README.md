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
Test Cases Overview
-SignUp	Signs up using random user data from DB
-Filtersinlogoutmode	Applies color filter while logged out
-TimeframeFilter	Selects a timeframe from a dropdown
-TypeInSearch    Tests search with valid input
-TypeInSearchGibberish    Tests search with invalid input + screenshot
-FiltersBar	Clicks through filter arrows
-PopularButton    Randomly selects from 'Popular' or 'New & Noteworthy'
-LoginP	Logs in using hardcoded user data + screenshot
-LoginN	Logs in using random user from DB
-Filtersinloginmode	Applies search filters while logged in
