package sqlrest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

//import javax.security.auth.login.Configuration;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import core.Config;
import core.Product;
import core.Config.ENV;
import io.restassured.RestAssured;

public class BaseTest {
	Config conf = new Config(ENV.QA);
	String csvFile = "./input.csv";
	//String csvFile = System.getProperty("testcases"); // mvn site -Dtestcases="./input.csv"
	
	@BeforeMethod(alwaysRun = true)
	public void before(){
		/*
		 * 
		 */
				RestAssured.baseURI		= conf.baseURI;
				RestAssured.port		= conf.port;
				RestAssured.basePath	= conf.basePath;
				RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
	}
	
	@DataProvider(name = "dp")
    public Iterator<String[]> a2d() throws InterruptedException, IOException {
           String cvsLine = "";
           String[] a = null;
           ArrayList<String[]> al = new ArrayList<String[]>();
           BufferedReader br = new BufferedReader(new FileReader(csvFile));
           while ((cvsLine = br.readLine()) != null) {
                  a = cvsLine.split(",");
                  al.add(a);}
           br.close();
           return al.iterator();}
	
	public static String getStringXML(Product product) throws JAXBException  {
	
		StringWriter writer = new StringWriter();
		JAXBContext context = JAXBContext.newInstance(Product.class);
		Marshaller m = context.createMarshaller();
		m.marshal(product, writer);
		return writer.toString();
	}
	
	

}
