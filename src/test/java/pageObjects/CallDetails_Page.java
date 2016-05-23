package pageObjects;
        import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import utility.Log;
    public class CallDetails_Page extends BaseClass {
           private static WebElement element = null;
        
        public CallDetails_Page(WebDriver driver){
            	super(driver);
        }     
        
        public static WebElement btn_PrzejmijZgloszenie() throws Exception{
        	try{
	            element = driver.findElement(By.id("_ctl0_btnPrzejmijZgloszenie"));
        	}catch (Exception e){
           		Log.error("Nie znaleziono przycisku Przejmij Zgłoszenie!!!");
           		throw(e);
           		}
           	return element;
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
        
        public static WebElement legend_NrZlecenia() throws Exception{
        	try{
	            element = driver.findElement(By.xpath("//span[@id='_ctl1__ctl0_lblCallNum']"));
        	}catch (Exception e){
           		Log.error("Nie znaleziono numeru zlecenia!!!");
           		throw(e);
           		}
           	return element;
            }
        
        public static WebElement legend_TypZlecenia() throws Exception{
        	try{
	            element = driver.findElement(By.xpath("//span[@id='_ctl1__ctl0_lblTypZlecenia']"));
        	}catch (Exception e){
           		Log.error("Nie znaleziono typu zlecenia!!!");
           		throw(e);
           		}
           	return element;
            }
        
        /** link do przejścia ze szczegółów calla do projektu
         * @return
         * @throws Exception
         */
        public static WebElement lnk_NrRealizacji() throws Exception{
        	try{
	            element = driver.findElement(By.xpath("//a[@id='_ctl1__ctl0_lnkNrRealizacji']"));
        	}catch (Exception e){
           		Log.error("Link do realizacji nie został znaleziony!!!");
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
        
        public static WebElement lst_Wykonawca(String kolejka) throws Exception{
        	try{
    			Select dropdown = new Select(driver.findElement(By.id("_ctl1__ctl0_ddlForwardTo")));
    			dropdown.selectByValue(kolejka);
    			Log.info("Kolejka wykonawcy zlecenia została wybrana");
        	}catch (Exception e){
    			Log.error("Nie udało się wybrać kolejki wykonawcy zlecenia!!!");
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
        
        /** dostępne na callu ZUI
         * @param kolejka
         * @return
         * @throws Exception
         */
        public static WebElement lst_RealizowanePrzez(String kolejka) throws Exception{
        	try{
    			Select dropdown = new Select(driver.findElement(By.id("_ctl1__ctl0_Internet_Request_Queue_List")));
    			dropdown.selectByValue(kolejka);
    			Log.info("Kolejka Realizowane Przez zlecenia została wybrana");
        	}catch (Exception e){
    			Log.error("Nie udało się wybrać kolejki do realizacji zlecenia!!!");
           		throw(e);
           		}
           	return element;
            }
        
        /** dostępne na callu ZUI
         * @return
         * @throws Exception
         */
        public static WebElement chkb_PrzyznanieAdresowIP() throws Exception{
        	try{
	            element = driver.findElement(By.id("_ctl1__ctl0_chkIPConfiguration"));
           		Log.info("Znaleziono checkbox Przyznanie Adresów IP");
        	}catch (Exception e){
           		Log.error("Checkbox Przyznanie Adresów IP nie został znaleziony!!!");
           		throw(e);
           		}
           	return element;
            }
        
        /**  dostępne na callu ZUI
         * @param adres
         * @return
         * @throws Exception
         */
        public static WebElement lst_ZakonczenieLaczaAEnd(String adres) throws Exception{
        	try{
    			Select dropdown = new Select(driver.findElement(By.id("_ctl1__ctl0_ddlA_end")));
    			dropdown.selectByVisibleText(adres);
    			Log.info("Znaleziono listę Zakończenie łącza CE-end");
        	}catch (Exception e){
    			Log.error("Lista Zakończenie łącza CE-end nie została znaleziona!!!");
           		throw(e);
           		}
           	return element;
            }
        /**  dostępne na callu ZUI
         * @param adres
         * @return
         * @throws Exception
         */
        public static WebElement lst_ZakonczenieLaczaBEnd(String adres) throws Exception{
        	try{
    			Select dropdown = new Select(driver.findElement(By.id("_ctl1__ctl0_ddlB_end")));
    			dropdown.selectByVisibleText(adres);
    			Log.info("Znaleziono listę Zakończenie łącza PE-end");
        	}catch (Exception e){
    			Log.error("Lista Zakończenie łącza PE-end nie została znaleziona!!!");
           		throw(e);
           		}
           	return element;
            }
        /** dostępne na callu ZUI
         * @return
         * @throws Exception
         */
        public static WebElement txt_PrzepustowoscDlaPolaczeniaZInternetem() throws Exception{
        	try{
	            element = driver.findElement(By.id("_ctl1__ctl0_txtBandwidth"));
           		Log.info("Znaleziono pole Przepustowość dla połączenia z internetem");
        	}catch (Exception e){
           		Log.error("Pole Przepustowość dla połączenia z internetem nie zostało znalezione!!!");
           		throw(e);
           		}
           	return element;
            }
        /** dostępne na callu ZUI
         * @return
         * @throws Exception
         */
        public static WebElement txt_ZaterminowaneNa() throws Exception{
        	try{
	            element = driver.findElement(By.id("_ctl1__ctl0_Internet_Request_P0_Zaterminowana"));
           		Log.info("Znaleziono pole Zaterminowane Na");
        	}catch (Exception e){
           		Log.error("Pole Zaterminowane Na nie zostało znalezione!!!");
           		throw(e);
           		}
           	return element;
            }
        /** dostępne na callu ZUI
         * @return
         * @throws Exception
         */
        public static WebElement txt_ParamWAN_Abonent() throws Exception{
        	try{
	            element = driver.findElement(By.id("_ctl1__ctl0_Address_IP1_txtLink_IP_Abonent"));
           		Log.info("Znaleziono pole Abonent w parametrach WAN");
        	}catch (Exception e){
           		Log.error("Pole Abonent w parametrach WAN nie zostało znalezione!!!");
           		throw(e);
           		}
           	return element;
            }
        /** dostępne na callu ZUI
         * @return
         * @throws Exception
         */
        public static WebElement txt_ParamWAN_GTS() throws Exception{
        	try{
	            element = driver.findElement(By.id("_ctl1__ctl0_Address_IP1_txtLink_IP_GTS"));
           		Log.info("Znaleziono pole GTS w parametrach WAN");
        	}catch (Exception e){
           		Log.error("Pole GTS w parametrach WAN nie zostało znalezione!!!");
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
        public static WebElement txt_daneTech_Description() throws Exception{
        	try{
	            element = driver.findElement(By.id("_ctl1__ctl0_Link1__ctl0_txtDescription"));
           		Log.info("Znaleziono pole Tekstowy opis przebiegu połączenia");
        	}catch (Exception e){
           		Log.error("Pole Tekstowy opis przebiegu połączenia nie zostało znalezione!!!");
           		throw(e);
           		}
           	return element;
            }
        
        public static WebElement txt_dodatkoweInfoOPrzebieguLacza() throws Exception{
        	try{
        		element = driver.findElement(By.xpath("//textarea[@id='_ctl1__ctl0_Link1_txtAdditionalInfo']"));
	            //element = driver.findElement(By.id("_ctl1:_ctl0:Link1:txtAdditionalInfo"));
           		Log.info("Znaleziono pole Dodatkowe informacje o przebiegu łącza");
        	}catch (Exception e){
           		Log.error("Pole Dodatkowe informacje o przebiegu łącza nie zostało znalezione!!!");
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
            	if (driver.findElements(By.xpath("//input[@value='Do realizacji']")).size() > 0) {
            		element = driver.findElement(By.xpath("//input[@value='Do realizacji']"));
            		Log.info("Znaleziono przycisk Do Realizacji");
            	} else if (driver.findElements(By.xpath("//input[@value='Przekaż do Realizacji']")).size() > 0) {
            		element = driver.findElement(By.xpath("//input[@value='Przekaż do Realizacji']"));
            		Log.info("Znaleziono przycisk Przekaż do realizacji");
            	}
        	}catch (Exception e){
           		Log.error("Przycisk Do Realizacji nie został znaleziony!!!");
           		throw(e);
           		}
           	return element;
            }
        public static WebElement btn_PostepyInstalacji_DoPodwykonawcy() throws Exception{
        	try{
	            element = driver.findElement(By.xpath("//input[@value='Do podwykonawcy']"));
           		Log.info("Znaleziono przycisk Do podwykonawcy");
        	}catch (Exception e){
           		Log.error("Przycisk Do podwykonawcy nie został znaleziony!!!");
           		throw(e);
           		}
           	return element;
            }
        public static WebElement btn_PostepyInstalacji_DoneZainstalowano() throws Exception{
        	try{
	            element = driver.findElement(By.xpath("//input[@value='Done/Zainstalowano']"));
           		Log.info("Znaleziono przycisk Done/Zainstalowano");
        	}catch (Exception e){
           		Log.error("Przycisk Done/Zainstalowano nie został znaleziony!!!");
           		throw(e);
           		}
           	return element;
            }
        public static WebElement btn_PostepyInstalacji_Zrealizuj() throws Exception{
        	try{
	            element = driver.findElement(By.xpath("//input[@value='Zrealizuj']"));
           		Log.info("Znaleziono przycisk Zrealizuj");
        	}catch (Exception e){
           		Log.error("Przycisk Zrealizuj nie został znaleziony!!!");
           		throw(e);
           		}
           	return element;
            }
        public static WebElement btn_PostepyInstalacji_Zrealizowano() throws Exception{
        	try{
	            element = driver.findElement(By.xpath("//input[@value='Zrealizowano']"));
           		Log.info("Znaleziono przycisk Zrealizowano");
        	}catch (Exception e){
           		Log.error("Przycisk Zrealizowano nie został znaleziony!!!");
           		throw(e);
           		}
           	return element;
            }
        public static WebElement btn_PostepyInstalacji_UruchomTransmisje() throws Exception{
        	try{
	            element = driver.findElement(By.xpath("//input[@value='Uruchom transmisję']"));
           		Log.info("Znaleziono przycisk Uruchom transmisję");
        	}catch (Exception e){
           		Log.error("Przycisk Uruchom transmisję nie został znaleziony!!!");
           		throw(e);
           		}
           	return element;
            }
        public static WebElement btn_PostepyInstalacji_Odrzuc() throws Exception{
        	try{
	            element = driver.findElement(By.xpath("//input[@value='Odrzuć']"));
           		Log.info("Znaleziono przycisk Odrzuć");
        	}catch (Exception e){
           		Log.error("Przycisk Odrzuć nie został znaleziony!!!");
           		throw(e);
           		}
           	return element;
            }
        public static WebElement btn_PostepyInstalacji_PrzyznanoAdresy() throws Exception{
        	try{
	            element = driver.findElement(By.xpath("//input[@value='Przyznano adresy']"));
           		Log.info("Znaleziono przycisk Przyznano adresy");
        	}catch (Exception e){
           		Log.error("Przycisk Przyznano adresy nie został znaleziony!!!");
           		throw(e);
           		}
           	return element;
            }
    }
