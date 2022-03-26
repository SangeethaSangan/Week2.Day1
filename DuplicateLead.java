package seliniumtestcode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");

		/// maximize browser
		driver.manage().window().maximize();

		/// identify User name and enter value

		driver.findElement(By.id("username")).sendKeys("DemoCSR");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TEstLeaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Sangeetha");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Sangeetha");

		WebElement element = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select dd = new Select(element);
		dd.selectByVisibleText("Employee");

		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("test1");
		driver.findElement(By.id("createLeadForm_lastNameLocal")).sendKeys("test2");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("TestDep");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("type description");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("sanga.gg@gmail.com");

		WebElement ele = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select dd1 = new Select(ele);
		dd1.selectByVisibleText("New York");
		driver.findElement(By.className("smallSubmit")).click();
		String Title = driver.getTitle();
		System.out.println(Title);
		driver.findElement(By.linkText("Duplicate Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).clear();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("new comp");
		driver.findElement(By.id("createLeadForm_firstName")).clear();
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("new name");
		driver.findElement(By.name("submitButton")).click();

		String Title1 = driver.getTitle();
		System.out.println(Title1);

		driver.close();
	}

}
