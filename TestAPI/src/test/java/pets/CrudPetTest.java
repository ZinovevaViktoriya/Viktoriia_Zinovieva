package pets;

import dto.PetDto;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import steps.PetApiStep;
import util.Constant;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static util.HelperClass.*;

public class CrudPetTest {

	private PetApiStep petApiStep = new PetApiStep();
	private PetDto pet;
	private PetDto updatedPet;

	@BeforeEach
	private void getPet() throws FileNotFoundException {
		updatedPet = getPetDto(Constant.UPDATED_PET_FILE_PATH);
		pet = getPetDto(Constant.PET_JSON_FILE_PATH);
	}

	@Test
	public void verifyUploadingAnImage() {
		File file = getFile(Constant.PET_PHOTO_FILE_PATH);
		Response response = petApiStep.uploadAnImage(file,pet);
		String message = response.getBody().jsonPath().get("message");
		assertThat(message)
				.asString()
				.contains("photoUmka.jpg");
	}

	@Test
	public void verifyUpdatingAnExistingPet() {
		JsonPath expectedJson = getJsonPath(Constant.UPDATED_PET_FILE_PATH);
		Response response = petApiStep.updateAnExistingPet(expectedJson);
		Map jsonPath = response.getBody().jsonPath().get();
		assertThat(jsonPath).isEqualTo(expectedJson.get());
	}

	@Test
	public void verifyFindingPetsByStatus() {
		Response response = petApiStep.findPetsByStatus();
		List jsonPath = response.getBody().jsonPath().get();
		assertThat(jsonPath)
				.asList().hasSizeGreaterThan(0);
	}

}