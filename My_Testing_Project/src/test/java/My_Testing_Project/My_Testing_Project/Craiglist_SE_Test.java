package My_Testing_Project.My_Testing_Project;

import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Craiglist_SE_Test {
	
	private WebDriver driver;
	private String baseURL;
	
  
	@Test
  public void f() {
		
	/*
1. Log in to https://sfbay.craigslist.org/
2. Go to 'my account'
3. Open 'searches' tab
4. Click 'edit' on toyota search
5. Change name to 'toyota prius'
6. Click 'save'
7. Verify name was changed
8. Click 'delete'
9. Verify search was deleted	
	 */
	
  System.setProperty("webdriver.gecko.driver", 
	"/Users/yuri_naida/Documents/workspace_personal/selenium/geckodriver");
  
  driver = new FirefoxDriver();
  baseURL =  "https://sfbay.craigslist.org/";
  driver.manage().window().maximize();
  
  // 1.Log in to https://sfbay.craigslist.org/
  
  driver.get(baseURL);
  
  // 2. Go to 'my account'
  
  driver.findElement(By.linkText("my account")).click();
  driver.findElement(By.id("inputEmailHandle")).sendKeys("user.testing.qa1@gmail.com");
  driver.findElement(By.id("inputPassword")).sendKeys("First_User!123@");
  driver.findElement(By.linkText("Log in")).click();
 
  // 3. Open 'searches' tab 
  
  driver.findElement(By.linkText("searches")).click();
  
  // 4. Click 'edit' on toyota search
  
  driver.findElement(By.linkText("edit")).click();
  
  // 5. Change name to 'toyota prius'
  
  WebElement editField =  driver.findElement(By.name("subName"));
  editField.clear();
  editField.sendKeys("toyota prius");
  
  // 6. Click 'save'
  
  driver.findElement(By.linkText("save")).click();
  
  // 7. Verify name was changed
  
  String savedSearch = "https://sfbay.craigslist.org/search/sss?query=toyota+prius&sort=rel";
  
  if(savedSearch == driver.findElement(By.linkText
		  ("https://sfbay.craigslist.org/search/sss?query=toyota+prius&sort=rel")).toString()) {
	  System.out.println("Name was changed");
  }else {
	  System.out.println("Issue in step 7, Verify name!");
  }
  
  // 8. Click 'delete'
  
  driver.findElement(By.linkText("delete")).click();
  
  // 9. Verify search was deleted	
		
		
  }
}
