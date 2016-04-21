package pageObjects;
        import org.openqa.selenium.*;

import utility.Log;
    public class LogIn_Page extends BaseClass {
           private static WebElement element = null;
        
        public LogIn_Page(WebDriver driver){
            	super(driver);
        }     
        
        public static WebElement label_Logowanie() throws Exception{
        	try{
	            element = driver.findElement(By.xpath("//legend[.='Logowanie']"));
	            //Log.info("Username text box is found on the Login Page");
        	}catch (Exception e){
           		Log.error("Prawdopodobnie nie pokazała się strona logowania!!!");
           		throw(e);
           		}
           	return element;
            }
        
        public static WebElement txtbx_UserName() throws Exception{
        	try{
	            element = driver.findElement(By.id("txtUserName"));
	            //Log.info("Username text box is found on the Login Page");
        	}catch (Exception e){
           		Log.error("Pole UserName nie zostało znalezione!!!");
           		throw(e);
           		}
           	return element;
            }
        
        public static WebElement txtbx_Password() throws Exception{
        	try{
	        	element = driver.findElement(By.id("txtUserPass"));
	            //Log.info("Password text box is found on the Login page");
        	}catch (Exception e){
        		Log.error("Pole Password nie zostało znalezione!!!");
           		throw(e);
           		}
           	return element;
        }
        
        public static WebElement radiobtn_authMethod() throws Exception{
        	try{
	        	element = driver.findElement(By.id("rbtnAuthorizationTp_1"));
	            //Log.info("Submit button is found on the Login page");
        	}catch (Exception e){
        		Log.error("Radio button wyboru metody autoryzacji nie został znaleziony!!!");
           		throw(e);
           		}
           	return element;
        }
        
        public static WebElement btn_LogIn() throws Exception{
        	try{
	        	element = driver.findElement(By.name("cmdLogin"));
	        	Log.info("Przycisk Login został znaleziony");
        	}catch (Exception e){
        		Log.error("Przycisk Login nie został znaleziony!!!");
           		throw(e);
           		}
           	return element;
        }
    }
