package com.restAssured.testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.restAssured.utilities.ConfigsReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
	private static WebDriver driver;

	public static final WebDriver getDriver() {

		if (driver == null) {

			String browser = System.getProperty("browser") != null ? System.getProperty("browser")
					: ConfigsReader.getProperty("browser");

			switch (browser.toLowerCase()) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "headless":
				DesiredCapabilities caps = new DesiredCapabilities();
				caps.setJavascriptEnabled(true);
				WebDriverManager.phantomjs().setup();
				driver = new PhantomJSDriver(caps);
				break;
			default:
				throw new RuntimeException("Browser is not supported");
			}
		}

//		driver.get(ConfigsReader.getProperty("url"));
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		PageInitializer.initialize();
		return driver;
	}

	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
