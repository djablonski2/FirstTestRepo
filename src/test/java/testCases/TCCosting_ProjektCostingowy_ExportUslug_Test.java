package testCases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import appModules.LogOut_Action;
import appModules.LogIn_Action;
import pageObjects.BaseClass;
import pageObjects.CostingSearch_Page;
import pageObjects.CostingProjDetails_Page;
import pageObjects.Home_Page;
import pageObjects.QueuesSearch_Page;
import utility.Constant;
import utility.Log;
import utility.Utils;

public class TCCosting_ProjektCostingowy_ExportUslug_Test {
	public WebDriver driver;
	private String sTestCaseName;
	

	@BeforeMethod
	public void beforeMethod() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		sTestCaseName = this.toString();
		sTestCaseName = Utils.getTestCaseName(this.toString());
		Log.startTestCase(sTestCaseName);
		driver = Utils.OpenBrowser(Utils.selectEnvJenkins());//Utils.selectEnvJenkins()-pobranie środowiska z Jenkins, 1-clientele DEV, 2-clientele VIRT
		new BaseClass(driver);
	}

	@Test
	public void main() throws Exception {
		try {
			LogIn_Action.Execute();
			Home_Page.lnk_topMenu_Costing().click();
			Thread.sleep(1000);
			Log.info("Wyświetlenie zakładki Costing");
			
			CostingSearch_Page.txt_NrWyceny().click();
			CostingSearch_Page.txt_NrWyceny().sendKeys(Constant.COST_PROJ_ID_XLS_CHECK);
			
			CostingSearch_Page.txt_Kolejka_Osoba().click();
			CostingSearch_Page.txt_Kolejka_OsobaFillUp("--").click();
			
			QueuesSearch_Page.btn_Szukaj().click();
			
			CostingSearch_Page.cell_JTable_NrWyceny(Constant.COST_PROJ_ID_XLS_CHECK).click();
			
			Utils.takeScreenshot(sTestCaseName+ "_CostingProjDetails_"+Constant.COST_PROJ_ID_XLS_CHECK);
			
			//należy ukryć topMenu bo zasłania element który trzeba kliknąć
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("document.getElementById('topNav').style.display = 'none';");
			Thread.sleep(2000);
			CostingProjDetails_Page.btn_ExportToExcel().click();
			Log.info("Przycisk Export To Excel został kliknięty");
			driver.navigate().refresh();
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