package appModules;
import org.testng.Reporter;

import pageObjects.Home_Page;
import pageObjects.LogIn_Page;
import utility.Constant;
import utility.Log;
import utility.Utils;
     
    public class LogIn_Action {
    	
       public static void Execute() throws Exception{
    	   
    	    LogIn_Page.label_Logowanie().isDisplayed();
    	    
            LogIn_Page.txtbx_UserName().sendKeys(Constant.USERNAME);
            Log.info("Wpisanie użytkownika");
            
            LogIn_Page.txtbx_Password().sendKeys(Constant.PASSWORD);
            Log.info("Wpisanie hasła");
            
            LogIn_Page.radiobtn_authMethod().click();
            Log.info("Wybranie metody logowanie");
            
            LogIn_Page.btn_LogIn().click();
            Log.info("Kliknięcie przycisku logowania");
            
            Utils.waitForElement(Home_Page.lnk_ProfilName());
         
            /*Jeśli niepotrzebne jest wykywanie komunikatów to najlepiej wyłączyć wykrywanie - metoda logowania działa szybciej*/
           // Home_Page.act_closeNotifications();

            Reporter.log("Zalogowano do Clientele");
            Log.info("Zalogowano do Clientele");
            
        }
    }
