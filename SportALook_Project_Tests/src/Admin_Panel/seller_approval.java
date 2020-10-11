package Admin_Panel;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class seller_approval {
public static void takeScreenshot(String fileName) throws IOException {
		
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file,new File("C:\\Users\\USER\\eclipse-workspace\\CStech_Projects\\SportALook_Project_Tests\\"+
		"src\\Seller_Panel\\screenShots"+fileName+".jpg"));
	}
	
	 public static WebDriver driver;
		@BeforeClass
		public void setUp() {
		String browser="Chrome";
		if(browser.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browser.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
		}
		}
	
	@Test
	public void testAdminApproval() throws InterruptedException, IOException {
		
		driver.get("http://siteadminsportalook.cstechns.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.name("txtLogin")).sendKeys("sportalook@cstech.in");
		driver.findElement(By.name("txtPassword")).sendKeys("45824582");
		takeScreenshot("admin-page");
		
		driver.findElement(By.name("btnSubmit")).click();
	WebElement element =	driver.findElement(By.id("liSales_parent"));
	Actions action= new Actions(driver);
	action.moveToElement(element).build().perform();
	takeScreenshot("Sales");
	driver.findElement(By.linkText("Sellers")).click();
	takeScreenshot("Sellers");
	
	List<WebElement> Edit = driver.findElements(By.xpath("//i[@title='Edit']"));
	for(int i=0;i<Edit.size();i++){

		System.out.println(Edit.get(i));

		}
	Edit.get(0).click();
	driver.findElement(By.name("txtslaconfrmperiod")).clear();
	driver.findElement(By.name("txtslaconfrmperiod")).sendKeys("12");
	driver.findElement(By.name("txtslashipperiod")).clear();
	driver.findElement(By.name("txtslashipperiod")).sendKeys("24");
	driver.findElement(By.id("rbtLstActive_0")).click();
	Thread.sleep(1000);
	takeScreenshot("SLA");
		driver.findElement(By.linkText("Submit")).click();
		Thread.sleep(5000);
		WebElement CommissionAssign =driver.findElement(By.xpath("//a[@id='btnEdit39']//img[@title='Edit']"));
		Actions action1=new Actions(driver);
		action1.moveToElement(CommissionAssign).click().build().perform();
		takeScreenshot("Cat-Commission");
		Thread.sleep(2000);
		driver.findElement(By.id("39txtCommissionRate")).clear();
		driver.findElement(By.id("39txtCommissionRate")).sendKeys("20.00");
		takeScreenshot("Comm-Set");
	
		WebElement Update=driver.findElement(By.xpath("//a[@id='btnUpdate39']//img[@title='Update']"));
		try {
			Actions action3=new Actions(driver);
			action3.moveToElement(Update).click().build().perform();
			takeScreenshot("Comm-Update");
		} catch (UnhandledAlertException f) {
		    try {
		        Alert alert = driver.switchTo().alert();
		        String alertText = alert.getText();
		        System.out.println("Alert data: " + alertText);
		        alert.accept();
		    } catch (NoAlertPresentException e) {
		        e.printStackTrace();
		    }
		}	
		Thread.sleep(2000);
		driver.findElement(By.linkText("Logout")).click();
	}
	
@AfterClass()
public void tearDown() throws InterruptedException {
	driver.close();
	driver.quit();
	
}


}
