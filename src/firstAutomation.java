import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class firstAutomation {

	public static void main(String [] args) {
	
		
		try {
			//Chrome driver path
			String chromeDriver = "/Users/obaidnasary/Downloads/Softwares/Selenium/chromedriver";
			
			//Setting the Chrome driver path
			System.setProperty("webdriver.chrome.driver", chromeDriver);
			
			//Creating object
			ChromeDriver driverOb = new ChromeDriver();
			
			
			String URL = "https://www.westernunion.com/lt/en/home.html";
			
			//To wait for an element to be loaded for a maximum of 10 seconds
			driverOb.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			//Navigation to the WU URL
			driverOb.navigate().to(URL);

			//To maximize the page
			driverOb.manage().window().maximize();
			
			//Getting focus on the 'Accept Cookies' button and sending the enter key
			WebElement cookie = driverOb.findElement(By.id("onetrust-accept-btn-handler"));
			cookie.sendKeys();
			cookie.sendKeys(Keys.ENTER);
			
			//Getting focus on the 'Burger Menu' and sending the enter key
			WebElement burgerMenu = driverOb.findElement(By.xpath("//*[@id=\"menuicon\"]"));
			burgerMenu.sendKeys();
			burgerMenu.sendKeys(Keys.ENTER);
			
			//Finding the 'Settings' in the 'Burger Menu' and clicking it
			driverOb.findElement(By.xpath("//*[@id=\"site-menu\"]/li[7]/a")).click();
			
			//Locating the 'Country' drop-down and changing the country to 'United States'
			WebElement countries = driverOb.findElement(By.xpath("//*[@id=\"Question\"]"));
			Select selectCountry = new Select(countries);
			selectCountry.selectByVisibleText("United States");
			
			//Clicking the 'Yes' button in the 'Yes_No_Option' pop-up
			driverOb.findElement(By.xpath("//*[@id=\"settingsPage\"]/maincontents/div[3]/div[2]/div[2]/button")).click();
			
			//Getting the currently loaded URL
			String loadedUrl = driverOb.getCurrentUrl();
			
			//The URL for WU US page
			String usUrl = "https://www.westernunion.com/us/en/home.html";
			
			//To assert the currently loaded URL and WU US page URL
			Assert.assertEquals(loadedUrl, usUrl); 
			
			//Another way to confirm with top-level domain official country code of the website
			if(loadedUrl.contains("https://www.westernunion.com/us/")) {
				System.out.print("It is from US");
				JOptionPane.showMessageDialog(null, "The correct US page was loaded!", "Success", JOptionPane.INFORMATION_MESSAGE);
			}else {
				System.out.print("It is not from US");
				JOptionPane.showMessageDialog(null, "Incorrect page was loaded!", "Failed", JOptionPane.WARNING_MESSAGE);
			}
			
			
		}catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
	}
}
