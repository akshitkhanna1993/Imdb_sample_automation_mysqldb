package TestSessionInitiator;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import ImdbActions.HomescreenAction;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class TestSetup {
	
	private  DesiredCapabilities cap;
	private AppiumDriver driver;
	
	
       public TestSetup() throws MalformedURLException	{
		 cap=new DesiredCapabilities();
		 cap.setCapability(CapabilityType.PLATFORM, "Android");
		 cap.setCapability(CapabilityType.VERSION,"7.0.0");
		 cap.setCapability("deviceName","GUZSDYGYBMI7VSKJ");
		 cap.setCapability("appPackage","com.imdb.mobile");
		 cap.setCapability("appActivity",".HomeActivity");
		 cap.setCapability("noReset","true"); 
		 cap.setCapability("unicodeKeyboard", true);
		 driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		 driver .manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		  	 
		 initActionClasses();
	}
       
       public HomescreenAction hsa;
       
       public void initActionClasses(){
    	   
    	   
       hsa=new HomescreenAction(driver);
       }
       public void quitSession(){
   		driver.quit();

  }
}
