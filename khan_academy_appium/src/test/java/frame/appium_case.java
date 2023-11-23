package frame;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.io.IOException;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
public class appium_case extends capabilities {
	
	// In this class we are calling our driver from another class and we are declaring the variables for our report globally, so that
	// we can use these variables in every method
	
	
	AndroidDriver<AndroidElement> driver;
	ExtentHtmlReporter  htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	
	
	
	
	@BeforeTest
	//In this method we are starting our server and calling the main method from the capabilities class
	public void bt() throws IOException, InterruptedException {
    service=startServer();
    driver= hybrid_capabilities(appactivity, apppackage, deviceName, chromeexcutable);
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    htmlReporter = new ExtentHtmlReporter("extent.html");
	 extent = new ExtentReports();
	extent.attachReporter(htmlReporter);

	}
	
	
	//In this method I am performing the actions that i want to perform on my application  i.e clicking, scrolling etc.
	@Test(enabled=true)
	public void tc1() throws IOException, InterruptedException  {
    AndroidDriver<AndroidElement> driver=hybrid_capabilities(appactivity, apppackage, deviceName, chromeexcutable);
    Thread.sleep(8000);
    test=extent.createTest("this is my first test");
    driver.findElementByAndroidUIAutomator("text(\"Sign in\")").click();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.findElementByAndroidUIAutomator("text(\"Sign up with email\")").click();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.findElement(MobileBy.AccessibilityId("First name")).sendKeys("Vandana");
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	test.pass("you have entered the firstname");
	driver.findElement(MobileBy.AccessibilityId("Last name")).sendKeys("Raheja");
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	test.pass("you have entered the lastname");
	driver.findElement(MobileBy.AccessibilityId("Birthday")).click();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.findElementByAndroidUIAutomator("text(\"OK\")").click();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.findElement(MobileBy.AccessibilityId("Email address")).sendKeys("vandanaraheja111@gmail.com");
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	test.pass("you have entered the email address");
    driver.pressKey(new KeyEvent(AndroidKey.BACK));
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.pressKey(new KeyEvent(AndroidKey.BACK));
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.findElement(MobileBy.AccessibilityId("Search")).click();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//    driver.findElement(By.xpath("//*[@text='Science']")).click();
//    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Science\"))").click();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.findElement(By.xpath("//*[@text='Class 9 Physics (India)']")).click();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    AndroidElement rr= driver.findElement(By.xpath("//*[@text='Average speed and average velocity']"));
    rr.click();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.pressKey(new KeyEvent(AndroidKey.BACK));
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.pressKey(new KeyEvent(AndroidKey.BACK));
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.pressKey(new KeyEvent(AndroidKey.BACK));
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.pressKey(new KeyEvent(AndroidKey.BACK));
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    System.out.println("operation complete");
    extent.flush();
    service.stop();		
}
}