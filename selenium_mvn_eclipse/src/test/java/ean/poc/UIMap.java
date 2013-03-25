package ean.poc;

import java.io.IOException;
import java.util.Properties;

public class UIMap {
	private static UIMap instance = new UIMap();
	
	private Properties properties = new Properties();
	
	private UIMap() {
		try {
			properties.load(UIMap.class.getResourceAsStream("/uimap.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*Method used to return a locator Key's xpath value from the "uimap.properties" document.
	 * @entryID - the Key name used to retrieve its specific xpath location on the page.
	*/
	public static String find(String entryID) {
		return instance.properties.getProperty(entryID);
	}

}
