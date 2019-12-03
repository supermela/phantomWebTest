package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {
	public static WebDriver driver;

	@Given("^launch Phantom url$")
	public void launch_Phantom_url() {
		System.setProperty("webdriver.chrome.driver", "C:/Program Files/chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://phantom.land/work/");

		driver.manage().window().maximize();

	}

	@Then("^click on Market Finder$")
	public void click_on_Market_Finder() {

		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,250)", "");

		WebElement marketFinder = driver.findElement(By.xpath("//span[contains(text(),'MARKET FINDER')]"));
		marketFinder.click();
	}

	@Then("^click on Launch$")
	public void click_on_Launch() throws InterruptedException {

		Thread.sleep(2000);

		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,200)", "");

		WebElement launchLink = driver.findElement(By.xpath("//a[@class='info has-link-hover-effect']"));
		launchLink.click();

	}

	@Then("^click on About$")
	public void click_on_About() {

		String phantomTab = driver.getWindowHandle();
		driver.switchTo().window(phantomTab);

		WebElement about = driver.findElement(By.xpath("//a[@class='nav_about']"));
		about.click();

	}

	@When("^click on view open positions$")
	public void click_on_view_open_positions() throws InterruptedException {

		Thread.sleep(2000);

		WebElement openPositions = driver
				.findElement(By.xpath("/html/body/app-root/div/app-about/div/main/div/section[9]/div/p[2]/a"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", openPositions);

		Thread.sleep(2000);

		openPositions.click();
	}

	@When("^click on junior QA$")
	public void click_on_junior_QA() {

		WebDriverWait wait = new WebDriverWait(driver, 50);
		WebElement jrQAbutton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Junior QA')]")));
		jrQAbutton.click();
	}

	@When("^click Submit$")
	public void click_Submit() throws InterruptedException {

		Thread.sleep(2000);

		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,1000)", "");

		WebElement submit = driver.findElement(By.xpath("//button[@class='submit-button slime-single-rect invert']"));
		submit.click();

	}

	@Then("^fill the required fields$")
	public void fill_the_required_fields() {

		WebElement name = driver.findElement(By.name("name"));
		name.sendKeys("Melania Manzone");

		WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
		email.sendKeys("melania.manzone@gmail.com");

		WebElement phone = driver.findElement(By.xpath("//input[@name='phone']"));
		phone.sendKeys("07447790911");

	}

	@When("^click on contact$")
	public void click_on_contact() {

		WebElement contact = driver.findElement(By.xpath("//a[@class='nav_contact']"));
		contact.click();

	}

	@Then("^click on home$")
	public void click_on_home() {

		WebElement home = driver.findElement(By.xpath("//a[@class='main_logo invert']"));
		home.click();
	}

	@Then("^quit the browser$")
	public void quit_the_browser() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

}