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
1-SignUp	Signs up using random user data from DB
2-Filtersinlogoutmode	Applies color filter while logged out
3-TimeframeFilter	Selects a timeframe from a dropdown
4-TypeInSearch    Tests search with valid input
5-TypeInSearchGibberish    Tests search with invalid input + screenshot
6-FiltersBar	Clicks through filter arrows
7-PopularButton    Randomly selects from 'Popular' or 'New & Noteworthy'
8-LoginP	Logs in using hardcoded user data + screenshot
9-LoginN	Logs in using random user from DB
10-Filtersinloginmode	Applies search filters while logged in
