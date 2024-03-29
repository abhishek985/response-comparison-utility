package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import extentreport.Testlistener;
import utils.JSONComp;
import utils.XMLComp;

@Listeners(extentreport.Testlistener.class)	
public class Testcompare {

	static Properties prop;
	JSONComp jc = new JSONComp();
	XMLComp xc  = new XMLComp();


	@Test
	public void jsonTest() throws FileNotFoundException, IOException {
		prop = new Properties();
		prop.load(new FileInputStream("src/test/resources/test.properties"));

		String res1 =prop.getProperty("res1");
		String res2 =prop.getProperty("res2");
		String res3 =prop.getProperty("res3");

		Assert.assertEquals(jc.compare(res1, res2),-1);
		Assert.assertEquals(jc.compare(res1, res3),0);

	}

	@Test
	public void xmlTest() throws SAXException, IOException {
		
		String xml1 = prop.getProperty("xml1");
		String xml2 = prop.getProperty("xml2");
		String xml3 = prop.getProperty("xml3");
		
		Assert.assertEquals(xc.compare(xml1, xml2), true);
		Assert.assertEquals(xc.compare(xml1, xml3), false);
		Assert.assertEquals(xc.compare(xml1, xml1), true);

	}
	
	@AfterMethod
	public void close() {
		Testlistener.extent.flush();
	}
}
