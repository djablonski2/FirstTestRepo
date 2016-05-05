package appModules;

import pageObjects.Home_Page;
import pageObjects.LogIn_Page;
import utility.Log;
import utility.Utils;

public class LogOut_Action {
	public static void Execute() throws Exception {

		Home_Page.lnk_LogOut().click();
		Log.info("Kliknięto LogOut");
		Thread.sleep(1000);
		Utils.waitForElement(LogIn_Page.btn_LogIn());
		Log.info("Wylogowano z Clientele");
	}

	public static void Execute_expectedAlert() throws Exception {

		Home_Page.lnk_LogOut().click();
		Thread.sleep(1000);

		if (Utils.detectAlert()) {
			Log.info("Zaakceptowano alert");
		} else {
			Home_Page.lnk_LogOut().click();
			Utils.waitForElement(LogIn_Page.btn_LogIn());
		}
		Log.info("Wylogowano z Clientele");
	}
}
