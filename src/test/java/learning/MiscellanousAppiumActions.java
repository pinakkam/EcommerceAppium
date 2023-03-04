package learning;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class MiscellanousAppiumActions extends BaseTest {

	@Test
	public void Miscellanous() throws MalformedURLException {
		//Clicked on the preference tab on the App
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		//Navigating through the Preference tab
		//tagName[@attribute='value']
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		
		//Rotate Device i.e. to check in Landscape mode
		DeviceRotation landScape= new DeviceRotation(0, 0, 90);
		driver.rotate(landScape);
		//Verifying whether after checking WIFI button, WiFi Setting is Enabled or not.
		Assert.assertTrue(driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).isEnabled());
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		//Grabbing the text of the WiFi Setting Pop-up for further Assertions.
		String alertTitle=driver.findElement(By.id("android:id/alertTitle")).getText();
		//Verifying whether WiFi Setting pop-up correctly and matches with the value
		Assert.assertEquals(alertTitle, "WiFi settings");
		driver.setClipboardText("Ankit wiFi");
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		
		
		//driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipBoradText());
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
	}

}
