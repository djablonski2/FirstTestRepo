package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;

public class CostingProjDetails_Page extends BaseClass {
	private static WebElement element = null;

	public CostingProjDetails_Page(WebDriver driver) {
		super(driver);
	}

	public static WebElement btn_ExportToExcel() throws Exception {
		try {
			element = driver.findElement(By.xpath("//button[@id='Export']"));
			Log.info("Przycisk Export To Excel został znaleziony");
		} catch (Exception e) {
			Log.error("Nie znaleziono przycisku Export To Excel!!!");
			throw (e);
		}
		return element;
	}
}
