import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_Practice_Extended {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String URL = "http://www.qaclickacademy.com/";

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\748639\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		System.out.println("Opened QA Academy");

		driver.findElement(By.xpath("//a[text()='Practice']")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,500)");

		js.executeScript("document.querySelector('.tableFixHead').scrollBy(0,100)");

		List<WebElement> values = driver.findElements(By.xpath("//table[@id='product']/tbody/tr/td[4]"));
		int sum = 0;

		for (int i = 0; i < values.size(); i++) {

			sum = sum + Integer.parseInt(values.get(i).getText().trim());

		}
		
		String totalValue[] = driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(":");
		
		String number = totalValue[1].toString().trim();
		
		int num = Integer.parseInt(number);
		
		if(num==sum){
			
			System.out.println("Pass");
			
			
		}
		
		else{
			
			
			System.out.println("fail");
		}
	}

}
