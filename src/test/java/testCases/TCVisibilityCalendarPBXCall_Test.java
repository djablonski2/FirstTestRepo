package testCases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import appModules.FindCall_Action;
import appModules.LogOut_Action;
import appModules.ShowAllTabs_Action;
import appModules.LogIn_Action;
import pageObjects.BaseClass;
import pageObjects.CallDetails_Page;
import utility.Constant;
import utility.Log;
import utility.Utils;

public class TCVisibilityCalendarPBXCall_Test {
	/***
	 * Testowanie widoczności kalendarza w polu "Oczekiwany termin uruchomienia usługi dla klienta(wypełnia PM):"
	 * w zgłoszeniach PBX Request.
	 */

	public WebDriver driver;
	private String sTestCaseName;
	
	@BeforeMethod
	public void beforeMethod() throws Exception {
	
		DOMConfigurator.configure("log4j.xml");
		sTestCaseName = this.toString();
		sTestCaseName = Utils.getTestCaseName(this.toString());
		Log.startTestCase(sTestCaseName);
		driver = Utils.OpenBrowser(Utils.selectEnvJenkins()); //Utils.selectEnvJenkins()-pobranie środowiska z Jenkins, 1-clientele DEV, 2-clientele VIRT
		new BaseClass(driver);
	}
	
	@Test
	public void main() throws Exception {
		try {
			LogIn_Action.Execute();
			FindCall_Action.Execute(Constant.CALL_ID_CALENDAR_CHECK);
			FindCall_Action.CheckVisibilityCalendarOczekiwanyTermin();
			Utils.takeScreenshot(sTestCaseName);
			LogOut_Action.Execute_expectedAlert();

		} catch (Exception e) {
			Utils.takeScreenshot(sTestCaseName+"_ERR");
			Log.error(e.getMessage());
			throw (e);
		}
	}

	@AfterMethod
	public void afterMethod() {
		Log.endTestCase(sTestCaseName);
		driver.close();
	}
	
}
