package appModules;

import pageObjects.CallDetails_Page;
import utility.Log;
import utility.Utils;


public class FillNewCall_Action {
	
	/**
	 * Metoda wypełniająca wymagane pola na formularzu calla GENERIC
	 * @param lstWykonawcaValue - sample: ".WROCLAW"
	 * @param AEnd - sample: "Bełchatów (Kwiatowa 1) - 6052"
	 * @param BEnd - sample: "Białystok (TP Emitel Cieszyńska 3) - 9001"
	 * @param Bandwidth - sample: "40000"
	 * @throws Exception
	 */
	public static void Execute_Generic(String lstWykonawcaValue, String AEnd, String BEnd, String Bandwidth) throws Exception {
			
		CallDetails_Page.lst_Wykonawca(lstWykonawcaValue);
		CallDetails_Page.rbtn_adrInsUsl_AEnd_Wezel().click();
		Thread.sleep(1000);
		Utils.detectAlert();
		CallDetails_Page.lst_adrInsUsl_AEnd(AEnd);
		CallDetails_Page.lst_adrInsUsl_BEnd(BEnd);
		
		CallDetails_Page.txt_dodatkoweInfoOPrzebieguLacza().sendKeys("Lorem ipsum dolor sit amet - Dodatkowe informacje o przebiegu łącza");
		CallDetails_Page.txt_daneTech_Bandwidth().clear();
		CallDetails_Page.txt_daneTech_Bandwidth().sendKeys(Bandwidth);
		CallDetails_Page.txt_daneTech_Description().sendKeys("Lorem ipsum dolor sit amet - Tekstowy opis przebiegu połączenia");

		Log.info("Wymagane pola dla calla GENERIC zostały wypełnione.");
	}
	
	/**
	 *  Metoda wypełniająca wymagane pola na formularzu calla RADIOLINIA
	 * @param AEnd - sample: "Bełchatów (Kwiatowa 1) - 6052"
	 * @param BEnd - sample: "Białystok (TP Emitel Cieszyńska 3) - 9001"
	 * @param Bandwidth - sample: "40000"
	 * @param RLType - sample: "BAS - 26GHz"
	 * @param Port - sample: "G703"
	 * @param WspolGeog_Szer - sample:"00 00 00.0"
	 * @param WspolGeog_Dlug - sample:"00 00 00.0"
	 * @throws Exception
	 */
	public static void Execute_RL(String AEnd, String BEnd, String Bandwidth, String RLType, String Port, String WspolGeog_Szer, String WspolGeog_Dlug) throws Exception {
		
		CallDetails_Page.rbtn_adrInsUsl_AEnd_Wezel().click();
		Utils.detectAlert();
		CallDetails_Page.lst_adrInsUsl_AEnd(AEnd);
		CallDetails_Page.lst_adrInsUsl_BEnd(BEnd);
		
		CallDetails_Page.txt_dodatkoweInfoOPrzebieguLacza().sendKeys("Lorem ipsum dolor sit amet - Dodatkowe informacje o przebiegu łącza");
		CallDetails_Page.txt_daneTech_Bandwidth().clear();
		CallDetails_Page.txt_daneTech_Bandwidth().sendKeys(Bandwidth);
		CallDetails_Page.lst_daneTech_RLType(RLType);
		CallDetails_Page.lst_daneTech_Port(Port);
		CallDetails_Page.txt_daneTech_WspolGeog_Szer().sendKeys(WspolGeog_Szer);
		CallDetails_Page.txt_daneTech_WspolGeog_Dlug().sendKeys(WspolGeog_Dlug);
		
		Log.info("Wymagane pola dla calla RADIO zostały wypełnione.");
	}
	
	public static void Execute_ZUI(String lstWykonawcaValue, String AEnd, String BEnd, String Bandwidth) throws Exception {
		
		//Parametry techniczne
		CallDetails_Page.lst_RealizowanePrzez(lstWykonawcaValue);
		CallDetails_Page.chkb_PrzyznanieAdresowIP().click();
		CallDetails_Page.lst_ZakonczenieLaczaAEnd(AEnd);
		CallDetails_Page.lst_ZakonczenieLaczaBEnd(BEnd);
		CallDetails_Page.txt_PrzepustowoscDlaPolaczeniaZInternetem().sendKeys(Bandwidth);
		CallDetails_Page.txt_ZaterminowaneNa().sendKeys("karta_0123456789");
		
		//Adresacja IP
		CallDetails_Page.txt_ParamWAN_Abonent().sendKeys("127.0.0.1/11");
		CallDetails_Page.txt_ParamWAN_GTS().sendKeys("127.0.0.1/11");
		
		Log.info("Wymagane pola dla calla ZUI zostały wypełnione.");
	}

}
