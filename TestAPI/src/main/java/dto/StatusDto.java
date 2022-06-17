package dto;

import com.google.gson.annotations.SerializedName;

public enum StatusDto {

	@SerializedName("available")
	AVAILABLE("available"),
	@SerializedName("pending")
	PENDING("pending"),
	@SerializedName("sold")
	SOLD("sold");

	private String status;

	StatusDto(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
}