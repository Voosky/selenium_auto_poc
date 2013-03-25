package ean.poc;

import java.io.IOException;
import java.util.Properties;

public class MessageMap {
	private static MessageMap instance = new MessageMap();
	
	private Properties properties = new Properties();
	
	private MessageMap() {
		try {
			properties.load(UIMap.class.getResourceAsStream("/messages.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*Method used to return a message Key's value from the "messages.properties" document.
	 * @propertyID - the Key name used to retrieve its specific message.
	*/
	public static String find(String entryID) {
		return instance.properties.getProperty(entryID);
	}

}
