package learning;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;

	@BeforeClass
	public void configureAppium() throws MalformedURLException

	{

		// Starting the Appium Server
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File(
						"C:\\Users\\admin.user\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();

		// Android Driver- For Android Applications
		// Appium Code i.e. Appium client code is passed to server-> Appium Server ->
		// UIAutomator2-> Android Device

		// Defining UIAutomator desired Capabilities:
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("AnkitEmulator");
		//options.setApp("C:\\Selenium\\SeleniumTraining\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");
		options.setApp("C:\\Selenium\\SeleniumTraining\\Appium\\src\\test\\java\\resources\\General-Store.apk");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void longPressAction(WebElement ele) {

		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "duration", 2000));
	}

	// This method is defined to scroll and do while loop is added to scroll this
	// the condition returns false, i.e.do condition will keep on running till while
	// returns false. Once the while condition returns false, the do condition will
	// stop. Once while indicates that it can't scroll anymore the do condition will
	// stop.
	public void scrollToEndAction()

	{
		boolean canScrollMore;
		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap
					.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 3.0));
		} while (canScrollMore);
	}
	
	public void swipeAction(WebElement firstImage, String direction)
	{
		
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
				((RemoteWebElement) firstImage).getId(), "direction", direction, "percent", 0.75));

	}
	
	public double getFormattedAmount(String amount)
	{
		
		double price=Double.parseDouble(amount.substring(1));
		return price;
	}

	@AfterClass
	public void tearDown() {

		driver.quit();
		service.stop();
	}

}
