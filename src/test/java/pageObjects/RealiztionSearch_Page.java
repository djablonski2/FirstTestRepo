package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;

public class RealiztionSearch_Page extends BaseClass {
	private static WebElement element = null;

	public RealiztionSearch_Page(WebDriver driver) {
		super(driver);
	}

	public static WebElement txt_Realizacja() throws Exception {
		try {
			element = driver.findElement(By.xpath("//input[@id='RealizationNumber']"));
			Log.info("Pole Realizacja zostało znalezione");
		} catch (Exception e) {
			Log.error("Nie znaleziono Realizacja!!!");
			throw (e);
		}
		return element;
	}
	
//	public static WebElement txt_Kolejka_OsobaFillUp(String WorkingUser) throws Exception {
//		try {
//			element = driver.findElement(By.xpath("//div[@id='AssignedTo_chosen']/div/ul/li[contains(.,'"+WorkingUser+"')]"));
//			Log.info("Pole Kolejka/Osoba zostało uzupełnione");
//		} catch (Exception e) {
//			Log.error("Nie uzupełniono pola Kolejka/Osoba!!!");
//			throw (e);
//		}
//		return element;
//	}

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
	
	public static WebElement cell_JTable_NrRealizacji(String NrRealizacji) throws Exception {
		try {
			element = driver.findElement(By.xpath("//table[@class='jtable']//td[.='"+NrRealizacji+"']"));
			Log.info("Realizacja o ID: "+NrRealizacji+" została znaleziona");
		} catch (Exception e) {
			Log.error("Nie znaleziono realizacji o podanym ID: "+NrRealizacji+"!!!");
			throw (e);
		}
		return element;
	}
	
	
}
