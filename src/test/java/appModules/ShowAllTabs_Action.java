package appModules;

import pageObjects.Home_Page;
import utility.Constant;
import utility.Log;
import utility.Utils;

public class ShowAllTabs_Action {
	static String sActionName = "_ShowAllTabsAction";

	public static void Execute(String sTestCaseName) throws Exception {

		Home_Page.lnk_topMenu_Klienci().click();
		Log.info("Wyświetlenie zakładki Klienci");
		//Utils.takeScreenshot(sTestCaseName+sActionName + "_Klienci");
		
		Home_Page.lnk_topMenu_Realizacje().click();
		Log.info("Wyświetlenie zakładki Realizacje");
		//Utils.takeScreenshot(sTestCaseName+sActionName + "_Realizacje");

		Home_Page.lnk_topMenu_Zgloszenia().click();
		Log.info("Wyświetlenie zakładki Zgłoszenia");
		//Utils.takeScreenshot(sTestCaseName+sActionName + "_Zgłoszenia");

		Home_Page.lnk_topMenu_Kolejki().click();
		Log.info("Wyświetlenie zakładki Kolejki");
		//Utils.takeScreenshot(sTestCaseName+sActionName + "_Kolejki");

		Home_Page.lnk_topMenu_Costing().click();
		Log.info("Wyświetlenie zakładki Costning");
		//Utils.takeScreenshot(sTestCaseName+sActionName + "_Costing");

		Home_Page.lnk_topMenu_Administracja().click();
		Thread.sleep(1000);
		Log.info("Wyświetlenie zakładki Administracja");
		//Utils.takeScreenshot(sTestCaseName+sActionName + "_Administracja");

		// Utils.waitForElement(Home_Page.lnk_ProfilName());

		Log.info("Wyświetlono wszystkie zakładki");

	}


}
