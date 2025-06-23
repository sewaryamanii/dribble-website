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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.File; // For File
import java.io.IOException;

import org.apache.commons.io.FileUtils; // For FileUtils

public class AppTest extends TestData {
	WebDriver driver  ;
	JavascriptExecutor js;

	Connection con;
	Statement stmt;
	ResultSet rs;

	String FullName;
	String UserName;
	String Email;
	String Password;
	String ColorCode;
	String mydate = new Date().toString().replace(":", "-");

	@BeforeMethod
	public void projectsetup() throws SQLException {
		 driver = new ChromeDriver();
		 js = (JavascriptExecutor) driver;

		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/finalproject", "root", "1234");

		driver.get("https://dribbble.com");
	}

//	@Test(priority = 1, enabled = false)
//	// I have added randomization method to select random user from our data base
//	public void SignUp() throws SQLException, InterruptedException {
//		driver.findElement(By.cssSelector(".site-nav__signup.site-nav-hide-mobile")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.cssSelector(".btn2.btn2--large.btn2--tertiary.btn2--full-width.margin-b-40")).click();
//		String query = "SELECT * FROM Users WHERE ID = '" + randomuser + "';";
//		stmt = con.createStatement();
//		rs = stmt.executeQuery(query);
//		while (rs.next()) {
//			FullName = rs.getString("Name");
//			System.out.println(FullName);
//		}
//		rs = stmt.executeQuery(query);
//		while (rs.next()) {
//			UserName = rs.getString("Username");
//			System.out.println(UserName);
//		}
//		rs = stmt.executeQuery(query);
//		while (rs.next()) {
//			Email = rs.getString("Email");
//			System.out.println(Email);
//		}
//		rs = stmt.executeQuery(query);
//		while (rs.next()) {
//			Password = rs.getString("Password");
//			System.out.println(Password);
//		}
//		driver.findElement(By.id("user_name")).sendKeys(FullName);
//		driver.findElement(By.id("user_login")).sendKeys(UserName);
//		driver.findElement(By.id("user_email")).sendKeys(Email);
//		driver.findElement(By.id("user_password")).sendKeys(Password);
//		driver.findElement(By.id("user_agree_to_terms")).click();
//		driver.findElement(By.cssSelector(".btn2.btn2--large.btn2--full-width.margin-t-20")).click();
//
//	}

	@Test(priority = 1, enabled = false)
// we have to scroll so that we can click on filters button since the test can't reach it if we don't 
	public void Filters() throws InterruptedException, SQLException, IOException {
		js.executeScript("window.scrollTo(0,400)");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".form-btn.outlined.tertiary.filters-toggle-btn.empty")).click();
		// Color
		String query = "SELECT * FROM Color WHERE ID = '" + randomcolor + "';";
		stmt = con.createStatement();
		rs = stmt.executeQuery(query);
		while (rs.next()) {
			ColorCode = rs.getString("HexCode");
			System.out.println(ColorCode);}
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
		js.executeScript("window.scrollTo(400,500)");
		Thread.sleep(3000);
// Time Frame
		WebElement dropdown = driver.findElement(By.xpath("//a[@class='form-btn outlined btn-dropdown-link']"));
		dropdown.click();
Thread.sleep(1000);
js.executeScript("window.scrollTo(0,500)");
		String value = options[randomoptions];
		WebElement targetOption = driver
				.findElement(By.xpath("//a[normalize-space()='" + value + "']"));
		targetOption.click();           
	}



	@Test(priority = 2, enabled = false)
	public void TypeInSearch() throws InterruptedException {
		WebElement searchbar = driver.findElement(By.id("autocomplete-1-input"));
		Thread.sleep(3000);
		searchbar.sendKeys("Test Cases");
		searchbar.sendKeys(Keys.chord(Keys.ENTER));
		Thread.sleep(3000);
	

	}

	@Test(priority = 3, enabled = false)
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
		js.executeScript("window.scrollTo(0,400)");


	}



	@Test(priority = 4, enabled = false)
	public void PopularButton() throws InterruptedException {
		js.executeScript("window.scrollTo(0,400)");

		Thread.sleep(3000);
		WebElement dropdown = driver
				.findElement(By.cssSelector(".form-btn.outlined.btn-dropdown-link.btn-dropdown-link--small"));
		dropdown.click();
		String value = popularbutton[randomselect];
		WebElement targetOption = driver
				.findElement(By.cssSelector(".btn-dropdown-options a[data-track-view='" + value + "']"));
		targetOption.click();

	}




	@Test(priority = 5, enabled = true)
	public void Tags() throws InterruptedException, IOException {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
driver.findElement(By.cssSelector("button[aria-label='close']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Tags']")).click();
		js.executeScript("window.scrollTo(0,250)");

driver.findElement(By.xpath("//img[@alt='UI']")).click();


TakesScreenshot scrShot = ((TakesScreenshot) driver);
File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

File DestFile = new File("src/test/ScreenShot/" + mydate + ".jpg");
FileUtils.copyFile(SrcFile, DestFile);
	}

	@Test(priority = 6, enabled = false)
	public void SaveElementWithoutLogIn() throws InterruptedException, IOException {
		driver.findElement(By.cssSelector(".shot-thumbnail-link.dribbble-link.js-shot-link")).click();
		Thread.sleep(1500);
		driver.findElement(By.cssSelector(".bucket-shot.btn2.btn2--circle.btn2--tertiary")).click();
		Thread.sleep(1000);

		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		File DestFile = new File("src/test/ScreenShot/" + mydate + ".jpg");
		FileUtils.copyFile(SrcFile, DestFile);
	}

	@Test(priority = 7, enabled = false)
	public void socialmedialinks() throws InterruptedException, IOException {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@href='http://www.pinterest.com/dribbble/']//*[name()='svg']")).click();

		Thread.sleep(1000);

		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		File DestFile = new File("src/test/ScreenShot/" + mydate + ".jpg");
		FileUtils.copyFile(SrcFile, DestFile);
	}

	@Test(priority = 8, enabled = false)
	public void TapOnRandomBlog() throws InterruptedException {

		driver.findElement(By.cssSelector("button[aria-label='Toggle mobile menu']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@class='site-nav-main__link'][normalize-space()='Blog']")).click();
		Thread.sleep(1000);

		js.executeScript("window.scrollTo(0,800)");

		driver.findElement(By.cssSelector(".post.group")).click();

	}

	@Test(priority = 9, enabled = false)
	public void Support () throws InterruptedException, IOException {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

	 driver.findElement(By.xpath("//a[normalize-space()='Support']")).click();
	WebElement supportsearch = driver.findElement(By.id("search-input"));
				
	supportsearch.sendKeys("How to Create a New Service");
	supportsearch.sendKeys(Keys.chord(Keys.ENTER));
		
	driver.findElement(By.cssSelector(".article__preview.intercom-force-break")).click();
	Thread.sleep(1000);
	js.executeScript("window.scrollTo(0,500)");
	TakesScreenshot scrShot = ((TakesScreenshot) driver);
	File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

	File DestFile = new File("src/test/ScreenShot/" + mydate + ".jpg");
	FileUtils.copyFile(SrcFile, DestFile);
	
	}
	
	@Test (priority = 10 , enabled = false)
	public void FooterLinks () throws IOException, InterruptedException {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
driver.findElement(By.xpath("//a[normalize-space()='For designers']")).click();
Thread.sleep(1000);
TakesScreenshot scrShot = ((TakesScreenshot) driver);
File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
File DestFile = new File("src/test/ScreenShot/" + mydate + ".jpg");
FileUtils.copyFile(SrcFile, DestFile);

driver.findElement(By.xpath("//a[@aria-label='Back to home page']//*[name()='svg']")).click();

js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
driver.findElement(By.xpath("//a[normalize-space()='Hire talent']")).click();	
Thread.sleep(1000);
TakesScreenshot scrShot1 = ((TakesScreenshot) driver);
File SrcFile1 = scrShot1.getScreenshotAs(OutputType.FILE);
File DestFile1 = new File("src/test/ScreenShot/" + mydate + ".jpg");
FileUtils.copyFile(SrcFile1, DestFile1);	
		
driver.findElement(By.xpath("//a[@aria-label='Back to home page']//*[name()='svg']")).click();

js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
driver.findElement(By.xpath("//a[normalize-space()='About']")).click();
TakesScreenshot scrShot2 = ((TakesScreenshot) driver);
File SrcFile2 = scrShot2.getScreenshotAs(OutputType.FILE);
File DestFile2 = new File("src/test/ScreenShot/" + mydate + ".jpg");
FileUtils.copyFile(SrcFile2, DestFile2);
		
	}
	@AfterMethod 
	public void aftertest () {
		
		driver.close();
	}
}
