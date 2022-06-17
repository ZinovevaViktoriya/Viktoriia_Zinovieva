package steps;

import dto.PetDto;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PetApiStep {

	private RequestSpecification getRequestSpec() {
		RequestSpecification requestSpec = new RequestSpecBuilder().build();
		requestSpec.baseUri("https://petstore.swagger.io");
		requestSpec.basePath("/v2/pet");
		return requestSpec;
	}

	public Response uploadAnImage(File file, PetDto pet) {
		return given()
				.spec(getRequestSpec())
				.contentType("multipart/form-data")
				.multiPart(file)
				.pathParam("id", pet.getId())
				.when().post("{id}/uploadImage");
	}

	public Response updateAnExistingPet(JsonPath expectedJson ) {
		Map jsonPath = expectedJson.get();
		return given()
				.spec(getRequestSpec())
				.body(jsonPath)
				.contentType(ContentType.JSON)
				.when().put();
	}

	public Response findPetsByStatus() {
		return given()
				.spec(getRequestSpec())
				.param("status", "available")
				.when().get("/findByStatus");
	}

	public Response deleteAPet(PetDto pet) {
		return given()
				.spec(getRequestSpec())
				.pathParam("id", pet.getId())
				.when().delete("/{id}");
	}
}