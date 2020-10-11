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

public class Rej_Resub_Reappr {
	
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
	public void testRej_ReSub_ReApppr() throws InterruptedException, IOException {
		
	driver.get("http://siteadminsportalook.cstechns.com/");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	driver.manage().deleteAllCookies();
		driver.findElement(By.name("txtLogin")).sendKeys("sportalook@cstech.in");
		driver.findElement(By.name("txtPassword")).sendKeys("45824582");
		driver.findElement(By.name("btnSubmit")).click();
		
		WebElement element =	driver.findElement(By.id("liCatalog"));
		Actions action= new Actions(driver);
		action.moveToElement(element).build().perform();
		takeScreenshot("Master");
		driver.findElement(By.linkText("Product's List")).click();
		takeScreenshot("Product-List");

////2nd product Admin Rejection		
			Thread.sleep(1000);		
			List<WebElement> Reject = driver.findElements(By.xpath("//img[@src='images/reject3.gif']"));
			for(int i=0;i<Reject.size();i++){
		
					System.out.println(Reject.get(i));
					}
				Reject.get(0).click();
				takeScreenshot("Reject");
				Thread.sleep(1000); 
			driver.findElement(By.xpath("//textarea[@id='txtdesc']")).sendKeys("Resubmit the Product again");
			takeScreenshot("Reject_Reason");
				driver.findElement(By.linkText("GO")).click();
				Thread.sleep(1000);
				try {
					driver.switchTo().alert().accept();
					Thread.sleep(1000);
					driver.switchTo().alert().accept();
					
				} catch (UnhandledAlertException e) {
				  System.out.println(e.getMessage());
				    }
				Thread.sleep(2000);
				driver.findElement(By.linkText("Logout")).click();
//2nd product reSubmission
		driver.navigate().to("http://sellersportalook.cstechns.com/");
		driver.findElement(By.linkText("Login")).click();		
		driver.findElement(By.id("left_txtemail")).sendKeys("cstechseller@gmail.com");
		driver.findElement(By.id("left_txtpwd")).sendKeys("Xyz@1234");
		driver.findElement(By.id("signin_btnlogin")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Product List")).click();
		
		List<WebElement> ManagePrice =	driver.findElements(By.xpath("//img[@title='Manage Price & Stock']"));
		takeScreenshot("Resubmission");
		for(int i=0;i<ManagePrice.size();i++){
		System.out.println(ManagePrice.get(i));
		}
		ManagePrice.get(1).click();
		
		driver.findElement(By.id("txtmrpall")).sendKeys("2600");
		driver.findElement(By.id("txtofferall")).sendKeys("2350");
		driver.findElement(By.linkText("Confirm")).click();
		takeScreenshot("Price");
		driver.findElement(By.name("0Stock")).clear();
		driver.findElement(By.name("0Stock")).sendKeys("20");
		driver.findElement(By.name("0Stockremove")).clear();
		driver.findElement(By.name("0Stockremove")).sendKeys("05");
		driver.findElement(By.id("0chkdefaultval")).click();
		
		
		driver.findElement(By.name("1Price")).clear();
		driver.findElement(By.name("1offerPrice")).clear();
		driver.findElement(By.id("1Price")).sendKeys("3000");
		driver.findElement(By.id("1offerPrice")).sendKeys("2700");
		driver.findElement(By.name("1Stock")).clear();
		driver.findElement(By.name("1Stock")).sendKeys("10");
		driver.findElement(By.name("1Stockremove")).clear();
		driver.findElement(By.name("1Stockremove")).sendKeys("05");
		
		driver.findElement(By.name("2Price")).clear();
		driver.findElement(By.name("2offerPrice")).clear();
		driver.findElement(By.id("2Price")).sendKeys("1500");
		driver.findElement(By.id("2offerPrice")).sendKeys("1399");
		driver.findElement(By.name("2Stock")).clear();
		driver.findElement(By.name("2Stock")).sendKeys("10");
		driver.findElement(By.name("2Stockremove")).clear();
		driver.findElement(By.name("2Stockremove")).sendKeys("03");
		
		driver.findElement(By.name("3Price")).clear();
		driver.findElement(By.name("3offerPrice")).clear();
		driver.findElement(By.id("3Price")).sendKeys("1500");
		driver.findElement(By.id("3offerPrice")).sendKeys("1399");
		driver.findElement(By.name("3Stock")).clear();
		driver.findElement(By.name("3Stock")).sendKeys("10");
		driver.findElement(By.name("3Stockremove")).clear();
		driver.findElement(By.name("3Stockremove")).sendKeys("03");
		
		
		driver.findElement(By.linkText("Submit")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='desk']//a[text()='Sign Out']")).click();
		Thread.sleep(2000);
		
		
//2nd product Admin Approval	
		driver.navigate().to("http://siteadminsportalook.cstechns.com/");
		driver.findElement(By.name("txtLogin")).sendKeys("sportalook@cstech.in");
		driver.findElement(By.name("txtPassword")).sendKeys("45824582");
		driver.findElement(By.name("btnSubmit")).click();
			WebElement element1 =	driver.findElement(By.id("liCatalog"));
			Actions action1= new Actions(driver);
			action1.moveToElement(element1).build().perform();
			takeScreenshot("Master");
			driver.findElement(By.linkText("Product's List")).click();
			takeScreenshot("Product-List");
//	        1st product admin approves			
			driver.findElement(By.xpath("//input[@prdcode='SKU7793']")).click(); //change based on SKU code
			takeScreenshot("Checkbox");
		
			try {
				driver.findElement(By.linkText("Bulk Active")).click();
				takeScreenshot("Reapproval");
				
			} catch (UnhandledAlertException f1) {
			    try {
			        Alert alert = driver.switchTo().alert();
			        String alertText = alert.getText();
			        System.out.println("Alert data: " + alertText);
			        alert.accept();
			    } catch (NoAlertPresentException e) {
			        e.printStackTrace();
			    }
			Thread.sleep(1000);
			driver.findElement(By.linkText("Logout")).click();
			}	
	}
@AfterClass
public void tearDown() throws InterruptedException {
	driver.close();
	driver.quit();
	
	}
}

