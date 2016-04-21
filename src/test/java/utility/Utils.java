package utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Utils {

	public static WebDriver driver = null;
	private static String element = null;
	//protected static DesiredCapabilities dCaps;

	/***
	 * Pobiera property ustawiane w pom.xml
	 */
	// String envChoiceJenkins = null;
	public static String getSysProperty_envChoiceJenkins() {
		String envChoiceJenkins = System.getProperty("envChoiceJenkins");
		if (envChoiceJenkins == null) {
			envChoiceJenkins = "środowisko nie zostało podane";
		}
		return envChoiceJenkins;
	}
	// static String envChoiceJenkins = System.getProperty("envChoiceJenkins");

	/***
	 * Na podstawie property pobranego z pom.xml ustawia adres środowiska
	 * 
	 * @return
	 */
	public static String selectEnvJenkins() {
		String URL = null;
		switch (getSysProperty_envChoiceJenkins()) {
		case "DEV":
			URL = Constant.ENV_URL_DEV;
			break;
		case "VIRT":
			URL = Constant.ENV_URL_VIRT;
			break;
		default:
			URL = Constant.ENV_URL_DEV;
		}
		return URL;
	}

	/***
	 * Otwiera driver na środowisku ustawionym przez {@code selectEnvJenkins}
	 * 
	 * @param envURL
	 * @return
	 * @throws Exception
	 */
	public static WebDriver OpenBrowser(String envURL) throws Exception {
		try {

	/** konfiguracja profilu Firefoxa ----> **/
			FirefoxProfile fprofile = new FirefoxProfile();
			
			fprofile.setPreference("browser.download.dir", Constant.PATH_DOWNLOAD_FILES);
			fprofile.setPreference("browser.download.folderList", 2);
			fprofile.setPreference("browser.helperApps.neverAsk.saveToDisk",
					"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;" + "application/pdf;"
							+ "application/vnd.openxmlformats-officedocument.wordprocessingml.document;" + "text/plain;"
							+ "text/csv");
			fprofile.setPreference("browser.download.manager.showWhenStarting", false);
			fprofile.setPreference("pdfjs.disabled", true);
	/** <----- **/

	/** konfiguracja drivera PhantomJS ----> **/		
//			dCaps = new DesiredCapabilities();
//			dCaps.setJavascriptEnabled(true);
//			dCaps.setCapability("phantomjs.binary.path", Constant.PATH_PHANTOMJS_EXE_FILE);
//			driver = new PhantomJSDriver(dCaps);
	/** <----- **/
	
	/** konfiguracja drivera webdriver ----> **/		
			driver = new FirefoxDriver(fprofile);
			driver.manage().window().setSize(Constant.BROWSER_RES);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Constant.DRIVER_IMPLICITLY_WAIT_SEC, TimeUnit.SECONDS);
	/** <----- **/
			//driver.get(Constant.URL);
			Log.info("Driver został uruchomiony");
			driver.get(envURL);
		} catch (Exception e) {
			Log.error("Class Utils | Method OpenBrowser | Exception desc : " + e.getMessage());
		}
		return driver;
	}


	public static WebDriver OpenBrowser(int envSelect) throws Exception {
		try {
			driver = new FirefoxDriver();
			driver.manage().window().setSize(Constant.BROWSER_RES);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Constant.DRIVER_IMPLICITLY_WAIT_SEC, TimeUnit.SECONDS);
			//driver.get(Constant.URL);
			String URL = null;
			switch (envSelect) { // 1-clientele DEV, 2-clientele VIRT
			case 1:
				URL = Constant.ENV_URL_DEV;
				break;
			case 2:
				URL = Constant.ENV_URL_VIRT;
				break;
			}
			driver.get(URL);
			Log.info("Driver został uruchomiony");

		} catch (Exception e) {
			Log.error("Class Utils | Method OpenBrowser | Exception desc : " + e.getMessage());
		}
		return driver;
	}

	public static String getTestCaseName(String sTestCase) throws Exception {
		String value = sTestCase;
		try {
			int posi = value.indexOf("@");
			value = value.substring(0, posi);
			posi = value.lastIndexOf(".");
			value = value.substring(posi + 1);
			return value;
		} catch (Exception e) {
			Log.error("Class Utils | Method getTestCaseName | Exception desc : " + e.getMessage());
			throw (e);
		}
	}

	public static void mouseHoverAction(WebElement mainElement, String subElement) {

		Actions action = new Actions(driver);
		action.moveToElement(mainElement).perform();
		if (subElement.equals("Accessories")) {
			action.moveToElement(driver.findElement(By.linkText("Accessories")));
			Log.info("Accessories link is found under Product Category");
		}
		action.click();
		action.perform();
		Log.info("Click action is performed on the selected Product Type");
	}

	public static void waitForElement(WebElement element) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Constant.WAIT_FOR_ELEMENT_TO_BE_CLICKABLE_SEC);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			Log.error("Błąd przy oczekiwaniu na element");
			Log.error(e.getMessage());
			throw (e);
		}
	}

	public static String actualDate() {
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss");
		Date now = new Date();
		String strDate = sdfDate.format(now);
		return strDate;
	}

	public static boolean detectAlert() throws Exception  {
		try {
			Alert alert = driver.switchTo().alert();
			alert.getText();
			Log.info("Wykryto alert: " + alert.getText());
			alert.accept();
		} catch (NoAlertPresentException  e) {
			Log.error("Błąd przy wykrywaniu okna alertu");
			throw (e);
		} catch (Exception  e) {
			Log.error("Błąd przy wykrywaniu okna alertu");
			throw (e);
		}
		return true;
	}

	/***
	 * Metoda wykonująca screenshot ekranu
	 * @param sTestCaseName - parametr będzie częścią nazwy 
	 * @throws Exception
	 */
	public static void takeScreenshot(String sTestCaseName) throws Exception {
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile,
					new File(Constant.PATH_SCREENSHOT + actualDate() + "_" + sTestCaseName + ".png"));
		} catch (Exception e) {
			Log.error("Class Utils | Method takeScreenshot | Exception occured while capturing ScreenShot : "
					+ e.getMessage());
			throw new Exception();
		}
	}
	/***
	 * Metoda porównująca tekst elementu z podanym tekstem
	 * @param xpath - xpath elementu dla którego zostanie porównany tekst
	 * @param text - spodziewany tekst
	 */
	public static void doesElementContainText(String xpath, String text) {
		try {
			element = driver.findElement(By.xpath(xpath)).getText();
			Assert.assertEquals(text, element);
			Log.info("Element w xpath: "+ xpath +", zawiera wymagany tekst: " + text + ".");
		} catch (NoSuchElementException e) {
			Log.error("Podany element - xpath: "+ xpath +", nie zawiera tekstu: " + text + "!!!");
			
		}
	}
	/***
	 * Metoda porównująca tekst elementu z podanym tekstem
	 * @param webelement - webelement wybrany z wprowadzonych obiektów
	 * @param text - spodziewany tekst
	 */
	public static void doesElementContainText(WebElement webelement, String text) {
		try {
			element = webelement.getText();
			Assert.assertEquals(text, element);
			Log.info("Element zawiera wymagany tekst: " + text + ".");
		} catch (NoSuchElementException e) {
			Log.error("Tekst podanego webelementu nie zawiera tekstu: " + text + "!!!");
			
		}
	}
	
	
}
