package learning;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class eCommerce_tc_1 extends BaseTest {

	@Test
	public void FillForm() throws InterruptedException

	{

		//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Ankit Joshi");
		//driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Ireland\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Ireland']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(2000);
		//below method will grab the toast error message for not passing the name value in the box.
		String toastMessage=driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("Name");
		Assert.assertEquals(toastMessage, "Please enter your name");
		
		
	}
}
