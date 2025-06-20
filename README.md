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

🗂 Project Structure
bash
Copy code
DribbleWebsite.DribbleWebsite
├── AppTest.java          # Main test class containing test cases
├── TestData.java         # Contains test data, helpers (not shown here)
└── src/test/ScreenShot/  # Directory where screenshots are saved
🚀 Features / Test Cases
Test Name	Description
SignUp	Automates user sign-up with data fetched from MySQL DB.
Filters	Applies random color filters and dropdown filters on shots.
TypeInSearch	Searches for terms using the Dribbble search bar.
TypeInSearchGibberish	Searches gibberish to test no-results scenarios & screenshots.
PopularButton	Selects popular filters from dropdown.
LoginN	Automates login using email/username.
SaveElementWithoutLogIn	Attempts to save a shot without logging in, captures screenshot.
socialmedealiks	Clicks social media icon (Pinterest) and takes screenshot.
TapOnRandomBlog	Navigates and clicks a random blog post.
Support	Searches and opens an article in Dribbble support, screenshots.

