package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;

public class QueuesSearch_Page extends BaseClass {
	private static WebElement element = null;

	public QueuesSearch_Page(WebDriver driver) {
		super(driver);
	}

	/***
	 * Metoda klikająca w pole Kolejki - umożliwiające wybór kolejki do której jest przypisany call
	 * @return WebElement
	 * @throws Exception
	 */
	public static WebElement txt_AssignedTo() throws Exception {
		try {
			element = driver.findElement(By.xpath("//div[@id='AssignedTo_chosen']/ul/li/input[@type='text']"));
		} catch (Exception e) {
			Log.error("Nie znaleziono pola Kolejki!!!");
			throw (e);
		}
		return element;
	}
	
	/***
	 * Metoda wybierająca z listy kolejek tę, której częściowy string jest wpisany w parametrze
	 * @param AssignedTo - wybierze kolejkę zawierającą ten ciąg znaków
	 * @return WebElement
	 * @throws Exception
	 */
	public static WebElement txt_AssignedToFillUp(String AssignedTo) throws Exception {
		try {
			element = driver.findElement(By.xpath("//div[@id='AssignedTo_chosen']/div/ul/li[contains(.,'"+AssignedTo+"')]"));
			Log.info("Wybranie Kolejki");
		} catch (Exception e) {
			Log.error("Na liście kolejek nie znaleziono "+AssignedTo+"!!!");
			throw (e);
		}
		return element;
	}
	
	/***
	 * Metoda klikająca w pole Working User - umożliwiające wybór użytkownika do którego jest przypisany call
	 * @return WebElement
	 * @throws Exception
	 */
	public static WebElement txt_WorkingUser() throws Exception {
		try {
			element = driver.findElement(By.xpath("//div[@id='WorkingUser_chosen']/ul/li/input[@type='text']"));
		} catch (Exception e) {
			Log.error("Nie znaleziono pola Working user!!!");
			throw (e);
		}
		return element;
	}
	
	/***
	 * Metoda wybierająca z listy użytkowników tego, którego częściowy string jest wpisany w parametrze
	 * @param WorkingUser - wybierze użytkownika zawierającą ten ciąg znaków
	 * @return WebElement
	 * @throws Exception
	 */
	public static WebElement txt_WorkingUserFillUp(String WorkingUser) throws Exception {
		try {
			element = driver.findElement(By.xpath("//div[@id='WorkingUser_chosen']/div/ul/li[contains(.,'"+WorkingUser+"')]"));
			Log.info("Wybranie Working usera");
		} catch (Exception e) {
			Log.error("Na liście kolejek nie znaleziono pola "+WorkingUser+"!!!");
			throw (e);
		}
		return element;
	}
	
	public static WebElement btn_Szukaj() throws Exception {
		try {
			element = driver.findElement(By.xpath("//button[.='Szukaj']"));
		} catch (Exception e) {
			Log.error("Nie znaleziono przycisku Szukaj!!!");
			throw (e);
		}
		return element;
	}
	
	public static WebElement txt_Klient() throws Exception {
		try {
			element = driver.findElement(By.xpath("//input[@id='CustomerName']"));
		} catch (Exception e) {
			Log.error("Nie znaleziono pola Klient!!!");
			throw (e);
		}
		return element;
	}
	
	public static WebElement lnk_StareKolejki() throws Exception {
		try {
			element = driver.findElement(By.xpath("//a[.='Stare kolejki']"));
			Log.info("Link Stare kolejki został znaleziony");
		} catch (Exception e) {
			Log.error("Nie znaleziono linku Stare Kolejki!!!");
			throw (e);
		}
		return element;
	}
	
	public static WebElement lnk_NoweKolejki() throws Exception {
		try {
			element = driver.findElement(By.xpath("//a[.='Nowe kolejki']"));
			Log.info("Link Nowe kolejki został znaleziony");
		} catch (Exception e) {
			Log.error("Nie znaleziono linku Nowe Kolejki!!!");
			throw (e);
		}
		return element;
	}
	
}
