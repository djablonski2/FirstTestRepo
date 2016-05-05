package pageObjects;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.Log;
import utility.Utils;

    public class Home_Page extends BaseClass{
            private static WebElement element = null;
           
        public Home_Page(WebDriver driver){
            	super(driver);
        }    
        public static WebElement lnk_Profil() throws Exception{
            try{ 
            	element = driver.findElement(By.xpath("//input[@value='Profil']"));
	             //Log.info("My Account link is found on the Home Page");
            }catch (Exception e){
           		Log.error("Link Profil nie został znaleziony");
           		throw(e);
           		}
           	return element;
        }
        
        public static WebElement dialog_Window_Notification() throws Exception{
            try{ 
            	element = driver.findElement(By.xpath("//div[contains(@class,'bootstrap-dialog')]"));
	             //Log.info("My Account link is found on the Home Page");
            }catch (NoSuchElementException e){
           		Log.error("Brak komunikatów do zamknięcia");
            }catch (StaleElementReferenceException e){
           		Log.error("Brak komunikatów do zamknięcia");
           		}
           	return element;
        }
        
        public static WebElement btn_notification_ZamknijOkno() throws Exception{
        	try{
        		element = driver.findElement(By.xpath("//button[.='Zamknij okno.']"));
        		Log.info("Przycisk Zamknij okno zostało znalezione");
        	} catch (Exception e){
        		Log.error("Przycisk Zamknij okno nie zostało znalezione");
           		throw(e);
        	}
			return element;
        }

      //Obsługa zamykania komunikatów
    	public static void act_closeNotifications(){
    		List<WebElement> listNotif= driver.findElements(By.xpath("//button[.='Zamknij okno.']"));
    		//List<WebElement> listButtonByXPathClass= driver.findElements(By.xpath("//button[@class='btn btn-warning']"));
    		if (listNotif.size()>0) {
    			//for odlicza od góry do dołu bo elementy na ekranie pojawiają się w porządku odwrotnym
    			for(int i=listNotif.size()-1;i>=0;i--) {
    				listNotif.get(i).click(); 
    			}	
    			Log.info("Zamknieto powiadomienia");
    		} else {
//    		if (listNotif.size()>0) {
//    			for(int i=1;i<=listNotif.size();i++) {
//    				boolean Buttonstan = driver.findElement(By.xpath("//button[.='Zamknij okno.']")).isDisplayed();
//    				driver.findElement(By.xpath("//button[.='Zamknij okno.']")).click(); 
//    			}
    		Log.info("Brak powiadomień do zamknięcia");
    		}
    		
    	}
    	
        
        public static WebElement txt_CallID() throws Exception{
        	try{
        		element = driver.findElement(By.xpath("//input[@placeholder='Call ID...']"));
        		Log.info("Pole CallID zostało znalezione");
        	} catch (Exception e){
        		Log.error("Pole CallID nie zostało znalezione");
           		throw(e);
        	}
			return element;
        }
        
        public static WebElement btn_SearchCallID() throws Exception{
        	try{
        		element = driver.findElement(By.xpath("//*[@id='FindMenu1_FindCallPlugin1_btnFindCall2']"));
        		Log.info("Przycisk z lupką zostało znalezione");
        	} catch (Exception e){
        		Log.error("Przycisk z lupką nie zostało znalezione");
           		throw(e);
        	}
			return element;
        }
        
        public static WebElement lnk_LogOut() throws Exception{
            try{
            	Log.info("Szukanie linku Wyloguj ... ... ...");
            	//Utils.takeScreenshot("zrzut przed wylogowaniem");
            	driver.findElement(By.xpath("//span[contains(@class,'glyphicon-user')]")).click();
            	if (driver.findElements(By.xpath("//input[@value='Wyloguj']")).size()>0){
            		element = driver.findElement(By.xpath("//input[@value='Wyloguj']"));
                	Log.info("Znaleziono link Wyloguj.");
            	} else if (driver.findElements(By.xpath("//a[.='Wyloguj']")).size()>0){
            		element = driver.findElement(By.xpath("//a[.='Wyloguj']"));
                	Log.info("Znaleziono link Wyloguj.");
            	}
            	
            }catch (Exception e){
            	Log.error("Link Wyloguj nie został znaleziony");
           		throw(e);
           		}
           	return element;
        }
        
        public static WebElement lnk_ProfilName() throws Exception{
            try{
            	if (driver.findElements(By.xpath("//span[.='DJABLONSKI']")).size() > 0) {
            		element = driver.findElement(By.xpath("//span[.='DJABLONSKI']"));
            		Log.info("Link ProfilName (w tag Span) został znaleziony");
            	} else if (driver.findElements(By.xpath("//div[.='DJABLONSKI']")).size() > 0) {
            		element = driver.findElement(By.xpath("//div[.='DJABLONSKI']"));
            		Log.info("Link ProfilName (w tag Div) został znaleziony");
            	}
            }catch (Exception e){
            	Log.error("Link ProfilName nie został znaleziony!");
           		throw(e);
           		}
           	return element;
        }
        
        public static WebElement lnk_topMenu_Klienci() throws Exception{
            try{
            	element = driver.findElement(By.xpath("//*[@id='FindMenu1_ibtnCustomers']"));
            	Log.info("Link Klienci został znaleziony");
            }catch (Exception e){
            	Log.error("Link Klienci nie został znaleziony!");
           		throw(e);
           		}
           	return element;
        }
        
        public static WebElement lnk_topMenu_Realizacje() throws Exception{
            try{
            	element = driver.findElement(By.xpath("//*[@id='FindMenu1_ibtnProjects']"));
            	Log.info("Link Realizacje został znaleziony");
            }catch (Exception e){
            	Log.error("Link Realizacje nie został znaleziony!");
           		throw(e);
           		}
           	return element;
        }
        
        public static WebElement lnk_topMenu_Zgloszenia() throws Exception{
            try{
            	element = driver.findElement(By.xpath("//a[.='Zgłoszenia']"));
            	//element = driver.findElement(By.xpath("//*[@id='FindMenu1_imbtCalls']")); // było na realizacjach w WebForms'ach
            	Log.info("Link Zgłoszenia został znaleziony");
            }catch (Exception e){
            	Log.error("Link Zgłoszenia nie został znaleziony!");
           		throw(e);
           		}
           	return element;
        }
        
        public static WebElement lnk_topMenu_Kolejki() throws Exception{
            try{
            	element = driver.findElement(By.xpath("//input[@value='Kolejki']"));
            	Log.info("Link Kolejki został znaleziony");
            }catch (Exception e){
            	Log.error("Link Kolejki nie został znaleziony!");
           		throw(e);
           		}
           	return element;
        }
        
        public static WebElement lnk_topMenu_Costing() throws Exception{
            try{
            	if (driver.findElements(By.xpath("//*[@id='FindMenu1_btnCosting']")).size()>0) {
            		element = driver.findElement(By.xpath("//*[@id='FindMenu1_btnCosting']"));
                	Log.info("Link Costing został znaleziony");
            	} else if (driver.findElements(By.xpath("//a[.='Costing']")).size()>0) {
            		element = driver.findElement(By.xpath("//a[.='Costing']"));
                	Log.info("Link Costing został znaleziony");
            	}
            	
            }catch (Exception e){
            	Log.error("Link Costing nie został znaleziony!");
           		throw(e);
           		}
           	return element;
        }
        
		public static WebElement lnk_topMenu_Administracja() throws Exception {
			try {
				if (driver.findElements(By.xpath("//*[@id='FindMenu1_btnAdministration']")).size() > 0) {
					element = driver.findElement(By.xpath("//*[@id='FindMenu1_btnAdministration']"));
					Log.info("Link Administracja został znaleziony");
				} else if (driver.findElements(By.xpath("//a[.='Administration']")).size() > 0 ) {
					element = driver.findElement(By.xpath("//a[.='Administration']"));
					Log.info("Link Administration został znaleziony");
				}
				
			} catch (Exception e) {
				Log.error("Linki Administracja i Administration nie zostały znaleziony!");
				throw (e);
			}
			return element;
		}
       
      
    }
