package steps;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class StoreApiStep {

	private RequestSpecification getRequestSpecForStore() {
		RequestSpecification requestSpec = new RequestSpecBuilder().build();
		requestSpec.baseUri("https://petstore.swagger.io");
		requestSpec.basePath("/v2/store");
		return requestSpec;
	}

	public Response findPurchaseOrderById(JsonPath expectedJson) {
		return given()
				.spec(getRequestSpecForStore())
				.pathParam("id", expectedJson.get("id"))
				.when().get("/order/{id}");
	}

	public Response placeAnOrderForAPet(JsonPath expectedJson) {
		Map jsonPath = expectedJson.get();
		return given()
				.spec(getRequestSpecForStore())
				.body(jsonPath)
				.contentType(ContentType.JSON)
				.when().post("/order");
	}

	public Response deleteOrderById(JsonPath expectedJson) {
		return given()
				.spec(getRequestSpecForStore())
				.pathParam("id", expectedJson.get("id"))
				.when().delete("/order/{id}");
	}


	public Response returnPetInventoriesByStatus() {
		return given()
				.spec(getRequestSpecForStore())
				.when().get("/inventory");
	}
}
