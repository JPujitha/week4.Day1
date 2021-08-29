package week4.Day1.Assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class ServiceNow {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		Thread.sleep(20000);
		driver.get("https://dev113545.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.switchTo().frame("gsft_main");
		driver.findElementById("user_name").sendKeys("admin");
		driver.findElementById("user_password").sendKeys("w6hnF2FRhwLC");
		driver.findElementById("sysverb_login").click();
		driver.switchTo().defaultContent();
		driver.findElementById("filter").sendKeys("incident");
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//ul[@class='sn-widget-list_v2 sn-widget-list_dense collapse in'])[3]/li[6]/div/div/a")).click();
		driver.switchTo().frame("gsft_main");
		driver.findElementById("sysverb_new").click();
		driver.findElement(By.xpath("//span[@class='icon icon-search']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> l=new ArrayList<String>(windowHandles);
		driver.switchTo().window(l.get(1));
		driver.findElement(By.xpath("//a[@class='glide_ref_item_link']")).click();
		driver.switchTo().window(l.get(0));
driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys("Test");
/*
 * Set<String> L = driver.getWindowHandles(); List<String> i= new
 * ArrayList<String>(L); driver.switchTo().window(i.get(1));
 * driver.findElement(By.
 * xpath("(//td[@class='list_decoration_cell col-small col-center '])[1]/following::td/a"
 * )).click();
 */
	}

}
