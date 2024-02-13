package Task22;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Phptravels {

	public static void main(String[] args) throws IOException {
		//load the driver
		WebDriver driver = new ChromeDriver();
		
		// load the Url
		driver.navigate().to("https://phptravels.com/demo/");
		
		//using window maximize
		driver.manage().window().maximize();
		
		// using implicitly time wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         
        // fill in the form details in phptravels
       WebElement ele=    driver.findElement(By.xpath("//input[@name='first_name']"));
       ele.sendKeys("priya");
       WebElement las =   driver.findElement(By.xpath("//input[@name='last_name']"));
       las.sendKeys("sai");
       WebElement buss = driver.findElement(By.xpath("//input[@name='business_name']"));
       buss.sendKeys("Guardening");
       WebElement mail = driver.findElement(By.xpath("//input[@class='email form-control']"));
       mail.sendKeys("ct3.staffing@gmail.com");
        
      //  two numbers validation
      String num1 =  driver.findElement(By.id("numb1")).getText();
      String num2 = driver.findElement(By.id("numb2")).getText();
      
       //convert string to integer
       int resl1= Integer.parseInt(num1);
       int resl2= Integer.parseInt(num2);;
       int num3=resl1+resl2;
       System.out.println("total:"+ num3);
       driver.findElement(By.cssSelector("input#number")).sendKeys(Integer.toString(num3));
      
       // click submit button
       driver.findElement(By.xpath("//button[text()='Submit']")).click();
      
       // using x-path locater thankyou massage 
       WebElement Thankyoutext = driver.findElement(By.xpath("//strong[text()='Thank you!']"));
        
       // using web driver wait
        WebDriverWait wait  = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(Thankyoutext));
        System.out.println(driver.findElement(By.xpath("// strong[text()=' Thank you!']")).getText());
        
        // using screenshot
          TakesScreenshot screenshort = ((TakesScreenshot)driver);
            File source = screenshort.getScreenshotAs(OutputType.FILE);
            File destination = new File("C:\\Users\\USER\\eclipse-workspace\\MavenRepofiles\\Snapshort\\ screenshort1.png");
            FileUtils.copyFile(source, destination);
    
	}		
}
