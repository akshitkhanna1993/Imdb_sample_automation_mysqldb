package Tests;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeTest;

import TestSessionInitiator.TestSetup;



public class Common {
		
		static TestSetup setup;
		@BeforeTest
		
		public void setup(){
			  try {
				setup =new TestSetup();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

