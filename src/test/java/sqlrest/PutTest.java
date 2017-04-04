package sqlrest;

import static org.hamcrest.Matchers.*;
import javax.xml.bind.JAXBException;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import core.Product;

public class PutTest extends BaseTest {

	@Test(dataProvider = "dp")
	public void createProductWithPUT(String id, String name, String price, String updatedPrice) throws JAXBException {

		Product product = new Product();
		product.setName(name);
		product.setPrice(price);
		
	
		String body = getStringXML(product);
		
		RestAssured 
			.given()
				.contentType("application/xml")
				.body(body)
			.when()
				.put("/PRODUCT"+"/"+id)
			.then()
 	       .assertThat()    
	          .statusCode(201);
	}
	
}
