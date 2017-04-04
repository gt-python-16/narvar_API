package sqlrest;

import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import org.testng.annotations.Test;


public class GetTest extends BaseTest {

	@Test(dataProvider = "dp", enabled = false)
	public void checkProductExists(String id, String name, String price, String updatedPrice) {
		
		RestAssured 
			.given()
				.header("Content-Type", "application/xml")
			.when()
				.get("/PRODUCT"+"/"+id)
			.then()
 	       .assertThat()    
	          .statusCode(200)
	          .body("PRODUCT.NAME", equalTo(name));
	}
	
	@Test(dataProvider = "dp")
	public void checkProductDoesNotExists(String id, String name, String price, String updatedPrice) {
		
		RestAssured 
			.given()
				.header("Content-Type", "application/xml")
			.when()
				.get("/PRODUCT"+"/"+id)
			.then()
 	       .assertThat()    
	          .statusCode(404);
	}
	@Test //(enabled = false)
	public void checkProductList() {

		
		Response resp = RestAssured  
			.given()
				.header("Content-Type", "application/xml")
			.when()
				.get("/PRODUCT");
		assert resp.statusCode() == 200;
		XmlPath xmlPath = resp.xmlPath();
		
		int n = (xmlPath.get(""+"PRODUCTList.PRODUCT.size()"));
		//System.out.println(n);
		 assert n == 50;
	
	}
	
}
