package DribbleWebsite.DribbleWebsite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.File; // For File
import java.io.IOException;

import org.apache.commons.io.FileUtils; // For FileUtils

public class AppTest extends TestData {

	WebDriver driver = new ChromeDriver();

	Connection con;
	Statement stmt;
	ResultSet rs;

	String FullName;
	String UserName;
	String Email;
	String Password;
	String ColorCode;
	String mydate = new Date().toString().replace(":", "-");
	JavascriptExecutor js = (JavascriptExecutor) driver;

	@BeforeTest
	public void projectsetup() throws SQLException {

		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/finalproject", "root", "1234");

		driver.get("https://dribbble.com");
	}

	@Test(priority = 1, enabled = false)
	// I have added randomization method to select random user from our data base
	public void SignUp() throws SQLException, InterruptedException {
		driver.findElement(By.cssSelector(".site-nav__signup.site-nav-hide-mobile")).click();
		;
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".btn2.btn2--large.btn2--tertiary.btn2--full-width.margin-b-40")).click();
		;

		String query = "SELECT * FROM Users WHERE ID = '" + randomuser + "';";
		stmt = con.createStatement();
		rs = stmt.executeQuery(query);
		while (rs.next()) {
			FullName = rs.getString("Name");
			System.out.println(FullName);
		}
		rs = stmt.executeQuery(query);

		while (rs.next()) {
			UserName = rs.getString("Username");
			System.out.println(UserName);
		}

		rs = stmt.executeQuery(query);
		while (rs.next()) {
			Email = rs.getString("Email");
			System.out.println(Email);
		}
		rs = stmt.executeQuery(query);

		while (rs.next()) {
			Password = rs.getString("Password");
			System.out.println(Password);
		}

		driver.findElement(By.id("user_name")).sendKeys(FullName);
		driver.findElement(By.id("user_login")).sendKeys(UserName);
		driver.findElement(By.id("user_email")).sendKeys(Email);
		driver.findElement(By.id("user_password")).sendKeys(Password);
		driver.findElement(By.id("user_agree_to_terms")).click();
		driver.findElement(By.cssSelector(".btn2.btn2--large.btn2--full-width.margin-t-20")).click();

	}

	@Test(priority = 2, enabled = false)
// we have to scroll so that we can click on filters button since the test can't reach it if we don't 
	public void Filtersinlogoutmode() throws InterruptedException, SQLException, IOException {

		js.executeScript("window.scrollTo(0,400)");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".form-btn.outlined.tertiary.filters-toggle-btn.empty")).click();

		// Color

		String query = "SELECT * FROM Color WHERE ID = '" + randomcolor + "';";
		stmt = con.createStatement();
		rs = stmt.executeQuery(query);
		while (rs.next()) {
			ColorCode = rs.getString("HexCode");
			System.out.println(ColorCode);
		}
		WebElement filtterbutton = driver.findElement(By.id("color"));
		filtterbutton.sendKeys(ColorCode);
		filtterbutton.sendKeys(Keys.chord(Keys.ENTER));
		Thread.sleep(3000);

		// take a screenshot for the results
		String mydate = new Date().toString().replace(":", "-");
		System.out.println(mydate);
		Thread.sleep(1000);
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File("src/test/ScreenShot/" + mydate + ".jpg");
		FileUtils.copyFile(SrcFile, DestFile);

	}

	@Test(priority = 3, enabled = false)
	public void TimeframeFilter() throws InterruptedException {

		js.executeScript("window.scrollTo(400,500)");
		Thread.sleep(3000);

		WebElement dropdown = driver.findElements(By.cssSelector(".form-btn.outlined.btn-dropdown-link")).get(1);
		dropdown.click();

		String value = options[randomoptions];
		WebElement targetOption = driver
				.findElement(By.cssSelector(".btn-dropdown-options.sets-querystring li[data-value='" + value + "'] a"));
		targetOption.click();
	}

	@Test(priority = 4, enabled = false)
	public void TypeInSearch() throws InterruptedException {
		WebElement searchbar = driver.findElement(By.id("autocomplete-1-input"));
		Thread.sleep(3000);
		searchbar.sendKeys("Test Cases");
		searchbar.sendKeys(Keys.chord(Keys.ENTER));
		Thread.sleep(3000);
		WebElement searchbar2 = driver.findElement(By.id("autocomplete-0-input"));
		searchbar2.clear();
		searchbar2.sendKeys("sewar");

	}

	@Test(priority = 5, enabled = false)
	public void TypeInSearchGibberish() throws InterruptedException, IOException {
		WebElement searchbar2 = driver.findElement(By.id("autocomplete-1-input"));
		searchbar2.click();
		searchbar2.sendKeys("betdgae");
		searchbar2.sendKeys(Keys.chord(Keys.ENTER));

		js.executeScript("window.scrollTo(0,400)");
		Thread.sleep(1000);
		// print No Results Found
		WebElement message = driver.findElement(By.xpath("//h3[text()='No results found']"));
		if (message.getText().equals("No results found")) {
			System.out.println("No results found.");
		}

		// take a screenshot after clicking search
		System.out.println(mydate);
		Thread.sleep(1000);
		TakesScreenshot scrShott = ((TakesScreenshot) driver);
		File SFile = scrShott.getScreenshotAs(OutputType.FILE);
		File DFile = new File("src/test/ScreenShot/" + mydate + ".jpg");
		FileUtils.copyFile(SFile, DFile);
	}

	@Test(priority = 6, enabled = false)
	public void FiltersBar() throws InterruptedException {
		js.executeScript("window.scrollTo(0,400)");
		Thread.sleep(2000);
		WebElement arrow = driver.findElement(By.linkText(">"));
		arrow.click();

	}

	@Test(priority = 7, enabled = true)
	public void PopularButton() throws InterruptedException {
		js.executeScript("window.scrollTo(0,400)");
		Thread.sleep(3000);

		WebElement dropdown = driver.findElement(
			    By.cssSelector(".form-btn.outlined.btn-dropdown-link.btn-dropdown-link--small")
			);
		dropdown.click();
		String value = popularbutton[randomselect];
		WebElement targetOption = driver.findElement(
			    By.cssSelector(".btn-dropdown-options a[data-track-view='" + value + "']")
			);

		targetOption.click();

		
		
		
	}

	@Test(priority = 8, enabled = false)
	public void LoginP() throws SQLException, InterruptedException, IOException {

		driver.findElement(By.cssSelector(".site-nav__login.btn2.btn2--medium")).click();
		String query = "SELECT * FROM Users WHERE ID = '2';";
		stmt = con.createStatement();
		rs = stmt.executeQuery(query);
		while (rs.next()) {
			UserName = rs.getString("Username");
			System.out.println(UserName);
		}
		rs = stmt.executeQuery(query);

		while (rs.next()) {
			Password = rs.getString("Password");
			System.out.println(Password);
		}

		WebElement Username = driver.findElement(By.id("login"));
		Username.sendKeys(UserName);

		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys(Password);
		driver.findElement(By.cssSelector(".btn2.btn2--large.btn2--full-width.margin-t-20")).click();

		System.out.println(mydate);

		Thread.sleep(1000);

		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		File DestFile = new File("src/test/ScreenShot/" + mydate + ".jpg");
		FileUtils.copyFile(SrcFile, DestFile);

	}

	@Test(priority = 9, enabled = false)
	public void LoginN() throws SQLException {
		driver.findElement(By.cssSelector(".site-nav__login.btn2.btn2--medium")).click();
		String query = "SELECT * FROM Users WHERE ID = '" + randomuser + "';";
		stmt = con.createStatement();
		rs = stmt.executeQuery(query);
		while (rs.next()) {
			UserName = rs.getString("Username");
			System.out.println(UserName);
		}
		rs = stmt.executeQuery(query);

		while (rs.next()) {
			Password = rs.getString("Password");
			System.out.println(Password);
		}
		WebElement Username = driver.findElement(By.id("login"));
		Username.sendKeys(UserName);
		driver.findElement(By.cssSelector(".btn2.btn2--large.btn2--full-width.margin-t-20")).click();

	}

	@Test(priority = 10, enabled = false)
	public void Filtersinloginmode() throws InterruptedException, IOException {
		WebElement searchbar = driver.findElement(By.id("autocomplete-1-input"));
		Thread.sleep(3000);
		searchbar.sendKeys("Test Cases");
		searchbar.sendKeys(Keys.chord(Keys.ENTER));
		Thread.sleep(3000);

		WebElement searchbar2 = driver.findElement(By.id("autocomplete-0-input"));
		driver.findElement(By.cssSelector("aa-ClearIcon")).click();
		searchbar2.sendKeys("betdgae");
		searchbar2.sendKeys(Keys.chord(Keys.ENTER));

		System.out.println(mydate);

		Thread.sleep(1000);

		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		File DestFile = new File("src/test/ScreenShot/" + mydate + ".jpg");
		FileUtils.copyFile(SrcFile, DestFile);

	}
}