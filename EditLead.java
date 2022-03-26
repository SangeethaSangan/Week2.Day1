package seliniumtestcode;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.findElement(By.id("username")).sendKeys("DemoCSR");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		WebElement CompanyName = driver.findElement(By.id("createLeadForm_companyName"));
		CompanyName.sendKeys("TestLeaf");
		String attribute = CompanyName.getAttribute("value");
		System.out.println(attribute);
		WebElement firstName = driver.findElement(By.id("createLeadForm_firstName"));
		firstName.sendKeys("Sangeetha");
		String fn = firstName.getAttribute("value");
		System.out.println(fn);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("SSLt");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("SSLocal");
		driver.findElement(By.id("createLeadForm_lastNameLocal")).sendKeys("SSLocalast");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("TEstDep");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Description entered");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("s@gmail.com");

		WebElement element = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));

		Select dd = new Select(element);
		dd.selectByVisibleText("New York");
		List<WebElement> options = dd.getOptions();
		int size = dd.getOptions().size();
		System.out.println(size);
		/*
		 * WebElement selected=dd.getFirstSelectedOption();
		 * System.out.println(selected);
		 */
		driver.findElement(By.className("smallSubmit")).click();

		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_description")).clear();
		driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("updating Notes");
		driver.findElement(By.name("submitButton")).click();

		String Title = driver.getTitle();
		System.out.println(Title);

	}

}
