package pageObjects;
        import org.openqa.selenium.*;

import utility.Log;
    public class CallDetails_Page extends BaseClass {
           private static WebElement element = null;
        
        public CallDetails_Page(WebDriver driver){
            	super(driver);
        }     

        public static WebElement legend_SzczegolyZlecenia() throws Exception{
        	try{
	            element = driver.findElement(By.xpath("//legend[.='Szczegóły zlecenia']"));
        	}catch (Exception e){
           		Log.error("Prawdopodobnie zgłoszenie o podanym ID nie zostało znalezione!!!");
           		throw(e);
           		}
           	return element;
            }
        
        public static WebElement txt_CallIdInCallDetails() throws Exception{
        	try{
	            element = driver.findElement(By.xpath("//span[@id='_ctl1__ctl0_PBX_ConfCallNo']"));
	            //Log.info("Username text box is found on the Login Page");
        	}catch (Exception e){
           		Log.error("Prawdopodobnie nie pokazała się strona logowania!!!");
           		throw(e);
           		}
           	return element;
            }

        public static WebElement txt_OczekiwanyTermin() throws Exception{
        	try{
	            element = driver.findElement(By.xpath("//input[@id='_ctl1__ctl0_txtOczekiwanyTermin']"));
	            //Log.info("Username text box is found on the Login Page");
        	}catch (Exception e){
           		//Log.error("Prawdopodobnie nie pokazała się strona logowania!!!");
           		throw(e);
           		}
           	return element;
        }
        
        public static WebElement module_CalendarXDSoft() throws Exception{
        	try{
	            element = driver.findElement(By.xpath("//div[@class='xdsoft_datetimepicker xdsoft_noselect xdsoft_']"));
	            //Log.info("Username text box is found on the Login Page");
        	}catch (Exception e){
           		//Log.error("Prawdopodobnie nie pokazała się strona logowania!!!");
           		throw(e);
           		}
           	return element;
            }
    }
