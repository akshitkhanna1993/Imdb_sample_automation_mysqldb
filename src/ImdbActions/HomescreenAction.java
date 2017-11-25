package ImdbActions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import DatabaseActions.ImdbDatabaseConnection;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class HomescreenAction{
	
	ImdbDatabaseConnection imdbobj=new ImdbDatabaseConnection();

	WebDriver driver;
	
	public HomescreenAction(WebDriver driver){	
	this.driver=driver;
	imdbobj.setup();
		
	}

	public void MoviesTab(){
		
	//WebElement moviestab=((AndroidDriver)driver).findElementByAndroidUIAutomator("new UISelector().text(\"MOVIES\")");
			
	WebElement moviestab=driver.findElement(By.xpath("//android.widget.TextView[@text='MOVIES']"));
	moviestab.click();
	
		
	WebElement seeAll=driver.findElement(By.id("com.imdb.mobile:id/see_all"));
	seeAll.click();
	
	List<WebElement> myList=driver.findElements(By.id("com.imdb.mobile:id/label"));
     
	for (WebElement currentmovie : myList) {
    	String currentmovietext=currentmovie.getText();
    	System.out.println(currentmovietext);
    	imdbobj.InsertMovieName(currentmovietext);
       }
	
		imdbobj.closedatabase();	
	}
}

