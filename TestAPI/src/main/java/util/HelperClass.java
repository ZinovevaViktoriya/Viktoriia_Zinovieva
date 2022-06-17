package util;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import dto.PetDto;
import io.restassured.path.json.JsonPath;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class HelperClass {

	public static JsonPath getJsonPath(String path) {
		File file = getFile(path);
		return new JsonPath(file);
	}

	public static File getFile(String petPhotoFilePath) {
		return new File(petPhotoFilePath);
	}

	public static PetDto getPetDto(String updatedPetFilePath) throws FileNotFoundException {
		JsonReader reader = new JsonReader(new FileReader(updatedPetFilePath));
		return new Gson().fromJson(reader, PetDto.class);
	}
}
