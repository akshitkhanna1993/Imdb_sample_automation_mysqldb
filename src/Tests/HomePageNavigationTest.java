package Tests;

import org.testng.annotations.Test;

import Tests.Common;

public class HomePageNavigationTest extends Common {
	
	@Test(priority=1)
	public void HomePagedisplayedTest(){
	
		
		System.out.println("Imdb application launched"); 
		setup.hsa.MoviesTab();
		
	}

}
