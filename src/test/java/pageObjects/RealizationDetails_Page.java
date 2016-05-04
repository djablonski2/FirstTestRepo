package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utility.Log;

public class RealizationDetails_Page extends BaseClass {
	private static WebElement element = null;

	public RealizationDetails_Page(WebDriver driver) {
		super(driver);
	}

	public static WebElement tab_ZleceniaTechniczne() throws Exception {
		try {
			element = driver.findElement(By.xpath("//a[.='Zlecenia Techniczne']"));
			Log.info("Zakładka Zlecenia Techniczne została znaleziona");
		} catch (Exception e) {
			Log.error("Nie znaleziono zakładki Zlecenia Techniczne!!!");
			throw (e);
		}
		return element;
	}
	
	public static WebElement lst_tabZlecTech_typZlecenia(String usluga) throws Exception {
		try {
			Select dropdown = new Select(driver.findElement(By.id("_ctl0__ctl0_ddlCallType")));
			dropdown.selectByVisibleText(usluga);
			Log.info("Lista wyboru typu zlecenia i typ zlecenia: "+usluga+" została znaleziona");
		} catch (Exception e) {
			Log.error("Nie znaleziono Listy wyboru typu zlecenia lub typu zlecenia: "+usluga+"!!!");
			throw (e);
		}
		return element;
	}
	
/* Zastąpione przez jedną metodę
  	public static WebElement lst_tabZlecTech_typZlecenia() throws Exception {
		try {
			element = driver.findElement(By.xpath("//select[contains(@id,'ddlCallType')]"));
			Log.info("Lista wyboru typu zlecenia została znaleziona");
		} catch (Exception e) {
			Log.error("Nie znaleziono Listy wyboru typu zlecenia!!!");
			throw (e);
		}
		return element;
	}
	public static WebElement opt_lst_tabZlecTech_typZlecenia(String lstOption) throws Exception {
		try {
			element = driver.findElement(By.xpath("//option[contains(.,'"+lstOption+"')]"));
			Thread.sleep(1000);
			Log.info("Pozycja "+lstOption+" na liście wyboru typu zlecenia została znaleziona");
		} catch (Exception e) {
			Log.error("Nie znaleziono pozycji "+lstOption+" na liście wyboru typu zlecenia!!!");
			throw (e);
		}
		return element;
	}
	*/
	
	public static WebElement lst_tabZlecTech_wybierzUsluge() throws Exception {
		try {
			//element = driver.findElement(By.xpath("//div[contains(.,'Wybierz')]"));
			element = driver.findElement(By.xpath("//div[contains(@id,'ddchkUslugi_sl')]"));
			Log.info("Lista wyboru usługi została znaleziona");
		} catch (Exception e) {
			Log.error("Nie znaleziono listy wyboru usługi!!!");
			throw (e);
		}
		return element;
	}
	
	public static WebElement opt_lst_tabZlecTech_wybierzUsluge(Integer nrUslugiNaLiscie) throws Exception {
		try {
			element = driver.findElement(By.xpath("//div[@id='checks']/span[2]/label["+nrUslugiNaLiscie+"]"));
			Log.info("Wybrana usługa została znaleziona na liście");
		} catch (Exception e) {
			Log.error("Nie znaleziono usługi na liście wyboru!!!");
			throw (e);
		}
		return element;
	}
	
	public static WebElement btn_lst_tabZlecTech_wybierzUsluge_OK() throws Exception {
		try {
			element = driver.findElement(By.xpath("//input[@value='OK']"));
			Log.info("Przycisk OK na liście wyboru został znaleziony");
		} catch (Exception e) {
			Log.error("Nie znaleziono przycisku OK na liście wyboru!!!");
			throw (e);
		}
		return element;
	}
	
	public static WebElement btn_tabZlecTech_dodajNoweZlecenie() throws Exception {
		try {
			element = driver.findElement(By.xpath("//input[@value='Dodaj nowe zlecenie']"));
			Log.info("Przycisk Dodaj nowe zlecenie został znaleziony");
		} catch (Exception e) {
			Log.error("Nie znaleziono przycisku Dodaj nowe zlecenie!!!");
			throw (e);
		}
		return element;
	}
}
