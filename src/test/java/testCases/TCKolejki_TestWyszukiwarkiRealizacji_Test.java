package testCases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import appModules.LogOut_Action;
import appModules.LogIn_Action;
import pageObjects.BaseClass;
import pageObjects.Home_Page;
import pageObjects.QueuesSearch_Page;
import pageObjects.RealiztionSearch_Page;
import utility.Log;
import utility.Utils;

public class TCKolejki_TestWyszukiwarkiRealizacji_Test {
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
			Thread.sleep(1000);
			
			Home_Page.lnk_topMenu_Realizacje().click();
			Thread.sleep(1000);
			
			RealiztionSearch_Page.txt_Realizacja().sendKeys("33234");
			RealiztionSearch_Page.btn_Szukaj().click();
			RealiztionSearch_Page.cell_JTable_NrRealizacji("33234").isDisplayed();
			
			RealiztionSearch_Page.txt_Realizacja().clear();
			RealiztionSearch_Page.txt_ServiceID().sendKeys("847152");
			RealiztionSearch_Page.btn_Szukaj().click();
			RealiztionSearch_Page.cell_JTable_NrRealizacji("33234").isDisplayed();
			
			RealiztionSearch_Page.txt_ServiceID().clear();
			RealiztionSearch_Page.txt_Klient().sendKeys("LIDL");
			RealiztionSearch_Page.txt_PM().click();
			RealiztionSearch_Page.txt_PMFillUp("Jabłoński").click();
			RealiztionSearch_Page.txt_Status().click();
			RealiztionSearch_Page.txt_StatusFillUp("W realizacji").click();
			RealiztionSearch_Page.btn_Szukaj().click();
			RealiztionSearch_Page.cell_JTable_NrRealizacji("33234").isDisplayed();

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