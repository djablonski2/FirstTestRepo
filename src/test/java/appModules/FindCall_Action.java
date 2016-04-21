package appModules;

import org.openqa.selenium.Alert;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import pageObjects.CallDetails_Page;
import pageObjects.Home_Page;
import pageObjects.LogIn_Page;
import utility.Constant;
import utility.Log;
import utility.Utils;

public class FindCall_Action {

	public static void Execute(String CallID) throws Exception {

		Home_Page.txt_CallID().sendKeys(CallID);
		Home_Page.btn_SearchCallID().click();
		Log.info("Wyszukiwanie zgłoszenia po CallID");

		Utils.waitForElement(CallDetails_Page.legend_SzczegolyZlecenia());

		Log.info("Zgłoszenie o ID: " + CallID + " zostało wyszukane");

	}

	public static void CheckVisibilityCalendarOczekiwanyTermin() throws Exception {

		CallDetails_Page.txt_OczekiwanyTermin().clear();
		
		try {
			CallDetails_Page.module_CalendarXDSoft().isDisplayed();
			Thread.sleep(1000);
			Log.info("Kalendarz umożliwiający wybór oczekiwanego terminu zakończenia został wyświetlony");
			//Utils.takeScreenshot("FindCall_IsCalendarDisplayed");

		} catch (Exception e) {
			Log.info("Kalendarz umożliwiający wybór oczekiwanego terminu zakończenia NIE został wyświetlony !!!");
			throw (e);
		}

	}
}
