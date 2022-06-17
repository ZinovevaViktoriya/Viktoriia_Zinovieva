package store;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import steps.StoreApiStep;
import util.Constant;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static util.HelperClass.getJsonPath;

public class CrudStoreTest {

	private StoreApiStep storeApiStep = new StoreApiStep();

	private JsonPath expectedJson;

	@BeforeEach
	private void getExpectedJson() {
		expectedJson = getJsonPath(Constant.PET_ORDER_FILE_PATH);
		storeApiStep.placeAnOrderForAPet(expectedJson);
	}

	@Test
	public void verifyFindingPurchaseOrderById() {
		Response response = storeApiStep.findPurchaseOrderById(expectedJson);
		Map jsonPath = response.getBody().jsonPath().get();
		assertThat(jsonPath).isEqualTo(expectedJson.get());
	}

	@Test
	public void verifyDeletingOrderById() {
		storeApiStep.placeAnOrderForAPet(expectedJson);
		Response response = storeApiStep.deleteOrderById(expectedJson);
		String message= response.getBody().jsonPath().get("message");
		assertThat(message).isEqualTo(expectedJson.get("id").toString());
	}

	@Test
	public void verifyGetPetInventoriesByStatus() {
		Response response = storeApiStep.returnPetInventoriesByStatus();
		assertThat(response.getBody().jsonPath().get("available") != null);
	}
}