package homework;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class CalculatorPrac {

	public static void main(String[] args) throws MalformedURLException, URISyntaxException, InterruptedException {

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformName", "Android");
		dc.setCapability("automationName", "UiAutomator2");
		dc.setCapability("appPackage", "com.google.android.calculator");
		dc.setCapability("appActivity", "com.android.calculator2.Calculator");

		AppiumDriver driver = new AppiumDriver(new URI("http://127.0.0.1:4723/").toURL(), dc);

		Thread.sleep(2);
		driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_5")).click();
		driver.findElement(AppiumBy.id("com.google.android.calculator:id/op_add")).click();
		driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_3")).click();

		// get the result and print it
		Thread.sleep(2);
		String additionResult = driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_preview"))
				.getText();
		System.out.println("Addition of 5 & 3 is " + additionResult);
		driver.findElement(AppiumBy.id("com.google.android.calculator:id/clr")).click();
		Thread.sleep(2);

		driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_" + additionResult)).click();
		driver.findElement(AppiumBy.id("com.google.android.calculator:id/op_mul")).click();
		String numberToBeMultiplied = "15";
		for (char each : numberToBeMultiplied.toCharArray()) {
			driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_" + each)).click();
		}
		Thread.sleep(2);
		String multiplicationResult = driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_preview"))
				.getText();
		System.out.println(
				"Multiplication of " + additionResult + " & " + numberToBeMultiplied + " is " + multiplicationResult);
		driver.quit();

	}
}
