package Admin_Panel;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PromotionDisc {

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
	public void testPromoDiscount() throws InterruptedException, IOException {
		
		driver.get("http://siteadminsportalook.cstechns.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.name("txtLogin")).sendKeys("sportalook@cstech.in");
		driver.findElement(By.name("txtPassword")).sendKeys("45824582");
		
		driver.findElement(By.name("btnSubmit")).click();
		
		WebElement element =	driver.findElement(By.id("liSales_parent"));
		Actions action= new Actions(driver);
		action.moveToElement(element).build().perform();
		takeScreenshot("Promo");
		driver.findElement(By.linkText("Promotions")).click();
		takeScreenshot("Promo1");
		driver.findElement(By.id("AccjA")).click();
		driver.findElement(By.id("chk_slab")).click();
		
		driver.findElement(By.id("txt_datefrom")).click();
		driver.findElement(By.linkText("1")).click();
		
		driver.findElement(By.id("txt_dateto")).click();
		driver.findElement(By.linkText("20")).click();
		
		driver.findElement(By.id("txt_amount")).sendKeys("2000");
		driver.findElement(By.xpath("//input[@value='Flat']")).click();
		
		driver.findElement(By.id("txt_discount")).sendKeys("300");
		takeScreenshot("Promo300");
		Thread.sleep(2000);
		driver.findElement(By.linkText("Submit")).click();
		try {
		driver.findElement(By.linkText("Finish")).click();
		Thread.sleep(2000);
		}
		catch(Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
	@AfterClass
	public void tearDown() throws InterruptedException { 
		driver.findElement(By.xpath("//a[@href='logout.aspx']")).click();
		Thread.sleep(2000);
		driver.close();
	}

}
