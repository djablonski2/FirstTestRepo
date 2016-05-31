package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utility.Log;

public class RealiztionSearch_Page extends BaseClass {
	private static WebElement element = null;

	public RealiztionSearch_Page(WebDriver driver) {
		super(driver);
	}

	public static WebElement txt_Realizacja() throws Exception {
		try {
			element = driver.findElement(By.id("RealizationNumber"));
			Log.info("Pole Realizacja zostało znalezione");
		} catch (Exception e) {
			Log.error("Nie znaleziono Realizacja!!!");
			throw (e);
		}
		return element;
	}
    public static WebElement txt_Klient() throws Exception{
    	try{
            element = driver.findElement(By.id("CustomerName"));
       		Log.info("Znaleziono pole Klient");
    	}catch (Exception e){
       		Log.error("Pole Klient nie zostało znalezione!!!");
       		throw(e);
       		}
       	return element;
        }
    public static WebElement txt_OrderID() throws Exception{
    	try{
            element = driver.findElement(By.id("OrderId"));
       		Log.info("Znaleziono pole OrderID");
    	}catch (Exception e){
       		Log.error("Pole OrderID nie zostało znalezione!!!");
       		throw(e);
       		}
       	return element;
        }
    public static WebElement txt_ServiceID() throws Exception{
    	try{
            element = driver.findElement(By.id("ServiceId"));
       		Log.info("Znaleziono pole ServiceID");
    	}catch (Exception e){
       		Log.error("Pole ServiceID nie zostało znalezione!!!");
       		throw(e);
       		}
       	return element;
        }
    public static WebElement txt_QuoteID() throws Exception{
    	try{
            element = driver.findElement(By.id("Quote"));
       		Log.info("Znaleziono pole QuoteID");
    	}catch (Exception e){
       		Log.error("Pole QuoteID nie zostało znalezione!!!");
       		throw(e);
       		}
       	return element;
        }
    public static WebElement txt_Tag() throws Exception{
    	try{
            element = driver.findElement(By.id("Tag"));
       		Log.info("Znaleziono pole Tag");
    	}catch (Exception e){
       		Log.error("Pole Tag nie zostało znalezione!!!");
       		throw(e);
       		}
       	return element;
        }
	
	/***
	 * Metoda klikająca w pole PM - umożliwiające wybór PM do którego przypisana jest realizacja
	 * @return WebElement
	 * @throws Exception
	 */
	public static WebElement txt_PM() throws Exception {
		try {
			element = driver.findElement(By.xpath("//div[@id='AssignedTo_chosen']/ul/li/input[@type='text']"));
			Log.info("Znaleziono pol PM");
		} catch (Exception e) {
			Log.error("Nie znaleziono pola PM!!!");
			throw (e);
		}
		return element;
	}
	/***
	 * Metoda wybierająca z listy PMów tego, którego częściowy string jest wpisany w parametrze
	 * @param AssignedTo - wybierze PMa zawierającego ten ciąg znaków; case sensitive
	 * @return WebElement
	 * @throws Exception
	 */
	public static WebElement txt_PMFillUp(String AssignedTo) throws Exception {
		try {
			element = driver.findElement(By.xpath("//div[@id='AssignedTo_chosen']/div/ul/li[contains(.,'"+AssignedTo+"')]"));
			Log.info("Wybrano PMa");
		} catch (Exception e) {
			Log.error("Na liście PMa nie znaleziono "+AssignedTo+"!!!");
			throw (e);
		}
		return element;
	}
	
	/***
	 * Metoda klikająca w pole Status - umożliwiające wybór Statusu szukanych calli
	 * @return WebElement
	 * @throws Exception
	 */
	public static WebElement txt_Status() throws Exception {
		try {
			element = driver.findElement(By.xpath("//div[@id='Status_chosen']/ul/li/input[@type='text']"));
			Log.info("Znaleziono pol Status");
		} catch (Exception e) {
			Log.error("Nie znaleziono pola Status!!!");
			throw (e);
		}
		return element;
	}
	/***
	 * Metoda wybierająca z listy Statusów 
	 * @param status - wybierze Status zawierającego ten ciąg znaków; case sensitive
	 * @return WebElement
	 * @throws Exception
	 */
	public static WebElement txt_StatusFillUp(String status) throws Exception {
		try {
			element = driver.findElement(By.xpath("//div[@id='Status_chosen']/div/ul/li[contains(.,'"+status+"')]"));
			Log.info("Wybrano Status");
		} catch (Exception e) {
			Log.error("Na liście Statusów nie znaleziono "+status+"!!!");
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
	
	public static WebElement lnk_StareRealizacje() throws Exception {
		try {
			element = driver.findElement(By.xpath("//a[.='Stare realizacje']"));
			Log.info("Link Stare realizacje został znaleziony");
		} catch (Exception e) {
			Log.error("Nie znaleziono linku Stare realizacje!!!");
			throw (e);
		}
		return element;
	}
	
	public static WebElement lnk_NoweRealizacje() throws Exception {
		try {
			element = driver.findElement(By.xpath("//a[.='Nowe realizacje']"));
			Log.info("Link Nowe realizacje został znaleziony");
		} catch (Exception e) {
			Log.error("Nie znaleziono linku Nowe realizacje!!!");
			throw (e);
		}
		return element;
	}
}
