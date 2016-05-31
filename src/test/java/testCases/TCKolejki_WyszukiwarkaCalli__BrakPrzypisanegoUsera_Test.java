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
import utility.Log;
import utility.Utils;

/**
 * Test sprawdzający czy po wyszukaniu calli po kolejce na liście znajdują się też kole bez przypisanych userów
 * @author Dominik Jabłoński
 */
public class TCKolejki_WyszukiwarkaCalli__BrakPrzypisanegoUsera_Test {
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
			
			Home_Page.lnk_topMenu_Kolejki().click();
			Thread.sleep(1000);
			Log.info("Wyświetlenie zakładki Costning");
			
			QueuesSearch_Page.txt_AssignedTo().click();
			QueuesSearch_Page.txt_AssignedToFillUp("5ESS").click();
			QueuesSearch_Page.btn_Szukaj().click();
			
			Utils.doesElementContainText("//table[@class='jtable']//tr[1]//td[9]", "");

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