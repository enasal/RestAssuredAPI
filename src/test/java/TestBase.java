
import org.junit.jupiter.api.BeforeAll;

import io.restassured.RestAssured;

public class TestBase {
	@BeforeAll
	public static void init() {
		RestAssured.baseURI = "https://restful-booker.herokuapp.com/";
		RestAssured.basePath = "/booking";
	}
}
