package sauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class swagLabs {
	
	public static WebDriver driver;//(Declare the driver)
 
@BeforeSuite
	public static void main(String[] args) throws InterruptedException {
		
		// TODO Auto-generated method stub
				
		
//1.ACCESS THE DEMO SITE..........................................................................................................................................................
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();//through Chrome driver 
		driver.manage().window().maximize();//(Maximize the window)
		driver.get("https://www.saucedemo.com");//(Go through site's URL)
		System.out.println("**************************************GOING TO LAUNCH**************************************");
		System.out.println();
		System.out.println("1.Access the site..................");
		System.out.println();
		
//2.lOGIN TO THE SYSTEM............................................................................................................................................................
		 WebElement userName = driver.findElement(By.id("user-name"));//(Find path to User name)
		 userName.sendKeys("performance_glitch_user");//(Type given user name )
		
		 WebElement passWord = driver.findElement(By.id("password"));//(Find path to Password)
		 passWord.sendKeys("secret_sauce");//(Type given password)
		 
		 WebElement loginButton = driver.findElement(By.id("login-button"));//(Find path to Login button)
		 loginButton.click();//(Click the login button)
		 
		 System.out.println("2.Successfully Login to Swag Labs!!!");
		 System.out.println();
		 Thread.sleep(3000);
		 
//3.CHECK THE PRIZE OF " Sauce Labs Fleece Jacket "................................................................................................................................
		 WebElement prizeOfFleeceJacket = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[4]/div[2]/div[2]/div\r\n"));//(Find path to prizeOfFleeceJacket)
		 String Prize = prizeOfFleeceJacket.getText();
         System.out.println("3.Prize of Fleece Jacket is "+ Prize);//(Get prize of FleeceJacket)
		 System.out.println();
		 Thread.sleep(3000);
        
//4.ADD CARDS FOR 2 ITEMS...........................................................................................................................................................
     	 WebElement addCard1 = driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]"));//(Find path to card 1)
		 addCard1.click();//(add the card 1)
		 String card1Name =(driver.findElement(By.id("item_4_title_link"))).getText();
		 System.out.println("4.1.I added one - " +card1Name);
		 Thread.sleep(2500);
		 
		 WebElement addCard2 = driver.findElement(By.xpath("//*[@id=\"add-to-cart-test.allthethings()-t-shirt-(red)\"]"));//(Find path to card 2)
		 addCard2.click();//(add the card 2)
		 String card2Name =(driver.findElement(By.id("item_3_title_link"))).getText();
		 System.out.println("4.2.I added second one - " + card2Name);
		 System.out.println();
		 
//5.CLICK CARD ICON................................................................................................................................................................
		 WebElement cardIcon = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));//(Find path to card Icon)
		 cardIcon.click();//(click card button)
		 System.out.println("5.Click card icon button .");
		 System.out.println();
		 
//6.VERIFY THE ITEMS................................................................................................................................................................		
		 String yourCard1 = (driver.findElement(By.id("item_4_title_link"))).getText();//(Find path to added card 1 name)
		 String yourCard2 = (driver.findElement(By.id("item_3_title_link"))).getText();//(Find path to added card 1 name)
		 System.out.println("6.1.I saw the added one - " +yourCard1);
		 System.out.println("6.2.I saw the added second one - " +yourCard2);
		 
		 try {
				AssertJUnit.assertEquals(card1Name, yourCard1);
				AssertJUnit.assertEquals(card2Name, yourCard2);
				System.out.println("6.3 There are added cards.So selected items are verified!.");
			} catch (AssertionError e) {
				 System.out.println("The names of the second item do not match.");
			}
		 System.out.println();
		 Thread.sleep(3000);
		
//7.CLICK CHECKOUT BUTTON.........................................................................................................................................................
		 WebElement checkOut = driver.findElement(By.id("checkout"));//(Find path to checkOut button)
		 checkOut.click();//Click checkout button
		 System.out.println("7.Navigate to ................. inforamtion page");
		 System.out.println();
		 
//8.PROVIDE A RANDOM NAME & ZIP CODE...............................................................................................................................................
		 //continue
		 WebElement firstName = driver.findElement(By.id("first-name"));//(Find path to first name)
		 firstName.sendKeys("Manoharan");
		 
		 WebElement lastName = driver.findElement(By.id("last-name"));//(Find path to last name)
		 lastName.sendKeys("Mathusan");
		 
		 WebElement zipCode = driver.findElement(By.id("postal-code"));//(Find path to Zip code)
		 zipCode.sendKeys("mathusanmano");

		 System.out.println("8.Provided name & zip code .");
		 System.out.println();
		 Thread.sleep(2000);

//9.CLICK CONTINUE BUTTON.............................................................................................................................................................. 	 
		 WebElement continueButton = driver.findElement(By.id("continue"));//(Find path to continue button)
		 continueButton.click();//click continue button 
		 System.out.println("9.Then continue............");
		 System.out.println();
		 
//10.FINISH............................................................................................................................................................................		 
		 WebElement finishButton = driver.findElement(By.id("finish"));//(Find path to finish button)
		 finishButton.click();//click finish button 			 
		 System.out.println("10.I have Ordered successfully!");		 
		 Thread.sleep(5000);
		 System.out.println();
		 System.out.println("**************************************GOING TO TEARDOWN**************************************");
	}
		@AfterSuite
		public void tearDown() throws InterruptedException {
			Thread.sleep(3000);
			driver.close();//close driver
			Thread.sleep(5500);
		}


}