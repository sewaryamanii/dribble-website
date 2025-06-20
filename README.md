📌 Overview
This project automates test scenarios for the Dribbble website using Selenium WebDriver, TestNG, and Java. The automation includes user actions like sign-up, login, search, applying filters, interacting with blogs, social media links, and support pages.

⚙ Technologies Used
Java

Selenium WebDriver

TestNG

MySQL (for user & color data)

Maven

Apache Commons IO (for file handling & screenshots)

JDBC (for database connectivity)

🚀 Features / Test Cases


SignUp

Automates user sign-up using data fetched from the MySQL database.

Filters

Applies random color filters and dropdown filters to browse shots.

TypeInSearch

Performs search actions with terms using the Dribbble search bar.

TypeInSearchGibberish

Tests search with gibberish text to validate no-results handling and takes a screenshot.

PopularButton

Selects popular filters from the dropdown menu and verifies functionality.

LoginN

Automates the login process using email or username.

SaveElementWithoutLogIn

Attempts to save a shot without logging in and captures a screenshot of the result.

socialmedealiks

Clicks on a social media icon (Pinterest) and takes a screenshot of the opened page.

TapOnRandomBlog

Navigates to the blog section and clicks on a random blog post.

Support

Searches for a support article on Dribbble, opens it, scrolls, and captures a screenshot.
