package testCases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import appModules.AddNewCall_Action;
import appModules.FillNewCall_Action;
import appModules.FindCall_Action;
import appModules.FindRealization_Action;
import appModules.LogOut_Action;
import appModules.LogIn_Action;
import pageObjects.BaseClass;
import pageObjects.CallDetails_Page;
import pageObjects.RealizationDetails_Page;
import utility.Constant;
import utility.Log;
import utility.Utils;

/***
 * Test tworzący nowy call RL w wybranym projekcie i przechodzący kolejne etapy procesu.
 * 
 */
public class TCProcessingCall_RL_Test {

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

			FindRealization_Action.Execute(Constant.REALIZATION_ID);
			RealizationDetails_Page.tab_ZleceniaTechniczne().click();
				//należy ukryć topMenu bo zasłania element który trzeba kliknąć
				JavascriptExecutor js = ((JavascriptExecutor) driver);
				js.executeScript("document.getElementById('topNav').style.display = 'none';");
			AddNewCall_Action.Execute("Zamówienie transmisji RL II",2);
				js.executeScript("document.getElementById('topNav').style.display = 'none';");
			FillNewCall_Action.Execute_RL("Bełchatów (Kwiatowa 1) - 6052", "Białystok (TP Emitel Cieszyńska 3) - 9001", 
					"40000", "BAS - 26GHz", "G703", "00 00 00.0", "00 00 00.0");
			js.executeScript("document.getElementById('topNav').style.display = 'none';");
			String NrZlecenia = CallDetails_Page.legend_NrZlecenia().getText();
			Log.info("Numer utworzonego zlecenia to: " + NrZlecenia
					+ " a jego typ to: " + CallDetails_Page.legend_TypZlecenia().getText() );
			CallDetails_Page.btn_PostepyInstalacji_DoRealizacji().click();
			RealizationDetails_Page.txt_tabZlecTech_statusZlecenia(NrZlecenia);
			
				js.executeScript("document.getElementById('topNav').style.display = 'none';");
			RealizationDetails_Page.lnk_tabZlecTech_nrZlecenia(NrZlecenia).click();
			CallDetails_Page.btn_PrzejmijZgloszenie().click();
				js.executeScript("document.getElementById('topNav').style.display = 'none';");
			CallDetails_Page.btn_PostepyInstalacji_DoPodwykonawcy().click();
			RealizationDetails_Page.txt_tabZlecTech_statusZlecenia(NrZlecenia);
			
				js.executeScript("document.getElementById('topNav').style.display = 'none';");
			RealizationDetails_Page.lnk_tabZlecTech_nrZlecenia(NrZlecenia).click();
				js.executeScript("document.getElementById('topNav').style.display = 'none';");
			CallDetails_Page.btn_PostepyInstalacji_DoneZainstalowano().click();
			RealizationDetails_Page.txt_tabZlecTech_statusZlecenia(NrZlecenia);
			
			js.executeScript("document.getElementById('topNav').style.display = 'none';");
			RealizationDetails_Page.lnk_tabZlecTech_nrZlecenia(NrZlecenia).click();
				js.executeScript("document.getElementById('topNav').style.display = 'none';");
			CallDetails_Page.btn_PostepyInstalacji_Zrealizuj().click();
			RealizationDetails_Page.txt_tabZlecTech_statusZlecenia(NrZlecenia);
			
			js.executeScript("document.getElementById('topNav').style.display = 'none';");
			RealizationDetails_Page.lnk_tabZlecTech_nrZlecenia(NrZlecenia).click();
			CallDetails_Page.btn_PrzejmijZgloszenie().click();
				js.executeScript("document.getElementById('topNav').style.display = 'none';");
			CallDetails_Page.btn_PostepyInstalacji_UruchomTransmisje().click();
			RealizationDetails_Page.txt_tabZlecTech_statusZlecenia(NrZlecenia);

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
