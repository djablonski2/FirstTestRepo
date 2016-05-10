package pageObjects;
        import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import utility.Log;
    public class CallDetails_Page extends BaseClass {
           private static WebElement element = null;
        
        public CallDetails_Page(WebDriver driver){
            	super(driver);
        }     

        public static WebElement legend_SzczegolyZlecenia() throws Exception{
        	try{
	            element = driver.findElement(By.xpath("//legend[contains(.,'Szczegóły zlecenia')]"));
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
        
        public static WebElement rbtn_adrInsUsl_AEnd_Wezel() throws Exception{
        	try{
	            //element = driver.findElement(By.xpath("//input[@value='rbtnAGTSNode']"));
	            //element = driver.findElement(By.id("_ctl1__ctl0_Link1_rbtnAGTSNode"));
        		element = driver.findElement(By.xpath("//label[@for='_ctl1__ctl0_Link1_rbtnAGTSNode']"));
//        		if (element.isDisplayed()) {
//        			System.out.println("Element Radio Button jest widoczny: "+element.getText());
//				}
//        		else {
//        			System.out.println("Element Radio Button nie jest widoczny");
//        		};
           		Log.info("Znaleziono radio button Węzeł GTS dla A-End");
        	}catch (Exception e){
           		Log.error("Radio button Węzeł GTS dla A-End nie zostało znalezione!!!");
           		throw(e);
           		}
           	return element;
            }
        public static WebElement lst_adrInsUsl_AEnd(String wezelA) throws Exception{
        	try{
    			Select dropdown = new Select(driver.findElement(By.id("_ctl1__ctl0_Link1_ddlAendNode")));
    			dropdown.selectByVisibleText(wezelA);
    			Log.info("Węzeł A-End został wybrany");
        	}catch (Exception e){
    			Log.error("Nie udało się wybrać węzła A-End!!!");
           		throw(e);
           		}
           	return element;
            }
        public static WebElement rbtn_adrInsUsl_BEnd_Wezel() throws Exception{
        	try{
	            element = driver.findElement(By.xpath("//input[@value='rbtnBGTSNode']"));
           		Log.error("Znaleziono radio button Węzeł GTS dla B-End");
        	}catch (Exception e){
           		Log.error("Radio button Węzeł GTS dla E-End nie zostało znalezione!!!");
           		throw(e);
           		}
           	return element;
            }
        public static WebElement lst_adrInsUsl_BEnd(String wezelB) throws Exception{
        	try{
    			Select dropdown = new Select(driver.findElement(By.id("_ctl1__ctl0_Link1_ddlBendNode")));
    			dropdown.selectByVisibleText(wezelB);
    			Log.info("Węzeł A-End został wybrany");
        	}catch (Exception e){
    			Log.error("Nie udało się wybrać węzła A-End!!!");
           		throw(e);
           		}
           	return element;
            }
        public static WebElement txt_daneTech_Bandwidth() throws Exception{
        	try{
	            element = driver.findElement(By.id("_ctl1__ctl0_Link1_txtBandWidth"));
           		Log.info("Znaleziono pole Przepustowość");
        	}catch (Exception e){
           		Log.error("Pole przepustowość nie zostało znalezione!!!");
           		throw(e);
           		}
           	return element;
            }
        public static WebElement lst_daneTech_RLType(String rlType) throws Exception{
        	try{
    			Select dropdown = new Select(driver.findElement(By.id("_ctl1__ctl0_Link1__ctl0_Link_RL_Types")));
    			dropdown.selectByVisibleText(rlType);
    			Log.info("Lista RL Type zostało znaleziona");
        	}catch (Exception e){
    			Log.error("Lista RL Type nie została znaleziona!!!");
           		throw(e);
           		}
           	return element;
            }  
        public static WebElement lst_daneTech_Port(String port) throws Exception{
        	try{
    			Select dropdown = new Select(driver.findElement(By.id("_ctl1__ctl0_Link1__ctl0_ddlPort")));
    			dropdown.selectByVisibleText(port);
    			Log.info("Lista Port zostało znaleziona");
        	}catch (Exception e){
    			Log.error("Lista Port nie została znaleziona!!!");
           		throw(e);
           		}
           	return element;
            }  
        public static WebElement txt_daneTech_WspolGeog_Szer() throws Exception{
        	try{
	            element = driver.findElement(By.id("_ctl1__ctl0_Link1__ctl0_txtWspolGeog_Szer"));
           		Log.info("Znaleziono pole Współrzędne geograficzne szerokość");
        	}catch (Exception e){
           		Log.error("Pole Współrzędne geograficzne szerokość nie zostało znalezione!!!");
           		throw(e);
           		}
           	return element;
            }
        public static WebElement txt_daneTech_WspolGeog_Dlug() throws Exception{
        	try{
	            element = driver.findElement(By.id("_ctl1__ctl0_Link1__ctl0_txtWspolGeog_Dlug"));
           		Log.info("Znaleziono pole Współrzędne geograficzne długość");
        	}catch (Exception e){
           		Log.error("Pole Współrzędne geograficzne długość nie zostało znalezione!!!");
           		throw(e);
           		}
           	return element;
            }
        public static WebElement btn_PostepyInstalacji_DoRealizacji() throws Exception{
        	try{
	            element = driver.findElement(By.xpath("//input[@value='Do realizacji']"));
           		Log.info("Znaleziono przycisk Do Realizacji");
        	}catch (Exception e){
           		Log.error("Przycisk Do Realizacji nie został znaleziony!!!");
           		throw(e);
           		}
           	return element;
            }
    }
