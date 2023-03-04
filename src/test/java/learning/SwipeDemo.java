package learning;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class SwipeDemo extends BaseTest {

	@Test
	public void SwipeDemoTest() throws MalformedURLException, InterruptedException {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Gallery']")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();

		WebElement firstImage = driver.findElement(By.xpath("//(android.widget.ImageView)[1]"));
		// to Check if the selected image has focusable attribute as true.
		Assert.assertEquals(driver.findElement(By.xpath("//(android.widget.ImageView)[1]")).getAttribute("focusable"),
				"true");

		swipeAction(firstImage, "left");
		// After swipe this method will check if the swiped image now has focusable
		// attribute as false.
		Assert.assertEquals(driver.findElement(By.xpath("//(android.widget.ImageView)[1]")).getAttribute("focusable"),
				"false");
		// After Swipe, if the second image focusable is enabled, so with this method we
		// will verify the same.
		Assert.assertEquals(driver.findElement(By.xpath("//(android.widget.ImageView)[2]")).getAttribute("focusable"),
				"true");
		Thread.sleep(2000);
	}
}
