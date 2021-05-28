import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import groovy.ui.SystemOutputInterceptor;

public class Selenium_practice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String URL = "https://www.makemytrip.com/";

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\748639\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		System.out.println("Opened MakeMyTrip");

		// Calendar example

		/*
		 * for (int i =1;i<=12;i++){
		 * 
		 * if(monthsElement.get(i).getText().trim().contains("October 2021")){
		 * 
		 * break;
		 * 
		 * } else{
		 * 
		 * 
		 * } }
		 */
		driver.findElement(By.xpath("//div[@class='fsw_inner ']/div/label/span[text()='DEPARTURE']")).click();

		List<WebElement> monthsElement = driver
				.findElements(By.xpath("//div[@class='DayPicker-Month']/div[@class='DayPicker-Caption']/div"));

		int i = 0;

		do {

			if (monthsElement.get(i).getText().trim().contains("October 2021")) {

				break;

			}

			else {
				driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
				monthsElement = driver
						.findElements(By.xpath("//div[@class='DayPicker-Month']/div[@class='DayPicker-Caption']/div"));
			}
		} while (i == 0);

		// Open the practice page
		// driver.findElement(By.xpath("//a[text()='Practice']")).click();

		/*
		 * // print the number of links in a web page List<WebElement>
		 * activelinks = driver.findElements(By.tagName("a")); int countofLinks
		 * = activelinks.size();
		 * 
		 * System.out.println("There are " + countofLinks +
		 * " links present in the webpage");
		 * 
		 * // Limiting WebDriver scope // Print the number of links present in
		 * the footer section WebElement footerSection =
		 * driver.findElement(By.xpath("//div[@id='gf-BIG']"));
		 * 
		 * System.out.println( "There are " +
		 * footerSection.findElements(By.tagName("a")).size() +
		 * "links in the footer section");
		 * 
		 * // Print the number of links present in the first column of the
		 * footer // section
		 * 
		 * WebElement firstColumn =
		 * footerSection.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		 * 
		 * System.out.println( "There are " +
		 * firstColumn.findElements(By.tagName("a")).size() +
		 * " links in the first column");
		 * 
		 * // Click on each link in the footer section and check the number of
		 * // working links
		 * 
		 * for (int i = 1; i < firstColumn.findElements(By.tagName("a")).size();
		 * i++) {
		 * 
		 * firstColumn.findElements(By.tagName("a")).get(i).sendKeys(Keys.chord(
		 * Keys.CONTROL, Keys.ENTER)); Thread.sleep(5000);
		 * 
		 * }
		 * 
		 * // Print all the titles of newly opened windows in a web page
		 * Set<String> abc = driver.getWindowHandles(); Iterator<String> it =
		 * abc.iterator();
		 * 
		 * while (it.hasNext()) {
		 * 
		 * driver.switchTo().window(it.next());
		 * System.out.println(driver.getTitle());
		 * 
		 * }
		 */

		// Assignmemt
		// 1. Select any checkbox
		// 2. Grab the label of checkbox and put into variable
		// 3. Select an option in dropdown . Value should match with the
		// selected checkbox label
		// 4. Enter the label name in editbox field
		// 5. Click Alert and then verify if text grabbed from step 2 is present
		// in the pop-up message

		/*
		 * driver.findElement(By.xpath("//input[@id='checkBoxOption2']")).click(
		 * );
		 * 
		 * String selectedCheckboxLabel =
		 * driver.findElement(By.xpath("//label[@for='benz']")).getText().trim()
		 * ;
		 * 
		 * Select sl = new Select(driver.findElement(By.xpath(
		 * "//select[@id='dropdown-class-example']")));
		 * 
		 * sl.selectByVisibleText(selectedCheckboxLabel);
		 * 
		 * String selectedDropdown =
		 * driver.findElement(By.xpath("//select[@id='dropdown-class-example']")
		 * ).getText() .trim();
		 * 
		 * Assert.assertEquals(selectedCheckboxLabel, selectedDropdown);
		 * 
		 * driver.findElement(By.xpath("//input[@name='enter-name']")).sendKeys(
		 * selectedDropdown);
		 * 
		 * driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
		 * 
		 * Alert al = driver.switchTo().alert();
		 * 
		 * String popupMessage = al.getText();
		 * 
		 * if (popupMessage.trim().contains(selectedDropdown)) {
		 * 
		 * System.out.println("popup message displayed successfully");
		 * 
		 * }
		 * 
		 * else {
		 * 
		 * System.out.println("Test Case failed"); }
		 */

		driver.close();

	}

}
