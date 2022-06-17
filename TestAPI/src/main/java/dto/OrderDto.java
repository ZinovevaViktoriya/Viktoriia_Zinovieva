package dto;

import lombok.Data;

@Data
public class OrderDto {

	private long id;
	private long petId;
	private long quantity;
	private String shipDate;
	private String status;
	private boolean complete;
}