package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class loadProps {
	Properties prop;
	public Properties prop() {
		prop = new Properties();
		try {
			prop.load(new FileInputStream("src/main/resources/config.properties"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}
