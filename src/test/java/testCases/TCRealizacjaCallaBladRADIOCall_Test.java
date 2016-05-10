package testCases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import appModules.FindCall_Action;
import appModules.FindRealization_Action;
import appModules.LogOut_Action;
import appModules.ShowAllTabs_Action;
import appModules.LogIn_Action;
import pageObjects.BaseClass;
import pageObjects.CallDetails_Page;
import pageObjects.RealizationDetails_Page;
import utility.Constant;
import utility.Log;
import utility.Utils;

/***
 * Test tworzący nowy call RADIO w wybranym projekcie i sprawdzajacy czy nie pojawia się błąd przy jego realizacji.
 * Redmine #760 - http://redmine.nexio.pl/issues/760
 */
public class TCRealizacjaCallaBladRADIOCall_Test {

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
			
			FindRealization_Action.Execute(Constant.REALIZATION_ID_FAIL_REALIZATION);
			RealizationDetails_Page.tab_ZleceniaTechniczne().click();
			
			RealizationDetails_Page.lst_tabZlecTech_typZlecenia("Zamówienie transmisji RL II");
			
			RealizationDetails_Page.lst_tabZlecTech_wybierzUsluge().click();
			RealizationDetails_Page.opt_lst_tabZlecTech_wybierzUsluge(1).click();
			RealizationDetails_Page.btn_lst_tabZlecTech_wybierzUsluge_OK().click();
			
			RealizationDetails_Page.btn_tabZlecTech_dodajNoweZlecenie().click();
			
			//należy ukryć topMenu bo zasłania element który trzeba kliknąć
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("document.getElementById('topNav').style.display = 'none';");

			CallDetails_Page.rbtn_adrInsUsl_AEnd_Wezel().click();
			
			Utils.detectAlert();
			CallDetails_Page.lst_adrInsUsl_AEnd("Bełchatów (Kwiatowa 1) - 6052");
			CallDetails_Page.lst_adrInsUsl_BEnd("Białystok (TP Emitel Cieszyńska 3) - 9001");
			
			CallDetails_Page.txt_daneTech_Bandwidth().clear();
			CallDetails_Page.txt_daneTech_Bandwidth().sendKeys("40000");
			CallDetails_Page.lst_daneTech_RLType("BAS - 26GHz");
			CallDetails_Page.lst_daneTech_Port("G703");
			CallDetails_Page.txt_daneTech_WspolGeog_Szer().sendKeys("00 00 00.0");
			CallDetails_Page.txt_daneTech_WspolGeog_Dlug().sendKeys("00 00 00.0");
			Utils.takeScreenshot(sTestCaseName+"_uzup_Call_RL");
			//należy ukryć topMenu bo zasłania element który trzeba kliknąć
			js.executeScript("document.getElementById('topNav').style.display = 'none';");
			Log.info(CallDetails_Page.legend_SzczegolyZlecenia().getText());
			CallDetails_Page.btn_PostepyInstalacji_DoRealizacji().click();
			
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
