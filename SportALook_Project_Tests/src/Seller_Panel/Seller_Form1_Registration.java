package Seller_Panel;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Seller_Form1_Registration {
	
	
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
	public void testSellerForm1Registration() throws InterruptedException, IOException {
		
	
	 driver.get("http://sportalook.cstechns.com/");
	 String main=driver.getWindowHandle();
	 takeScreenshot("SportALook_Home");
	
	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
		
		driver.findElement(By.linkText("Sell On SportALook")).click();
		Thread.sleep(2000);
		takeScreenshot("Register");
		String s=driver.getTitle();
		System.out.println("Page Title is"+s);
		 
		driver.get("http://sellersportalook.cstechns.com/register");
		takeScreenshot("SportALook_Registration_Page");
		driver.switchTo().window(main);
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("right_txtname")).sendKeys("Proxy Seller");
		driver.findElement(By.id("right_txtemailid")).sendKeys("cstechseller@gmail.com");
		driver.findElement(By.id("right_txtpwd")).sendKeys("Xyz@1234");
		driver.findElement(By.id("right_txtcpwd")).sendKeys("Xyz@1234");
		driver.findElement(By.id("right_txtcontact")).sendKeys("09987654321");
		driver.findElement(By.id("Agree")).click();	
		driver.findElement(By.xpath("//input[@value='REGISTER']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='confirm']")).click();
		takeScreenshot("SportALook_Form1_Page");
		
		Thread.sleep(2000);

 driver.get("https://gmail.com/");
 driver.findElement(By.id("identifierId")).sendKeys("cstechseller@gmail.com"+Keys.ENTER);
 driver.findElement(By.name("password")).sendKeys("Xyz@1234"+Keys.ENTER);
 Thread.sleep(10000);

 takeScreenshot("SportALook_mail");
		
}
@AfterClass
public void tearDown() throws InterruptedException {

driver.close();

}	


}
