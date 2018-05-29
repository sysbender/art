package com.presagis.art.examples.appinum.win10calculator;

import java.util.concurrent.TimeUnit;

import org.aspectj.lang.annotation.Before;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.windows.WindowsDriver;
import junit.framework.Assert;

public class CalculatorTest {
	
	private static WindowsDriver session = null;
	private static  WebElement resultElement = null;
	
	
	@BeforeClass	
	public static void setup() {
		try {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
            capabilities.setCapability("platformName", "Windows");
            capabilities.setCapability("deviceName", "WindowsPC");
			session = new WindowsDriver(capabilities);
			session.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			resultElement = session.findElementByAccessibilityId("CalculatorResults");
			Assert.assertNotNull(resultElement);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		
	}
	
	
	@Before(value = "")
	public void clear() {
		session.findElementByName("Clear").click();
		Assert.assertEquals("0", _GetCalculatorResultText());
	}
	
	
	@AfterClass
	public static void TearDown() {
		resultElement = null;
		if(session !=null) {
			session.quit();
		}
		session = null;

	}
	
	@Test
	public void Addition() {
		session.findElementByName("One").click();
		session.findElementByName("Plus").click();
		session.findElementByName("Seven").click();
		session.findElementByName("Equals").click();
		System.out.println("==========================");
		System.out.println(_GetCalculatorResultText());
		Assert.assertEquals("8", _GetCalculatorResultText());
	}
	
	
	protected String _GetCalculatorResultText() {
		return resultElement.getText().replace("Display is","").trim();
	}

}
