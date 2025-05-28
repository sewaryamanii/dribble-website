package DribbleWebsite.DribbleWebsite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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

	@Test(priority = 2, enabled = true)
// we have to scroll so that we can click on filters button since the test can't reach it if we don't 
	public void Filters() throws InterruptedException, SQLException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
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

		// Time frame

		js.executeScript("window.scrollTo(400,500)");
		Thread.sleep(3000);

		WebElement dropdown = driver.findElements(By.cssSelector(".form-btn.outlined.btn-dropdown-link")).get(1);
		dropdown.click();

		String value = options[randomoptions];
		WebElement targetOption = driver
				.findElement(By.cssSelector(".btn-dropdown-options.sets-querystring li[data-value='" + value + "'] a"));
		targetOption.click();

	}

}