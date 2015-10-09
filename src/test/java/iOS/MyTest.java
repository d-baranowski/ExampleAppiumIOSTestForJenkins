package iOS;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;

public class MyTest {

  private static WebDriver driver = null;
  @Test
  public void appiumExampleTest() throws Exception {
	    //Check if label with text My Label is visible on the screen 
		driver.findElement(By.name("Hello World of Appium and Calabash"));		
		Thread.sleep(5000);
	}
  
@BeforeMethod
@BeforeTest
public void setUp() throws Exception {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("platformName", "iOS");
    capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
    capabilities.setCapability("platformVersion", "9.0.2");
    capabilities.setCapability("deviceName", "iPhone 4s");
    capabilities.setCapability("app", "/Users/Shared/Jenkins/Desktop/JenkinsTestBuild.app");
    
    try {
		driver = new RemoteWebDriver(new URL("http://bjsss-mac-mini:4475/wd/hub"), capabilities);
	} catch (MalformedURLException e) {
		e.printStackTrace();
	}
}

@AfterMethod
@AfterTest
  public static void tearDown(){
		driver.quit();
	}	
}
