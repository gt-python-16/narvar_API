package sqlrest;

import static org.hamcrest.Matchers.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import io.restassured.RestAssured;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import core.Product;

public class PostTest extends BaseTest {

	
	@Test(dataProvider = "dp")
	public void createProduct(String id, String name, String price, String updatedPrice) throws JAXBException {

		Product product = new Product();
		product.setID(id);
		product.setName(name);
		product.setPrice(price);
		
	
		String body = getStringXML(product);
		
		RestAssured 
			.given()
				.contentType("application/xml")
				.body(body)
			.when()
				.post("/PRODUCT")
			.then()
 	       .assertThat()    
	          .statusCode(201);
	}
	@Test(dataProvider = "dp")
	public void updateProductPrice(String id, String name, String price, String updatedPrice) throws JAXBException {

		Product product = new Product();
		product.setPrice(updatedPrice);
		
	
		String body = getStringXML(product);
		
		RestAssured 
			.given()
				.contentType("application/xml")
				.body(body)
			.when()
				.post("/PRODUCT"+"/"+id)
			.then()
 	       .assertThat()    
	          .statusCode(200);
	}
	
}
