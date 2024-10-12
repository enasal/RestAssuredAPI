
import static io.restassured.RestAssured.*;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import io.qameta.allure.restassured.AllureRestAssured;

public class AddNewItemTest extends TestBase {
	
	@Test
	@DisplayName("Verify adding new booking")
	void verifyAddingNewBooking() {
		String payload = "{\"firstname\":\"testFirstName\",\"lastname\":\"lastName\",\"totalprice\":10.11,\"depositpaid\":true,\"bookingdates\":{\"checkin\":\"2022-01-01\",\"checkout\":\"2024-01-01\"},\"additionalneeds\":\"testAdd\"}";
		Response response = 
		given()
		.when()
		.contentType(ContentType.JSON)
		.when()
		.body(payload)
		.post();

		response.then().statusCode(200);
		response.prettyPrint();
		String bookingId = response.jsonPath().getString("bookingid");
		
		System.out.println(bookingId);
		
		Response response2 = 
		given()
		.pathParam("bookingid", bookingId)
		.when()
		.get("/{bookingid}");
		
		response2.then().statusCode(200);
		response2.prettyPrint();
		
		
	}
}
