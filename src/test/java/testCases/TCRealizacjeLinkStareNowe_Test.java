package testCases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import appModules.LogOut_Action;
import appModules.LogIn_Action;
import pageObjects.BaseClass;
import pageObjects.Home_Page;
import pageObjects.RealiztionSearch_Page;
import utility.Log;
import utility.Utils;
/***
 * Kliknięcie linku Stare realizacje, kliknięcie Nowe realizacje - pojawia się bład 404
 * @author Dominik Jabłoński
 */
public class TCRealizacjeLinkStareNowe_Test {
	
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
			
			Home_Page.lnk_topMenu_Realizacje().click();
			RealiztionSearch_Page.lnk_StareRealizacje().click();
			Utils.takeScreenshot(sTestCaseName+"_StareRealizacje");
			RealiztionSearch_Page.lnk_NoweRealizacje().click();
			
			LogOut_Action.Execute();

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
