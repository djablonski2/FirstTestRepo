package appModules;

import pageObjects.RealizationDetails_Page;
import utility.Log;


public class AddNewCall_Action {

	/***
	 * Metoda dodająca nowy call na zakładce zlecenia techniczne
	 * @param typZlecenia - String - nazwa calla pojawiająca się na liście
	 * @param nrUslugi - numer usługi według kolejności na rozwijanej liście
	 * @throws Exception
	 */
	public static void Execute(String typZlecenia, int nrUslugi) throws Exception {
			
		RealizationDetails_Page.lst_tabZlecTech_typZlecenia(typZlecenia);
		
		RealizationDetails_Page.lst_tabZlecTech_wybierzUsluge().click();
		RealizationDetails_Page.opt_lst_tabZlecTech_wybierzUsluge(nrUslugi).click();
		RealizationDetails_Page.btn_lst_tabZlecTech_wybierzUsluge_OK().click();
		
		RealizationDetails_Page.btn_tabZlecTech_dodajNoweZlecenie().click();

		Log.info("Zgłoszenie "+typZlecenia+" zostało dodane");

	}

}
