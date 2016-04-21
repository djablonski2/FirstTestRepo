package utility;

import org.openqa.selenium.Dimension;

public class Constant {
	    public static final String ENV_URL_DEV = "http://clnet-tst/"; 
	    public static final String ENV_URL_VIRT = "http://clnet-dev/clnet-tst-virt/";
	    
	    public static final String USERNAME = "djablonski";
	    public static final String PASSWORD ="Al@b2st3r";
		public static final String PATH_TEST_DATA = "D:\\eclipse\\workspace\\ClientelePOFramework\\TestData\\";
		public static final String FILE_TEST_DATA = "TestData.xlsx";
		public static final String PATH_SCREENSHOT = "D:\\eclipse\\workspace\\ClientelePOFramework\\Screenshots\\";
		public static final String PATH_DOWNLOAD_FILES = "D:\\eclipse\\workspace\\ClientelePOFramework\\DownloadFiles\\";
		public static final int WAIT_FOR_ELEMENT_TO_BE_CLICKABLE_SEC = 10;
		public static final int DRIVER_IMPLICITLY_WAIT_SEC = 8;
		public static final String CALL_ID_CALENDAR_CHECK = "721583";
		public static final String COST_PROJ_ID_XLS_CHECK = "118";
		
		
		//public static Dimension BROWSER_RES = new Dimension(1920, 1080);
		public static Dimension BROWSER_RES = new Dimension(1366, 768);
		
		//Test Data Sheet Columns
		public static final int COL_TEST_CASE_NAME = 0;	
		public static final int COL_USER_NAME = 1 ;

	}
