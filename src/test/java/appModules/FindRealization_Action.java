package appModules;

import org.openqa.selenium.Alert;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import pageObjects.CallDetails_Page;
import pageObjects.Home_Page;
import pageObjects.LogIn_Page;
import pageObjects.RealiztionSearch_Page;
import utility.Constant;
import utility.Log;
import utility.Utils;

public class FindRealization_Action {

	public static void Execute(String RealizationID) throws Exception {

		Home_Page.lnk_topMenu_Realizacje().click();
		RealiztionSearch_Page.txt_Realizacja().sendKeys(RealizationID);
		Log.info("Wyszukiwanie projektu po RealizationID");
		
		RealiztionSearch_Page.btn_Szukaj().click();
		Log.info("Projekt o ID: " + RealizationID + " został wyszukany");
		
		
		RealiztionSearch_Page.cell_JTable_NrRealizacji(RealizationID).click();
		
		
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
