package Seller_Panel;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Add_Single_List2 {
	
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
	public void sellerAddingProducts() throws InterruptedException, IOException {		
		
		driver.get("http://sellersportalook.cstechns.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("left_txtemail")).sendKeys("cstechseller@gmail.com");
		driver.findElement(By.id("left_txtpwd")).sendKeys("Xyz@1234");
		driver.findElement(By.id("signin_btnlogin")).click();
		takeScreenshot("Login-Page");
//product 1 adding			
		Thread.sleep(5000);
		WebElement element = driver.findElement(By.xpath("//a[@href='supplierproductlist']"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		takeScreenshot("Dashboard");
		driver.findElement(By.linkText("Add Single Listing")).click();
	
	//Commission Category	
		WebElement w1=driver.findElement(By.id("maincategory"));
		Select option=new Select(w1);
		option.selectByVisibleText("Clothing");
		
		WebElement w2 = driver.findElement(By.id("ddlcommissioncategory"));
		Select option2= new Select(w2);
		option2.selectByVisibleText("Men Clothing");
		
		
		WebElement w3 = driver.findElement(By.id("ddlsubcategorywithcommision"));
		Select option3= new Select(w3);
		option3.selectByVisibleText("T-shirt & Tee");
		takeScreenshot("Comm-Cat");
		
		Thread.sleep(2000);
		driver.findElement(By.linkText("NEXT")).click();
	//	Display Category	
		driver.findElement(By.id("myTreeViewn138CheckBox")).click();
		driver.findElement(By.xpath("//a[@id='myTreeViewn138']//img[@src='images/iconPlus.png']")).click();
		
		
		driver.findElement(By.id("myTreeViewn146CheckBox")).click();
		driver.findElement(By.xpath("//a[@id='myTreeViewn146']//img[@src='images/iconPlus.png']")).click();
		
		driver.findElement(By.id("myTreeViewn150CheckBox")).click();
		takeScreenshot("Display-Cat");
		
		driver.findElement(By.linkText("NEXT")).click();
//Basic Info
			WebElement w4 = driver.findElement(By.id("ddlproducttype"));
			Select option4= new Select(w4);
			option4.selectByVisibleText("Clothing");
			Thread.sleep(1000);
			
		driver.findElement(By.xpath("//input[@tabindex='2']")).sendKeys("Nautica Tshirt");
		Thread.sleep(1000);
		driver.findElement(By.id("txt_hsn")).sendKeys("HSN77018");
		driver.findElement(By.id("txt_igst")).sendKeys("18"+Keys.ENTER);
		Thread.sleep(1000);
		takeScreenshot("Basi-info1");
		driver.findElement(By.id("txt_desc")).sendKeys("T-shirst for better apperance");
		Thread.sleep(1000);
		driver.findElement(By.id("txt_Skucode")).sendKeys("SKU3937");
		driver.findElement(By.id("fl_MainImg")).sendKeys("C:\\Users\\USER\\Downloads\\Nautica1.jpg");
		driver.findElement(By.id("fl_bookpdf")).sendKeys("C:\\Users\\USER\\Downloads\\Nautica.pdf");
		driver.findElement(By.id("txt_Metakeywords")).sendKeys("Shoe,");
		WebElement w5 = driver.findElement(By.id("ddlretunpolicy"));
		Select option5= new Select(w5);
		option5.selectByVisibleText("Easy exchange or return within 10 days");
		Thread.sleep(1000);
		takeScreenshot("Basic-Info2");
		driver.findElement(By.linkText("NEXT")).click();
		
	//Attribute Settings
		WebElement Fit = driver.findElement(By.id("ddl5"));
		Select select=new Select(Fit);
		select.selectByVisibleText("Regular Fit");
		
		WebElement Collar = driver.findElement(By.id("ddl6"));
		Select select2=new Select(Collar);
		select2.selectByVisibleText("Collarless");
		
		WebElement  Sleeve= driver.findElement(By.id("ddl7"));
		Select select3=new Select(Sleeve);
		select3.selectByVisibleText("Half");
		
		
		WebElement  Cotton= driver.findElement(By.id("ddl16"));
		Select select4=new Select(Cotton);
		select4.selectByVisibleText("Cotton");
		
		takeScreenshot("Attribute1");
		WebElement  Pattern= driver.findElement(By.id("ddl22"));
		Select select5=new Select(Pattern);
		select5.selectByVisibleText("Brand Logo");
		
		WebElement  Neck= driver.findElement(By.id("ddl38"));
		Select select6=new Select(Neck);
		select6.selectByVisibleText("Round");
		
		WebElement  Straps= driver.findElement(By.id("ddl41"));
		Select select7=new Select(Straps);
		select7.selectByVisibleText("Regular");
		
		WebElement  Technology= driver.findElement(By.id("ddl40"));
		Select select8=new Select(Technology);
		select8.selectByVisibleText("Quick Dry");
		takeScreenshot("Attribute2");
		
		Thread.sleep(1000);
		driver.findElement(By.id("Checkl43_1")).click();
		driver.findElement(By.id("Checkl43_48")).click();
		takeScreenshot("Attribute3");
		WebElement  SizeChart= driver.findElement(By.id("ddlsizechart"));
		Select select9=new Select(SizeChart);
		select9.selectByVisibleText("Kica Size Guide Crop Top");
		takeScreenshot("Attribute4");
		driver.findElement(By.linkText("NEXT")).click();
		Thread.sleep(1000);
		
//COD &Shipping		
		
		
		driver.findElement(By.id("rbt_cod_0")).click();
		driver.findElement(By.id("txt_Weight")).clear();
		driver.findElement(By.id("txt_Weight")).sendKeys("1000");
		takeScreenshot("COD_Shipping");
		driver.findElement(By.xpath("//span[@class='button_03']//a[@id='LinkButton1']")).click();
		Thread.sleep(5000);
		
//Upload Multiple Images
		driver.findElement(By.linkText("Upload Multiple Image Files")).click();
		driver.findElement(By.id("file-1")).sendKeys("C:\\Users\\USER\\Downloads\\Nautica2.jpg");
		driver.findElement(By.id("file-1")).sendKeys("C:\\Users\\USER\\Downloads\\Nautica3.jpg");
		takeScreenshot("multi-upload");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title='Upload selected files']//span[text()='Upload']")).click();
		driver.findElement(By.xpath("//div[@class='close fileinput-remove']")).click();
		takeScreenshot("multi-up-disp");
		driver.findElement(By.xpath("//div[@class='product button_03']//a[@id='LinkButton1']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("txtmrpall")).sendKeys("2500");
		driver.findElement(By.id("txtofferall")).sendKeys("2250");
		driver.findElement(By.linkText("Confirm")).click();
		takeScreenshot("Price");
		driver.findElement(By.name("0Stock")).clear();
		driver.findElement(By.name("0Stock")).sendKeys("20");
		driver.findElement(By.name("0Stockremove")).clear();
		driver.findElement(By.name("0Stockremove")).sendKeys("05");
		driver.findElement(By.id("0chkdefaultval")).click();
		
		takeScreenshot("Diff_prices");
		
		driver.findElement(By.linkText("Submit")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href='supplierwelcome']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='desk']//a[text()='Sign Out']")).click();
	}
		@AfterClass
		public void tearDown() throws InterruptedException {
		
			Thread.sleep(1000);
			driver.close();
			driver.quit();
			
		}

}
