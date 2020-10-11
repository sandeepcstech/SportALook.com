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

public class AddSingleList {
	
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
		option.selectByVisibleText("Footwear");
		
		WebElement w2 = driver.findElement(By.id("ddlcommissioncategory"));
		Select option2= new Select(w2);
		option2.selectByVisibleText("Men Footwear");
		
		
		WebElement w3 = driver.findElement(By.id("ddlsubcategorywithcommision"));
		Select option3= new Select(w3);
		option3.selectByVisibleText("Walking Shoes");
		takeScreenshot("Comm-Cat");
		
		Thread.sleep(2000);
		driver.findElement(By.linkText("NEXT")).click();
	//	Display Category	
		driver.findElement(By.id("myTreeViewn181CheckBox")).click();
		driver.findElement(By.xpath("//a[@id='myTreeViewn181']//img[@src='images/iconPlus.png']")).click();
		
		
		driver.findElement(By.id("myTreeViewn190CheckBox")).click();
		driver.findElement(By.xpath("//a[@id='myTreeViewn190']//img[@src='images/iconPlus.png']")).click();
		
		driver.findElement(By.id("myTreeViewn197CheckBox")).click();
		takeScreenshot("Display-Cat");
		
		driver.findElement(By.linkText("NEXT")).click();
//Basic Info
			WebElement w4 = driver.findElement(By.id("ddlproducttype"));
			Select option4= new Select(w4);
			option4.selectByVisibleText("Footwear");
			Thread.sleep(1000);
			
		driver.findElement(By.xpath("//input[@tabindex='2']")).sendKeys("Shoes1");
		Thread.sleep(1000);
		driver.findElement(By.id("txt_hsn")).sendKeys("HSN9985");
		driver.findElement(By.id("txt_igst")).sendKeys("18"+Keys.ENTER);
		Thread.sleep(1000);
		takeScreenshot("Basi-info1");
		driver.findElement(By.id("txt_desc")).sendKeys("Good to Run, Good to Burn");
		Thread.sleep(1000);
		driver.findElement(By.id("txt_Skucode")).sendKeys("SKU7793");
		driver.findElement(By.id("fl_MainImg")).sendKeys("C:\\Users\\USER\\Documents\\Puma1.jpg");
		driver.findElement(By.id("fl_bookpdf")).sendKeys("C:\\Users\\USER\\Downloads\\Shoes are Nike.pdf");
		driver.findElement(By.id("txt_Metakeywords")).sendKeys("Shoe,");
		WebElement w5 = driver.findElement(By.id("ddlretunpolicy"));
		Select option5= new Select(w5);
		option5.selectByVisibleText("Not eligible for exchange or return");
		Thread.sleep(1000);
		takeScreenshot("Basic-Info2");
		driver.findElement(By.linkText("NEXT")).click();
		
	//Attribute Settings
		WebElement Cushioning = driver.findElement(By.id("ddl8"));
		Select select=new Select(Cushioning);
		select.selectByVisibleText("High");
		
		WebElement Pronation = driver.findElement(By.id("ddl10"));
		Select select2=new Select(Pronation);
		select2.selectByVisibleText("Neutral Overpronator");
		
		WebElement  Closure= driver.findElement(By.id("ddl15"));
		Select select3=new Select(Closure);
		select3.selectByVisibleText("Lace-Up");
		
		
		WebElement  Material= driver.findElement(By.id("ddl23"));
		Select select4=new Select(Material);
		select4.selectByVisibleText("Crochet");
		
		takeScreenshot("Attribute1");
		WebElement  SoleMaterial= driver.findElement(By.id("ddl36"));
		Select select5=new Select(SoleMaterial);
		select5.selectByVisibleText("PU");
		
		WebElement  Cleats= driver.findElement(By.id("ddl37"));
		Select select6=new Select(Cleats);
		select6.selectByVisibleText("No Cleats");
		
		WebElement  ArchType= driver.findElement(By.id("ddl39"));
		Select select7=new Select(ArchType);
		select7.selectByVisibleText("Medium");
		
		WebElement  Technology= driver.findElement(By.id("ddl40"));
		Select select8=new Select(Technology);
		select8.selectByVisibleText("Clima Cool");
		takeScreenshot("Attribute2");
		
		Thread.sleep(1000);
		driver.findElement(By.id("Checkl43_1")).click();
		driver.findElement(By.id("Checkl43_48")).click();
		driver.findElement(By.id("Checkl44_26")).click();
		driver.findElement(By.id("Checkl44_28")).click();
		takeScreenshot("Attribute3");
		WebElement  SizeChart= driver.findElement(By.id("ddlsizechart"));
		Select select9=new Select(SizeChart);
		select9.selectByVisibleText("Kica Size Guide Joggers");
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
		driver.findElement(By.id("file-1")).sendKeys("C:\\Users\\USER\\Downloads\\Puma4.jpg");
		driver.findElement(By.id("file-1")).sendKeys("C:\\Users\\USER\\Downloads\\Puma5.jpg");
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
		
		

		driver.findElement(By.id("1Price")).sendKeys("2800");
		driver.findElement(By.id("1offerPrice")).sendKeys("2500");
		driver.findElement(By.name("1Stock")).clear();
		driver.findElement(By.name("1Stock")).sendKeys("10");
		driver.findElement(By.name("1Stockremove")).clear();
		driver.findElement(By.name("1Stockremove")).sendKeys("05");
		

		driver.findElement(By.id("2Price")).sendKeys("2400");
		driver.findElement(By.id("2offerPrice")).sendKeys("2100");
		driver.findElement(By.name("2Stock")).clear();
		driver.findElement(By.name("2Stock")).sendKeys("20");
		driver.findElement(By.name("2Stockremove")).clear();
		driver.findElement(By.name("2Stockremove")).sendKeys("10");
		
		
		driver.findElement(By.id("2Price")).sendKeys("2600");
		driver.findElement(By.id("2offerPrice")).sendKeys("2400");
		driver.findElement(By.name("2Stock")).clear();
		driver.findElement(By.name("2Stock")).sendKeys("10");
		driver.findElement(By.name("2Stockremove")).clear();
		driver.findElement(By.name("2Stockremove")).sendKeys("03");
		takeScreenshot("Diff_prices");
		
		driver.findElement(By.linkText("Submit")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href='supplierwelcome']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='desk']//a[text()='Sign Out']")).click();
		}
	
	@AfterClass
	public void tearDown() throws InterruptedException {
		
		driver.close();
		driver.quit();
	}


}
