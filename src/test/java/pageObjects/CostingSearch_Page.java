package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;

public class CostingSearch_Page extends BaseClass {
	private static WebElement element = null;

	public CostingSearch_Page(WebDriver driver) {
		super(driver);
	}

	public static WebElement txt_NrWyceny() throws Exception {
		try {
			element = driver.findElement(By.xpath("//input[@id='CostingProjectId']"));
			Log.info("Pole Nr wyceny Clientele zostało znalezione");
		} catch (Exception e) {
			Log.error("Nie znaleziono pola Nr wyceny Clientele!!!");
			throw (e);
		}
		return element;
	}
	

	public static WebElement txt_Kolejka_Osoba() throws Exception {
		try {
			element = driver.findElement(By.xpath("//div[@id='AssignedTo_chosen']"));
			Log.info("Pole Kolejka/Osoba zostało znalezione");
		} catch (Exception e) {
			Log.error("Nie znaleziono pola Kolejka/Osoba!!!");
			throw (e);
		}
		return element;
	}
	
	public static WebElement txt_Kolejka_OsobaFillUp(String WorkingUser) throws Exception {
		try {
			element = driver.findElement(By.xpath("//div[@id='AssignedTo_chosen']/div/ul/li[contains(.,'"+WorkingUser+"')]"));
			Log.info("Pole Kolejka/Osoba zostało uzupełnione");
		} catch (Exception e) {
			Log.error("Nie uzupełniono pola Kolejka/Osoba!!!");
			throw (e);
		}
		return element;
	}

	public static WebElement txt_Nazwa_Klienta() throws Exception {
		try {
			element = driver.findElement(By.xpath("//div[@id='CustomerName_chosen']"));
			Log.info("Pole Nazwa Klienta zostało znalezione");
		} catch (Exception e) {
			Log.error("Nie znaleziono pola Nazwa Klienta!!!");
			throw (e);
		}
		return element;
	}

	public static WebElement txt_Nazwa_KlientaFillUp(String CostingProjectStatus) throws Exception {
		try {
			element = driver.findElement(By.xpath("//div[@id='CustomerName_chosen']/div/ul/li[contains(.,'"+CostingProjectStatus+"')]"));
			Log.info("Pole Nazwa Klienta zostało uzupełnione");
		} catch (Exception e) {
			Log.error("Nie uzupełniono pola Nazwa Klienta!!!");
			throw (e);
		}
		return element;
	}

	public static WebElement txt_Status() throws Exception {
		try {
			element = driver.findElement(By.xpath("//div[@id='selectedStatuses_chosen']/ul/li/input[@type='text']"));
			Log.info("Pole Status zostało znalezione");
		} catch (Exception e) {
			Log.error("Nie znaleziono pola Status!!!");
			throw (e);
		}
		return element;
	}

	public static WebElement txt_StatusFillUp(String CostingProjectStatus) throws Exception {
		try {
			element = driver.findElement(By.xpath("//div[@id='selectedStatuses_chosen']/div/ul/li[contains(.,'"+CostingProjectStatus+"')]"));
			Log.info("Pole Status zostało uzupełnione");
		} catch (Exception e) {
			Log.error("Nie uzupełniono pola Status!!!");
			throw (e);
		}
		return element;
	}
	
	public static WebElement btn_Szukaj() throws Exception {
		try {
			element = driver.findElement(By.xpath("//button[.='Szukaj']"));
			Log.info("Przycisk Szukaj został znaleziony");
		} catch (Exception e) {
			Log.error("Nie znaleziono przycisku Szukaj!!!");
			throw (e);
		}
		return element;
	}
	
	public static WebElement cell_JTable_NrWyceny(String NrWyceny) throws Exception {
		try {
			element = driver.findElement(By.xpath("//table[@class='jtable']//td[.='"+NrWyceny+"']"));
			Log.info("Wycena o ID: "+NrWyceny+" została znaleziona");
		} catch (Exception e) {
			Log.error("Nie znaleziono wyceny o podanym ID: "+NrWyceny+"!!!");
			throw (e);
		}
		return element;
	}
	
}
