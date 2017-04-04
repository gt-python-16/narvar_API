package sqlrest;

import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class DeleteTest extends BaseTest {

	@Test(dataProvider = "dp")
	public void deleteProduct(String id, String name, String price, String updatedPrice) {

		RestAssured 
			.given()
				.contentType("application/xml")
			.when()
				.delete("/PRODUCT"+"/"+id)
			.then()
 	       .assertThat()    
	          .statusCode(200)
	          .body("resourse.deleted", equalTo(id));
	}
	
}
